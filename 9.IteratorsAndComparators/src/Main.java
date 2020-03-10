import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
            Book bookThree = new Book("The Documents in the Case", 2002);
            Book bookTwo = new Book("The Documents in the Case", 1230, "Dorothy Sayers", "Robert Eustace");

            var lib = new Library<Book>(bookOne, bookTwo, bookThree);
            lib.sort(new BookComparator());

            for (Book book : lib) {
                System.out.println(book);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
