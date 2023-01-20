package com.juaracoding.Test_Web.Demo_Guru99;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void Login (){
	
			System.setProperty("webdriver.chrome.driver",
			"C:\\webdrivers\\chromedriver.exe");
			String baseURL = "https://demo.guru99.com/V1/index.php";
			WebDriver driver = new ChromeDriver();
			driver.get(baseURL);
			
			WebElement inputUserID = driver.findElement(By.name("uid"));
			WebElement inputPass = driver.findElement(By.name("password"));
			WebElement KlikLogin = driver.findElement(By.name("btnLogin"));
			
			inputUserID.sendKeys("mngr456673");
			inputPass.sendKeys("Arasuny");
			KlikLogin.click();
			}
	@Test
	public void Login2(){
	
			System.setProperty("webdriver.chrome.driver",
			"C:\\webdrivers\\chromedriver.exe");
			String baseURL = "https://demo.guru99.com/V1/index.php";
			WebDriver driver = new ChromeDriver();
			driver.get(baseURL);
			
			WebElement inputUserID = driver.findElement(By.name("uid"));
			WebElement inputPass = driver.findElement(By.name("password"));
			WebElement KlikLogin = driver.findElement(By.name("btnLogin"));
			
			inputUserID.sendKeys("oncom12345");
			inputPass.sendKeys("Kucing");
			KlikLogin.click();
			}
}
