package server.http.routing;

import server.http.HttpRequest;
import server.http.HttpRequestMethod;
import server.http.handler.RequestHandlerImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public class AppRouteConfigImpl implements AppRouteConfig {

    private Map<HttpRequestMethod,Map<String,RequestHandlerImpl>> routes;

    public AppRouteConfigImpl() {
        this.routes = new HashMap<>();

        for (HttpRequestMethod httpRequestMethod: HttpRequestMethod.values()){
            this.routes.put(httpRequestMethod, new HashMap<>());
        }
    }

    @Override
    public AppRouteConfig addRoute(String path, RequestHandlerImpl handler) {

        if(handler.getClass().toString().toLowerCase().contains("get")){
          this.routes.get(HttpRequestMethod.GET).put(path,handler);
        }
        else if(handler.getClass().toString().toLowerCase().contains("post")){
            this.routes.get(HttpRequestMethod.POST).put(path,handler);
        }

        return this;
    }

    @Override
    public Iterable<Map.Entry<HttpRequestMethod, Map<String, RequestHandlerImpl>>> getRoutes() {
        return this.routes.entrySet();
    }
}
