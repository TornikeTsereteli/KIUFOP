package PenguinTrees;

import java.util.Comparator;
import java.util.function.Predicate;

public interface TreeElement <T>{
    TreeElement<T> insert(T value, Comparator<T> comp);
    void toString(StringBuilder sb);

    int size();
    T getMin();
    TreeElement<T> remove(T t,Comparator<T> comp);
    boolean contains(T value,Comparator<T> comp);
    int countMatches(Predicate<T> filter);
    int getAll(Predicate<T> filter,T[] array,int index);

}
