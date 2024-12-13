package Inheritance.DoubleLinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IntDoubleList {

    private IntDoubleListElement head, tail;

    public IntDoubleList() {
        head = null;
        tail = null;
    }

    public IntDoubleListElement getFirstElement(){
        return head;
    }

    public IntDoubleListElement getLastElement(){
        return tail;
    }

    public void append(int info){
        IntDoubleListElement newElement = new IntDoubleListElement(info,null,null);
        if(head == null) {
            head = tail = newElement;
            return;
        }

        tail.next = newElement;
        newElement.prev = tail;
        tail = tail.next;
    }

    public int size(){
        return sizeHelper(head);
    }

    public int get(int i){
        return getHelper(head,i);
    }


    // 1->2->3->-<-4->  1->2->4

    public void remove(int pos){
        IntDoubleListElement l = head;
        for(int i = 0;i < pos - 1;i++){
            l = l.next;
        }
        l.next = l.next.next;
        l.next.prev = l;
    }


    // 1->2->3->4 2 ->: 2->3->4 1 :-> 3->4 0 -> 3
    private static int getHelper(IntDoubleListElement list, int index){
        if(index == 0){
            return list.getInfo();
        }
        if(list == null){
            throw new IllegalArgumentException();
        }
        return getHelper(list.next, index - 1);
    }

    private static int sizeHelper(IntDoubleListElement list){
        if(list == null){
            return 0;
        }
        return 1 + sizeHelper(list.next);
    }




    static class ListNode{
        int info;
        ListNode next;

        public ListNode(int info, ListNode next) {
            this.info = info;
            this.next = next;
        }

        public ListNode half(){
            return null;
        }

        public static ListNode[] half(ListNode l){
            if(l == null){
                return new ListNode[]{null,null};
            }
            if(l.next == null){
                return new ListNode[]{l,null};
            }

            //                         [1 3, 2 4]
            ListNode[] halfs = half(l.next.next);
            halfs[0] = new ListNode(l.info,halfs[0]);
            halfs[1] = new ListNode(l.next.info,halfs[1]);
            return halfs;
        }
        public static ListNode[] half(ListNode l, ListNode f, ListNode s){
            if(l == null){
                return new ListNode[]{f,s};
            }
            if(l.next == null){
                f = new ListNode(l.info,f);
                return new ListNode[]{f,s};
            }

            f = new ListNode(l.info,f);
            s = new ListNode(l.next.info,s);

            return half(l.next.next,f,s);

        }


        public static void main(String[] args) {
            LinkedList<Integer> l = new LinkedList<>();


            Stack<Integer> stack = new Stack<>();
            stack.push(5);
            int c = stack.pop();
            int s = stack.peek();


        }


        static class Queue{

            ListNode first;




        }

    }




}
