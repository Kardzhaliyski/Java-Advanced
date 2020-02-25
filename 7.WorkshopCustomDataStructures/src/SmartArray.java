import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public void add(int element) {
        if(this.size >= this.capacity) {
            resize();
        }

        this.data[size] = element;
        this.size++;
    }

    public void add(int index, int element) {
        if(this.size >= this.capacity) {
            resize();
        }

        if(index == this.size) {
            add(element);
        } else {
            checkIndex(index);
            shiftRight(index);
            this.data[index] = element;
            this.size++;
        }
    }

    public int get(int index) {
        checkIndex(index);

        return this.data[index];
    }

    public int remove(int index) {
        checkIndex(index);

        var removedValue = this.data[index];
        this.data[index] = 0;

        shiftLeft(index);

        if(this.size <= this.capacity / 4) {
            shrink();
        }

        return removedValue;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if(this.data[i] == element){
                return true;
            }
        }

        return false;
    }

    public void forEach (Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < this.size; i++) {
            sum += this.data[i];
        }

        return sum;
    }

    private void checkIndex(int index) {
        if(index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
    }

    private void resize() {
        this.capacity *= 2;
        var copy = new int[this.capacity];

        System.arraycopy(this.data, 0, copy, 0, this.data.length);

        this.data = copy;
    }

    private void shrink() {
        this.capacity /= 2;
        var copy = new int[capacity];

        System.arraycopy(this.data, 0, copy, 0, this.capacity);

        this.data = copy;
    }

    private void shiftLeft(int index) {
        for (int i = index ; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.data[--this.size] = 0;
    }

    private void shiftRight(int index) {
        for (int i = this.size ; i > index; i--) {
            this.data[i] = data[i - 1];
        }

        this.data[index] = 0;
    }


}
