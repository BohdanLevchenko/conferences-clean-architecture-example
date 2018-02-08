package pacemaker.conferences.jpa.conferences;

import pacemaker.conferences.domain.communities.Community;
import pacemaker.conferences.domain.conferences.Conference;

import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

class ConferenceToEntityMapper {
    ConferenceEntity map(Conference conference) {

        return new ConferenceEntity(
                conference.getConferenceId().toString(),
                conference.getTopic(),
                Date.from(conference.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                conference.getCommunities().stream()
                        .map(Community::toString)
                        .collect(Collectors.joining(",")));
    }
}
