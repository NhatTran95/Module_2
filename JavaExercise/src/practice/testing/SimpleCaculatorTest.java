//package practice.testing;
//
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SimpleCaculatorTest {
//    @Test
//    @DisplayName("Testing add 0 + 0")
//    public void testAdd0And0() {
//        int first = 0;
//        int second = 0;
//        int expected = 0;
//
//        int result = SimpleCaculator.add(first, second);
//        assertEquals(expected, result);
//    }
//    @Test
//    @DisplayName("Testing add 1 + 1")
//    public void testAdd1And1() {
//        int first = 1;
//        int second = 1;
//        int expected = 2;
//
//        int result = SimpleCaculator.add(first, second);
//        assertEquals(expected, result);
//    }
//    @Test
//    @DisplayName("Testing add 2 - 1")
//    public void testSub2And1() {
//        int first = 2;
//        int second = 1;
//        int expected = 1;
//
//        int result = SimpleCaculator.sub(first, second);
//        assertEquals(expected, result);
//    }
//
//}
