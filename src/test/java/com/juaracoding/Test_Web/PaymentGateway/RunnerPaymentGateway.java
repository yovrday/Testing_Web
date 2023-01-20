package com.juaracoding.Test_Web.PaymentGateway;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Ahmad Chaidar SQA Batch 7
@CucumberOptions (
		features = "src/test/java/com/juaracoding/day20/PaymentGateway",
		glue=""
	)

public class RunnerPaymentGateway extends AbstractTestNGCucumberTests {

}
