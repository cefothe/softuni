package cookie;

/**
 * Created by cefothe on 02.03.17.
 */
public class CookieDemo {

    public static void main(String[] args) {
        setContentType();
        setCookie();
        String cookieValue = System.getProperty("cgi_cookie");
        System.out.println(cookieValue);
    }

    public static void setContentType(){
        String contentType= "Content-type: text/html \n";
        System.out.print(contentType);
    }

    public static void setCookie(){
        System.out.print("Set-Cookie:" + new Cookie("lang","en").getCookie()+"\n\n");
    }
}
