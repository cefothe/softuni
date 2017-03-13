package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cefothe on 04.03.17.
 */
@WebServlet("/main")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> weekdays = new ArrayList<String>(){{
            add("Sunday");
            add("Saturday");
        }};

        req.setAttribute("weekdays",weekdays);
        req.getRequestDispatcher("beer.jsp").forward(req,resp);
    }
}
