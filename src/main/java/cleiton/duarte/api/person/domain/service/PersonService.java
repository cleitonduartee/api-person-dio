package cleiton.duarte.api.person.domain.service;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.mapper.PersonMapper;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private PersonRepository personRepository;

    public PersonDTO createdPerson(PersonDTO personDTO){
        Person person = personMapper.toModel(personDTO);
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    }
}
