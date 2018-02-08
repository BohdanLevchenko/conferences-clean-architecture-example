package pacemaker.conferences.rest;

import pacemaker.conferences.api.conferences.response.ConferenceResponse;

import java.time.ZoneId;
import java.util.*;
import java.util.function.Consumer;

class ConferencePresenter implements Consumer<ConferenceResponse> {
    private final List<ConferenceJson> result = new ArrayList<>();

    @Override
    public void accept(ConferenceResponse conf) {
        ConferenceJson json = new ConferenceJson();
        json.setId(conf.getId());
        json.setTopic(conf.getTopic());
        json.setDate(Date.from(conf.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        json.setCommunities(conf.getCommunities());
        result.add(json);
    }

    public List<ConferenceJson> getResultList() {
        return result;
    }

    public ConferenceJson getSingleResult() {
        if (result.isEmpty()) {
            throw new IllegalStateException("No result found");
        }
        return result.get(0);
    }
}
