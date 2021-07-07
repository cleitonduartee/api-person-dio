package cleiton.duarte.api.person.controller;

import cleiton.duarte.api.person.domain.service.PersonService;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id){
        return personService.findById(id);
    }
    @GetMapping
    public List<PersonDTO> findAll (){
        return personService.findAll();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personService.delete(id);
    }
    @PutMapping("/{id}")
    public PersonDTO upDate(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO){
        return personService.update(id, personDTO);
    }
}
