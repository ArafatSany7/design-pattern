interface Draw {
    String Art();
}

// Basic Class
class Object implements Draw {
    String shape;

    public Object(String shape) {
        this.shape = shape;
    }

    @Override
    public String Art() {
        return shape;
    }
}

// Basic Decorator Class
abstract class ShapeDecorator implements Draw {
    protected Draw shape;

    public ShapeDecorator(Draw shape) {
        this.shape = shape;
    }
}

class Circle extends ShapeDecorator {
    public Circle(Draw shape) {
        super(shape);
    }

    @Override
    public String Art() {
        return "circle " + shape.Art() + " chosen";
    }
}

class Square extends ShapeDecorator {
    public Square(Draw shape) {
        super(shape);
    }

    @Override
    public String Art() {
        return "square " + shape.Art() + " chosen";
    }
}

public class Draws {
    public static void main(String[] args) {
        Draw brush = new Object("brush");

        System.out.println(new Circle(brush).Art());
        System.out.println(new Square(brush).Art());
    }
}
