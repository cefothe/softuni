package server.http.routing;

import server.http.handler.RequestHandlerImpl;

import java.util.List;

/**
 * Created by cefothe on 03.03.17.
 */
public class RoutingContextImpl implements RoutingContext {

    private RequestHandlerImpl handler;
    private List<String> paramNames;

    public RoutingContextImpl(RequestHandlerImpl handler, List<String> paramNames) {
        this.handler = handler;
        this.paramNames = paramNames;
    }

    @Override
    public RequestHandlerImpl getHandler() {
        return this.handler;
    }

    @Override
    public Iterable<String> getParamNames() {
        return this.paramNames;
    }
}
