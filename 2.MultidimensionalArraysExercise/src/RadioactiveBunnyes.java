import java.util.Scanner;

public class RadioactiveBunnyes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizes = sc.nextLine().split(" ");
        var rows = Integer.parseInt(sizes[0]);
        var zone = new char[rows][];
        for (int row = 0; row < zone.length; row++) {
            zone[row] = sc.nextLine().toCharArray();
        }

        var playerPosition = new int[2];
        findPlayerPosition(playerPosition, zone);

        var moves = sc.nextLine().toCharArray();

        for (char direction : moves) {
            if (playerEscaped(zone, playerPosition, direction)) {
                rabbitsMultiply(zone);
                printZone(zone);
                System.out.printf("won: %d %d", playerPosition[0], playerPosition[1]);
                break;
            } else {
                playerMoves(playerPosition, direction);
                rabbitsMultiply(zone);
                if (zone[playerPosition[0]][playerPosition[1]] != '.') {
                    printZone(zone);
                    System.out.printf("dead: %d %d", playerPosition[0], playerPosition[1]);
                    break;
                }
            }


        }

    }

    public static boolean playerEscaped(char[][] zone, int[] playerPosition, char direction) {
        switch (direction) {
            case 'U':
                return playerPosition[0] - 1 < 0;
            case 'R':
                return playerPosition[1] + 1 == zone[0].length;
            case 'D':
                return playerPosition[0] + 1 == zone.length;
            case 'L':
                return playerPosition[1] - 1 < 0;
        }

        return false;
    }

    public static void playerMoves(int[] playerPosition, char direction) {
        switch (direction) {
            case 'U':
                playerPosition[0] -= 1;
                break;
            case 'R':
                playerPosition[1] += 1;
                break;
            case 'D':
                playerPosition[0] += 1;
                break;
            case 'L':
                playerPosition[1] -= 1;
                break;
        }
    }

    private static void printZone(char[][] zone) {
        for (char[] row : zone) {
            System.out.println(String.valueOf(row));
        }
    }

    private static void rabbitsMultiply(char[][] zone) {
        var tempZone = new char[zone.length][];
        for (int row = 0; row < zone.length; row++) {
            tempZone[row] = zone[row].clone();
        }

        for (int row = 0; row < tempZone.length; row++) {
            for (int col = 0; col < tempZone[row].length; col++) {
                if (tempZone[row][col] == 'B') {
                    multiplyARabbit(zone, row, col);
                }
            }
        }
    }

    private static void multiplyARabbit(char[][] zone, int row, int col) {
        if (row - 1 >= 0) {
            zone[row - 1][col] = 'B';
        }

        if (col + 1 < zone[row].length) {
            zone[row][col + 1] = 'B';
        }

        if (row + 1 < zone.length) {
            zone[row + 1][col] = 'B';
        }

        if(col - 1 >= 0) {
            zone[row][col -1] = 'B';
        }
    }

    private static void findPlayerPosition(int[] playerPosition, char[][] zone) {
        for (int row = 0; row < zone.length; row++) {
            for (int col = 0; col < zone[row].length; col++) {
                if (zone[row][col] == 'P') {
                    zone[row][col] = '.';
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    return;
                }
            }
        }
    }
}
