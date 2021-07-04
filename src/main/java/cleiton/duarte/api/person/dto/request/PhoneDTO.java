package cleiton.duarte.api.person.dto.request;

import cleiton.duarte.api.person.domain.enuns.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@Builder
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @NotEmpty
    @Size(min = 8, max = 11)
    private String number;
}
