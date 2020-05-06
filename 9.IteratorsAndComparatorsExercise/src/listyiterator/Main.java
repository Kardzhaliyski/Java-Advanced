package listyiterator;

import classes.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var inputArr = bfr.readLine().split("\\s+");

            var iterator = new ListyIterator(
                    Arrays.copyOfRange(inputArr,1,inputArr.length));

            var inputCommand = bfr.readLine();
            while (!inputCommand.equals("END")) {
                switch (inputCommand) {
                    case "Move": {
                        System.out.println(iterator.move());
                        break;
                    }
                    case "Print": {
                        iterator.print();
                        break;
                    }
                    case "HasNext": {
                        System.out.println(iterator.hasNext());
                        break;
                    }
                    case "PrintAll": {
                        iterator.printAll();
                    }
                }
                inputCommand = bfr.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
