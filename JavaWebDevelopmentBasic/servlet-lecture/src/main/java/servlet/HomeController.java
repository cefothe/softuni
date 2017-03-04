package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cefothe on 04.03.17.
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.println("I'm home");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if(username!= null){
            pw.println("Username : "+ username);
        }

        session.invalidate();
        req.getRequestDispatcher("home.html").forward(req,resp);
    }
}
