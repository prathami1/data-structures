import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class GivenTuneTests {
    @Test
    public void exampleTests() {
        assertEquals(true, Kata.isTune(new int[]{1, 3, 6, 8, 10, 12}));
        assertEquals(true, Kata.isTune(new int[]{1, 3, 6, 8, 10, 12, 13, 15}));
        assertEquals(true, Kata.isTune(new int[]{1, 6, 3}));
        assertEquals(false, Kata.isTune(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
        assertEquals(true, Kata.isTune(new int[]{2, 4, 7, 9, 11, 13}));
    }
}
