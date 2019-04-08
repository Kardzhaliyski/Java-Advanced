import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String url = sc.nextLine();

        while (!url.equals("Home")) {
            if(url.equals("back")){
                if(browserHistory.size() <= 1){
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }

                url = sc.nextLine();
                continue;
            }

            browserHistory.push(url);
            System.out.println(browserHistory.peek());
            url = sc.nextLine();
        }
    }
}
