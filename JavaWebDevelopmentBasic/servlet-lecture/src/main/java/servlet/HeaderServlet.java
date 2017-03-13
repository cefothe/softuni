package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by cefothe on 04.03.17.
 */
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        PrintWriter printWriter = resp.getWriter();
        while (headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            String headerElement = req.getHeader(element);
            printWriter.println(headerElement);
        }

        HttpSession session = req.getSession();
        session.setAttribute("username","test");
    }
}
