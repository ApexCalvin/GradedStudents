package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;

    private int maxNumberOfStudents;

    private Comparator<Student> nameComparator = Comparator.comparing(o -> o.firstName);
    //TODO - iterates through array and compares the first name part of an obj with another first name of another obj

    private Comparator<Student> studentComparator = ((o1, o2) -> (int) (o2.getAverageExamScore() - o1.getAverageExamScore()) );
    //TODO - comparing getAverageExamScore aspect of each object

    private HashMap<Student, String> gradeBook = new HashMap<>();
    //TODO - <KEY, VALUE>
    public Classroom() {
        students = new Student[30];
    }

    public Classroom(Student[] Student) {
        students = Student;

    }
    public Classroom(int maxNumberOfStudents) {
        //this.maxNumberOfStudents = MaxNumberOfStudents;
        students = new Student[maxNumberOfStudents];
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        for(int i = 0 ; i < students.length ; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public double getAverageExamScore() {
        double sum = 0;
        double count = 0;
        for(int i = 0 ; i < students.length ; i++) {
            while(students[i] != null){
                count++;
                sum += students[i].getAverageExamScore();
                break;
            }
        }
        return sum / count;
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)) {
                students[i] = null;
            }
        }

        boolean sorted = false;
        Student swap = null;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < students.length - 1; j++) {
                if (students[j] == null) {
                    swap = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = swap;
                    sorted = false;
                }
            }
        }
    }

    public void sortSudentsByName() {
        Arrays.sort(students, nameComparator);
        //Sorting the students array using the comparator
    }

    public void sortStudentsByScore() {
        sortSudentsByName();
        Arrays.sort(students, studentComparator);
        //Sorting the students array using comparator
    }

    public Student[] getStudentsByScore() {
        sortStudentsByScore();;
        return students;
    }

    public HashMap<Student, String> getGradeBook() {
        this.students = getStudentsByScore();

        for(int i =0; i< students.length; i++) {
            double percentile = 0;
            double rank = students.length - (i+1); //TODO - Out of ten students
            percentile = (rank / students.length) * 100.00;
            if (percentile >= 90) {
                gradeBook.put(students[i], "A");
            } else if (percentile <= 89 && percentile >= 71) {
                gradeBook.put(students[i], "B");
            } else if (percentile <= 70 && percentile >= 50) {
                gradeBook.put(students[i], "C");
            } else if (percentile <= 49 && percentile >= 11) {
                gradeBook.put(students[i], "D");
            } else {
                gradeBook.put(students[i], "F");
            }
        }

        return gradeBook;
    }
}
