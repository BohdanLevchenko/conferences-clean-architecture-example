package pacemaker.conferences.domain.conferences;

import java.util.Collection;

public interface ConferenceGateway {

    Conference findById(ConferenceId conferenceId);

    Collection<Conference> findAll();

    ConferenceId save(Conference conference);


}
