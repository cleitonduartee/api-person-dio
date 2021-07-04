package cleiton.duarte.api.person.controller;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Person created(@RequestBody Person person){
        return personRepository.save(person);
    }
}
