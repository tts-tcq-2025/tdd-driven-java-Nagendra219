import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import caluculator.StringCalculator;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator(new StringCalculatorConfig());
    }

    @Test
    void testEmpty() {
        CalculationResult r = calculator.add("");
        assertEquals(0, r.getSum());
        assertTrue(r.getNumbers().isEmpty());
    }

    @Test
    void testSingleNumber() {
        CalculationResult r = calculator.add("5");
        assertEquals(5, r.getSum());
        assertEquals(List.of(5), r.getNumbers());
    }

    @Test
    void testMultipleNumbers() {
        CalculationResult r = calculator.add("1,2,3");
        assertEquals(6, r.getSum());
        assertEquals(List.of(1,2,3), r.getNumbers());
    }

    @Test
    void testNewlineDelimiter() {
        CalculationResult r = calculator.add("1\n2,3");
        assertEquals(6, r.getSum());
        assertEquals(List.of(1,2,3), r.getNumbers());
    }

    @Test
    void testCustomDelimiter() {
        CalculationResult r = calculator.add("//;\n1;2;3");
        assertEquals(6, r.getSum());
        assertEquals(List.of(1,2,3), r.getNumbers());
    }

    @Test
    void testMultiCharDelimiter() {
        CalculationResult r = calculator.add("//[***]\n1***2***3");
        assertEquals(6, r.getSum());
        assertEquals(List.of(1,2,3), r.getNumbers());
    }

    @Test
    void testNumbersAbove1000Ignored() {
        CalculationResult r = calculator.add("2,1001,3");
        assertEquals(5, r.getSum());
        assertEquals(List.of(2,3), r.getNumbers());
    }

    @Test
    void testNegativeNumbers() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3"));
        assertEquals("Negatives not allowed: [-2]", e.getMessage());
    }

    @Test
    void testMultipleCustomDelimiters() {
        CalculationResult r = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6, r.getSum());
        assertEquals(List.of(1,2,3), r.getNumbers());
    }
}
