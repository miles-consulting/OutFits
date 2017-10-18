package com.outfittery.assignment.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/cucumber.json", features = {
        "src/test/resources/features/UserInfo.feature"},
        glue = "com.outfittery.assignment.stepdefs")
public class RunCukesTest {

}