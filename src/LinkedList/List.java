package LinkedList;

import java.util.Arrays;
import java.util.Iterator;

public class List<T>  implements Iterable<T> {
    private T info;
    private List<T> next;

    public List(T info, List<T> next) {
        this.info = info;
        this.next = next;
    }
    // [7 0 -3 13]

    public boolean isEmpty(List<T> l){
        return l == null;
    }



    public void insert(T data, int i){
        List<T> l = next;
        for(int k = 1; k < i - 1; i++){
            l = l.next;
        }
        l.next = new List<T>(data,l.next);

    }

    public void insert(T data){
        next = new List<T>(data, next);
    }

    public void delete(){
        next = next.next;
    }


    public int length(){
        int cnt = 1;
        List<T> l = next;
        while(l != null){
            cnt++;
            l = l.next;
        }
        return cnt;
    }

    public int lengthRec(){
        if(next == null){
            return 1;
        }
        return 1 + next.lengthRec();
    }


//    public static List<A> toList(int[] arr){
//        List<A> l = null;
//        // l =  1 2 3  arr[i] = 4 ->l = 4 1 2 3
//        for (int i = arr.length - 1; i >= 0; i--) { // 4 3 2 1 null
//            l = new List<A>(arr[i],l);
//        }
//        return l;
//    }
//
//    public static int[] toArray(List<A> l){
//        int[] arr = new int[l.length()];
//        int i = 0;
//        while (l != null){  // 1 2 3   i = 0  [0,0,0] -> [1,0,0]  2 3  1 -> [1 2 0] 3 2 -> [1 2 3] null 3
//            arr[i] = l.info;
//            l = l.next;
//            i++;
//        }
//        return arr;
//    }
//



    public static void main(String[] args) {
//        List<A> l = new List<A>(1,new List<A>(2,new List<A>(4,null)));
//        // 1 next 2  next.next 4  next/next.next.....
//        l.insert(7);
//        l.delete();
//
//        List<A> l1 = toList(new int[]{1,2,3,4});
//
//        int[] arr = toArray(l1);
//
//        System.out.println(Arrays.toString(arr));
//        print(l1);
//
////        print(l);


        List<Integer> list = new List<>(1,new List<>(2,new List<>(3,null)));

        for(int i: list){
            System.out.println(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }





    }


    static class ListIterator<T> implements Iterator<T> {
        List<T> current;
        ListIterator(List<T> l) {
            current = l;
        }
        public boolean hasNext() { return current!=null; }
        public T next() {
            T result = current.info;
            current = current.next;
            return result;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }


}
