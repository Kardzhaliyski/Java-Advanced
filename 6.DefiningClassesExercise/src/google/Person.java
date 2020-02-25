package google;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Job job;
    private List<Pokemon> pokemons;
    private List<RelativePerson> parents;
    private List<RelativePerson> children;
    private Car car;


    public Person(String name) {
        this.name = name;
        this.job = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }

    public void addData(String[] data) {
        String category = data[1];

        switch (category.toLowerCase()){
            case "company": {
                if(job == null) {
                    this.job = new Job();
                }

                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                this.job.setCompanyName(companyName);
                this.job.setDepartment(department);
                this.job.setSalary(salary);
                break;
            }
            case "pokemon": {
                String pokemonName = data[2];
                String pokemonType = data[3];
                this.pokemons.add(new Pokemon(pokemonName, pokemonType));
                break;
            }
            case "parents": {
                String parentName = data[2];
                String parentBirthdayDate = data[3];
                parents.add(new RelativePerson(parentName, parentBirthdayDate));
                break;
            }
            case "children": {
                String childName = data[2];
                String childBirthdayDate = data[3];
                children.add(new RelativePerson(childName, childBirthdayDate));
                break;
            }
            case "car": {
                if(this.car == null) {
                    this.car = new Car();
                }

                String carModel = data[2];
                String carSpeed = data[3];
                this.car.setModel(carModel);
                this.car.setSpeed(carSpeed);
                break;
            }
        }
    }

    public void printData() {
        System.out.println(this.name);
        System.out.println("Company:");
        if(this.job != null) { System.out.println(this.job); }
        System.out.println("Car:");
        if(this.car != null) { System.out.println(this.car); }
        System.out.println("Pokemon:");
        if(!this.pokemons.isEmpty()) { this.pokemons.forEach(System.out::println);}
        System.out.println("Parents:");
        if(!this.parents.isEmpty()) { this.parents.forEach(System.out::println);}
        System.out.println("Children:");
        if(!this.children.isEmpty()) { this.children.forEach(System.out::println);}

    }




}
