import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.items = new int[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    public void push(int element) {
        if (this.capacity == this.size) {
            resize();
        }

        items[size++] = element;
    }

    public int pop() {
        if (capacity / 4 > size && capacity > INITIAL_CAPACITY) {
            shrink();
        }

        return items[--size];
    }

    public int peek() {
        if (this.size == 0) {
            throw new NullPointerException();
        }
        return items[size - 1];
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }

    public int getSize() {
        return this.size;
    }

    private void shrink() {
        capacity /= 2;
        var copy = new int[capacity];

        System.arraycopy(this.items, 0, copy, 0, size);

        this.items = copy;
    }

    private void resize() {
        this.capacity *= 2;
        var copy = new int[capacity];

        System.arraycopy(this.items, 0, copy, 0, size);

        this.items = copy;
    }


}
