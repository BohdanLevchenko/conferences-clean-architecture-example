package pacemaker.conferences.jpa.conferences;

import pacemaker.conferences.domain.communities.Community;
import pacemaker.conferences.domain.conferences.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Collectors;

class EntityToConferenceMapper {

    Conference map(ConferenceEntity entity) {
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        return ConferenceFactory.create().scheduleConference(
                ConferenceId.from(entity.getId()),
                entity.getTopic(),
                entity.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                entity.getCommunities().stream().map(Community::valueOf).collect(Collectors.toSet()));
    }
}
