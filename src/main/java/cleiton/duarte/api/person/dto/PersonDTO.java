package cleiton.duarte.api.person.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO {
    private Long id;

    @NotEmpty
    @Size(min = 3,max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 3,max = 20)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private LocalDate birthDate;

    @NotEmpty
    @Valid
    List<PhoneDTO> phones = new ArrayList<>();
}
