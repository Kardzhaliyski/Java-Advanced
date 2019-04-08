package com.company;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var numOfStudents = Integer.parseInt(sc.nextLine());
        var studentsList = new ArrayList<Student>();
        for (int i = 0; i < numOfStudents; i++) {
            var studentName = sc.nextLine();
            double[] studentGradesInputArray = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            var student = new Student(studentName);
            student.grades = studentGradesInputArray;
            studentsList.add(student);
        }

        System.out.println();
        orderListByName(studentsList);
        printStudentGrades(studentsList);

    }

    private static void printStudentGrades(ArrayList<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.printf("%s is graduated with %s%n", student.name, student.getAverageGrade());
        }
    }

    private static void orderListByName(ArrayList<Student> studentsList) {
        studentsList.sort(Comparator.comparing(s -> s.name));
    }

    public static class Student {

        Student(String studentName){
            name = studentName;
        }

        String name;
        double[] grades;

        public double getAverageGrade(){
            double gradesSum = 0;
            for (double grade : grades) {
                gradesSum += grade;
            }
            double averageGrade = gradesSum / grades.length;
            return averageGrade;
        }
    }
}
