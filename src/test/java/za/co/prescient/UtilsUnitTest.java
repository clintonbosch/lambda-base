package za.co.prescient;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import uk.org.webcompere.systemstubs.rules.EnvironmentVariablesRule;

public class UtilsUnitTest {

    @Rule
    public EnvironmentVariablesRule environmentVariablesRule = new EnvironmentVariablesRule();

    @Before
    public void before() {
        environmentVariablesRule.set("envVariable1", TestConstants.PARAM_VARIABLE_1)
                .set("envVariable2", TestConstants.PARAM_VARIABLE_2);
    }

    @Test
    @Ignore
    public void testSomething() {
    }
}
