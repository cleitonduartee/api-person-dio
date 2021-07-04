package cleiton.duarte.api.person.repository;

import cleiton.duarte.api.person.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
