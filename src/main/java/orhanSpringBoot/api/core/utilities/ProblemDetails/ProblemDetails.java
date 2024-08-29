package orhanSpringBoot.api.core.utilities.ProblemDetails;

import java.util.Date;


public class ProblemDetails {
    private Date timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ProblemDetails(int status, String error, String message, String path) {
        this.timestamp = new Date();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getter ve setter metodları
    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
