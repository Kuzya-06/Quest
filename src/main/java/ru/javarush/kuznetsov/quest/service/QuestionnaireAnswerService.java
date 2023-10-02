package ru.javarush.kuznetsov.quest.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.kuznetsov.quest.repository.QuestionnaireAnswerRepo;

import java.io.IOException;

public class QuestionnaireAnswerService {
    private QuestionnaireAnswerRepo qar = new QuestionnaireAnswerRepo();


    public String getAnswer(Integer idAnswer) {
        return qar.getAnswer(idAnswer);
    }

    public String getAnswerImg(Integer idAnswer) {
        return qar.getAnswerImg(idAnswer);
    }

    public void getAnswerRequest(Integer idAnswer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String answer = getAnswer(idAnswer);
        String img = getAnswerImg(idAnswer);

        request.setAttribute("answer", answer);
        request.setAttribute("answerImg", img);

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/winner.jsp");
//        requestDispatcher.forward(request, response);

        JspService.reqDispForward(request, response, "winner");
    }
}


