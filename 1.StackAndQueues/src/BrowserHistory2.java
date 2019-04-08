import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> browserForward = new ArrayDeque<>();
        String url = sc.nextLine();

        while (!url.equals("Home")) {
            if(url.equals("back")){
                if(browserHistory.size() <= 1){
                    System.out.println("no previous URLs");
                    url = sc.nextLine();
                    continue;
                } else {
                    browserForward.push(browserHistory.pop());
                }

            } else if(url.equals("forward")){
                if(browserForward.isEmpty()){
                    System.out.println("no next URLs");
                    url = sc.nextLine();
                    continue;
                } else {
                    browserHistory.push(browserForward.pop());
                }

            } else {
                browserHistory.push(url);
                browserForward.clear();
            }

            System.out.println(browserHistory.peek());
            url = sc.nextLine();
        }
    }
}
