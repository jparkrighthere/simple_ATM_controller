import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.internal.TextListener;

public class TestRunner {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        
        Result result = junit.run(ATMTest.class);
        
        // Print overall result
        System.out.println("TEST RUN COMPLETED.");
        System.out.println("TOTAL TESTS RUN: " + result.getRunCount());
        System.out.println("TOTAL SUCCESSES " + (result.getRunCount() - result.getFailureCount()));
        System.out.println("TOTAL FAILURES: " + result.getFailureCount());
        
        for (Failure failure : result.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }
        
        System.out.println();
        System.out.println("OVERALL SUCCESS: " + result.wasSuccessful());
    }
}