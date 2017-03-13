package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cefothe on 04.03.17.
 */
@WebServlet("/getcookies")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            printWriter.println(String.format("%s - %s %n",cookie.getName(), cookie.getValue()));
        }

        Cookie languageCookie = new Cookie("lang","en");
        resp.addCookie(languageCookie);
    }
}
