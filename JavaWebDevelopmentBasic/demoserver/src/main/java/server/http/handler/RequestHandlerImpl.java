package server.http.handler;

import server.http.HttpContext;
import server.http.response.HttpResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

/**
 * Created by cefothe on 03.03.17.
 */
public abstract class RequestHandlerImpl implements  RequestHandler {

    private final Function<HttpContext, HttpResponse> function;
    private Writer writer;

    protected RequestHandlerImpl(Function<HttpContext, HttpResponse> function) {
        this.function = function;
    }

    @Override
    public void handle(HttpContext httpContext) throws IOException {
        HttpResponse httpResponse = function.apply(httpContext);
        httpResponse.addResponseHeader("Content-Type","text/html");
        this.writer.write(httpResponse.getResponse());
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
