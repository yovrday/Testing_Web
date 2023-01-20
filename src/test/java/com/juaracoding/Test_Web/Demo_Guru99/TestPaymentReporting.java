package com.juaracoding.Test_Web.Demo_Guru99;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestPaymentReporting {
	private WebDriver driver ;
	private String baseURL = "https://demo.guru99.com/payment-gateway/index.php";
	private JavascriptExecutor js;
	private WebDriverWait wait;

    ExtentHtmlReporter htmlReporter;
    ExtentTest test;
    ExtentReports extent;
    
    @BeforeTest
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReportPG.html");
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report Payment Gateway");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }
    
	@BeforeSuite
	public void UjianMinggu3 () throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
		"C:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		js = (JavascriptExecutor) driver;
		driver.get(baseURL);
		driver.manage().window().maximize();
	}	
	
	@Test
	public void BuyNow () throws InterruptedException {
		
		js.executeScript("window.scrollBy(0,20000)");
		WebElement quantity1 = driver.findElement(By.xpath("//select[@name='quantity']"));
		Select quantity2 = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		WebElement buybutton = driver.findElement(By.xpath("//input[@value='Buy Now']"));
		
		quantity1.click();
		Thread.sleep(1000);
		test = extent.createTest("Input Quantity", "PASSED");
		quantity2.selectByValue("3");
		Thread.sleep(1000);
		test = extent.createTest("Click Buy", "PASSED");
		buybutton.click();
		test = extent.createTest("Test Case Buy Now ", "PASSED");
	}
	
	@Test
	public void CheckOut () throws InterruptedException {
		//input[@id='card_nmuber']
		WebElement cardnum = driver.findElement(By.xpath("//input[@id='card_nmuber']"));
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		WebElement cvv = driver.findElement(By.xpath("//input[@id='cvv_code']"));
		WebElement buybutton = driver.findElement(By.xpath("//input[@name='submit']"));
		
		test = extent.createTest("Input Card Number", "PASSED");
		cardnum.sendKeys("4934468677218077");
		Thread.sleep(1000);
		test = extent.createTest("Input Month", "PASSED");
		month.selectByValue("5");
		Thread.sleep(1000);
		test = extent.createTest("Input Year", "PASSED");
		year.selectByValue("2026");
		Thread.sleep(1000);
		test = extent.createTest("Input CVV", "PASSED");
		cvv.sendKeys("800");
		Thread.sleep(1000);
		test = extent.createTest("Click CheckOut", "PASSED");
		buybutton.click();
		test = extent.createTest("Test Case Check Out", "PASSED");
	}
	@Test
	public void GetorderID () throws InterruptedException {
		
		js.executeScript("window.scrollBy(0,20000)");
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.cssSelector("div[class='table-wrapper'] h2"));
		String expected = "Payment successfull!";
		assertEquals(alert.getText(), expected); 
		test = extent.createTest("Test Payment Successfull", "PASSED");
		driver.close();
		test = extent.createTest("Test Case Payment", "PASSED");
	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS,MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
    }
 
    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }
}