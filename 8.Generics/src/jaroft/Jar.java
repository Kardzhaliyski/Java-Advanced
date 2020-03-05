package jaroft;

import java.util.ArrayDeque;

public class Jar<T> {
    ArrayDeque<T> stack;

    public Jar(){
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.push(element);
    }

    public T remove() {
        return this.stack.pop();
    }

    public Boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
