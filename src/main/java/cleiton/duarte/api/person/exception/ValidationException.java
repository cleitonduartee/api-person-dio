package cleiton.duarte.api.person.exception;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class ValidationException extends StandardError {

    @Singular
    private List<FieldMessage> errors ;

    public ValidationException(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);

       // this.errors = new ArrayList<>();
    }
//
//    public void adicionarError(String field, String message){
//        errors.add(new FieldMessage(field, message));
//    }
}
