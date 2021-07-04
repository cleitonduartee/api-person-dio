package cleiton.duarte.api.person.controller;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.domain.entity.Phone;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.dto.request.PhoneDTO;
import cleiton.duarte.api.person.dto.response.MessageDTO;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO created(@RequestBody @Valid PersonDTO personDTO){
       List<Phone> phone = new ArrayList<>();
       personDTO.getPhones().stream()
               .map(phonee ->phone.add(new Phone(null,phonee.getType(),phonee.getNumber())))
               .collect(Collectors.toList());
        Person person = Person
                .builder()
                .cpf(personDTO.getCpf())
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .phones(phone)
                .birthDate(personDTO.getBirthDate())
                .build();
        person = personRepository.save(person);
        return MessageDTO
                .builder()
                .message("Created person id: "+person.getId())
                .build();
    }
}
