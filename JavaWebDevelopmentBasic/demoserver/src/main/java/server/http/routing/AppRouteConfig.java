package server.http.routing;

import server.http.HttpRequestMethod;
import server.http.handler.RequestHandlerImpl;

import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public interface AppRouteConfig {
    AppRouteConfig addRoute(String path, RequestHandlerImpl handler);
    Iterable<Map.Entry<HttpRequestMethod,Map<String,RequestHandlerImpl>>> getRoutes();
}
