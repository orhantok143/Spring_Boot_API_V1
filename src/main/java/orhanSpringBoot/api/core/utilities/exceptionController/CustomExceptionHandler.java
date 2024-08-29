package orhanSpringBoot.api.core.utilities.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import orhanSpringBoot.api.core.utilities.ProblemDetails.ProblemDetails;
import orhanSpringBoot.api.core.utilities.exceptions.BadGatewayException;
import orhanSpringBoot.api.core.utilities.exceptions.BadRequestException;
import orhanSpringBoot.api.core.utilities.exceptions.ForbiddenException;
import orhanSpringBoot.api.core.utilities.exceptions.ResourceNotFoundException;
import orhanSpringBoot.api.core.utilities.exceptions.UnauthorizedException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(problemDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ProblemDetails> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ProblemDetails> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(problemDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ProblemDetails> handleForbiddenException(ForbiddenException ex, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(problemDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleGlobalException(Exception ex, WebRequest request) {
        ProblemDetails ProblemDetails = new ProblemDetails(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(ProblemDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Diğer HTTP hataları için metodlar
    @ExceptionHandler(BadGatewayException.class)
    public ResponseEntity<ProblemDetails> handleBadGatewayException(BadGatewayException ex, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.BAD_GATEWAY.value(),
                HttpStatus.BAD_GATEWAY.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_GATEWAY);
    }

}
