package companyroster;

public class Employee {


    String name;
    Double salary;
    String position;
    String department;
    String email = "n/a";
    Integer age = -1;

    public Employee(String name, String salary, String position, String department) {
        this.name = name;
        this.salary = Double.parseDouble(salary);
        this.position = position;
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",
                this.name, this.salary, this.email, this.age);
    }

    public void addAgeOrEmail(String emailOrAge) {
        if(emailOrAge.contains("@")) {
            this.email = emailOrAge;
        } else {
            this.age = Integer.parseInt(emailOrAge);
        }
    }


}
