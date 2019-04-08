package com.company;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var gradesToWrite = Integer.parseInt(sc.nextLine());
        var studentsGrades = new TreeMap<String, ArrayList<Double>>();
        for (int i = 0; i < gradesToWrite; i++) {
            var nameAndGrade = sc.nextLine().split(" ");
            var name = nameAndGrade[0];
            var grade = Double.parseDouble(nameAndGrade[1]);
            studentsGrades.putIfAbsent(name, new ArrayList<Double>());
            studentsGrades.get(name).add(grade);
        }

        for (Map.Entry<String, ArrayList<Double>> student : studentsGrades.entrySet()) {
            System.out.print(student.getKey() + " -> ");
            for (Double grade : student.getValue()) {
                System.out.printf("%.2f ",
                        grade);
            }

            System.out.println();
            //double averageGrade = student.getValue().stream().mapToDouble(e -> e).average().orElse(0);
            double avrGrade = getAverage(student.getValue());
            System.out.printf("(avg: %.2f)%n",
                    avrGrade);
        }

    }

    private static double getAverage(ArrayList<Double> grades) {
        var gradeSum = 0.0;
        for (Double grade : grades) {
            gradeSum += grade;
        }

        return gradeSum / grades.size();
    }
}
