import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> players = new ArrayDeque<>();
        String[] inputPlayers = sc.nextLine().split(" ");
        Collections.addAll(players, inputPlayers);
        int burnNum = Integer.parseInt(sc.nextLine());
        int rotationsCounter = 1;
        List<Integer> foundPrimes = new ArrayList<Integer>();
        foundPrimes.add(2);

        while(players.size() > 1){
            for (int i = 0; i < burnNum -1; i++) {
                var currPlayer = players.poll();
                players.offer(currPlayer);
            }

            if(isPrime(foundPrimes, rotationsCounter)){
                System.out.println("Prime " + players.peek());
            } else {
                System.out.println("Removed " + players.pop());
            }

            rotationsCounter++;
        }

        System.out.println("Last is " + players.peek());
    }

    private static boolean isPrime(List<Integer> foundPrimes, int rotationsCounter) {
        if(rotationsCounter == 1){
            return false;
        }

        if(foundPrimes.contains(rotationsCounter)){
            return true;
        }

        for (Integer prime : foundPrimes) {
            if(rotationsCounter % prime == 0){
                return false;
            }
        }

        foundPrimes.add(rotationsCounter);
        return true;

    }

//    private static boolean isPrime(List<Integer> foundPrimes, int rotationsCounter) {
//        if(rotationsCounter == 1){
//            return false;
//        }
//
//        if(foundPrimes.contains(rotationsCounter)){
//            return true;
//        }
//
//        for (Integer prime : foundPrimes) {
//            if(rotationsCounter % prime == 0){
//                return false;
//            }
//        }
//
//        findPrimes(foundPrimes, rotationsCounter);
//        return isPrime(foundPrimes, rotationsCounter);
//    }

//    private static void findPrimes(List<Integer> foundPrimes, int rotationsCounter) {
//        int lastFoundPrime = foundPrimes.get(foundPrimes.size() -1);
//        for (int curNum = lastFoundPrime +1; curNum <= Math.sqrt(rotationsCounter); curNum++) {
//            boolean curNumIsPrime = true;
//            for (Integer prime : foundPrimes) {
//                if(curNum % prime == 0){
//                    curNumIsPrime = false;
//                    break;
//                }
//            }
//
//            if(curNumIsPrime){
//                foundPrimes.add(curNum);
//            }
//        }
//    }
}
