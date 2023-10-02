package ru.javarush.kuznetsov.quest.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class JspService {
    private JspService() {}

    public static void reqDispForward(HttpServletRequest request, HttpServletResponse response, String nameJSP) throws ServletException, IOException {

        String str = "%s.jsp".formatted(nameJSP);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(str);
        requestDispatcher.forward(request, response);
    }
}
