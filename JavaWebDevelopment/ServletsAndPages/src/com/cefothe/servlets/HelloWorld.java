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
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

    public HelloWorld() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Append values to response
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        resp.getWriter().println();
        resp.getWriter().append(LocalDateTime.now().toString());


        resp.getWriter().println();

        //get attribute "COUNTER" from session
        Integer count= (Integer) req.getSession().getAttribute("COUNTER");

        if(count==null){
            count = 0;
        }
        
        // Return counter to response
        resp.getWriter().append(count.toString());
    }
}
