package excercise;

/**
 * Created by cefothe on 01.03.17.
 */
public class FirstCgi {


    public static void main(String[] args) {
        setContentType();
        setHtmlBody();
    }

    public static void setContentType(){
        String contentType= "Content-type: text/html \n";
        System.out.println(contentType);
    }

    public static void setHtmlBody(){
        String body = "<html><p>Exercise</p></html> \n";
        System.out.println(body);
    }
}
