package google;

public class Job {
    String companyName;
    String department;
    Double salary;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDepartment(String departmentName) {
        this.department = departmentName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.department, this.salary);
    }

}
