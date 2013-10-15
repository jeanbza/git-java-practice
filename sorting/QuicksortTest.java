import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class QuicksortTest {

  private int[] numbers;
  private final static int SIZE = 7;
  private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    @Test
    public void testQuicksort() {
        Quicksort sorter = new Quicksort();
        assertTrue(numbersInOrder(sorter.sort(numbers)));
    }

    public boolean numbersInOrder(int[] numbers) {
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return false;
            }
        }

        return true;
    }
}