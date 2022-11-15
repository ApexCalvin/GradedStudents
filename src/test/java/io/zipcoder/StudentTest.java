package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StudentTest {

    @Test
    public void getExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        // When
        String actual = student.getExamScores();
        // Then
        System.out.println(actual); // CALVIN

        String expected =
                "Exam Scores:\n" + // CALVIN
                "\tExam 1 -> 100\n\tExam 2 -> 95\n\tExam 3 -> 123\n\tExam 4 -> 96";

        assertEquals(actual, expected);
    }

    @Test
    public void addExamScoreTest(){
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        //When
        student.addExamScore(100);
        String actual = student.getExamScores();

        String expected = "Exam Scores:\n\tExam 1 -> 100";

        assertEquals(expected, actual);
    }

    @Test
    public void setExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);

        // When
        student.setExamScore(0, 150);
        String actual = student.getExamScores();

        String expected = "Exam Scores:\n\tExam 1 -> 150";

        assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);

        // When
        Double actual = student.getAverageExamScore();

        // Then
        System.out.println(actual); // CALVIN
        Double expected = 125.0;

        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student(firstName, lastName, examScoresList);
        String expected = "Student Name: Leon Hunter\n" + // CALVIN
                "> Average Score: 125\n" + //CALVIN
                "> Exam Scores:\n" + // CALVIN
                "\tExam 1 -> 100\n\tExam 2 -> 150\n\tExam 3 -> 250\n\tExam 4 -> 0";
        // When
        String actual = student.toString();

        // Then
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

}