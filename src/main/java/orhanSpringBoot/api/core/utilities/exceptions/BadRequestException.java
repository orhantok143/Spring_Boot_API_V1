package orhanSpringBoot.api.core.utilities.exceptions;
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}