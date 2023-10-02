package ru.javarush.kuznetsov.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionnaireAnswer {
    private int id;
    private String text;
    private String img;
}
