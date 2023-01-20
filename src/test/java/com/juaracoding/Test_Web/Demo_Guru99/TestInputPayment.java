package com.juaracoding.Test_Web.Demo_Guru99;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestInputPayment {
	private WebDriver driver ;
	private String baseURL = "https://demo.guru99.com/payment-gateway/index.php";
	private JavascriptExecutor js;
	private WebDriverWait wait;
	
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
	public void CheckOut () throws InterruptedException {
		js.executeScript("window.scrollBy(0,20000)");
		WebElement quantity1 = driver.findElement(By.xpath("//select[@name='quantity']"));
		Select quantity2 = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		WebElement buybutton = driver.findElement(By.xpath("//input[@value='Buy Now']"));
		
		quantity1.click();
		Thread.sleep(1000);
		quantity2.selectByValue("3");
		Thread.sleep(1000);
		buybutton.click();
	}
	
	@Test
	public void CheckOut2 () throws InterruptedException {
		//input[@id='card_nmuber']
		WebElement cardnum = driver.findElement(By.xpath("//input[@id='card_nmuber']"));
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		WebElement cvv = driver.findElement(By.xpath("//input[@id='cvv_code']"));
		WebElement buybutton = driver.findElement(By.xpath("//input[@name='submit']"));
		
		cardnum.sendKeys("4934468677218077");
		Thread.sleep(1000);
		month.selectByValue("5");
		Thread.sleep(1000);
		year.selectByValue("2026");
		Thread.sleep(1000);
		cvv.sendKeys("800");
		Thread.sleep(1000);
		buybutton.click();
		
		js.executeScript("window.scrollBy(0,20000)");
		Thread.sleep(2000);
		WebElement alert = driver.findElement(By.cssSelector("div[class='table-wrapper'] h2"));
		String expected = "Payment successfull!";
		AssertJUnit.assertEquals(alert.getText(), expected); 
		driver.close();
	}
}