package practice.Refactoring;

public class Cylinder {
    /**public static double getVolume(int radius, int height){
        double baseArea = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI  * radius;
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }**/
    public static double getVolume(int radius, int height){
        double volume = getPerimeter(radius) * height + 2 * getPerimeter(radius);
        return volume;
    }
    public static double getArea(int radius){
        return Math.PI * radius * radius;
    }
    public static double getPerimeter(int radius){
        return 2 * Math.PI  * radius;
    }
}
