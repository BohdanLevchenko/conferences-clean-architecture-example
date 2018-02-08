package pacemaker.conferences.jpa.conferences;

import pacemaker.conferences.domain.conferences.*;

import javax.inject.Named;
import java.util.Collection;
import java.util.stream.*;

@Named
class JPAConferenceGateway implements ConferenceGateway {
    private final EntityToConferenceMapper e2c = new EntityToConferenceMapper();
    private final ConferenceToEntityMapper c2e = new ConferenceToEntityMapper();

    private final ConferenceRepository conferenceRepository;

    public JPAConferenceGateway(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public Conference findById(ConferenceId conferenceId) {
        return e2c.map(this.conferenceRepository.findOne(conferenceId.toString()));
    }

    @Override
    public Collection<Conference> findAll() {
        return StreamSupport.stream(this.conferenceRepository.findAll().spliterator(), false)
                .map(e2c::map)
                .collect(Collectors.toSet());
    }

    @Override
    public ConferenceId save(Conference conference) {
        return ConferenceId.from(this.conferenceRepository.save(c2e.map(conference)).getId());
    }
}
