package exercise.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextDayText {
    @Test
    void testNextDate10_10_2018(){
        String date = "10-10-2018";
        String expected = "11-10-2018";
        String nextDate = NextDay.nextDate(date);
        assertEquals(expected, nextDate);
    }
    @Test
    void testNextDate20_05_2023(){
        String date = "20-05-2023";
        String expected = "21-05-2023";
        String nextDate = NextDay.nextDate(date);
        assertEquals(expected, nextDate);
    }
    @Test
    void testNextDate28_02_2020(){
        String date = "28-02-2020";
        String expected = "29-02-2020";
        String nextDate = NextDay.nextDate(date);
        assertEquals(expected, nextDate);
    }
}
