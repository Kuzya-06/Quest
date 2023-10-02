package ru.javarush.kuznetsov.quest.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionnaireTest {
Questionnaire questionnaire = new Questionnaire(5, "Вы попали в комнату 5", "Да", 6, "Нет", 7);

    @Test
    void getAnswer1() {
        Assertions.assertEquals(5, questionnaire.getIdQest());
        Assertions.assertEquals("Вы попали в комнату 5", questionnaire.getQuestion());
        Assertions.assertEquals("Да", questionnaire.getAnswer1());
        Assertions.assertEquals(6, questionnaire.getIdNext1());
        Assertions.assertEquals("Нет", questionnaire.getAnswer2());
        Assertions.assertEquals(7, questionnaire.getIdNext2());
    }
}