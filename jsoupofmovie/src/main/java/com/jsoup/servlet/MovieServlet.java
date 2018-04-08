package com.jsoup.servlet;

import com.jsoup.pojo.Movie;
import com.jsoup.tool.ExtractMovie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MovieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String member = request.getParameter("member");

        List<Movie> listMovie = new ArrayList<Movie>();
        ExtractMovie extractMovie = new ExtractMovie();
        listMovie = extractMovie.extractFilm(id,title,member);


        HttpSession session = request.getSession();
        session.setAttribute("listMovie",listMovie);
        response.sendRedirect("checkList.jsp");




        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
