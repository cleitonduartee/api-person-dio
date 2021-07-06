package cleiton.duarte.api.person.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StandardError {
    private LocalTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
