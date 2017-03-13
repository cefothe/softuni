package com.pizza.lab.models.pages;

import com.pizza.lab.cookie.Cookie;
import com.pizza.lab.models.header.Header;
import com.pizza.lab.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 03.03.17.
 */
public class Home {

    private static Map<String,String> parametars;

    private static Map<String,Cookie> cookies;

    private static Header header;

    static {
        parametars = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
    }

    public static void main(String[] args) {
        getPageParametars();
        Home.header.printHeader();
        getCookies(args);
        printHtml();
    }

    private static void printHtml() {
        Cookie languages = Home.cookies.get("lang");
        if(header.getCookie()!=null){
            languages =header.getCookie();
        }
        if(languages!=null){
            String language = languages.getValue();
            switch (language){
                case "EN":
                        printHtmlEn();
                    break;
                case "DE":
                        printHtmlDe();
                    break;
            }
        }else{
            printHtmlEn();
        }
    }

    private static void getCookies(String[] args) {
        for(String cookie: args){
            String[] tokens = cookie.split("=");
            String name = tokens[0];
            String value = tokens[1];

            Cookie cookieObject = new Cookie(name,value);

            cookies.put(name,cookieObject);
        }
    }

    private static void getPageParametars() {
        Home.parametars = WebUtils.getParameters();
        for (String parameter: parametars.keySet()){
            switch (parameter){
                case "signup":
                    goToSignUp();
                    break;
                case "signin":
                    goToSignIn();
                    break;
                case "language":
                    setCookie();
                    break;

            }
        }
    }

    private static void setCookie() {
        String languageValue = parametars.get("language");
        Cookie cookie = new Cookie("lang",languageValue);
        header.setCookie(cookie);
    }

    private static void goToSignIn() {
        Home.header.setLocation("http://localhost/cgi/pizzamore-lab/signin.cgi");
    }

    private static void goToSignUp() {
        Home.header.setLocation("http://localhost/cgi/pizzamore-lab/signup.cgi");
    }


    private static void printHtmlDe() {
        String html = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Pizza</title>\n" +
                "</head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" />\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" ></script>\n" +
                "    <link rel=\"stylesheet\" href=\"css/home.css\"/>\n" +
                "<body>\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div id=\"mainCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "            <ol class=\"carousel-indicators\">\n" +
                "                <li data-target=\"#mainCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                <li data-target=\"#mainCarousel\" data-slide-to=\"1\"></li>\n" +
                "            </ol>\n" +
                "\n" +
                "            <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                <div class=\"item active\">\n" +
                "                    <img src=\"images/picture_1.jpg\" />\n" +
                "                </div>\n" +
                "                <div class=\"item\">\n" +
                "                    <img src=\"images/picture_2.jpg\" />\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"navbar-header\">\n" +
                "                <a href=\"#\" class=\"navbar-brand\">PizzaMore</a>\n" +
                "            </div>\n" +
                "            <form method=\"post\">\n" +
                "                <input class=\"btn btn-warning  navbar-btn\" type=\"submit\" name=\"language\" value=\"EN\"/>\n" +
                "                <input class=\"btn btn-success navbar-btn\" type=\"submit\" name=\"signin\" value=\"Anmelden\"/>\n" +
                "                <input class=\"btn btn-primary navbar-btn\" type=\"submit\" name=\"signup\" value=\"Unterschre\"/>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
    }

    private static void printHtmlEn() {
        String html = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Pizza</title>\n" +
                "</head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" />\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" ></script>\n" +
                "    <link rel=\"stylesheet\" href=\"css/home.css\"/>\n" +
                "<body>\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div id=\"mainCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "            <ol class=\"carousel-indicators\">\n" +
                "                <li data-target=\"#mainCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                <li data-target=\"#mainCarousel\" data-slide-to=\"1\"></li>\n" +
                "            </ol>\n" +
                "\n" +
                "            <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                <div class=\"item active\">\n" +
                "                    <img src=\"images/picture_1.jpg\" />\n" +
                "                </div>\n" +
                "                <div class=\"item\">\n" +
                "                    <img src=\"images/picture_2.jpg\" />\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "        <div class=\"container\">\n" +
                "            <div class=\"navbar-header\">\n" +
                "                <a href=\"#\" class=\"navbar-brand\">PizzaMore</a>\n" +
                "            </div>\n" +
                "            <form method=\"post\">\n" +
                "                <input class=\"btn btn-warning  navbar-btn\" type=\"submit\" name=\"language\" value=\"DE\"/>\n" +
                "                <input class=\"btn btn-success navbar-btn\" type=\"submit\" name=\"signin\" value=\"Sign in\"/>\n" +
                "                <input class=\"btn btn-primary navbar-btn\" type=\"submit\" name=\"signup\" value=\"Sign up\"/>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </nav>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
    }
}
