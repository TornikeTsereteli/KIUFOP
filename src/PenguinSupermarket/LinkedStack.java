package PenguinSupermarket;

public class LinkedStack<T> implements Stack<T> {

    private List<T> head;

    public LinkedStack(){
        head = null;
    }


    @Override
    public int size() {
        return head == null ? 0 : head.length();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T info) {
        if(head == null){
            head = new List<>(info);
        }else{
            head = new List<>(info,head);
        }
    }

    @Override
    public T pop() {
        if(head != null) {
            T info = head.getInfo();
            head = head.getNext();
            return info;
        }
        return null;
    }
}
