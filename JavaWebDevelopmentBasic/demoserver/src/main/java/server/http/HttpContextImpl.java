package server.http;

import server.exception.BadRequestException;

import java.io.UnsupportedEncodingException;

/**
 * Created by cefothe on 03.03.17.
 */
public class HttpContextImpl implements HttpContext {

    private final HttpRequestImpl httpRequest;

    public HttpContextImpl(String requestString) throws BadRequestException, UnsupportedEncodingException {
        this.httpRequest = new HttpRequestImpl(requestString);
    }
    
    @Override
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }
}
