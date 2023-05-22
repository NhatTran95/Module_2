package moveablePoint;

import java.util.Arrays;

public class MoveablePoint extends Point{
    private float xSpeed;
    private float ySpeed;
    public MoveablePoint(){
    }
    public MoveablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        return new float[]{getxSpeed(), getySpeed()};
    }

    @Override
    public String toString() {
        return String.format("%s, speed = %s", Arrays.toString(getXY()), Arrays.toString(getSpeed()));
    }
    public void move(){
         this.setX(this.getX()+this.getxSpeed());
         this.setY((getY()+getySpeed()));
    }
}
