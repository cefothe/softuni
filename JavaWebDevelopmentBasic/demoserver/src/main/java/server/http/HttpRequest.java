package server.http;

import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public interface HttpRequest {
    String getURL();
    String getPath();
    HttpRequestMethod getRequestMethod();
    String getHeader(String name);
    Map<String, String> getURLParameters();
    Map<String, String> getQueryParameters();
    Map<String, String> getFormData();
    void addParameter(String name, String value);
}
