package Inheritance;

public class RegularPolygon extends BaseArea{
    private int n;
    private int length;

    public RegularPolygon(int n, int length) {
        this.n = n;
        this.length = length;
    }


    @Override
    public double circumference() {
        return n * length;
    }

    @Override
    public double area() {
        return (length * length * n) / (4 * Math.tan(Math.PI/n));
    }

    @Override
    public boolean isSquare() {
        return n == 4;
    }

    @Override
    public Square toSquare() {
        if(isSquare()){
            return new Square(length);
        }
        return null;
    }


    @Override
    public String toString() {
        return "RegularPolygon{" +
                "n=" + n +
                ", length=" + length +
                '}';
    }
}
