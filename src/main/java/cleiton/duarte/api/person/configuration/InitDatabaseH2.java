package cleiton.duarte.api.person.configuration;

import cleiton.duarte.api.person.domain.entity.Person;
import cleiton.duarte.api.person.domain.entity.Phone;
import cleiton.duarte.api.person.domain.enuns.PhoneType;
import cleiton.duarte.api.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Configuration
@AllArgsConstructor
public class InitDatabaseH2 implements CommandLineRunner {

    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Phone> listPhone1 = Arrays.asList(new Phone(null, PhoneType.HOME,"67 99999-9999"));
        List<Phone> listPhone2 = Arrays.asList(new Phone(null, PhoneType.HOME,"67 99999-9999"));
        List<Phone> listPhone3 = Arrays.asList(new Phone(null, PhoneType.HOME,"67 99999-9999"));
        List<Phone> listPhone4 = Arrays.asList(new Phone(null, PhoneType.HOME,"67 99999-9999"));

        Person person1 = new Person(null,"José","Silva","24612096002", LocalDate.now(),listPhone1);
        Person person2 = new Person(null,"Maria","Auxiliadora","06086854025", LocalDate.now(),listPhone2);
        Person person3 = new Person(null,"Marcos","Duarte","36023984045", LocalDate.now(),listPhone3);
        Person person4 = new Person(null,"Cleiton","Gonçalves","88212119084", LocalDate.now(),listPhone4);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);

    }
}
