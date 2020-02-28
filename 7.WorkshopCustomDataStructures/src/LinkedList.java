import java.util.ArrayList;
import java.util.function.Consumer;

public class LinkedList {

    private  class Node {
        private int element;
        private Node previousNode;
        private Node nextNode;

        public Node(int element) {
            this.element = element;
            this.previousNode = null;
            this.nextNode = null;
        }

        public void setPreviousNode(Node node) {
            this.previousNode = node;
        }

        public boolean hasPrevious() {
            return this.previousNode != null;
        }

        public Node getPrevious() {
            return this.previousNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

        public boolean hasNext() {
            return this.nextNode != null;
        }

        public Node getNext() {
            return this.nextNode;
        }

        public int getElement() {
            return this.element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        Node node = new Node(element);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNextNode(this.head);
            this.head = node;
        }

        this.size++;
    }

    public void addLast(int element) {
        Node node = new Node(element);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNextNode(node);
            node.setPreviousNode(this.tail);
            this.tail = node;
        }

        this.size++;
    }

    public int get(int index) {
        if(index < 0 || index >= this.size) {
            throw  new IndexOutOfBoundsException("Index " + index + " is out of bounds for size: " + this.size);
        }

        Node node = head;

        for (int i = 0; i < index; i++) {
            if(node.hasNext()) {
                node = node.getNext();
            }
        }

        return node.getElement();
    }

    public Integer removeFirst() {
        if(this.head == null) {
            return null;
        }

        Node node = this.head;
        if(!node.hasNext()) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = node.getNext();
            this.head.setPreviousNode(null);
        }

        this.size--;
        return node.getElement();
    }

    public Integer removeLast() {
        if(this.head == null) {
            return null;
        }

        Node node = this.tail;

        if(!this.head.hasNext()) {
            this.head = null;
            this.tail = null;
            return node.getElement();
        }

        Node previousNode = node.getPrevious();

        previousNode.setNextNode(null);
        this.tail = previousNode;

        this.size--;
        return node.getElement();
    }

    public Integer removeAt(int index) {
        if(index < 0 || index >= this.size) {
//            throw new NullPointerException("Index " + index + " is out of bounds! For size: " + this.size);
            return null;
        }

        if(this.head == null) {
            return null;
        }

        Node node;

        if(index < this.size / 2 ){
            node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = this.tail;
            int diff = this.size - 1 - index;
            for (int i = 0; i < diff; i++) {
                node = node.getPrevious();
            }
        }

        if(node.hasPrevious() && node.hasNext()) {
            node.getPrevious().setNextNode(node.getNext());
            node.getNext().setPreviousNode(node.getPrevious());
        } else if(node.hasNext()) {
            return removeFirst();
        } else {
            return removeLast();
        }

        size--;
        return node.getElement();
    }

    public void forEach(Consumer<Integer> consumer) {
        Node node = this.head;

        while (node != null) {
            consumer.accept(node.getElement());
            node = node.getNext();
        }
    }

    public void forEachReverse (Consumer<Integer> consumer) {
        Node node = this.tail;

        while (node != null) {
            consumer.accept(node.getElement());
            node = node.getPrevious();
        }
    }

    public int[] toArray() {
        Node node = this.head;
        int[] arr = new int[this.size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = node.getElement();
            node = node.getNext();
        }

        return arr;
    }

    public int getSize() {
        return this.size;
    }

}
