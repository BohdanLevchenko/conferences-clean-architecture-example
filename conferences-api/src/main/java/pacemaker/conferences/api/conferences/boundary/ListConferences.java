package pacemaker.conferences.api.conferences.boundary;

import pacemaker.conferences.api.conferences.request.ListConferencesRequest;
import pacemaker.conferences.api.conferences.response.ConferenceResponse;

import java.util.function.Consumer;

public interface ListConferences {
    void execute(Consumer<ConferenceResponse> conferenceConsumer);
}
