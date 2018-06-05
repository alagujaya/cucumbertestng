package com.rightmoveplc.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(monochrome = true, 
format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
features = "src/test/resources/features")

public class RunAllTest extends AbstractTestNGCucumberTests {

}
