package ru.javarush.kuznetsov.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Questionnaire {
    private int idQest;

    private String question;

    private String answer1;
//    private int luck1;
    private int idNext1;

    private String answer2;
//    private int luck2;
    private int idNext2;
}
