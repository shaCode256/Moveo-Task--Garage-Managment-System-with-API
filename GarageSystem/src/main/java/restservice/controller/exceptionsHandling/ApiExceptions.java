package restservice.controller.exceptionsHandling;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiExceptions {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public ApiExceptions(String message,
                         Throwable throwable,
                         HttpStatus httpStatus,
                         ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessege() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
