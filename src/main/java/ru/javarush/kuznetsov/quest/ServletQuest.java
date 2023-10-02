package ru.javarush.kuznetsov.quest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javarush.kuznetsov.quest.entity.Questionnaire;
import ru.javarush.kuznetsov.quest.service.JspService;
import ru.javarush.kuznetsov.quest.service.QuestionnaireAnswerService;
import ru.javarush.kuznetsov.quest.service.QuestionnaireService;
import java.io.IOException;


@WebServlet(name = "servletQuest", value = "/start")
public class ServletQuest extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(ServletQuest.class);

    QuestionnaireService questionnaireService = new QuestionnaireService();
    QuestionnaireAnswerService qas = new QuestionnaireAnswerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("method doGet ServletQuest - begin.");

        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

        Questionnaire gameById = questionnaireService.getQuestionnareById(1);
        request.setAttribute("gameId", gameById);

        log.info("method doGet ServletQuest - end.");

        JspService.reqDispForward(request, response, "quest");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("method doPost ServletQuest - begin.");

        HttpSession session = request.getSession(true);
        String id = session.getId();
        System.out.println("id " + id);

        session = request.getSession(true);
        log.info("method doPost ServletQuest: session -> " + session);
        String radios = request.getParameter("radios");

        Integer idAnswer = Integer.parseInt(radios);
        if (idAnswer > 100) {
            qas.getAnswerRequest(idAnswer, request, response);
            log.info("method doPost ServletQuest: idAnswer -> " + idAnswer);
        } else {
            log.info("method doPost ServletQuest - idAnswer -> " + idAnswer);
            log.info("method doPost ServletQuest - end.");
            questionnaireService.getRadiosOutputRequest(radios, request, response);
        }
    }
}
