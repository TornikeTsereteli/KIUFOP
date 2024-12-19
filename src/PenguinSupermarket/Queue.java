package PenguinSupermarket;

public interface Queue<T> extends DataStructure {
    void enqueue(T info);
    T dequeue();
}
