package Inheritance;

public class Square extends BaseArea{


    private int length;

    public Square(int length) {
        this.length = length;
    }


    public int getLength(){
        return length;
    }

    @Override
    public double circumference() {
        return  4* length;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public boolean isSquare() {
        return true;
    }

    @Override
    public Square toSquare() {
        return this;
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
}
