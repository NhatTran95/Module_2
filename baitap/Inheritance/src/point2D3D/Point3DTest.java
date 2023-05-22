package point2D3D;

import java.util.Arrays;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D();
        System.out.println(p3);
        p3.setXYZ(2f, 3.3f, 5.2f);
        System.out.println(p3);
        Point3D p5 = new Point3D(1.1f, 2.2f, 3.3f);
        System.out.println(p5);
        Point2D p6 = new Point3D();
        ((Point3D)p6).setXYZ(1f, 2f, 3f);
        System.out.println(p6);
    }
}
