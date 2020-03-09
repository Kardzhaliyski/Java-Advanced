import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Book bookOne = new Book("Zanimal Farm", 2003, "George Orwell");
            Book bookThree = new Book("The Documents in the Case", 2002);
            Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

            List<Book> books = new ArrayList<>();
            books.add(bookOne);
            books.add(bookTwo);
            books.add(bookThree);

            books.sort(BookComparator::compare);

            for (Book book : books) {
                System.out.println(book);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
