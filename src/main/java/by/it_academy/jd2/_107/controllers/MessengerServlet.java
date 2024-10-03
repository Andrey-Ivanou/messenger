package by.it_academy.jd2._107.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class MessengerServlet extends HttpServlet {
    public static final String SET_CHARTER_ENCODING = "UTF-8";
    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        session.getAttribute("login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
