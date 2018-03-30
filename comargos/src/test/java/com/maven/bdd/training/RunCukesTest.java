package com.maven.bdd.training;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources_feature/FilterPrice.feature"
        ,glue={"Stepdefs"}
)

public class RunCukesTest {

}
