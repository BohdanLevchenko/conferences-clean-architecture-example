package pacemaker.conferences.jpa.conferences;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ConferenceRepository extends CrudRepository<ConferenceEntity, String> {
}
