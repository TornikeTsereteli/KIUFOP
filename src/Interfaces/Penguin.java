package Interfaces;

import Inheritance.BaseArea;

import java.util.Comparator;
import java.util.List;

public class Penguin extends Animal implements Comparable,CopyAble{

    private String name;
    private double height;

    public Penguin(int age, String name, double height) {
        super(age);
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Penguin penguin) {
        if(age == penguin.age){
            if(height == penguin.height){
                return name.compareTo(penguin.name);
            }else{
                return Double.compare(height,penguin.height);
            }
        }else{
            return Integer.compare(age,penguin.age);
        }
    }

    @Override
    public Penguin copy() {
        return new Penguin(age,name,height);
    }

    public static void main(String[] args) {
        Animal penguin = new Penguin(12,"aa",140);
        Comparable penguin1 = new Penguin(12,"aa",140);
        CopyAble penguin2 = new Penguin(12,"aa",140);
        Penguin penguin3 = new Penguin(12,"aa",140);

        penguin.birthday();

        A a = new B();
        System.out.println(a.y);


        TreeNode treeNode = new TreeNode(1,new TreeNode(2,null,null),new TreeNode(3,null,null));
    }

    public static boolean findElement(TreeNode root, int element){
        if(root == null){
            return false;
        }
//        if(root.info == element){
//            return true;
//        }
        return findElement(root.left,element) || findElement(root.right,element);
    }

    public static void print1(TreeNode root){
        if(root!=null){
            System.out.println(root.info);
            print1(root.left);
            print1(root.right);


        }
    }



    public static void print2(TreeNode root){
        if(root!=null){
            print2(root.left);

            System.out.println(root.info);
            print2(root.right);
        }
    }

    public static void print3(TreeNode root){
        if(root!=null){

            print3(root.left);
            print3(root.right);
            System.out.println(root.info);
        }
    }

    public static int depth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return 1 + Math.max(depth(treeNode.left),depth(treeNode.right));
    }

    public static int countEvenNumbers(TreeNode<Integer> treeNode){
        if(treeNode == null){
            return 0;
        }
        int c = countEvenNumbers(treeNode.left) + countEvenNumbers(treeNode.right);
        return treeNode.info % 2 == 0 ? c+1 : c;
    }

//    public static<T> void add8ToLeft(TreeNode<T> treeNode,T value){
//        treeNode.left = new TreeNode<T>(value,treeNode.left,null);
//    }



     static class A{
        int y = 3;
    }
    static class B extends A{
        int y = 9;
    }
    static class C{

    }


    static class TreeNode<T>{
        T info;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T info, TreeNode<T> left, TreeNode<T> right) {

            this.info = info;
            this.left = left;
            this.right = right;
        }

        static void f(int[] arr){
            arr = new int[4];
        }
        public static <T> TreeNode<T> insert(TreeNode<T> treeNode, T value, Comparator<T> comp){
            if(treeNode == null){
               return new TreeNode<>(value,null,null);
            }
            if(comp.compare(value,treeNode.info) <= 0){
                treeNode.left = insert(treeNode.left,value,comp);
                return treeNode;
            }else{
                treeNode.right = insert(treeNode.right,value,comp);
                return treeNode;
            }
        }


        static class A{
            void f(){
                System.out.println("A");
            }
        }
        static class B extends A{
            @Override
            void f(){
                super.f();
                System.out.println("B");
            }
            void g(){
                System.out.println("CC");
            }
        }


        interface I1{
            int f();
        }

        interface I2{
            int g();
        }
        interface I3 extends I1,I2{
            default void h(){
                System.out.println("I3");
            }
        }

        static class C implements I3{

            @Override
            public int f() {
                return 0;
            }

            @Override
            public int g() {
                return 0;
            }

            @Override
            public void h() {
                System.out.println("CCCCC");
            }
        }

        public static void main(String[] args) {

            C c = new C();
            c.h();

            A a = new A();
            a.f();
            A a1 = new B();
            a1.f();

            B b1 = new B();
            A a2 = (A) b1;
            B b = (B) a1; //
            b.g();

            if(a1 instanceof B){
                B b3 = (B) a1;

            }


            Object[] objects = new Object[]{1,"dsada","dasda",new A()};

//            Pair<Integer,Boolean> aa = new Pair<>(1,false);


//            BaseArea a = new BaseArea();

            I aaa = new AAA();
            aaa.f();
            aaa.g();

            A a11 = new B();

            if(a11 instanceof B){
               CC a2122 = (CC) a11;

            }



//            Pair<Integer,String> pair = new Pair<>(1,"dada");


        }
        static class CC extends B{

        }
//
//        public int g(I a){
//
//        }

        static class Pair<A extends I,B>{
            A a;
            B b;

            public Pair(A a,B b){
//                a
                this.a = a;
                this.b = b;
            }

            public static <T> T foo(List<T> list){
                return list.get(0);
            }

        }
    }


    interface I{
        int f();
        int g();
    }

    static class AAA implements I{

        @Override
        public int f() {
            return 123;
        }

        @Override
        public int g() {
            return 12;
        }
    }


    static class Tree<T>{
        T info;
        Tree<T> left;
        Tree<T> right;

        public Tree(T info, Tree<T> left, Tree<T> right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }
    }




}
