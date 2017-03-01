public class Test {
    public static void main(String[] args) {
        String type = "Content-Type: text/html\n\n";
        String output =
                "<html>" +
                    "<body>" +
                        "<b>" +
                        "Hello from CGI!" +
                        "</b>" +
                    "</body>" +
                "</html>";
        System.out.println(type);
        System.out.println(output);
    }
}