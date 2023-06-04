package practice.exception.triangle;

public class Triangle {
    int a, b, c;
    public Triangle(int a, int b, int c) throws IllegalTriangleException{
        if(a<= 0 || b <= 0 || c <= 0){
            throw new IllegalTriangleException("Canh phai la so duong khong the am");
        }
        if (a+b < c || a+c < b || b+c < a){
            throw new IllegalTriangleException("Day khong phai la ba canh cua tam giac");
        }
        this.a = a;
        this.b = b;
        this. c =c;
    }
}
