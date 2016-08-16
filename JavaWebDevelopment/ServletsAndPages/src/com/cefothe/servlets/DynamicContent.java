package com.cefothe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        resp.getWriter().append(count.toString());

        //set attribute "COUNTER" to req
        req.getSession().setAttribute("COUNTER",++count);
    }
}
