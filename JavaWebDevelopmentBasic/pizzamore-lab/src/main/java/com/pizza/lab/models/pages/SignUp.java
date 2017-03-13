package com.pizza.lab.models.pages;

import com.pizza.lab.models.header.Header;
import com.pizza.lab.models.entities.User;
import com.pizza.lab.repository.UserRepository;
import com.pizza.lab.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public class SignUp {

    private static Map<String,String> parametars;

    private static Header header;

    private static UserRepository userRepository;

    static {
        parametars = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
    }

    public static void main(String[] args) {
        //GET parameters
        getPageParameters();
        //print header
        header.printHeader();
        
        printHtml();
    }

    private static void printHtml() {
        String html = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Sign Up</title>\n" +
                "</head>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" />\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" ></script>\n" +
                "<link rel=\"stylesheet\" href=\"css/signup.css\"/>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"jumbotron vertical-center\">\n" +
                "            <form method=\"post\" class=\"form-horizontal\">\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2 col-sm-offset-2\">Username:</label>\n" +
                "                    <div class=\"col-sm-4\">\n" +
                "                        <input class=\"form-control\" name=\"username\" type=\"text\"/>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2 col-sm-offset-2\">Password:</label>\n" +
                "                    <div class=\"col-sm-4\">\n" +
                "                        <input class=\"form-control\" name=\"password\" type=\"password\"/>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <div class=\"col-sm-offset-4 col-sm-4\">\n" +
                "                        <input class=\"btn btn-success\" type=\"submit\" name=\"signup\" value=\"Sign Up\"/>\n" +
                "                        <input class=\"btn btn-warning\" type=\"submit\" name=\"home\" value=\"Home\"/>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }

    private static void getPageParameters() {
        SignUp.parametars= WebUtils.getParameters();
        for (String parameter: parametars.keySet()){
            switch (parameter){
                case "signup":
                    String username = parametars.get("username");
                    String password = parametars.get("password");
                    createUser(username, password);
                    goToSignPage();
                    break;
                case "home":
                    goToHome();
                    break;

            }
        }
    }

    private static void goToSignPage() {
        SignUp.header.setLocation("http://localhost/cgi/pizzamore-lab/signin.cgi");
    }

    private static void goToHome() {
        SignUp.header.setLocation("http://localhost/cgi/pizzamore-lab/home.cgi");
    }

    private static void createUser(String username, String password) {
        User user = new User(username,password);
        SignUp.userRepository.createUser(user);
    }
}
