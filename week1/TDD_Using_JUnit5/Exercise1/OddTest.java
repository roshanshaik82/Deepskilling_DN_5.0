import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class OddTest {
    @Test
    public void testEvenNumber() {
        EvenOdd eo = new EvenOdd();
        assertFalse(eo.isOdd(10));
    }
    @Test
    public void testOddNumber() {
        EvenOdd eo = new EvenOdd();
        assertTrue(eo.isOdd(7));
    }
}