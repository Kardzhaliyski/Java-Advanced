package GenericBox;

public class GenericBox <T> {
    T element;

    public GenericBox() {}
    public GenericBox(T element) {
        setElement(element);
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getName(), this.element);
    }
}
