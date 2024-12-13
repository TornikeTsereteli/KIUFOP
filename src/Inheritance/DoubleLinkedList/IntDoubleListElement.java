package Inheritance.DoubleLinkedList;

public class IntDoubleListElement {
    public int getInfo() {
        return info;
    }

    private int info;
    public IntDoubleListElement prev;
    public IntDoubleListElement next;

    public IntDoubleListElement(int info, IntDoubleListElement prev, IntDoubleListElement next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public IntDoubleListElement(int info) {
        this.info = info;
    }
}
