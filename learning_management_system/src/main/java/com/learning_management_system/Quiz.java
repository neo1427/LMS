import java.util.Scanner;

class Quiz {
    private int quizId;
    private String startTime;
    private int bufferTime;
    private String endTime;
    private String[] questions;
    private String[][] options;
    private char[] studentAnswers;

    public Quiz(int quizId, String startTime, int bufferTime, String endTime, String[] questions, String[][] options) {
        this.quizId = quizId;
        this.startTime = startTime;
        this.bufferTime = bufferTime;
        this.endTime = endTime;
        this.questions = questions;
        this.options = options;
    }

    public void displayQuestions(Scanner scanner) {
        System.out.println("Attempting quiz " + quizId + ".");
        this.studentAnswers = new char[questions.length];

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((char)('A' + j) + ". " + options[i][j]);
            }
            System.out.print("Enter your answer (A/B/C/D): ");
            char answer = scanner.next().toUpperCase().charAt(0);
            studentAnswers[i] = answer;
        }
    }

    public void viewResults() {
        if (studentAnswers == null) {
            System.out.println("Error: Quiz not attempted.");
            return;
        }

        System.out.println("Viewing results of quiz " + quizId + ":");
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + studentAnswers[i]);
            if (studentAnswers[i] == QuestionBank.correctAnswers[i]) {
                System.out.println("Your answer is correct!");
                score++;
            } else {
                System.out.println("Your answer is incorrect. Correct answer is " + QuestionBank.correctAnswers[i]);
            }
        }
        System.out.println("Your total score: " + score + "/" + questions.length);
    }

    public Integer getQuizId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuizId'");
    }
}