package Inheritance;

public class Rectangle extends BaseArea{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public double circumference() {
        return 2*width + 2*height;
    }

    @Override
    public double area() {
        return width*height;
    }


    @Override
    public boolean isSquare() {
        return height == width;
    }

    @Override
    public Square toSquare() {
        if(isSquare()){
            return new Square(height);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
