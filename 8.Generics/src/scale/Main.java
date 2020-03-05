package scale;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var scale = new Scale<>("left", "ri");
        scale.setLeft("3");
        System.out.println(scale.getHeavier());
    }
}
