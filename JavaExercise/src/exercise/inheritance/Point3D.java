package exercise.inheritance;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;
    public Point3D(){

    }
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x, y);
        this.z = z;
    }
    public float[] getXYZ(){
        float[] arr = new float[3];
        arr[0] = this.getX();
        arr[1] = this.getY();
        arr[2] = this.z;
        return arr;
        //return new float[] {this.getX(), this.getY(), this.z};
        // float[] arr = {this.getX(), this.getY(), this.z};
        // return arr;
    }
    public String toString(){
        return String.format("%s", Arrays.toString(getXYZ()));
    }
}
