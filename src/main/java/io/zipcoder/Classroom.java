package io.zipcoder;

public class Classroom {

    private Student[] students;

    private int maxNumberOfStudents;

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
        int count = 0;
        int temp = 0;

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) &&
                    students[i].getLastName().equals(lastName)) {
                students[i] = null;
                temp = i;
                count = i;
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
    //public Students[] getStudentsByScore;() {
}
