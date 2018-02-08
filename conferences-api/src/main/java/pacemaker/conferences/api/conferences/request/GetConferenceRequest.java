package pacemaker.conferences.api.conferences.request;

import java.util.Objects;

public class GetConferenceRequest {

    private final String conferenceId;

    public GetConferenceRequest(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetConferenceRequest that = (GetConferenceRequest) o;
        return Objects.equals(conferenceId, that.conferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conferenceId);
    }
}
