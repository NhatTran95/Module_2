package moveablePoint;

public class TestMoveablePoint {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint.setSpeed(1f, 1f);
        moveablePoint.move();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(2f, 3f);
        moveablePoint.move();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1f, 1f, 2f, 2f);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }

}
