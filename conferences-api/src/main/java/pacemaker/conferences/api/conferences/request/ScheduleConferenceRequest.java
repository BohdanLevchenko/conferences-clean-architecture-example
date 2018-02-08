package pacemaker.conferences.api.conferences.request;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class ScheduleConferenceRequest {

    private final String topic;
    private final LocalDate date;
    private final Set<String> communities;

    public ScheduleConferenceRequest(String topic, LocalDate date, Set<String> communities) {
        this.topic = topic;
        this.date = date;
        this.communities = communities;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public Set<String> getCommunities() {
        return communities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleConferenceRequest that = (ScheduleConferenceRequest) o;
        return Objects.equals(topic, that.topic) &&
                Objects.equals(date, that.date) &&
                Objects.equals(communities, that.communities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, date, communities);
    }
}
