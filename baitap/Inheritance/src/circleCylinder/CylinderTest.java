package circleCylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Circle cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(2.5);
        System.out.println(cylinder);
        cylinder = new Cylinder(4.3, 2.2, "blue");
        System.out.println(cylinder);
    }
}
