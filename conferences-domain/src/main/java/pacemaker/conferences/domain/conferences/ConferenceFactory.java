package pacemaker.conferences.domain.conferences;

import pacemaker.conferences.domain.communities.Community;

import java.time.LocalDate;
import java.util.*;

public class ConferenceFactory {
    private ConferenceFactory() { }

    public Conference scheduleConference(String topic, LocalDate date) {
        return scheduleConference(ConferenceId.allocate(), topic, date, Collections.emptySet());
    }

    public Conference scheduleConference(ConferenceId conferenceId, String topic, LocalDate date, Set<Community> communities) {
        return new Conference(conferenceId, topic, date, EnumSet.copyOf(communities));
    }

    public static ConferenceFactory create() { return new ConferenceFactory(); }
}
