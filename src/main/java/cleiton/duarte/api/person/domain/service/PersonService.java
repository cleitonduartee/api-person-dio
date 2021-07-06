package cleiton.duarte.api.person.domain.service;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.exception.NotFoundResourceException;
import cleiton.duarte.api.person.mapper.PersonMapper;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(()->new NotFoundResourceException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> personMapper.toDTO(person))
                .collect(Collectors.toList());
    }
}
