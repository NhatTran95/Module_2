package moveablePoint;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(2.3f, 4.5f);
        System.out.println(point);
        point.setXY(2f, 3f);
        System.out.println(point);
    }
}
