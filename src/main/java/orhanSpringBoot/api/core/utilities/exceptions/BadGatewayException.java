package orhanSpringBoot.api.core.utilities.exceptions;
public class BadGatewayException extends RuntimeException {
    public BadGatewayException(String message) {
        super(message);
    }
}
