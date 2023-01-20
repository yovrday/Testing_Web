package com.juaracoding.Test_Web.Tokopedia;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class TestGetAllPriceHandphone {
	private String baseURL = "https://www.tokopedia.com";
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public void scrolling() {
		int limit = 180;
		int page = 1;
		while (page <= limit) {
			js.executeScript("window.scrollBy(0,"+ page + ")");
			page++;
		}
	}
	
	@BeforeSuite
	public void SuiteTokpedTest () throws InterruptedException{
	System.setProperty("webdriver.chrome.driver",
	"C:\\webdrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	js = (JavascriptExecutor) driver;
	driver.get(baseURL);
	driver.manage().window().maximize();
	}
	
	@Test
	public void TokpedTest () throws InterruptedException {
	
	WebElement search = driver.findElement(By.cssSelector("input[placeholder='Cari di Tokopedia']"));
	WebElement button = driver.findElement(By.cssSelector("[aria-label='Kirimkan']"));
	search.sendKeys("handphone");
	button.click();
	Thread.sleep(1000);	
	
	this.scrolling();
	int sum = 0;
	String path = "div[data-testid=\"spnSRPProdPrice\"]";
	List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(path)));
	for (WebElement elem : elements) {
		String a = elem.getText().replaceAll("\\D+", "");
		System.out.println(a);
		sum += Integer.parseInt(a);
	}
	System.out.println(sum);
	System.out.println(elements.size());
	assertTrue( sum > 0 );
	driver.quit();
}
}