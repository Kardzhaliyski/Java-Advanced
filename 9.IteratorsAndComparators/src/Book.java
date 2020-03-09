import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, Integer year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.stream(authors)
                .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.title;
    }


    @Override
    public int compareTo(Book book) {
        var difference = this.title.compareTo(book.title);

        return difference != 0 ? difference : this.year - book.year;
    }
}
