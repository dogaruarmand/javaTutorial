package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import testingCode.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calc = new Calculator(); // this method is prefered if we can use the object as it is

    /**
     * This method is preferred if we need to instantiate/reset every time the object
    @BeforeEach // annotation for Unit -> method that run before any method

    void setUp() {
        calc = new Calculator();
    }
    */

    @Test
    public void canAddZeroPlusZero() {
        Calculator calc = new Calculator();
        int sum = calc.add(0, 0);
        assertEquals(0, sum, "Was expecting sum of 0");
    }

    @Test
    public void canAddOnePlusOne() {
        int sum = calc.add(1, 1);
        assertEquals(2, sum, "Was expecting sum of 2");
    }

    @Test()
    @Disabled
    //@Ignore
    public void canAddMaxIntPlusOne() {
        int sum = calc.add(Integer.MAX_VALUE, 1);
        System.out.println(sum); // 2147483647
        assertEquals(Integer.MAX_VALUE + 1L, sum, "Was expecting max integer");
    }

    @Test
    public void annuityExample() {
        String answer = calc.calcAnnuity("22000", 7, ".06", 1);
        assertEquals("$184,664.43", answer);
    }

    @Test
    public void annuityPractice() {
        String answer = calc.calcAnnuity("1200", 10, ".08", 4);
        assertEquals("$72,482.38", answer);
    }

}
