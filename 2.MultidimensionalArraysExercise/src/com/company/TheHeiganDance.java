package com.company;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player();
        player.dps = Double.parseDouble(sc.nextLine());
        Boss boss = new Boss();

        while (player.hp > 0 && boss.hp > 0) {
            if (player.isPoisoned) {
                player.isPoisoned = false;
                player.hp -= 3500;

                if (player.hp <= 0) {
                    player.killedBy = "Killed by Plague Cloud";
                }
            }

            boss.hp -= player.dps;

            if (boss.hp <= 0 || player.hp <= 0) {
                break;
            }

            var bossCasting = sc.nextLine().split("\\s+");
            var spellName = bossCasting[0];
            var hitRow = Integer.parseInt(bossCasting[1]);
            var hitCol = Integer.parseInt(bossCasting[2]);

            if (!player.canEvade(hitRow, hitCol)) {
                if ("Cloud".equalsIgnoreCase(spellName)) {
                    player.hp -= 3500;
                    player.isPoisoned = true;

                    if (player.hp < 0) {
                        player.killedBy = "Killed by Plague Cloud";
                        break;
                    }
                } else if ("Eruption".equalsIgnoreCase(spellName)) {
                    player.hp -= 6_000;

                    if(player.hp < 0) {
                        player.killedBy = "Killed by Eruption";
                        break;
                    }
                }
            }
        }

        printResult(player, boss);
    }

    private static void printResult(Player player, Boss boss) {
        if(boss.hp > 0) {
            System.out.printf("Heigan: %.2f%n", boss.hp);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if(player.hp > 0) {
            System.out.printf("Player: %d%n", player.hp);
        } else {
            System.out.printf("Player: %s%n", player.killedBy);
        }

        System.out.printf("Final position: %d, %d", player.positionRow, player.positionCol);
    }

    private static class Player {
        int hp = 18500;
        int positionRow = 7;
        int positionCol = 7;
        boolean isPoisoned = false;
        double dps;
        String killedBy = "Alive";

        public boolean canEvade(int hitRow, int hitCol) {
            if (positionRow == hitRow && positionCol == hitCol) {
                return false;
            }

            int aoeStartRow = hitRow - 1;
            int aoeStartCol = hitCol - 1;
            int aoeEndRow = hitRow + 1;
            int aoeEndCol = hitCol + 1;

            if (positionRow < aoeStartRow || positionRow > aoeEndRow) {
                return true;
            } else if (positionCol < aoeStartCol || positionCol > aoeEndCol) {
                return true;
            }

            if (positionRow == aoeStartRow && positionRow > 0) {
                positionRow -= 1;
                return true;
            } else if (positionCol == aoeEndCol && positionCol < 14) {
                positionCol += 1;
                return true;
            } else if (positionRow == aoeEndRow && positionRow < 14) {
                positionRow += 1;
                return true;
            } else if (positionCol == aoeStartCol && positionCol > 0) {
                positionCol -= 1;
                return true;
            }

            return false;
        }
    }

    private static class Boss {
        double hp = 3_000_000.0;
    }
}
