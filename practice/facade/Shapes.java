interface Shape {
    public void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Circle ::draw()");
    }
}
class Square implements  Shape{
    @Override
    public void draw(){
        System.out.println("Square::draw()");
    }
}

class ShapeMaker{
    private final  Shape circle;
    private final Shape square;

    ShapeMaker(){
       this.circle =  new Circle();
       this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

public class Shapes {
    public static void main(String[] args) {
        ShapeMaker shapeMaker =  new ShapeMaker();

        shapeMaker.drawCircle();
    }
}
