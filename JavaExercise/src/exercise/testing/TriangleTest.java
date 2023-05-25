package exercise.testing;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void testTriangle214(){
        int a = 2;
        int b = 1;
        int c = 4;
        String expected = "không phải là tam giác";
        String result = Triangle.triangleStyle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void testTriangle335(){
        int a = 3;
        int b = 3;
        int c = 5;
        String expected = "tam giác cân";
        String result = Triangle.triangleStyle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void testTriangle222(){
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "tam giác đều";
        String result = Triangle.triangleStyle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void testTriangle354(){
        int a = 3;
        int b = 5;
        int c = 4;
        String expected = "tam giác vuông";
        String result = Triangle.triangleStyle(a, b, c);
        assertEquals(expected, result);
    }
    @Test
    void testTriangle356(){
        int a = 3;
        int b = 5;
        int c = 6;
        String expected = "tam giác thường";
        String result = Triangle.triangleStyle(a, b, c);
        assertEquals(expected, result);
    }
}
