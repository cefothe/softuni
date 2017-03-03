package server.http.routing;

import server.http.HttpRequestMethod;

import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public interface ServerRouteConfig {
    Map<HttpRequestMethod, Map<String, RoutingContext>> getRoutes();
}
