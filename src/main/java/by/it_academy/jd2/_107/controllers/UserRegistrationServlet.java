package by.it_academy.jd2._107.controllers;

import by.it_academy.jd2._107.dto.UserDTO;
import by.it_academy.jd2._107.service.api.IUserRegistrationService;
import by.it_academy.jd2._107.service.factory.MessengerServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class UserRegistrationServlet extends HttpServlet {

    public static final String SET_CHARTER_ENCODING = "UTF-8";
    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final IUserRegistrationService messengerService = MessengerServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>messenger</title>\n" +
                "</head>\n" +
                "<body bgcolor=\"#87ceeb\">\n" +
                "\n" +
                "<form action=\"http://localhost:8080/messenger/reg\" method=\"get\" autocomplete=\"off\" >\n" +
                "\n" +
                "    <fieldset>\n" +
                "        <legend><h2>Форма для регистрации в мессенджер</h2></legend>\n" +
                "\n" +
                "        <p>\n" +
                "            <a><input type=\"text\" name=\"fullName\">Введите ФИО</a><br>\n" +
                "            <br>\n" +
                "            <a><input type=\"date\" name=\"date\">Дату рождения</a><br>\n" +
                "            <br>\n" +
                "            <a><input type=\"text\"name=\"login\">Логин</a><br>\n" +
                "            <br>\n" +
                "            <a><input type=\"password\" name=\"password\">Пароль</a><br>\n" +
                "            <br>\n" +
                "        </p>\n" +
                "        <p>\n" +
                "            <input type=\"submit\" value=\"Отправить\">\n" +
                "        </p>\n" +
                "\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");


        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("date"));

        try {
            messengerService.create(new UserDTO(login, password, fullName, dateOfBirth));
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }

        /*<form action=\"" + req.getContextPath() + "/messenger/reg\" method=\"get\">\n" +*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("date"));

        try {
            messengerService.create(new UserDTO(login, password, fullName, dateOfBirth));
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }
    }
}
