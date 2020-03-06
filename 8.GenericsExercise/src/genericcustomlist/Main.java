package genericcustomlist;

import genericclasses.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var list = new CustomList<String>();

            String inputCommand = bfr.readLine();
            while (!inputCommand.equalsIgnoreCase("END")) {
                var tokens = inputCommand.split("\\s+");

                switch (tokens[0].toLowerCase()) {
                    case "add": {
                        list.add(tokens[1]);
                        break;
                    }
                    case "remove": {
                        list.remove(Integer.parseInt(tokens[1]));
                        break;
                    }
                    case "contains": {
                        System.out.println(list.contains(tokens[1]));
                        break;
                    }
                    case "swap": {
                        int index1 = Integer.parseInt(tokens[1]);
                        int index2 = Integer.parseInt(tokens[2]);
                        list.swapElements(index1, index2);
                        break;
                    }
                    case "greater": {
                        System.out.println(list.countGreaterElements(tokens[1]));
                        break;
                    }
                    case "max": {
                        System.out.println(list.getMax());
                        break;
                    }
                    case "min": {
                        System.out.println(list.getMin());
                        break;
                    }
                    case "print": {
                        list.forEach(System.out::println);
                        break;
                    }
                }

                inputCommand = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
