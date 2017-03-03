package server;

import server.exception.BadRequestException;
import server.http.HttpContext;
import server.http.HttpContextImpl;
import server.http.handler.HttpHandler;
import server.http.routing.ServerRouteConfig;
import server.http.routing.ServerRouteConfigImpl;

import java.io.*;
import java.net.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.regex.Pattern;

public class ConnectionHandler implements Runnable {
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;
    private final ServerRouteConfig serverRouteConfig;


    public ConnectionHandler(Socket clientSocket, ServerRouteConfig serverRouteConfig) throws IOException {
        this.socket = clientSocket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter = new PrintWriter(socket.getOutputStream());
        this.serverRouteConfig = serverRouteConfig;

    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while(this.bufferedReader.ready()
                    || stringBuilder.length() == 0){
                stringBuilder.append((char) this.bufferedReader.read());
            }

            try {
                HttpContext httpContext = new HttpContextImpl(stringBuilder.toString());
                new HttpHandler(this.serverRouteConfig, this.printWriter).handle(httpContext);
//                HttpSession session = httpContext.getHttpRequest().getHttpSession();
//                this.sessionMap.put(session.getId(), session);
            } catch (BadRequestException e) {
                this.printWriter.write("HTTP/1.1 400 Bad Request");
            } catch (FileNotFoundException e){
                this.printWriter.write("HTTP/1.1 404 Not Found");
            } catch (Exception e) {
                e.printStackTrace();
                this.printWriter.write("HTTP/1.1 500 Internal Server Error");
            }

            this.printWriter.close();
            this.bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}