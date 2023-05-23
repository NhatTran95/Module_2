package interfaceResizeable;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(3, 3);
        Square square = new Square(4);
        System.out.println(circle);
        circle.resize(50);
        System.out.println(circle);
        System.out.println(rectangle);
        rectangle.resize(100);
        System.out.println(rectangle);
        System.out.println(square);;;
        square.resize(25);
        System.out.println(square);
    }
}
