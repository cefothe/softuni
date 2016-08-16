package com.cefothe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by stefanangelov on 8/15/16.
 */
@WebServlet("/DynamicContent")
public class DynamicContent extends HttpServlet {

    public DynamicContent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set content type on response
        resp.setContentType("text/html");

        //get attribute "COUNTER" from session
        Integer count= (Integer) req.getSession().getAttribute("COUNTER");

        if(count==null){
            count = 0;
        }

        // Return counter to response
        resp.getWriter().append(formatDynamicContent(count));

        //set attribute "COUNTER" to req
        req.getSession().setAttribute("COUNTER",++count);
    }

    private String formatDynamicContent(int count){
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>").append("Dynamic Content").append("</title></head>");
        builder.append("<body>");
        builder.append("<h2>Timestamp:").append(LocalDateTime.now()).append("</h2><br>");
        builder.append("<h3>Times:").append(count).append("</h3>");
        builder.append("</body>");
        builder.append("</html>");
        return  builder.toString();
    }
}
