package point2D3D;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        p1.getXY();
        System.out.println(p1);
        p1.setXY(2f, 3.3f);
        System.out.println(Arrays.toString(p1.getXY()));
        Point2D p2 = new Point2D(3.5f, 4.6f);
        System.out.println(p2);
    }
}
