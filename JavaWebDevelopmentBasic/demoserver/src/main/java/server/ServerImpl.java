package server;

import server.http.routing.AppRouteConfig;
import server.http.routing.ServerRouteConfigImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.FutureTask;

/**
 * Created by cefothe on 03.03.17.
 */
public class ServerImpl implements Server {

    private final ServerSocket serverSocket;
    private final ServerRouteConfigImpl serverRouteConfig;
    private boolean isRunning;

    public ServerImpl(ServerSocket serverSocket, AppRouteConfig appRouteConfig) {
        this.serverSocket = serverSocket;
        this.serverRouteConfig = new ServerRouteConfigImpl(appRouteConfig);
    }

    public void runServer() throws SocketException {
        System.out.println("Server started");

        this.isRunning = true;
        this.serverSocket.setSoTimeout(10000);
        this.acceptRequest();
    }

    private void acceptRequest() {
        while (isRunning){
            try(Socket clientSocket = serverSocket.accept()) {
                clientSocket.setSoTimeout(10000);
                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, serverRouteConfig);
                FutureTask<?> futureTask = new FutureTask<>(connectionHandler,null);
                futureTask.run();
            } catch (IOException e) {

            }
        }
    }
}
