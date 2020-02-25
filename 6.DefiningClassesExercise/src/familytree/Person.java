package familytree;

import java.util.LinkedHashMap;
import java.util.Map;

public class Person {
    private String name;
    private String birthday;
    private Map<String, Person> parents;
    private Map<String, Person> children;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        parents = new LinkedHashMap<>();
        children = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void addParent(Person parent) {
        parents.putIfAbsent(parent.getName(), parent);
    }

    public void addChild(Person child) {
        children.putIfAbsent(child.getName(), child);
    }

    public void printFamilyTree() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        parents.forEach((n,p) -> sb.append(p.toString()).append(System.lineSeparator()));
        sb.append("Children:").append(System.lineSeparator());
        children.forEach((n,c) -> sb.append(c.toString()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                this.name, this.birthday);
    }
}
