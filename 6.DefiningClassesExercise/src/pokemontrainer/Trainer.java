package pokemontrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int badges;
    private Map<String, List<Pokemon>> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.setPokemons();
    }

    private void setPokemons() {
        this.pokemons = new HashMap<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);
    }

    public void elementalCheck(String type) {
        if (pokemons.containsKey(type) && pokemons.get(type).size() > 0) {
            incrementBadges(1);
            return;
        }

        damageAllPokemons(10);
    }

    private void damageAllPokemons(int amount) {
        for (List<Pokemon> pokemonList : pokemons.values()) {
            for (Pokemon pokemon : pokemonList) {
                pokemon.takeDamage(amount);
            }
        }

        removeDeadPokemons();
    }

    private void removeDeadPokemons() {
        for (List<Pokemon> pokemonList : pokemons.values()) {
            pokemonList.removeIf(p -> p.getHealth() <= 0);
        }
    }

    private void incrementBadges(int incrementStep) {
        badges += incrementStep;
    }

    public int getBadgeCount() {
        return this.badges;
    }

    private int getPokemonCount() {
        int pokemonCount = 0;
        for (Map.Entry<String, List<Pokemon>> stringListEntry : pokemons.entrySet()) {
            pokemonCount += stringListEntry.getValue().size();
        }

        return pokemonCount;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, getPokemonCount());
    }
}
