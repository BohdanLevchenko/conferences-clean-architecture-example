package pacemaker.conferences.api.conferences.boundary;

import pacemaker.conferences.api.conferences.request.ScheduleConferenceRequest;

import java.util.function.Consumer;

public interface ScheduleConference {

    void execute(ScheduleConferenceRequest request, Consumer<String> idConsumer);
}
