import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;

class TestRunner
{

    private static final int max = 10, min = 1;
    private static final HashMap<String, Integer> penalties = new HashMap<>();

    static
    {
        penalties.put("test_next_term", 2);
        penalties.put("test_nth_term", 2);
    }

    public static void main(String[] args)
    {
        Result next_term_result = JUnitCore.runClasses(NextTermTest.class);
        Result nth_term_result = JUnitCore.runClasses(NthTermTest.class);
        Result[] results = new Result[]{next_term_result, nth_term_result};

        int grade = max;

        for(Result result: results)
        {
            for (Failure failure : result.getFailures())
            {
                Description description = failure.getDescription();
                String class_name = description.getClassName();
                String method_name = description.getMethodName();
                String message = failure.getMessage();

                System.err.printf("failed test %s.%s\n\t%s\n", class_name, method_name, message);

                grade -= penalties.get(method_name.split("[\\[]")[0]);
            }
        }

        if(grade < min)
            grade = min;

        System.out.println(grade);
    }
}
