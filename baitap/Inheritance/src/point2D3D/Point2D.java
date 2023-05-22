package point2D3D;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D(){

    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
//        float[] array = new float[2];
//        array[0] = x;
//        array[1] = y;
//        return array;
        return new float[]{x,y};
    }
    @Override
    public String toString(){
        return String.format("%s", Arrays.toString(getXY()));
    }

}
