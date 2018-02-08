package pacemaker.conferences.interactor;

import pacemaker.conferences.api.conferences.boundary.ScheduleConference;
import pacemaker.conferences.api.conferences.request.ScheduleConferenceRequest;
import pacemaker.conferences.domain.communities.Community;
import pacemaker.conferences.domain.conferences.*;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Named
@Transactional
class ScheduleConferenceImpl implements ScheduleConference {

    private final ConferenceGateway conferenceGateway;

    ScheduleConferenceImpl(ConferenceGateway conferenceGateway) {
        this.conferenceGateway = conferenceGateway;
    }

    @Override
    public void execute(ScheduleConferenceRequest request, Consumer<String> idConsumer) {
        final Set<Community> communities = request.getCommunities().stream().map(String::toUpperCase).map(Community::valueOf).collect(Collectors.toSet());
        final Conference conference = ConferenceFactory.create().scheduleConference(ConferenceId.allocate(), request.getTopic(), request.getDate(), communities);
        idConsumer.accept(this.conferenceGateway.save(conference).toString());
    }
}
