import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] zone = new int[15][15];
        Player.dps = Double.parseDouble(sc.nextLine());

        while (Player.health > 0 && Boss.health > 0) {

            String[] bossAttackData = sc.nextLine().split("\\s+");
            Boss.health -= Player.dps;
            if (Player.isPoisoned) {
                Player.health -= 3500;
                Player.isPoisoned = false;

                if (Player.health <= 0) {
                    Player.isKilledBy = "Plague Cloud";
                }
            }

            if (Player.health <= 0 || Boss.health <= 0) {
                break;
            }

            clearZone(zone);
            String bossAttackType = bossAttackData[0];
            int bossAttackRow = Integer.parseInt(bossAttackData[1]);
            int bossAttackCol = Integer.parseInt(bossAttackData[2]);
            markAttackZone(zone, bossAttackRow, bossAttackCol);

            if (!Player.evade(zone, bossAttackRow, bossAttackCol)) {
                if (bossAttackType.equals("Cloud")) {
                    Player.health -= 3500;
                    Player.isPoisoned = true;

                    if (Player.health <= 0) {
                        Player.isKilledBy = "Plague Cloud";
                    }
                } else if (bossAttackType.equals("Eruption")) {
                    Player.health -= 6000;

                    if (Player.health <= 0) {
                        Player.isKilledBy = "Eruption";
                    }
                }
            }

        }

        Boss.printStatus();
        Player.printStatus();
        Player.printFinalPosition();

    }

    private static void clearZone(int[][] zone) {
        for (int[] row : zone) {
            Arrays.fill(row, 0);
        }
    }

    private static void markAttackZone(int[][] zone, int bossAttackRow, int bossAttackCol) {
        int firstRow = bossAttackRow - 1;
        if (firstRow < 0) {
            firstRow = 0;
        }

        int firstCol = bossAttackCol - 1;
        if (firstCol < 0) {
            firstCol = 0;
        }

        int lastRow = bossAttackRow + 1;
        if (lastRow >= zone.length) {
            lastRow = zone.length - 1;
        }

        int lastCol = bossAttackCol + 1;
        if (lastCol >= zone.length) {
            lastCol = zone.length - 1;
        }

        for (int row = firstRow; row <= lastRow; row++) {
            for (int col = firstCol; col <= lastCol; col++) {
                zone[row][col] = 1;
            }
        }
    }


}

class Player {

    static int health = 18500;
    static boolean isPoisoned = false;
    static int[] position = new int[]{7, 7};
    static double dps;
    static String isKilledBy = "";


    public static boolean evade(int[][] zone, int spellRow, int spellCol) {
        if (zone[position[0]][position[1]] == 0) {
            return true;
        }

        if (goUp(zone)) {
            return true;
        } else if (goRight(zone)) {
            return true;
        } else if (goDown(zone)) {
            return true;
        } else if (goLeft(zone)) {
            return true;
        }

        return false;

    }

    public static void printStatus() {
        if(health <= 0) {
            System.out.printf("Player: Killed by %s%n", isKilledBy);
        } else {
            System.out.printf("Player: %d%n", health);
        }
    }

    public static void printFinalPosition() {
        System.out.printf("Final position: %d, %d%n", position[0], position[1]);
    }

    private static boolean goUp(int[][] zone) {
        int row = position[0] - 1;
        int col = position[1];
        if (row < 0) {
            return false;
        }

        if (zone[row][col] == 1) {
            return false;
        }

        position[0] -= 1;
        return true;
    }

    private static boolean goRight(int[][] zone) {
        int row = position[0];
        int col = position[1] + 1;
        if (col >= zone.length) {
            return false;
        }

        if (zone[row][col] == 1) {
            return false;
        }

        position[1] += 1;
        return true;
    }

    private static boolean goDown(int[][] zone) {
        int row = position[0] + 1;
        int col = position[1];
        if (row >= zone.length) {
            return false;
        }

        if (zone[row][col] == 1) {
            return false;
        }

        position[0] += 1;
        return true;
    }

    private static boolean goLeft(int[][] zone) {
        int row = position[0];
        int col = position[1] - 1;
        if (col < 0) {
            return false;
        }

        if (zone[row][col] == 1) {
            return false;
        }

        position[1] -= 1;
        return true;
    }


}

class Boss {
    static double health = 3000000;

    public static void printStatus() {
        if (health <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", health);
        }
    }
}
