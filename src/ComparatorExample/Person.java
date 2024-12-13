package ComparatorExample;

import Interfaces.Poly;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @FunctionalInterface
    public interface Comparator<T>{
        int compare(T o1,T o2);

    }

    public Person[] generalSort(Person[] persons, Comparator<Person> comp){
        for(int i = 0; i<persons.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < persons.length; j++ ){
                if(comp.compare(persons[j],persons[minIndex]) < 0){
                    minIndex = j;
                }
            }
            Person temp = persons[i];
            persons[i] = persons[minIndex];
            persons[minIndex] = temp;
        }
        return persons;
    }


    public static class AgeComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    public static class NameComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    public Person[] sortByAge(Person[] persons){
        Comparator<Person> comp = new AgeComparator();
        Comparator<Person> comp1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        };

        Comparator<Person> comp2 = (Person o1, Person o2)->{
            return o1.age - o2.age;
        };

        Comparator<Person> comp3 = (o1,o2) -> o1.age - o2.age;






        return generalSort(persons, (o1,o2)-> o1.age - o2.age);
    }

    public Person[] sortByName(Person[] persons){
       return generalSort(persons,new NameComparator());
    }

    @FunctionalInterface
    public interface Function<T,R>{
         R apply(T x);
    }

    public static<T,R> R[] map(T[] arr, Function<T,R> f){
        R[] brr = (R[]) new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            brr[i] = f.apply(arr[i]);
        }
        return brr;
    }

//    public interface Predicate<T>{
//        boolean test(T data);
//    }

    public static<T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> l = new LinkedList<>();
        for (T e: list){
            if(p.test(e)){
                l.add(e);
            }
        }
        return l;
    }
    public static interface BiFunction<T,R,S>{
        S apply(T a, R b);
    }
    public static<T,R> R reduce(List<T> l, R acc, BiFunction<T,R,R> f){
        if(l.isEmpty()){
            return acc;
        }
        T data = l.removeFirst();
        return reduce(l,f.apply(data,acc),f);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        Function<Integer,String> f =  x -> x.toString() + "aa";
        System.out.println(Arrays.toString(map(arr,f)));
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        List<Integer> l1 = new LinkedList<>(l);

        List<Double> l2 = new LinkedList<>();
        l2.add(1.0);
        l2.add(2.0);

        System.out.println(calculate(l2));

        System.out.println(reduce(l1,0,(x,acc)->x+acc));


        Predicate<Integer> p = x -> x > 0;
        Predicate<Integer> LessThanOrEqualZero =  p.negate();
        Predicate<Integer> xIsMoreThanZeroAndIsEven = p.and(x->x % 2 == 0);


        Person person1 = new Person("dsad",12);
        Person person2 = new Person("dsad",12);
        Person person3 = new Person("dsad",13);
        Person person4 = new Person("dsad",13);
        Person person5 = new Person("dsad",11);

        List<Person> personList = new ArrayList<>(List.of(person1,person2,person3,person4,person5));

        Map<Integer,List<Person>> map = groupByAge(personList);

        System.out.println(map);



    }


    public static double calculate(List<Double> list){
        return list.stream().filter(x-> x>0).map(x->x*x).reduce(0.0,(acc,x) -> x + acc);
    }

    public static Set<Double> toSet(List<Double> list){
        return list.stream().collect(Collectors.toSet());
    }

    public static double average(List<Double> l){
        return l.stream().reduce(0.0,(acc,x)->acc + x)/l.size();
    }

    public static double averageP(List<Person> personList){
        return personList.stream().mapToDouble(p->p.age).average().getAsDouble();
    }


    //

    /// p1 12  p2 12 p3 11 p4 14 p5 14
    //  12 -> [p1,p2]   11 -> [p4]   14 -> [p4,p5]
    //
    //

    public static Map<Integer,List<Person>> groupByAge(List<Person> personList){
        return personList.stream().collect(Collectors.groupingBy(x->x.age));
    }

    // l1 l2 l3 -> l1.size + l2.size + l3.size
    public static<T> int size(List<List<T>> list){
        return list.stream().mapToInt(x->x.size()).sum();
    }
//    public static<T> int sizeR(List<List<T>> list){
//        return list.stream().collect(0,(acc,x)->acc+x.size());
//    }
//

}

