package cleiton.duarte.api.person.exception;

public class CpfDuplicationException extends RuntimeException{
    public CpfDuplicationException(String msg) {
        super(msg);
    }
}
