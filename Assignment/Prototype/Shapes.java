abstract class Shape implements Cloneable {

    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract Shape cloneShape();

    @Override
    protected Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Circle extends Shape {

    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Shape cloneShape() {
        return new Circle(this.getColor(), this.radius);
    }

    public void showDetails() {
        System.out.println("Circle Details - Color: " + getColor() + ", Radius: " + radius);
    }
}

class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Shape cloneShape() {
        return new Rectangle(this.getColor(), this.width, this.height);
    }

    public void showDetails() {
        System.out.println("Rectangle Details - Color: " + getColor() + ", Width: " + width + ", Height: " + height);
    }
}

public class Shapes {
    public static void main(String[] args) {

        Circle originalCircle = new Circle("Red", 5);
        Circle clonedCircle = (Circle) originalCircle.cloneShape();

        originalCircle.showDetails();
        clonedCircle.showDetails();

        Rectangle originalRectangle = new Rectangle("Blue", 10, 20);
        Rectangle clonedRectangle = (Rectangle) originalRectangle.cloneShape();

        originalRectangle.showDetails();
        clonedRectangle.showDetails();

    }
}
