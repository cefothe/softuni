package server.http.routing;

import server.http.handler.RequestHandlerImpl;

/**
 * Created by cefothe on 03.03.17.
 */
public interface RoutingContext {
    RequestHandlerImpl getHandler();

    Iterable<String> getParamNames();
}
