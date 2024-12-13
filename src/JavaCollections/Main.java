package JavaCollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);

        list.add(1);
        list.addAll(arrayList);

        list.get(0);

        // Stack Queue

        Stack<Integer> stack = new Stack<>();


        stack.push(1);
        stack.push(2);
        int result = stack.pop(); // 2
        stack.peek(); // 1
        stack.peek(); // 1


//        stack.isEmpty();
        char[] arr = {'5','2','3', '+', '*'};
        System.out.println(evaluate(arr));



        Set<Integer> set = new HashSet<>(); // [ ...1....... ]



        set.add(1);
        set.add(1);



        // 1.hashCode() -> 0 - 999 -> 50

        set.contains(2); // 2.hashCode() -> 90

        // map["dsda"]  = 1;
        // map[2] = 4
        // 5 -> 12


        Map<Integer,Integer> map = new HashMap<>();

        map.put(5,12);
        map.get(5); // 12
        for(int i = 1; i < 5; i++){
            map.put(i,i*i);
        }

        map.put(5,13);

        map.get(5); // 13
        int a = map.getOrDefault(6,2);

        boolean fourExists = map.containsKey(4);
        // map 1->2 2->5  3->7
        Set<Integer> keys = map.keySet(); // 1 2 3
        Collection<Integer> values = map.values(); // 2 5 7
        System.out.println(set.size());

        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);

        list1.add(4);
        list1.add(6);
        list1.add(7);
        Stream<Integer> stream = list1.stream();

        List<Integer> filteredList = stream.filter( x -> x % 2 == 0).toList();
        System.out.println(filteredList);

        List<Integer> l = list1.stream().map(x->x+1).toList();

        boolean b = list.stream().anyMatch(x->x%2 == 0);

        boolean b1 = list.stream().allMatch(x->x%2 == 0);


        long size = list.stream().count();

        List<Integer> skipped = list.stream().skip(3).toList();

        int max = list.stream().reduce(Integer.MIN_VALUE,(x,acc)-> {
            return Math.max(x,acc);
        });

      char[] arr1 = new  char[256];
      arr1['a']++;


    }

    // [1,2 3, 1, 1, 5,5] -> |||    1 -> 3 ; 2->1 ; 3->1; 5->2
    public static Map<Integer,Integer> occurence(int[] arr){ // O(n2), O(N)
        Map<Integer,Integer> map = new HashMap<>();
        for(int e: arr){ // 1 1 1
            if(map.containsKey(e)){
                int c = map.get(e);  // 2
                map.put(e,c+1); // 1-> 3
            }else {
                map.put(e,1); // 1->1
            }
        }


        return map;
    }

    public boolean haveUniqueElements(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int e: arr){
            if(!set.add(e)){
                return false;
            }
        }
        return true;
    }


    // [{(((())))
    public boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) return false;
            char c1 = stack.pop();

            if(c1 == '['){
                if(c != ']'){
                    return false;
                }
                continue;
            }

            if(c1 == '('){
                if(c != ')'){
                    return false;
                }
                continue;
            }
            if(c1 == '{'){
                 if(c != '}'){
                     return false;
                 }
            }
        }
        return stack.isEmpty();
    }


    // [1 , 2, 3, + , 2, *, 3, + ] == (1 + 2) * 2 + 3
    // 4 1 2 3 + * * =  4 * 1 *(2+3)
    //

    public static int evaluate(char[] arr){
        Stack<Integer> stack = new Stack<>();
        for(char e: arr){
            if(e == '+'){
                int e1 = stack.pop(); // 3
                int e2 = stack.pop(); // 2
                stack.push(e1+e2);
                continue;
            }

            if(e == '*'){
                int e1 = stack.pop(); // 3
                int e2 = stack.pop(); //
                stack.push(e1*e2);
                continue;
            }

            // '0' | '1'  .... '9'
            stack.push(e - 48);
        }

        return stack.peek();
    }
}
