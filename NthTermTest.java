import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NthTermTest
{

    private Integer input;
    private String expected;

    public NthTermTest(Integer input, String expected)
    {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection test_cases()
    {
        return Arrays.asList(new Object[][] {
            {1, "1"},
            {2, "11"},
            {3, "21"},
            {4, "1211"},
            {5, "111221"},
            {6, "312211"},
            {7, "13112221"}
        });
    }

    @Test
    public void test_nth_term()
    {
        String result = CountSay.getNthTerm(input);
        assertEquals(expected, result);
    }

}