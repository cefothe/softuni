package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cefothe on 04.03.17.
 */
@WebServlet("/form")
public class FormController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("form.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String home = req.getParameter("home");
       String signin = req.getParameter("signin");
        if(signin!=null){
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect("/home");
        }
        if(home != null){
            resp.sendRedirect("/home");
        }
    }
}
