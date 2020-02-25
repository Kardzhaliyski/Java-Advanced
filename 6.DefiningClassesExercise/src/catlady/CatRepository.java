package catlady;

import java.util.HashMap;
import java.util.Map;

public class CatRepository {
    private Map<String, Cat> cats;

    public CatRepository() {
        cats = new HashMap<>();
    }

    public void addCat(Cat cat) {
        cats.put(cat.getName(), cat);
    }

    public void addNewCatFromData(String breed , String name, double specificParameter) {
        switch (breed){
            case "Cymric": {
                cats.put(name, new Cymric(name, specificParameter));
                break;
            }
            case "Siamese": {
                cats.put(name, new Siamese(name, specificParameter));
                break;
            }
            case "StreetExtraordinaire": {
                cats.put(name, new StreetExtraordinaire(name, specificParameter));
                break;
            }
        }
    }


    public void printCatData(String catName) {
        System.out.println(cats.get(catName));
    }
}
