package pacemaker.conferences.jpa.conferences;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity(name = "Conference")
@Table(name = "conferences")
class ConferenceEntity {

    @Id
    private String id;
    private String topic;
    private Date date;
    private String communities;

    protected ConferenceEntity() { }

    public ConferenceEntity(String id, String topic, Date date, String communities) {
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

    public Date getDate() {
        return date;
    }

    public Set<String> getCommunities() {
        return Stream.of(communities.split(",")).collect(Collectors.toSet());
    }
}
