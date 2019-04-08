import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> players = new ArrayDeque<>();
        String[] inputPlayers = sc.nextLine().split(" ");
        Collections.addAll(players, inputPlayers);
        int burnNum = Integer.parseInt(sc.nextLine());

        while(players.size() > 1){
            for (int i = 0; i < burnNum -1; i++) {
                var currPlayer = players.poll();
                players.offer(currPlayer);
            }

            System.out.println("Removed " + players.poll());
        }

        System.out.println("Last is " + players.peek());
    }
}
