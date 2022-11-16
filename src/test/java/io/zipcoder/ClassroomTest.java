package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassroomTest {

    @Test
    public void addStudentTest() {

        Classroom zipcode = new Classroom();
        Student dolio = new Student("Laurance", "Dolio",new ArrayList<>());
        dolio.addExamScore(105.0);
        zipcode.addStudent(dolio);
    }

    @Test
    public void addStudentTest2() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScoresList = new ArrayList<>(List.of(examScores));
        Student student = new Student("Leon", "Hunter", examScoresList);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void getAverageExamScore() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));

        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        double expected = 125.0;

        // When
        double actual = classroom.getAverageExamScore();

        // Then
        System.out.println(actual);

        Assert.assertEquals(expected, actual, 0);
    }

        @Test
    public void testRemoveStudentTest() {

        Double[] s1Scores = { 225.0, 25.0 };
        ArrayList<Double> s1ScoresList = new ArrayList<>(List.of(s1Scores));
        Double[] s2Scores = { 225.0, 25.0 };
        ArrayList<Double> s2ScoresList = new ArrayList<>(List.of(s2Scores));
        Double[] s3Scores = { 225.0, 25.0 };
        ArrayList<Double> s3ScoresList = new ArrayList<>(List.of(s3Scores));
        Double[] s4Scores = { 225.0, 25.0 };
        ArrayList<Double> s4ScoresList = new ArrayList<>(List.of(s4Scores));
        Double[] s5Scores = { 225.0, 25.0 };
        ArrayList<Double> s5ScoresList = new ArrayList<>(List.of(s5Scores));

        Student s1 = new Student("student", "one", s1ScoresList);
        Student s2 = new Student("student", "two", s2ScoresList);
        Student s3 = new Student("student", "three", s3ScoresList);
        Student s4 = new Student("student", "four", s4ScoresList);
        Student s5 = new Student("student", "five", s5ScoresList);

        Student[] students = {s1, s2, s3, s4, s5};
        Classroom classroom = new Classroom(students);

        classroom.removeStudent("student", "two");

        Student[] actual = classroom.getStudents();
        String removed = Arrays.toString(actual);

        Student[] expected = {s1, s3, s4, s5, null};

        System.out.println(removed);
        Assert.assertArrayEquals(actual, expected);
    }
}
