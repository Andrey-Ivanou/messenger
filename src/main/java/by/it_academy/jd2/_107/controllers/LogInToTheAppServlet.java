package by.it_academy.jd2._107.controllers;

import by.it_academy.jd2._107.service.api.ILogInService;
import by.it_academy.jd2._107.service.factory.LogInServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LogInToTheAppServlet extends HttpServlet {
    public static final String SET_CHARTER_ENCODING = "UTF-8";
    public static final String SET_CONTENT_TYPE = "text/html; charset=UTF-8";
    private static final ILogInService logInService = LogInServiceFactory.getInstance();
    private Map<String, String> logPass = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(SET_CHARTER_ENCODING);
        resp.setContentType(SET_CONTENT_TYPE);
        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "</head>\n" +
                "\n" +
                "<body bgcolor=\"#87ceeb\"></body>\n" +
                "\n" +
                "<body>\n" +
                "<form action=\"http://localhost:8080/messenger/log\" method=\"post\">\n" +
                "\n" +
                "    <fieldset>\n" +
                "        <legend><h2>Воход в мессенджер</h2></legend>\n" +
                "\n" +
                "        <p>\n" +
                "            <a><input name=\"login\">Логин</a><br>\n" +
                "            <br>\n" +
                "            <a><input name=\"password\">Пароль</a><br>\n" +
                "            <br>\n" +
                "        </p>\n" +
                "\n" +
                "        <p>\n" +
                "            <input type=\"submit\" value=\"Отправить\">\n" +
                "        </p>\n" +
                "\n" +
                "        <p>\n" +
                "            <a href=\"http://localhost:8080/messenger/reg\">Для регистрации перейдите сюда</a>\n" +
                "        </p>\n" +
                "\n" +
                "    </fieldset>\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

        HttpSession session = req.getSession();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            logInService.getLogIn(login, password);
        } catch (IllegalArgumentException e) {
            writer.write("Отчет об ошибке: " + e.getMessage());
        }


        if(login != null) {
            saveAttribute("login", login, session);
        } else {
            login = getValueFromSession("login", session);
        }

        if(password != null) {
            saveAttribute("password", login, session);
        } else {
            password = getValueFromSession("password", session);
        }


        /*Map<String, String> logPass = new HashMap<>();

        try {
            if (login != null && password != null){
                logPass.put(login, password);
                System.out.println(logPass);
            } else {
                throw new IllegalArgumentException("<fieldset><p><span style= 'color: red;'>Введите логин и пароль</span></p></fieldset>");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> getLogPass() {
        return logPass;
    }*/
    }
    public static void saveAttribute(String nameAttribute, String value, HttpSession session){
        session.setAttribute(nameAttribute, value);
    }
    public static String getValueFromSession(String nameAttribute, HttpSession session){
       return (String) session.getAttribute(nameAttribute);
    }
}
