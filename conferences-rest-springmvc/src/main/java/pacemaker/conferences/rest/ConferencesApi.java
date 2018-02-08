package pacemaker.conferences.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriTemplate;
import pacemaker.conferences.api.conferences.boundary.*;
import pacemaker.conferences.api.conferences.request.GetConferenceRequest;
import pacemaker.conferences.api.conferences.request.ScheduleConferenceRequest;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(ConferencesApi.ROOT)
class ConferencesApi {
    static final String ROOT = "/conferences";
    private static final String SINGLE_CONFERENCE_TEMPLATE = "/{conferenceId}";

    private final ListConferences listConferences;
    private final GetConference getConference;
    private final ScheduleConference scheduleConference;

    public ConferencesApi(ListConferences listConferences, GetConference getConference, ScheduleConference scheduleConference) {
        this.listConferences = listConferences;
        this.getConference = getConference;
        this.scheduleConference = scheduleConference;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ConferenceJson> all() {
        final ConferencePresenter presenter = new ConferencePresenter();
        listConferences.execute(presenter);
        return presenter.getResultList();
    }

    @RequestMapping(value = SINGLE_CONFERENCE_TEMPLATE, method = RequestMethod.GET)
    public ConferenceJson one(@PathVariable("conferenceId") String conferenceId) {
        final ConferencePresenter presenter = new ConferencePresenter();
        this.getConference.execute(new GetConferenceRequest(conferenceId), presenter);
        return presenter.getSingleResult();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody CreateConferenceJsonPayload payload) {
        final AtomicReference<String> id = new AtomicReference<>();
        this.scheduleConference.execute(new ScheduleConferenceRequest(
                payload.getTopic(),
                new Date(payload.getDate().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                payload.getCommunities()
                ), id::set);
        return ResponseEntity.created(new UriTemplate(ROOT + SINGLE_CONFERENCE_TEMPLATE).expand(id.get())
                .normalize()).header("X-Allocated-Identifier", id.get())
                .build();
    }
}
