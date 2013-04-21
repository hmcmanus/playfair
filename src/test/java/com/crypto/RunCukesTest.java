package com.crypto;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This class is just an entry point for junit into getting to the tests
 */

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report",
        "json-pretty:target/cucumber-json-report.json"})
public class RunCukesTest {
}
