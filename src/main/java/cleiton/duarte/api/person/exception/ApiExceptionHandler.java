package cleiton.duarte.api.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundResourceException.class)
    public ResponseEntity<StandardError> resourceNotFound(NotFoundResourceException e, HttpServletRequest request){
        String err = "ERRO RECURSO INFORMADO";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = StandardError
                .builder()
                .error(err)
                .status(status.value())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> validation (MethodArgumentNotValidException e, HttpServletRequest request){
        List<FieldMessage> listErrors = new ArrayList<>();
        for(FieldError fieldError: e.getFieldErrors()){
            listErrors.add(new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        String err = "ERRO NA VALIDAÇÂO";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationException validation = ValidationException
                .builder()
                .error(err)
                .message(e.getMessage())
                .path(request.getRequestURI())
                .status(status.value())
                .timestamp(Instant.now())
                .errors(listErrors)
                .build();


        return ResponseEntity.status(status).body(validation);
    }
    @ExceptionHandler(CpfException.class)
    public ResponseEntity<StandardError> cpfDuplicate(CpfException e, HttpServletRequest request){
        String err = "ERRO NA VALIDAÇÂO CPF";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = StandardError
                .builder()
                .timestamp(Instant.now())
                .message(e.getMessage())
                .error(err)
                .path(request.getRequestURI())
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(error);
    }
}
