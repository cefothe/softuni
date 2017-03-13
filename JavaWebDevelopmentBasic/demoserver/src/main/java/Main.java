import app.MainApplication;
import server.Application;
import server.Server;
import server.ServerImpl;
import server.http.routing.AppRouteConfig;
import server.http.routing.AppRouteConfigImpl;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by cefothe on 03.03.17.
 */
public class Main {

    public static void main(String[] args)  {
        try {
            Application application = new MainApplication();
            AppRouteConfig appRouteConfig = new AppRouteConfigImpl();
            application.start(appRouteConfig);
            ServerSocket serverSocket = new ServerSocket(8080);
            Server server = new ServerImpl(serverSocket,appRouteConfig);
            server.runServer();
        } catch (IOException e) {

        }
    }
}
