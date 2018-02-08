package pacemaker.conferences.interactor;

import pacemaker.conferences.api.conferences.boundary.GetConference;
import pacemaker.conferences.api.conferences.request.GetConferenceRequest;
import pacemaker.conferences.api.conferences.response.ConferenceResponse;
import pacemaker.conferences.domain.conferences.*;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Named
@Transactional
class GetConferenceImpl implements GetConference {
    private final ConferenceToResponseMapper mapper = new ConferenceToResponseMapper();

    private final ConferenceGateway conferenceGateway;

    public GetConferenceImpl(ConferenceGateway conferenceGateway) {
        this.conferenceGateway = conferenceGateway;
    }

    @Override
    public void execute(GetConferenceRequest request, Consumer<ConferenceResponse> consumer) {
        final Conference conference = conferenceGateway.findById(ConferenceId.from(request.getConferenceId()));
        consumer.accept(this.mapper.map(conference));
    }
}
