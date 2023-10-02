package ru.javarush.kuznetsov.quest.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.javarush.kuznetsov.quest.repository.QuestionnaireRepos;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireTest {
Questionnaire questionnaire = new Questionnaire(5, "Вы попали в комнату 5", "Да", 6, "Нет", 7);
    QuestionnaireRepos qr= QuestionnaireRepos.get();
    @Test
    void getAnswerTest() {
        Assertions.assertEquals(5, questionnaire.getIdQest());
        Assertions.assertEquals("Вы попали в комнату 5", questionnaire.getQuestion());
        Assertions.assertEquals("Да", questionnaire.getAnswer1());
        Assertions.assertEquals(6, questionnaire.getIdNext1());
        Assertions.assertEquals("Нет", questionnaire.getAnswer2());
        Assertions.assertEquals(7, questionnaire.getIdNext2());
    }

    @Test
    void getAnswerByIdQestZeroTest(){
        List<Questionnaire> allQuestionnaire = qr.getAllQuestionnaire();
        Assertions.assertEquals(0, allQuestionnaire.get(0).getIdQest());
        Assertions.assertEquals(null, allQuestionnaire.get(0).getQuestion());
        Assertions.assertEquals(null, allQuestionnaire.get(0).getAnswer1());
        Assertions.assertEquals(0, allQuestionnaire.get(0).getIdNext1());
        Assertions.assertEquals(null, allQuestionnaire.get(0).getAnswer2());
        Assertions.assertEquals(0, allQuestionnaire.get(0).getIdNext2());

    }

}