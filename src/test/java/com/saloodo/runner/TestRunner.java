package com.saloodo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src/test/java/com/saloodo/feature",
				glue = {"com.saloodo.steps", "com.saloodo.factory"},
				tags = {"@smoke"},
				strict = true,
				plugin={"pretty","html:target/cucumber"})

public class TestRunner {
}