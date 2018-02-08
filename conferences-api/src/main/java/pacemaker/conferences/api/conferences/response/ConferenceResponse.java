package pacemaker.conferences.api.conferences.response;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class ConferenceResponse {
    private final String id;
    private final String topic;
    private final LocalDate date;
    private final Set<String> communities;

    public ConferenceResponse(String id, String topic, LocalDate date, Set<String> communities) {
        this.id = id;
        this.topic = topic;
        this.date = date;
        this.communities = communities;
    }

    public String getId() {
        return id;
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
        ConferenceResponse that = (ConferenceResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(topic, that.topic) &&
                Objects.equals(date, that.date) &&
                Objects.equals(communities, that.communities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, topic, date, communities);
    }
}
