package point2D3D;

import java.util.Arrays;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D();
        System.out.println(p3);
        float[] p4 = p3.getXYZ(2.5f, 3f, 4.5f);
        System.out.println(Arrays.toString(p4));
        Point3D p5 = new Point3D(1f, 2f, 3f);
        System.out.println(p5);
        System.out.println(Arrays.toString(p5.getXYZ(2f, 2f, 2f)));
        Point2D p6 = new Point3D();
        float[] p7 = ((Point3D)p6).getXYZ(3f, 3f, 3f);
        System.out.println(p6);
        System.out.println(Arrays.toString(p7));
    }
}
