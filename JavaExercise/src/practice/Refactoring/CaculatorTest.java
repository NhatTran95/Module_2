package practice.Refactoring;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaculatorTest {
    @Test
    @DisplayName("Testing addtion")
    void testCaculateAdd(){
        int a = 1;
        int b = 2;
        char o = '+';
        int expected = 3;
        int result = Caculator.calculate(a, b, o);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing subtraction")
    void testCaculateSub(){
        int a = 5;
        int b = 2;
        char o = '-';
        int expected = 3;
        int result = Caculator.calculate(a, b, o);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing multipication")
    void testCaculateMul(){
        int a = 5;
        int b = 2;
        char o = '*';
        int expected =10;
        int result = Caculator.calculate(a, b, o);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing division")
    void testCaculateDiv(){
        int a = 4;
        int b = 2;
        char o = '/';
        int expected = 2;
        int result = Caculator.calculate(a, b, o);
        assertEquals(expected, result);
    }

}
