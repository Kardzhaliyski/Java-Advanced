package opinionpoll;

public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = Integer.parseInt(age);
    }


}
