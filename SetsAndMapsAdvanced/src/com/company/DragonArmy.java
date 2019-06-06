package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var dragonsNumInput = Integer.parseInt(sc.nextLine());

        var dragons = new LinkedHashMap<String, TreeMap<String, Dragon>>();

        for (int i = 0; i < dragonsNumInput; i++) {
            var input = sc.nextLine().split("\\s+");
            var dragonType = input[0];
            var dragonName = input[1];
            var dragonDamage = input[2];
            var dragonHp = input[3];
            var dragonArmor = input[4];
            dragons.putIfAbsent(dragonType, new TreeMap<>());

            if (dragons.get(dragonType).containsKey(dragonName)) {
                var dragon = dragons.get(dragonType).get(dragonName);

                if (!dragonDamage.equalsIgnoreCase("null")) {
                    dragon.damage = Integer.parseInt(dragonDamage);
                }

                if (!dragonHp.equalsIgnoreCase("null")) {
                    dragon.hp = Integer.parseInt(dragonHp);
                }

                if (!dragonArmor.equalsIgnoreCase("null")) {
                    dragon.armor = Integer.parseInt(dragonArmor);
                }
            } else {
                dragons.get(dragonType).put(dragonName, new Dragon(dragonHp, dragonDamage, dragonArmor));
            }
        }

        for (Map.Entry<String, TreeMap<String, Dragon>> dragonsType : dragons.entrySet()) {
            var avrgStats = getAvrgStats(dragonsType);
            System.out.println(String.format("%s::(%.02f/%.02f/%.02f)",
                    dragonsType.getKey(),
                    avrgStats[0],
                    avrgStats[1],
                    avrgStats[2]));

            dragonsType.getValue().entrySet().forEach(dragon -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                        dragon.getKey(),
                        dragon.getValue().damage,
                        dragon.getValue().hp,
                        dragon.getValue().armor));
            });
        }

    }

    private static double[] getAvrgStats(Map.Entry<String, TreeMap<String, Dragon>> type) {
        var totalDamage = 0.0;
        var totalHp = 0.0;
        var totalArmor = 0.0;
        var dragonCount = 0;

        for (Map.Entry<String, Dragon> dragon : type.getValue().entrySet()) {
            totalDamage += dragon.getValue().damage;
            totalHp += dragon.getValue().hp;
            totalArmor += dragon.getValue().armor;
            dragonCount++;
        }

        var statsArr = new double[3];
        statsArr[0] = totalDamage / dragonCount;
        statsArr[1] = totalHp / dragonCount;
        statsArr[2] = totalArmor / dragonCount;
        return statsArr;
    }

    public static class Dragon {
        Dragon(String hp, String damage, String armor) {
            if (!damage.equalsIgnoreCase("null")) {
                this.damage = Integer.parseInt(damage);
            }

            if (!hp.equalsIgnoreCase("null")) {
                this.hp = Integer.parseInt(hp);
            }

            if (!armor.equalsIgnoreCase("null")) {
                this.armor = Integer.parseInt(armor);
            }
        }

        int hp = 250;
        int damage = 45;
        int armor = 10;

    }
}

