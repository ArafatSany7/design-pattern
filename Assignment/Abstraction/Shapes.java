abstract class Shape {
    abstract double area();

    abstract double perimeter();

    abstract String description();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    String description() {
        return "This is a circle .";
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }

    @Override
    String description() {
        return "This is a rectangle.";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Shape shape = new Circle(3);
        System.out.println("Shape Area: " + shape.area() + ", Perimeter: " + shape.perimeter());
        System.out.println(shape.description());

        shape = new Rectangle(4, 6);
        System.out.println("Shape Area: " + shape.area() + ", Perimeter: " + shape.perimeter());
        System.out.println(shape.description());
    }
}
