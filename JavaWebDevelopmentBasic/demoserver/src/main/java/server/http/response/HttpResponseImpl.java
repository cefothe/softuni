package server.http.response;

import server.http.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public abstract class HttpResponseImpl implements HttpResponse {

    private final HttpResponseCode responseCode;
    private View template;
    private Map<String, String> responseHeaders = new HashMap<>();

    protected HttpResponseImpl(String redirectUrl) {
        this.responseCode = HttpResponseCode.MOVED_PERMANTLY;
        this.addResponseHeader("Location",redirectUrl);
    }


    protected HttpResponseImpl(HttpResponseCode responseCode, View view) {
        this.responseCode = responseCode;
        this.template = view;
    }

    @Override
    public String getResponse() {
        StringBuilder response = new StringBuilder();
        response.append(String.format("HTTP/1.1 %d %s%n",this.responseCode.getValue(), this.responseCode.getText()));

        for (Map.Entry<String, String> entry : responseHeaders.entrySet()) {
            response.append(String.format("%s: %s%n", entry.getKey(), entry.getValue()));
        }
        response.append(System.lineSeparator());

        if(this.responseCode != HttpResponseCode.MOVED_PERMANTLY){
            response.append(this.template.view());
        }
        return response.toString();
    }

    @Override
    public void addResponseHeader(String header, String value) {
        this.responseHeaders.put(header,value);
    }
}
