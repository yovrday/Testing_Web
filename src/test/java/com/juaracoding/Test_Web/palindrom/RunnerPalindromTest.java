package com.juaracoding.Test_Web.palindrom;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Ahmad Chaidar SQA Batch 7
@CucumberOptions (
		features = "src/test/java/com/juaracoding/day18/Palindrom",
		glue=""
	)
public class RunnerPalindromTest extends AbstractTestNGCucumberTests {

}
