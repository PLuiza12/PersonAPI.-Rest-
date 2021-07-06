package Digital.Innovation.one.personapi.repository;

import Digital.Innovation.one.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
