package session;

import cookie.Cookie;

import java.io.*;
import java.util.Map;
import java.util.Random;


/**
 * Created by cefothe on 02.03.17.
 */
public class SignIn {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<String,String> parameters = Utils.getParameters(System.in);
        Cookie cookie = null;
        if(parameters.containsKey("signin")) {
            User fileUser = readUser();
            if (parameters != null && parameters.size() > 0) {
                String username = parameters.get("username");
                String password = parameters.get("password");

                if (fileUser.getName().equals(username) && fileUser.getPassword().equals(password)) {
                    cookie = createSession();
                }
            }
        }
        setHeader(parameters.get("location"), cookie);
        if(System.getProperty("cgi_cookie")!=null){
            System.out.println(System.getProperty("cgi_cookie"));
        }
            setHtml();


    }

    public static void setHtml() throws IOException {
        System.out.println(SignUp.read(SignIn.class.getClassLoader().getResourceAsStream("html/signin.html")));
    }

    public static User readUser() throws IOException, ClassNotFoundException {
        User user = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/var/www/cgi/myuser.user"))){
            user = (User) ois.readObject();
        }
        return user;
    }

    public static void setHeader(String location, Cookie cookie){
        System.out.print("Content-type: text/html \n");
        if(location!=null){
            System.out.print("Location: http://localhost \n");
        }
        if(cookie!=null){
            System.out.print("Set-Cookie:"+cookie.getCookie()+"\n");
        }
        System.out.print("\n");
    }

    public static Cookie createSession() throws IOException {
        Long sid = new Random().nextLong();
        Session session = new Session(sid);
        try(ObjectOutputStream ous=  new ObjectOutputStream(new FileOutputStream("/var/www/cgi/mysession.session"))){
            ous.writeObject(session);
            return  createCookie(sid);
        }
    }

    public static Cookie createCookie(Long id){
        return new Cookie("sid",id.toString());
    }
}
