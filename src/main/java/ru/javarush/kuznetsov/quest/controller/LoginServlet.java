package ru.javarush.kuznetsov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javarush.kuznetsov.quest.entity.User;
import ru.javarush.kuznetsov.quest.service.JspService;
import ru.javarush.kuznetsov.quest.service.UserService;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/log-in")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getUserService();
    private final static Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        log.info("method doGet LoginServlet ID - "+session.getId());
        JspService.reqDispForward(request, response, "log-in");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("method doPost LoginServlet - begin.");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            Optional<User> user = userService.findUser(login, password);
            if (user.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user.get());
                log.info("method doPost LoginServlet -> "+session.getAttribute("user"));
            }
            log.info("method doPost LoginServlet - password correct.");
        } else {
            log.info("method doPost LoginServlet - login, password -> null.");
        }

        log.info("method doPost LoginServlet - end.");

        JspService.reqDispForward(request, response, "login");
    }
}
