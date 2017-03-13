package app;

import app.controller.HomeController;
import app.controller.UserController;
import server.Application;
import server.http.handler.GetHandler;
import server.http.routing.AppRouteConfig;

/**
 * Created by cefothe on 03.03.17.
 */
public class MainApplication  implements Application{

    @Override
    public void start(AppRouteConfig appRouteConfig) {
        appRouteConfig.addRoute("/", new GetHandler(httpContext -> new HomeController().index()));
        appRouteConfig.addRoute("/users/{(?<name>[a-z]+)}/details", new GetHandler(httpContext ->
                new UserController().details(httpContext.getHttpRequest().getURLParameters().get("name"))));

    }
}
