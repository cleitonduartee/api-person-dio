package cleiton.duarte.api.person.domain.service;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.dto.request.PersonDTO;
import cleiton.duarte.api.person.exception.CpfException;
import cleiton.duarte.api.person.exception.NotFoundResourceException;
import cleiton.duarte.api.person.mapper.PersonMapper;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            throw new CpfException("CPF  já está cadastrado.");
        }
    }

    public PersonDTO findById(Long id) {
        return personMapper.toDTO(verifyExist(id));
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(person -> personMapper.toDTO(person))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        verifyExist(id);
        personRepository.deleteById(id);
    }

    public PersonDTO update(Long id, PersonDTO personDTO) {
        Person personModel = verifyExist(id);
        updateData(personModel, personDTO);

        personModel = personRepository.save(personModel);
        return personMapper.toDTO(personModel);
    }
    private Person verifyExist(Long id){
        return personRepository.findById(id)
                .orElseThrow(()->new NotFoundResourceException(id));
    }
    private void updateData(Person personModel, PersonDTO personDTO){
        if(!cpfIsEquals(personModel.getCpf(),personDTO.getCpf())) throw new CpfException("CPF não pode ser editado.");

        personModel.setBirthDate(LocalDate.parse(personDTO.getBirthDate(),DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        personModel.setFirstName(personDTO.getFirstName());
        personModel.setLastName(personDTO.getLastName());
    }
    private boolean cpfIsEquals(String cpfModel, String cpfUpdate){
        return cpfModel.equals(cpfUpdate);
    }
}
