import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Library<T extends Comparable<T>> implements Iterable<T>{
    List<T> books;

    public Library(T... books) {
        this.books = Arrays.stream(books).collect(Collectors.toList());
    }

    public void sort() {
        books.sort(Comparable::compareTo);
    }

    public void sort(Comparator<T> comparator) {
        books.sort(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<T> {
        int currentIndex;

        LibraryIterator() {
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentIndex < books.size();
        }

        @Override
        public T next() {
            return books.get(currentIndex++);
        }
    }
}
