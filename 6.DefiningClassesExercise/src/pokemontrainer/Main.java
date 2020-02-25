package pokemontrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final String START_TOURNAMENT_COMMAND = "Tournament";
        final String END_TOURNAMENT_COMMAND = "End";

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            Map<String, Trainer> trainers = new LinkedHashMap<>();

            var tokens = bfr.readLine().split("\\s+");
            while (!tokens[0].equalsIgnoreCase(START_TOURNAMENT_COMMAND)) {
                var trainerName = tokens[0];
                var pokemonName = tokens[1];
                var pokemonElement = tokens[2];
                var pokemonHealth = Integer.parseInt(tokens[3]);

                trainers.putIfAbsent(trainerName, new Trainer(trainerName));
                
                Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                trainers.get(trainerName).addPokemon(pokemon);

                tokens = bfr.readLine().split("\\s+");
            }

            String command = bfr.readLine();
            while (!command.equalsIgnoreCase(END_TOURNAMENT_COMMAND)) {
                for (Trainer trainer : trainers.values()) {
                    trainer.elementalCheck(command);
                }

                command = bfr.readLine();
            }

            trainers.entrySet().stream()
                    .sorted((f, s) -> s.getValue().getBadgeCount() - f.getValue().getBadgeCount())
                    .forEach(entry ->  System.out.println(entry.getValue()));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
