package cleiton.duarte.api.person.exception;

public class NotFoundResourceException extends RuntimeException {
    public NotFoundResourceException(Long id) {
        super("Resource not found. ID: "+id);
    }
}
