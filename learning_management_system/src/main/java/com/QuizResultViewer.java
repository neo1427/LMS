package com;

class QuizResultViewer {
    private JDBCServer jdbcServer;

    public QuizResultViewer(JDBCServer jdbcServer) {
        this.jdbcServer = jdbcServer;
    }

    public void viewStudentResults() {
        // Code to view student results
        List<QuizResult> results = jdbcServer.getStudentResults();
        System.out.println("Student Results for Each Quiz:");
        for (QuizResult result : results) {
            System.out.println(result.getQuizTitle() + ": " + result.getScore() + "/" + result.getTotalMarks());
        }
    }

    public void viewTeacherResults() {
        // Code to view teacher results
        List<QuizResult> results = jdbcServer.getTeacherResults();
        System.out.println("Teacher Results for Each Quiz:");
        for (QuizResult result : results) {
            System.out.println(result.getQuizTitle());
        }
    }
}