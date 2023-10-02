package ru.javarush.kuznetsov.quest.repository;

import ru.javarush.kuznetsov.quest.entity.Questionnaire;
import java.util.Arrays;
import java.util.List;

public class QuestionnaireRepos {

    private static final QuestionnaireRepos qr = new QuestionnaireRepos();

    public static QuestionnaireRepos get(){
        return qr;
    }

    private List<Questionnaire> questionnaireList = Arrays.asList(
            new Questionnaire(0, null, null, 0 , null,0),
            new Questionnaire(1, "Вы проснулись в темном подземелье. Что вы будете делать?", "Попытаться разжечь факел.",  2, "Попытаться выбраться из подземелья.", 113),
            new Questionnaire(2, "Вы нашли факел и разожгли его. Вы видите перед собой две двери.", "Войти в первую дверь.",  3, "Войти во вторую дверь.",  4),
            new Questionnaire(3, "Вы попали в комнату с сундуком. Открыть его?", "Да", 101,  "Нет", 111),
            new Questionnaire(4, "Вы попали в комнату с монстром. Сражаться?", "Да", 102, "Нет", 112));

    public List<Questionnaire>getAllQuestionnaire(){
        return questionnaireList;
    }

    public Questionnaire getQuestionnareById(Integer id){
        return  questionnaireList.get(id);
    }


}
