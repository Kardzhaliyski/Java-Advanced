package genericswapmethodintegers;

import genericclasses.GenericBox;
import genericclasses.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            var count = Integer.parseInt(bfr.readLine());
            var list = new ArrayList<GenericBox<Integer>>();

            for (int i = 0; i < count; i++) {
                list.add(new GenericBox<>(Integer.parseInt(bfr.readLine())));
            }

            int[] swapIndexes = Arrays.stream(bfr.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            ListUtils.swapElements(list, swapIndexes[0], swapIndexes[1]);

            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
