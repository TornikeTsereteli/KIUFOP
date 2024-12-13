package Inheritance;

public class Prism {

    private int height;
    private BaseArea base;

    public Prism(int height, BaseArea base) {
        this.height = height;
        this.base = base;
    }

    public double surface(){
        return 2 * base.area() + base.circumference() * height;
    }

    public double volume(){
        return base.area() * height;
    }

    public boolean isCube(){
        if(!base.isSquare()){
            return false;
        }
        // a = (12 + 4) +  5
        // a = new Add(new Add(new Const(12),new Const(4)), new Const(5))

        // a = new Const(5)  a.getValue() =5


        return base.toSquare().getLength() == height;
    }

    @Override
    public String toString() {
        return "Prism{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }

    public static void main(String[] args) {
        Prism cube = new Prism(4,new Square(4));
        System.out.println(cube.isCube());

        Prism cilindri = new Prism(5,new Circle(12));



        String s = new String("dsada");


        Object s1 = new Prism(1,null);
        String s2 = (String) s1;
        // ClassCastException


        //A f() B f()
        // C extends A,B ........ AN{
        //
        // }



    }


    static interface I{
        void f();

    }


    static class A implements I{

        @Override
        public void f() {
            System.out.println("I");
        }
    }
}
