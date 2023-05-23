package exercise.inheritance;

public class Cylinder extends Circle{
    private double height = 3.0;
    public Cylinder(){
    }
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getArea(){
        return super.getArea()*2 + super.getPerimeter()*height;
    }
    public double getVolume(){
        return super.getArea()*height;
    }
    @Override
    public String toString(){
        return "A Cylinder has height = "
                + getHeight()
                + ", Area = "
                + getArea()
                + ", Volume = "
                + getVolume()
                + ", radius = "
                + getRadius()
                +", Area cỉcle = "
                + super.getArea();
    }
}
