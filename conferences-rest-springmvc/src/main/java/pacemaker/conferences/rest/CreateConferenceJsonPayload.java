package pacemaker.conferences.rest;

import java.sql.Date;
import java.util.Set;

class CreateConferenceJsonPayload {
    private String topic;
    private Date date;
    private Set<String> communities;

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
