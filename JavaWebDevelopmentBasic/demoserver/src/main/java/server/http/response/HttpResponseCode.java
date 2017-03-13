package server.http.response;

/**
 * Created by cefothe on 03.03.17.
 */
public enum HttpResponseCode {
    OK(200, "OK"), MOVED_PERMANTLY(301,"Moved Pernamently"), CREATED(201, "Created"), FOUND(302, "Found"),
    UNAUTHORIZED(401,"Unauthorized");

    private int value;
    private String text;

    HttpResponseCode(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
