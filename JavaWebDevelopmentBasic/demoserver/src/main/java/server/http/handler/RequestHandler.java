package server.http.handler;

import server.http.HttpContext;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by cefothe on 03.03.17.
 */
public interface RequestHandler {
    void handle(HttpContext httpContext) throws IOException;
    void setWriter(Writer writer);
}
