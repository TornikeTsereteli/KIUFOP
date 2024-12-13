package LinkedList;

import java.util.Arrays;

public class List {
    private int info;
    private List next;

    public List(int info, List next) {
        this.info = info;
        this.next = next;
    }
    // [7 0 -3 13]

    public boolean isEmpty(List l){
        return l == null;
    }

    public static void print(List l){
        List h = l;
        while (h != null){
            System.out.print(h.info + " ");
            h = h.next;
        }
    }

    public void insert(int data, int i){
        List l = next;
        for(int k = 1; k < i - 1; i++){
            l = l.next;
        }
        l.next = new List(data,l.next);

    }

    public void insert(int data){
        next = new List(data, next);
    }

    public void delete(){
        next = next.next;
    }


    public int length(){
        int cnt = 1;
        List l = next;
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


    public static List toList(int[] arr){
        List l = null;
        // l =  1 2 3  arr[i] = 4 ->l = 4 1 2 3
        for (int i = arr.length - 1; i >= 0; i--) { // 4 3 2 1 null
            l = new List(arr[i],l);
        }
        return l;
    }

    public static int[] toArray(List l){
        int[] arr = new int[l.length()];
        int i = 0;
        while (l != null){  // 1 2 3   i = 0  [0,0,0] -> [1,0,0]  2 3  1 -> [1 2 0] 3 2 -> [1 2 3] null 3
            arr[i] = l.info;
            l = l.next;
            i++;
        }
        return arr;
    }




    public static void main(String[] args) {
        List l = new List(1,new List(2,new List(4,null)));
        // 1 next 2  next.next 4  next/next.next.....
        l.insert(7);
        l.delete();

        List l1 = toList(new int[]{1,2,3,4});

        int[] arr = toArray(l1);

        System.out.println(Arrays.toString(arr));
        print(l1);

//        print(l);






    }




}
