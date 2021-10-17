import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "@target/rerun.txt",
        glue = "stepDef",
        plugin = {
                "pretty",
                "html:target1/cucumber-reports",
                "json:target1/cucumber.json",
        }
)

public class TestRunnerRerun extends AbstractTestNGCucumberTests {
}
