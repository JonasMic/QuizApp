package io.jonas.util;

import io.jonas.model.Question;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuestionImpl {
    private Question[] questions = new Question[5];
    private String selection[] = new String[5];
    // let assign 30 seconds for one question
    private final int TIME_FOR_EACH_QUESTION = 30;
    private final int DURATION_SECONDS = questions.length * TIME_FOR_EACH_QUESTION;
    private int timeLeft = DURATION_SECONDS;
    private Timer timer;
    private int score = 0;


    public QuestionImpl() {
        //creat instance of the question class
        questions[0] = new Question(1, "what is size of int in java  ?", "2 ", "4", "8", "16", "4");
        questions[1] = new Question(2, "what is size of double in java  ?", "2 ", "4", "8", "16", "8");
        questions[2] = new Question(3, "what is size of char in java  ?", "2 ", "4", "8", "16", "2");
        questions[3] = new Question(4, "what is size of long in java  ?", "2 ", "4", "8", "16", "8");
        questions[4] = new Question(5, "which one is feature of OOP ?", "Polymorphism ", "inheritance", "Encapsulation", "All", "All");

    }

    public void playQuiz() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeLeft--;
                if (timeLeft == 0) {
                    endPlay(score);
                }
            }
        }, 1000, 1000);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + " : ");
            Question currentQuestion = questions[i];
            System.out.println(currentQuestion.getQuestion());
            System.out.println(" the choices are : ");
            System.out.println(currentQuestion.getOpt1());
            System.out.println(currentQuestion.getOpt2());
            System.out.println(currentQuestion.getOpt3());
            System.out.println(currentQuestion.getOpt4());
            System.out.println("Do you want to skip the question , enter Y or N ");
            Scanner scan = new Scanner(System.in);
            if (!scan.nextLine().trim().equalsIgnoreCase("Y")) {
                System.out.println("type the right answer");
                Scanner scanner = new Scanner(System.in);
                selection[i] = scanner.nextLine().trim();
                if (selection[i].equalsIgnoreCase(currentQuestion.getAnswer())) {
                    score++;
                    System.out.println("Your current score is : " + score);
                } else {
                    score--;
                    System.out.println("Your current score is : " + score);
                }
            } else {
                if (i + 2 < questions.length) {
                    System.out.println("Question " + (i + 2) + " : ");
                    currentQuestion = questions[i + 1];
                } else {
                    System.out.println("Question " + (questions.length) + " : ");
                    currentQuestion = questions[questions.length - 1];

                }
                System.out.println(currentQuestion.getQuestion());
                System.out.println(" the choices are : ");
                System.out.println(currentQuestion.getOpt1());
                System.out.println(currentQuestion.getOpt2());
                System.out.println(currentQuestion.getOpt3());
                System.out.println(currentQuestion.getOpt4());

            }
        }
        System.out.println("Your total score is : " + score);

    }

    private void endPlay(int score) {
        timer.cancel();
        System.out.println("Oh Sorry! Time's over!");
        System.out.println("Your score is " + score);
        System.exit(0);
    }

//    public int getTotalScore() {
//        int totalScore = playQuiz();
//        System.out.println();
//        return totalScore;
//    }


    public void playSession(QuestionImpl service) {
        System.out.println("Do you want to play again : enter Y or N");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();
        boolean running = true;
        while (running) {
            if (input.equalsIgnoreCase("y")) {
                System.out.println(input.equalsIgnoreCase("y"));
                service.playQuiz();
                playSession(service);

            }
            running = false;
            System.out.println("Thanks for using the Quiz app.See you for the next play !!!");
        }
    }

    public void getHeader(String title) {
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
        }
        System.out.println();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 100; j++) {
                if (j == 40) {
                    System.out.print(title);
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print("#");
        }
        System.out.println();
        System.out.println("There are " + questions.length + " questions .And the total time  allotted is " + (TIME_FOR_EACH_QUESTION * questions.length) + " Seconds.");
        System.out.println();
    }
}


