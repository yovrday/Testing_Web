package com.juaracoding.Test_Web.Formy_Project;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestButtonFormy1 {
	
	//@BeforeSuite
//	public void FormySuite () {
//	System.setProperty("webdriver.chrome.driver",
//			"C:\\webdrivers\\chromedriver.exe");
//			String baseURL = "https://formy-project.herokuapp.com/buttons";
//			WebDriver driver = new ChromeDriver();
//			driver.get(baseURL);
	//}
	
	@Test
	public void FormyTest () throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
		"C:\\webdrivers\\chromedriver.exe");
		String baseURL = "https://formy-project.herokuapp.com/buttons";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
		
		WebElement primary = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-primary']"));
		WebElement succes = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-success']"));
		WebElement info = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-info']"));
		WebElement warning = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-warning']"));
		WebElement danger = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-danger']"));
		WebElement link = driver.findElement(By.cssSelector("button[class='btn btn-lg btn-link']"));
		
		WebElement left = driver.findElement(By.cssSelector("div[aria-label='Basic example'] button:nth-child(1)"));
		WebElement middle = driver.findElement(By.cssSelector("div[aria-label='Basic example'] button:nth-child(2)"));
		WebElement right = driver.findElement(By.cssSelector("div[aria-label='Basic example'] button:nth-child(3)"));
		
		WebElement no1 = driver.findElement(By.cssSelector("div[aria-label='Button group with nested dropdown'] button:nth-child(1)"));
		WebElement no2 = driver.findElement(By.cssSelector("div[aria-label='Button group with nested dropdown'] button:nth-child(2)"));
		
		WebElement dropdown0 = driver.findElement(By.cssSelector("#btnGroupDrop1"));		
		WebElement dropdown1 = driver.findElement(By.cssSelector("form a:nth-child(1)"));
		WebElement dropdown2 = driver.findElement(By.cssSelector("form a:nth-child(2)"));
	
		Thread.sleep(100);	
		primary.click();
		String expectprimary = "Primary";
		assertEquals(primary.getText(), expectprimary);
		Thread.sleep(100);	
		succes.click();
		String expectsucces = "Success";
		assertEquals(succes.getText(), expectsucces);
		Thread.sleep(100);	
		info.click();
		String expectinfo = "Info";
		assertEquals(info.getText(), expectinfo);
		Thread.sleep(100);
		warning.click();
		String expectwarning = "Warning";
		assertEquals(warning.getText(), expectwarning);
		Thread.sleep(100);	
		danger.click();
		String expectdanger = "Danger";
		assertEquals(danger.getText(), expectdanger);
		Thread.sleep(100);	
		link.click();
		String expectlink = "Link";
		assertEquals(link.getText(), expectlink);
		Thread.sleep(100);	
		
		left.click();
		Thread.sleep(100);	
		middle.click();
		Thread.sleep(100);	
		right.click();
		Thread.sleep(100);	
		
		no1.click();
		Thread.sleep(100);	
		no2.click();
		Thread.sleep(100);
		
		dropdown0.click();
		Thread.sleep(100);	
		dropdown1.click();
		Thread.sleep(100);	
		dropdown0.click();
		Thread.sleep(100);	
		dropdown2.click();
		Thread.sleep(100);
		
		driver.quit();
}
	
}
