package guild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if(roster.size() < capacity) {
            roster.put(player.getName(), player);
        }
    }

    public boolean removePlayer(String name) {
        if(roster.containsKey(name)) {
            roster.remove(name);
            return true;
        }

        return false;
    }

    public void promotePlayer(String name) {
        if(roster.containsKey(name)) {
            roster.get(name).setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        if(roster.containsKey(name)) {
            roster.get(name).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        var kickedPlayerArray = roster.values().stream()
                .filter(p -> p.getClazz().equals(clazz))
                .toArray(Player[]::new);

        roster.entrySet().removeIf(p -> p.getValue().getClazz().equals(clazz));
        return kickedPlayerArray;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        var sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":");
        roster.forEach((k,p) -> sb.append(System.lineSeparator()).append(p.toString()));
        return sb.toString();
    }
}
