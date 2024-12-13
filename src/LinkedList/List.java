//package LinkedList;
//
//import java.util.Arrays;
//
//public class List<A> {
//    private int info;
//    private List<A> next;
//
//    public List(int info, List<A> next) {
//        this.info = info;
//        this.next = next;
//    }
//    // [7 0 -3 13]
//
//    public boolean isEmpty(List<A> l){
//        return l == null;
//    }
//
//    public static void print(List<A> l){
//        List<A> h = l;
//        while (h != null){
//            System.out.print(h.info + " ");
//            h = h.next;
//        }
//    }
//
//    public void insert(int data, int i){
//        List<A> l = next;
//        for(int k = 1; k < i - 1; i++){
//            l = l.next;
//        }
//        l.next = new List<A>(data,l.next);
//
//    }
//
//    public void insert(int data){
//        next = new List<A>(data, next);
//    }
//
//    public void delete(){
//        next = next.next;
//    }
//
//
//    public int length(){
//        int cnt = 1;
//        List<A> l = next;
//        while(l != null){
//            cnt++;
//            l = l.next;
//        }
//        return cnt;
//    }
//
//    public int lengthRec(){
//        if(next == null){
//            return 1;
//        }
//        return 1 + next.lengthRec();
//    }
//
//
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
//
//
//
//    public static void main(String[] args) {
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
//
//
//
//
//
//
//    }
//
//
//
//
//}
