package point2D3D;

import org.omg.PortableInterceptor.ServerRequestInfo;

public class Point3D extends Point2D{
    private float z =0.0f;
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
    public float[] getXYZ(float x, float y, float z){
        float[] arr = new float[3];
        arr[0] = x;
        arr[1] = y;
        arr[2] = z;
        return arr;
    }
    public String toString(){
        return String.format("(%s, %s, %s)", this.getX(), this.getY(), this.z);
    }
}
