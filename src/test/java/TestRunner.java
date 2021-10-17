import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "src/test/java/features/signup",
        glue = "stepDef",
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
