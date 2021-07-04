package cleiton.duarte.api.person.domain.entity;

import cleiton.duarte.api.person.domain.enuns.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Phone {
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type typePhone;
    private Integer number;
}
