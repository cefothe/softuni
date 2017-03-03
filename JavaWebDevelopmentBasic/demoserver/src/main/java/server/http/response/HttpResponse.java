package server.http.response;

/**
 * Created by cefothe on 03.03.17.
 */
public interface HttpResponse {
    String getResponse();

    void addResponseHeader(String header, String value);
}
