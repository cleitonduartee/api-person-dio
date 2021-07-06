package cleiton.duarte.api.person.controller;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.domain.entity.Phone;
import cleiton.duarte.api.person.domain.service.PersonService;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.dto.request.PhoneDTO;
import cleiton.duarte.api.person.dto.response.MessageDTO;
import cleiton.duarte.api.person.mapper.PersonMapper;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/people")
public class PersonController {

   private PersonService personService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO created(@RequestBody @Valid PersonDTO personDTO){

        return personService.createdPerson(personDTO);

    }
}
