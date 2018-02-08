package pacemaker.conferences.api.conferences.boundary;

import pacemaker.conferences.api.conferences.request.GetConferenceRequest;
import pacemaker.conferences.api.conferences.response.ConferenceResponse;

import java.util.function.Consumer;

public interface GetConference {

    void execute(GetConferenceRequest request, Consumer<ConferenceResponse> consumer);
}
