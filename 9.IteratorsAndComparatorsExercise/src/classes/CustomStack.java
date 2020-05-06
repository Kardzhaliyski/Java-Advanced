package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomStack<T> implements Iterable<T> {
    private List<T> list;
    private Integer capacity;

    public CustomStack() {
        this.list = new ArrayList<>();
    }

    public void push(T[] elements) {
        list.addAll(Arrays.asList(elements));
    }

    public void pop() {
        if (list.size() == 0) {
            System.out.println("No elements");
        } else {
            list.remove(list.size() - 1);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int pointer = list.size() - 1;

            @Override
            public boolean hasNext() {
                return pointer >= 0;
            }

            @Override
            public T next() {
                return list.get(pointer--);
            }
        };
    }
}
