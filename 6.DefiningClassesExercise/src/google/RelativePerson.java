package google;

public class RelativePerson {
    private String name;
    private String birthday;

    public RelativePerson(String name, String birthdayDate) {
        this.name = name;
        this.birthday = birthdayDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthdayDate) {
        this.birthday = birthdayDate;
    }

    public String toString() {
            return String.format("%s %s", this.name, this.birthday);
    }
}
