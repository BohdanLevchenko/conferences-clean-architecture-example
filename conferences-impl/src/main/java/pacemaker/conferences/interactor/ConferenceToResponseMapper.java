package pacemaker.conferences.interactor;

import pacemaker.conferences.api.conferences.response.ConferenceResponse;
import pacemaker.conferences.domain.conferences.Conference;

import java.util.stream.Collectors;

final class ConferenceToResponseMapper {

    ConferenceResponse map(Conference conference) {
        return new ConferenceResponse(
                conference.getConferenceId().toString(),
                conference.getTopic(),
                conference.getDate(),
                conference.getCommunities().stream().map(Enum::toString).collect(Collectors.toSet())
        );
    }
}
