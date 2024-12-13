package Interfaces;

public class Poly {

    static class A{
        int f(String s){
            return 1;
        }

        void g(){
            System.out.println("A");
        }
    }

    interface I{
        void f();
    }

    public class C implements I{

        @Override
        public void f() {
            System.out.println("dasda");
        }
    }

    public class D implements I{

        @Override
        public void f() {

        }
    }

    static class B extends A{

        I i;
        public B(I i){
            this.i = i;
        }

        public void foo(){
            i.f();
        }

        int f(Object s) {
            System.out.println("B");
            return 12;
        }

        void g() {
            System.out.println("BB");
        }

        void h(){
            System.out.println("B class Method only");
        }
    }



    public static void main(String[] args) {
//        A a = new B();
//        a.f("dasda");


    }
}
