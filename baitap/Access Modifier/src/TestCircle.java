public class TestCircle {
    private double radius = 1.0;
    private String color = "red";
    public TestCircle(){

    }
    public TestCircle(double radius) {
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }

    public static void main(String[] args) {
        TestCircle Circle = new TestCircle();
        System.out.println(Circle.getRadius());
        System.out.println(Circle.getArea());
        System.out.println(Circle.color);
    }
}
