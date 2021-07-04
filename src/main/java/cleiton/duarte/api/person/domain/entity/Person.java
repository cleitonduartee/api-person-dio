package cleiton.duarte.api.person.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private LocalDate birthDate;

    List<Phone> phones = new ArrayList<>();

    public Person(Long id, String firstName, String lastName, String cpf, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }
}
