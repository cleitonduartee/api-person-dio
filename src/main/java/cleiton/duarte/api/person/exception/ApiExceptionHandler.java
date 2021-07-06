package cleiton.duarte.api.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

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
}
