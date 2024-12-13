package PenguinAndCompany;

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {
    private Node<T> root;

    public Tree(){
        this.root = null;
    }

    public Tree(Node<T> root){
        this.root = root;
    }

    public void insert(T value,T parent){
        Node<T> parentNode = find(parent,root);
        if(parentNode == null || containsKey(value)){
            return;
        }
        parentNode.insert(new Node<>(value));
    }

    private Node<T> find(T value, Node<T> root){
        if(root.getData() == value){
            return root;
        }
        for(Node<T> child : root.getChildren()){
            Node<T> nodeWithDesiredValue = find(value,child);
            if(nodeWithDesiredValue != null){
                return nodeWithDesiredValue;
            }
        }
        return null;
    }

    public void remove(T a){
        Node<T> node = find(a,root);
        if(node == null || node.getParent() == null){
            return;
        }
        node.remove();
    }

    public T LCA(T a,T b){
        Node<T> nodeA = find(a,root);
        Node<T> nodeB = find(b,root);
        if(nodeA == null || nodeB == null){
            return null;
        }
        LinkedList<T> parentsOfA = getAllParents(nodeA,new LinkedList<>());
        LinkedList<T> parentsOfB = getAllParents(nodeB,new LinkedList<>());

        int min = Math.min(parentsOfA.size(),parentsOfB.size());

        for(int i = 0; i<min;i++){
            if(parentsOfA.get(i)!=parentsOfB.get(i)){
                return parentsOfA.get(i-1);
            }
        }
        return parentsOfA.get(min-1);
    }


    private LinkedList<T> getAllParents(Node<T> node,LinkedList<T> result){
        if(node == null){
            return result;
        }
        result.addFirst(node.getData());
        return getAllParents(node.getParent(),result);
    }

    public int distanceBetweenNodes(T a,T b){
        return 0;
    }

    public boolean containsKey(T a){
        return containsKeyHelper(a,root);
    }

    private boolean containsKeyHelper(T a,Node<T> root){
        if(root.getData() == a){
            return true;
        }
        boolean b = false;
        for(Node<T> child: root.getChildren()){
            b = b || containsKeyHelper(a,child);
        }
        return b;
    }

    public void traversal(){

    }

}
