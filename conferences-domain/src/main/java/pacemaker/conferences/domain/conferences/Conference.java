package pacemaker.conferences.domain.conferences;

import pacemaker.conferences.domain.communities.Community;

import java.time.LocalDate;
import java.util.*;

public class Conference {
    private final ConferenceId conferenceId;
    private final String topic;
    private final LocalDate date;
    private final EnumSet<Community> communities;

    Conference(ConferenceId conferenceId, String topic, LocalDate date) {
        this(conferenceId, topic, date, EnumSet.noneOf(Community.class));
    }

    Conference(ConferenceId conferenceId, String topic, LocalDate date, EnumSet<Community> communities) {
        this.conferenceId = conferenceId;
        this.topic = topic;
        this.date = date;
        this.communities = communities;
    }

    public ConferenceId getConferenceId() {
        return conferenceId;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<Community> getCommunities() {
        return Collections.unmodifiableSet(this.communities);
    }
}
