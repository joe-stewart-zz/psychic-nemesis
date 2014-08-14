import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;
import java.util.Collection;

class Calculator {
    public double add(double p1, double p2) {
        return p1 + p2;
    }
}

@RunWith(value=Parameterized.class)
public class TestParameters {
    private double expected;
    private double p1, p2;

    @Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][] {
            {2,1,1},{3,2,1},{4,3,1}});
    }

    public TestParameters(double expected, double p1, double p2) {
        this.expected = expected;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Test
    public void testParameterized() {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(p1, p2), 0);
    }
}
