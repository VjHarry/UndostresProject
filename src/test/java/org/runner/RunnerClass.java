package org.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/Fea.feature",
				glue="org.test",
				dryRun=false,
				monochrome=true,
				plugin= {"pretty","html:src\\test\\resources\\Reports"})
public class RunnerClass {

}
