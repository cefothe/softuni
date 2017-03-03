package server.http.handler;

import server.http.HttpContext;
import server.http.HttpRequestMethod;
import server.http.routing.RoutingContext;
import server.http.routing.ServerRouteConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cefothe on 04.03.17.
 */
public class HttpHandler implements RequestHandler {

    private Writer writer;
    private ServerRouteConfig serverRouteConfig;

    public HttpHandler(ServerRouteConfig serverRouteConfig, PrintWriter printWriter) {
        this.serverRouteConfig = serverRouteConfig;
        this.writer = printWriter;
    }


    @Override
    public void handle(HttpContext httpContext) throws IOException {
        for (Map.Entry<String, RoutingContext> entry : serverRouteConfig.getRoutes().get(httpContext.getHttpRequest().getRequestMethod()).entrySet()) {

            Pattern pattern = Pattern.compile(entry.getKey());
            Matcher matcher = pattern.matcher(httpContext.getHttpRequest().getPath());

            if(!matcher.find()){
                continue;
            }

            for (String param : entry.getValue().getParamNames()) {
                httpContext.getHttpRequest().addParameter(param, matcher.group(param));
            }

            entry.getValue().getHandler().setWriter(this.writer);
            entry.getValue().getHandler().handle(httpContext);

            return;
        }

        throw new FileNotFoundException();
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
