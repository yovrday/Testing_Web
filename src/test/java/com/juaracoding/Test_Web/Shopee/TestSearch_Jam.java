package com.juaracoding.Test_Web.Shopee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSearch_Jam {

	@Test
	public void Shopee (){
	
			System.setProperty("webdriver.chrome.driver",
			"C:\\webdrivers\\chromedriver.exe");
			String baseURL = "https://shopee.co.id/welcome-package";
			WebDriver driver = new ChromeDriver();
			driver.get(baseURL);
			
			WebElement inputSearch = driver.findElement(By.xpath("//input[@placeholder='Daftar & Dapat Voucher Gratis']"));
			WebElement bSearch = driver.findElement(By.xpath("//button[@type='button']//*[name()='svg']"));
			
			inputSearch.sendKeys("jam");
			bSearch.click();
			}
}
