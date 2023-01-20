package com.juaracoding.Test_Web.Formy_Project;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestInputFormy {

	@Test
	public void Formy () throws InterruptedException{
	System.setProperty("webdriver.chrome.driver",
	"C:\\webdrivers\\chromedriver.exe");
	String baseURL = "https://formy-project.herokuapp.com/form";
	WebDriver driver = new ChromeDriver();
	driver.get(baseURL);
	
	WebElement FirstName = driver.findElement(By.cssSelector("#first-name"));
	WebElement LastName = driver.findElement(By.cssSelector("#last-name"));
	WebElement JobTitle = driver.findElement(By.cssSelector("#job-title"));
	WebElement HLErbutton = driver.findElement(By.cssSelector("#radio-button-2"));
	WebElement Sex = driver.findElement(By.cssSelector("#checkbox-1"));
	WebElement Date = driver.findElement(By.cssSelector("#datepicker"));
	WebElement button = driver.findElement(By.cssSelector("a[role='button']"));
	
	Select YoF = new Select(driver.findElement(By.cssSelector("#select-menu")));

	FirstName.sendKeys("Ahmad");
	Thread.sleep(500);	
	LastName.sendKeys("Chaidar");
	Thread.sleep(500);	
	JobTitle.sendKeys("Quality Assurance");
	Thread.sleep(500);	
	HLErbutton.click();
	Thread.sleep(500);	
	Sex.click();
	Thread.sleep(500);	
	YoF.selectByValue("2");
	Thread.sleep(500);	
	Date.sendKeys("10/19/1999");
	Thread.sleep(2000);
	button.click();
	
	WebElement alert = driver.findElement(By.cssSelector("div[role='alert']"));
	String expected = "The form was successfully submitted!";
	assertEquals(alert.getText(), expected); 
}
}