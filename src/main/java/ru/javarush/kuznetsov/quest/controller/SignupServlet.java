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

@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {
    private final UserService userService = UserService.getUserService();

    private final static Logger log = LoggerFactory.getLogger(SignupServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        log.info("method doGet SignupServlet ID - " +session.getId());
        JspService.reqDispForward(request, response, "signup");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("method doPost SignupServlet - begin");

        String login = request.getParameter("login");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (password1 == null || password2 == null || password1.isBlank() || password2.isBlank()) {
            log.info("method doPost SignupServlet - password1 == null");
            JspService.reqDispForward(request, response, "signup");
        }

        if (password1 != null && !password1.equals(password2)) {
            log.info("method doPost SignupServlet - !password1.equals(password2)");
            JspService.reqDispForward(request, response, "signup");
        }

        Optional<User> user = userService.verifyLogin(login);
        if (user.isEmpty()) {
            log.info("method doPost SignupServlet - yes isEmty");
            userService.createUser(login, password1);
        } else {
            log.info("method doPost SignupServlet - no isEmty");
            JspService.reqDispForward(request, response, "signup");
        }

        log.info("method doPost SignupServlet - end");
        JspService.reqDispForward(request, response, "login");
    }
}
