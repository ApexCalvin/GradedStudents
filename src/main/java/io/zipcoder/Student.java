package io.zipcoder;

import java.util.ArrayList;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;
    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder listed = new StringBuilder("Exam Scores:");
        for(int i = 0 ; i < this.examScores.size() ; i++) {
            listed.append("\n\tExam ").append(i + 1).append(" -> ").append(String.format("%.0f", this.examScores.get(i)));
        }
        return listed.toString();
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        this.examScores.set(examNumber, newScore);
    }

    public double getAverageExamScore() { // CALVIN
        Double sum = 0.0;
        for (Double examScore : this.examScores) {
            sum += examScore;
        }
        return sum / this.examScores.size();
    }

    @Override
    public String toString() { // CALVIN
        return String.format("Student Name: %s %s\n> Average Score: %s\n> %s",
                firstName, lastName, (int) getAverageExamScore(), getExamScores());
    }
}
