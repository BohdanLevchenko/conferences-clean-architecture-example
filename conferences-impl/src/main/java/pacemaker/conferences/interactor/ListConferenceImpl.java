package pacemaker.conferences.interactor;

import pacemaker.conferences.api.conferences.boundary.GetConference;
import pacemaker.conferences.api.conferences.boundary.ListConferences;
import pacemaker.conferences.api.conferences.request.GetConferenceRequest;
import pacemaker.conferences.api.conferences.request.ListConferencesRequest;
import pacemaker.conferences.api.conferences.response.ConferenceResponse;
import pacemaker.conferences.domain.conferences.*;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.function.Consumer;

@Named
@Transactional
class ListConferenceImpl implements ListConferences {

    private final ConferenceToResponseMapper mapper = new ConferenceToResponseMapper();

    private final ConferenceGateway conferenceGateway;

    public ListConferenceImpl(ConferenceGateway conferenceGateway) {
        this.conferenceGateway = conferenceGateway;
    }

    @Override
    public void execute(Consumer<ConferenceResponse> consumer) {
        conferenceGateway.findAll().forEach(c -> consumer.accept(this.mapper.map(c)));
    }
}
