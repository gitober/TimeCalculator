import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeCalculatorTest {

    @Test
    public void testCalculateTimeNormalCase() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals("Time calculation should be accurate", 2.0, calculator.calculateTime(100.0, 50.0), 0.0001);
    }

    @Test
    public void testCalculateTimeZeroSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows("Zero speed should throw IllegalArgumentException", IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, 0);
        });
    }

    @Test
    public void testCalculateTimeNegativeSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows("Negative speed should throw IllegalArgumentException", IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, -10);
        });
    }

    @Test
    public void testKelvinToFah() {
        assertEquals("300.1 Kelvin should convert to approximately 81.0 Fahrenheit", 81.0, TimeCalculator.kelvinToFah(300.1), 0.1);
    }
}
