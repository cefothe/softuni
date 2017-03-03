package server.http.handler;

import server.http.HttpContext;
import server.http.response.HttpResponse;

import java.util.function.Function;

/**
 * Created by cefothe on 03.03.17.
 */
public class GetHandler extends RequestHandlerImpl {

    public GetHandler(Function<HttpContext, HttpResponse> function) {
        super(function);
    }
}
