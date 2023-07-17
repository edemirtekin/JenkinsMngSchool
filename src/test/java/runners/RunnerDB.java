package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //raporların daha okunaklı olması için
                "html:target/default-cucumber-reports07.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",

        },
        monochrome = true, //raporları consolda daha okunaklı olması için
        features = "src/test/resources",
        glue = {"stepdefinitions", "hooks"},
        tags = "@db",
        dryRun = false

)


public class RunnerDB {
}
