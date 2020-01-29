package companyroster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employees = new ArrayList<>();

    public double averageSalary() {
        if(!employees.isEmpty()) {
            return employees.stream().mapToDouble(employee -> employee.salary).average().getAsDouble();
        }

        return 0;
    }

    public void printEmployeesInfo() {
        employees.stream()
                .sorted((e1,e2) -> e2.salary.compareTo(e1.salary))
                .forEach(System.out::println);
    }
}
