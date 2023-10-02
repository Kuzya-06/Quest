package ru.javarush.kuznetsov.quest.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.javarush.kuznetsov.quest.entity.Questionnaire;
import ru.javarush.kuznetsov.quest.repository.QuestionnaireRepos;

import java.io.IOException;
import java.util.List;

public class QuestionnaireService {
    QuestionnaireRepos questionnaireRepos = new QuestionnaireRepos();

    public List<Questionnaire> getAllQuestionnaire(){
        return questionnaireRepos.getAllQuestionnaire();
    }

    public Questionnaire getQuestionnareById(Integer id){
        return  questionnaireRepos.getQuestionnareById(id);
    }



    public void getRadiosOutputRequest(String radios, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(radios.equals("2")){
            Questionnaire gameById = getQuestionnareById(2);

            request.setAttribute("gameId", gameById);

//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("quest.jsp");
//            requestDispatcher.forward(request, response);
            JspService.reqDispForward(request, response, "quest");
        }
        if(radios.equals("3")){
            Questionnaire gameById = getQuestionnareById(3);

            request.setAttribute("gameId", gameById);

//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("quest.jsp");
//            requestDispatcher.forward(request, response);
            JspService.reqDispForward(request, response, "quest");
        }
        if(radios.equals("4")){
            Questionnaire gameById = getQuestionnareById(4);

            request.setAttribute("gameId", gameById);

//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("quest.jsp");
//            requestDispatcher.forward(request, response);
            JspService.reqDispForward(request, response, "quest");
        }

    }

}
