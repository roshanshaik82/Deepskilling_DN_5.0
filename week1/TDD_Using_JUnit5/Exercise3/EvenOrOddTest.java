import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvenOrOddTest {

    private EvenOrOdd evenOdd;

    @BeforeEach
    void setUp() {
        evenOdd = new EvenOrOdd();
        System.out.println("Setup executed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Teardown executed");
    }

    @Test
    void testOddNumber() {

        // Arrange
        int number = 5;

        // Act
        boolean res= evenOdd.isEven(number);

        // Assert
        assertFalse(res);
    }

    @Test
    void testEvenNumber() {

        // Arrange
        int number = 4;

        // Act
        boolean res=evenOdd.isEven(number);

        // Assert
        assertTrue(res);
    }
}