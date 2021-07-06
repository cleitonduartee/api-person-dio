package cleiton.duarte.api.person.domain.service;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.exception.CpfDuplicationException;
import cleiton.duarte.api.person.exception.NotFoundResourceException;
import cleiton.duarte.api.person.mapper.PersonMapper;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private PersonRepository personRepository;

    public PersonDTO createdPerson(PersonDTO personDTO){
        try{
            Person person = personRepository.save(personMapper.toModel(personDTO));
            return personMapper.toDTO(person);
        }catch (DataIntegrityViolationException e){
            throw new CpfDuplicationException(e.getMessage());
        }
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
