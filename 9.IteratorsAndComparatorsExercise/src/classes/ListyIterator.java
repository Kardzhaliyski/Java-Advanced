package classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int indexPointer;

    public ListyIterator(String[] inputCollection) {
        this.list = Arrays.stream(inputCollection).collect(Collectors.toList());
        this.indexPointer = 0;
    }

    public boolean move() {
        if (hasNext()) {
            this.indexPointer++;
            return true;
        }

        return false;

    }

    public boolean hasNext() {
        return this.indexPointer + 1 < this.list.size();
    }

    public void print() {
        if (this.list == null || this.list.isEmpty()) {
            //throw new NullPointerException("Invalid Operation!");
            System.out.println("Invalid Operation!");
            return;
        }

        System.out.println(list.get(indexPointer));
    }

    public void printAll() {
        System.out.println(String.join(" ", list));
    }

    @Override
    public Iterator<String> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<String> {
        int pointer = 0;

        public listIterator() {
            this.pointer = 0;
        }

        @Override
        public boolean hasNext() {
            return this.pointer < list.size();
        }

        @Override
        public String next() {
            return list.get(pointer++);
        }
    }
}
