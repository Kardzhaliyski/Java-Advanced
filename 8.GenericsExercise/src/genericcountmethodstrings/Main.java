package genericcountmethodstrings;

import genericclasses.GenericBox;
import genericclasses.ListUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            var list = new ArrayList<GenericBox<String>>();
            var count = Integer.parseInt(bfr.readLine());
            while (count-- > 0) {
                list.add(new GenericBox<>(bfr.readLine()));
            }

            var element = new GenericBox<>(bfr.readLine());
            System.out.println(ListUtils.countGreaterElements(list, element));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
