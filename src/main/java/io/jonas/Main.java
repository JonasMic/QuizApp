package io.jonas;

import io.jonas.util.QuestionImpl;

public class Main {
    public static void main(String[] args) {

        QuestionImpl service = new QuestionImpl();
        service.getHeader("Welcome to the Quiz App");
        service.playQuiz();
        service.playSession(service);
        System.currentTimeMillis();
    }

}