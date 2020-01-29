package companyroster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var inputNumber = Integer.parseInt(bfr.readLine());
            Map<String, Department> departments = new HashMap<>();

            for (int i = 0; i < inputNumber; i++) {
                var employeeInputData = bfr.readLine().split("\\s+");
                addEmployee(departments, employeeInputData);
            }

            String highestPaidDepartment = getHighestPaidDepartmentName(departments);
            System.out.printf("Highest Average Salary: %s%n",
                    highestPaidDepartment);

            departments.get(highestPaidDepartment).printEmployeesInfo();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static String getHighestPaidDepartmentName(Map<String, Department> departments) {
        var highestPaidDepartment = "";
        var highestAverageSalary = -1.0;
        for (Map.Entry<String, Department> kvp : departments.entrySet()) {
            var averageSalary = kvp.getValue().averageSalary();
            if(averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                highestPaidDepartment = kvp.getKey();
            };
        }
        return highestPaidDepartment;
    }

    private static void addEmployee(Map<String, Department> departments, String[] employeeInputData) {

        var employeeName = employeeInputData[0];
        var employeeSalary = employeeInputData[1];
        var employeePosition = employeeInputData[2];
        var employeeDepartment = employeeInputData[3];
        var employee = new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment);

        if(employeeInputData.length == 5) {
            employee.addAgeOrEmail(employeeInputData[4]);
        } else if (employeeInputData.length == 6) {
            employee.email = employeeInputData[4];
            employee.age = Integer.parseInt(employeeInputData[5]);
        }

        departments.putIfAbsent(employeeDepartment, new Department());
        departments.get(employeeDepartment).employees.add(employee);
    }
}
