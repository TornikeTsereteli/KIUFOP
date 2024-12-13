package PenguinAndCompany;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {
    private T data;
    private List<Node<T>> children;
    private Node<T> parent;


    public Node(T data){
        this.data = data;
        this.children = new LinkedList<>();
        this.parent = null;
    }

    public Node(T data, List<Node<T>> children, Node<T> parent) {
        this.data = data;
        this.children = children;
        this.parent = parent;
    }

    public void insert(Node<T> value){
        this.children.add(value);
        value.parent = this;
    }


    public boolean isLeaf(){
       return this.children.isEmpty();
    }


    public int size(){
         if(isLeaf()) return 1;
         int size = 1;
         for(Node<T> child : children){
             size += child.size();
         }
         return size;
    }

    public void remove(){
        for(Node<T> child: children){
            child.parent = this.parent;
        }
        this.parent.children.addAll(children);
        this.parent.children.remove(this);
    }

    public void traversal(){
        if(isLeaf()){
            System.out.print(data);
        }else{
            System.out.println(data);
            for (Node<T> child:children){
                child.traversal();
            }
        }
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }


}
