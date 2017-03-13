package server.exception;

/**
 * Created by cefothe on 03.03.17.
 */
public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }
}
