package genericclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public T getMin() {
        if(list.isEmpty()) {
            return null;
        }

        T minElement = list.get(0);
        for (T element : list) {
            if(minElement.compareTo(element) > 0) {
                minElement = element;
            }
        }

        return minElement;
    }

    public T getMax() {
        if(list.isEmpty()) {
            return null;
        }

        T maxElement = list.get(0);
        for (T element : list) {
            if(maxElement.compareTo(element) < 0) {
                maxElement = element;
            }
        }

        return maxElement;
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void forEach(Consumer<T> consumer) {
        list.forEach(consumer);
    }

    public void swapElements(int index1, int index2) {
        if(index1 > list.size() - 1 || index1 < 0) {
            throw new IndexOutOfBoundsException("Index " + index1 + " out of bounds for length " + this.list.size());
        } else if (index2 > list.size() -1 || index2 < 0 ) {
            throw new IndexOutOfBoundsException("Index " + index2 + " out of bounds for length " + this.list.size());
        }

        T tempElement = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, tempElement);
    }

    public int countGreaterElements(T element) {
        int count = 0;
        for (T t : this.list) {
            if(element.compareTo(t) < 0) {
                count++;
            }
        }

        return count;
    }
}
