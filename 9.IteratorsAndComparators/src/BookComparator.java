import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book left, Book right) {
        var difference = left.getTitle().compareTo(right.getTitle());

        return difference != 0 ? difference : left.getYear() - right.getYear();
    }
}
