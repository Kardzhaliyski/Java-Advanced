package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if(this.data.size() < capacity && !this.data.contains(rabbit)) {
            this.data.add(rabbit);
        } else if (this.data.contains(rabbit)) {
            rabbit.setAvailable(true);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if(this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rab : this.data) {
            if(rab.getName().equals(name) && rab.isAvailable()) {
                rab.setAvailable(false);
                return rab;
            }
        }

        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        var list = this.data.stream()
                .filter(r -> r.getSpecies().equals(species))
                .filter(Rabbit::isAvailable)
                .collect(Collectors.toList());

        for (Rabbit rabbit : list) {
            rabbit.setAvailable(false);
        }

        return list;
    }

    public int count(){
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Rabbits available at ").append(this.name).append(":");

        this.data.stream()
                .filter(Rabbit::isAvailable)
                .forEach(r -> sb.append(System.lineSeparator()).append(r.toString()));

        return sb.toString();
    }

}
