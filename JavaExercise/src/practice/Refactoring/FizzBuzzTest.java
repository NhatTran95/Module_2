package practice.Refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    void testFizz3(){
        int number = 3;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    void testFizz10(){
        int number = 10;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    void testFizz6(){
        int number = 6;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        assertEquals(expected, result);
    }
}
