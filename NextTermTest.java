import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NextTermTest
{

    private String input, expected;

    public NextTermTest(String input, String expected)
    {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection test_cases()
    {
        return Arrays.asList(new Object[][] {
            {"", ""},
            {"1", "11"},
            {"11", "21"},
            {"222333", "3233"}
        });
    }

    @Test
    public void test_next_term()
    {
        String result = CountSay.getNextTerm(input);
        assertEquals(expected, result);
    }

}