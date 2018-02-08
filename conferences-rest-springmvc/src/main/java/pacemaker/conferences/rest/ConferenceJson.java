package pacemaker.conferences.rest;

import java.util.Date;
import java.util.Set;

class ConferenceJson {
    private String id;
    private String topic;
    private Date date;
    private Set<String> communities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<String> getCommunities() {
        return communities;
    }

    public void setCommunities(Set<String> communities) {
        this.communities = communities;
    }
}
