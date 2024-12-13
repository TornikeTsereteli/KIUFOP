package PenguinTrees;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class InnerNode <T> implements TreeElement<T>{
    private T info;
    private TreeElement<T> left;
    private TreeElement<T> right;

    public InnerNode(T info, TreeElement<T> left, TreeElement<T> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    @Override
    public TreeElement<T> insert(T value, Comparator<T> comp) {
        int c = comp.compare(value,this.info);
        if(c<0){
            this.left = this.left.insert(value,comp);
        }else{
            this.right = this.right.insert(value,comp);
        }
        return this;
    }

    @Override
    public void toString(StringBuilder sb) {

        StringBuilder s = new StringBuilder("dada");
        s.append("dasda");

    }

    @Override
    public int size() {
        return left.size() + right.size() + 1;
    }

    @Override
    public T getMin() {
        T val = left.getMin();
        if(val == null){
            return info;
        }
        return val;
    }

    @Override
    public TreeElement<T> remove(T t, Comparator<T> comp) {
        return null;
    }

    @Override
    public boolean contains(T value, Comparator<T> comp) {
        return comp.compare(value,info) == 0 || left.contains(value,comp) || right.contains(value,comp);
    }

    @Override
    public int countMatches(Predicate<T> filter) {
        return left.countMatches(filter) + right.countMatches(filter) + (filter.test(info) ? 1 : 0);
    }

    @Override
    public int getAll(Predicate<T> filter, T[] array,int index) {
        int i = left.getAll(filter,array,index);
        if(filter.test(info)){
            array[i] = info;
            i++;
        }
        int j = right.getAll(filter,array,i);
        return j;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.get(3);
        list.addAll(List.of(1,2,3,4));
        list.remove(0);

    }
}
