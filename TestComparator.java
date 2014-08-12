import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class ReverseNumerical implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class TestComparator {
    @Test
    public void reverseComp() {
        final List<Integer> numbers = Arrays.asList(4,7,1,6,3,5,4);
        final List<Integer> expected = Arrays.asList(7,6,5,4,4,3,1);

        Collections.sort(numbers, new ReverseNumerical());
        assertEquals(expected, numbers);
    }
}
