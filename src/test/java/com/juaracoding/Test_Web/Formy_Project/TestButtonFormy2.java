package com.juaracoding.Test_Web.Formy_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestButtonFormy2 {
	
	@Test
	public void FormyTest () throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver",
		"C:\\webdrivers\\chromedriver.exe");
		String baseURL = "https://formy-project.herokuapp.com/buttons";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);

		List <WebElement> button = (List<WebElement>) driver.findElement(By.cssSelector(""));
		for (int i = 0; i<button.size();i++){
		System.out.println(button.get(i).getText());
		}
		
		driver.quit();
		
	}
}
