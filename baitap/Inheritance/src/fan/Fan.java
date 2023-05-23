package fan;

public class Fan {
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public Fan(){}
    @Override
    public String toString(){
        if(this.on == true) {
            return String.format("Fan hace speed: %s, color: %s, radius: %s fan is on", this.speed, this.color, this.radius);
        }
        else return String.format("Fan hace speed: %s, color: %s, radius: %s fan is off", this.speed, this.color, this.radius);
    }
}
