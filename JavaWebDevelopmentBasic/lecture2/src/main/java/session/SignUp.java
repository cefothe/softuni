package session;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cefothe on 02.03.17.
 */
public class SignUp {

    public static void main(String[] args) throws IOException {
        System.out.println("Content-type: text/html \n\n");
        System.out.println(read(SignUp.class.getClassLoader().getResourceAsStream("html/signup.html")));
        Map<String,String> parameters = Utils.getParameters(System.in);
        System.out.println(parameters);

        if(parameters != null && parameters.size() >0 ){
            String username = parameters.get("username");
            String password = parameters.get("password");

            User user = new User(username,password);

            try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("/var/www/cgi/myuser.user"))){
                ous.writeObject(user);
            }
        }
    }

    public static String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
