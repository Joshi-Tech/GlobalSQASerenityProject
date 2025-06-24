package hook;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Hook extends UIInteractionSteps {

    @BeforeAll
    public static void setup() {
        // Initialize the browser session
        System.out.println("=== Starting the Test Suite ===");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser session after all scenarios
        System.out.println("=== Closing the Test Suite ===");
    }
}
