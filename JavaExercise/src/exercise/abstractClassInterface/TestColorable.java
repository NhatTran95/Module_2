package exercise.abstractClassInterface;
public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(4, 2);
        shapes[2] = new Square(5);
        for(Shape shape: shapes) {
            if(shape instanceof Circle){
                System.out.println("Area circle: "+ Math.ceil(((Circle)shape).getArea()*100)/100);
            }
            else if(shape instanceof Rectangle){
                if(((Rectangle) shape).getWidth() != ((Rectangle) shape).getLength()){
                    System.out.println("Area rectangel: "+ ((Rectangle)shape).getArea());
                }
                else {
                    System.out.println("Area square: "+ ((Square)shape).getArea());
                    ((Square) shape).howToColor();
                }

            }
        }
    }
}
