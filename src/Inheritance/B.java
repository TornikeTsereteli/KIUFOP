package Inheritance;

public class B extends A{

    public void g(){
        System.out.println("Im in B");
    }

    @Override
    public void f() {
        System.out.println("IM in B");
    }

    public void h(){

    }

    public static void main(String[] args) {
        A b = new B();

        b.f();
        b.h();
//        b.g();



    }
}
