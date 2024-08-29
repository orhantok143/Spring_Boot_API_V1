package orhanSpringBoot.api.core.utilities.exceptions;
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}