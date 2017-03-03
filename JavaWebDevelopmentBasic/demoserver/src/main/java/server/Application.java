package server;

import server.http.routing.AppRouteConfig;

/**
 * Created by cefothe on 03.03.17.
 */
public interface Application {
    void start(AppRouteConfig appRouteConfig);
}
