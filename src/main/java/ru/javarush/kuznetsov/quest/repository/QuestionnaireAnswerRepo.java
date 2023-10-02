package ru.javarush.kuznetsov.quest.repository;

import ru.javarush.kuznetsov.quest.entity.QuestionnaireAnswer;

import java.util.Arrays;
import java.util.List;

public class QuestionnaireAnswerRepo {

    private String img5 = "https://www.stratege.ru/misc/news/VE/merc05.jpg";
    private String img4 = "https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663686060_41-mykaleidoscope-ru-p-strakh-temnoti-u-vzroslikh-oboi-47.jpg";
    private String img3 = "https://n1s1.hsmedia.ru/b1/46/3a/b1463afb93d594b742147ccc8f93bf19/1000x600_21_23c58b9a4638a635aa88fd25b8383260@1500x900_0xac120003_6142305811624470738.jpg";
    private String img2 = "https://mykaleidoscope.ru/x/uploads/posts/2022-09/1663408088_14-mykaleidoscope-ru-p-lestnitsa-v-zamke-oboi-15.jpg";
    private String img1 = "https://sun9-30.userapi.com/impg/ss9Ihiy02Q2NNZULkfgN5smwXdXy47MTCkiQWQ/QCCsCFCtdeo.jpg?size=604x457&quality=95&sign=cc432b8ddea7fd84cc4008c68aee084f&type=album";

    private List<QuestionnaireAnswer> questionnaireAnswerRepoList = Arrays.asList(
            new QuestionnaireAnswer(101, "Вы нашли магический артефакт и открыли портал домой!", img1),
            new QuestionnaireAnswer(102, "Вы победили монстра и нашли выход из подземелья!", img2),
            new QuestionnaireAnswer(111, "Вы умерли от голода и жажды!", img3),
            new QuestionnaireAnswer(112, "Вы умерли от рук монстра!", img4),
            new QuestionnaireAnswer(113, "Вы попали в ловушку и умерли.", img5)
    );

    public List<QuestionnaireAnswer> getQuestionnaireAnswerRepoList() {
        return questionnaireAnswerRepoList;
    }

    public String getAnswer(Integer idAnswer) {

        for (QuestionnaireAnswer qAnswer : questionnaireAnswerRepoList) {
            if (qAnswer.getId() == idAnswer) {
                return qAnswer.getText();
            }
        }
        return "No Answer, ERROR!";
    }

    public String getAnswerImg(Integer idAnswer) {

        for (QuestionnaireAnswer qAnswer : questionnaireAnswerRepoList) {
            if (qAnswer.getId() == idAnswer) {
                return qAnswer.getImg();
            }
        }
        return "No Answer, ERROR!";
    }
}
