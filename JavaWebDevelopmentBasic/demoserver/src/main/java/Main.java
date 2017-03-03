import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cefothe on 03.03.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String data ="";
        while (br.ready() || data.length()==0){
            data += (char)br.read();
        }

        System.out.println(data);

        PrintWriter printWriter= new PrintWriter(clientSocket.getOutputStream());
        printWriter.write("HTTP/1.1 200 OK");
        printWriter.write(String.format("%n%n Hello"));

        printWriter.close();
        br.close();
        clientSocket.close();
        serverSocket.close();
    }
}
