package post;

/**
 * Created by cefothe on 02.03.17.
 */
public class Main {

    public static void main(String[] args) {
        setHeader();
        setHtml();
        System.out.println(System.getProperty("cgi.request_method"));
        System.out.println(System.getProperty("cgi.query_string"));
    }

    public static void setHeader(){
        System.out.println("Content-type: text/html \n");
    }

    public static void setHtml(){
        String htmlContent ="<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"get\">\n" +
                "        <span>Name:</span><input type=\"text\" name=\"name\"/><br/>\n" +
                "        <span>Price:</span><input type=\"text\" name=\"price\"/><br/>\n" +
                "        <input type=\"submit\" value=\"show\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(htmlContent);
    }

}
