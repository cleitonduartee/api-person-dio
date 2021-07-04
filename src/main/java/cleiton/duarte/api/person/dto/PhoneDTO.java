package cleiton.duarte.api.person.dto;

import cleiton.duarte.api.person.domain.enuns.Type;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneDTO {

    private Long id;

    @NotEmpty
    private Type typePhone;

    @NotEmpty
    @Size(min = 8, max = 11)
    private String number;
}
