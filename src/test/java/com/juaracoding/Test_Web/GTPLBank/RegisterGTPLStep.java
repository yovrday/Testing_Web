package com.juaracoding.Test_Web.GTPLBank;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//Ahmad Chaidar SQA Batch 7
public class RegisterGTPLStep {
	private WebDriver driver ;
	private String baseURL = "https://demo.guru99.com";
	
	@Given("User sedang berada di halaman register")
	public void user_sedang_berada_di_halaman_register() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(baseURL);
				driver.manage().window().maximize();
			}	
	
	@When("User memasukan email {string}")
	public void user_memasukan_email(String string) {
		WebElement id = driver.findElement(By.xpath("//input[@name='emailid']"));
		id.sendKeys(string);
	}
	@When("User menekan tombol submit")
	public void user_menekan_tombol_submit() {
		WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		button.click();
	}
	
	@Then("User akan melihat kredensial yang diberikan")
	public void user_akan_melihat_kredensial_yang_diberikan() {
		WebElement alert = driver.findElement(By.xpath("//h2[normalize-space()='Access details to demo site.']"));
		String expected = "Access details to demo site.";
		assertEquals(alert.getText(), expected);
		driver.quit();
	}
	
	@Then("User akan melihat pesan validasi {string}")
	public void user_akan_melihat_pesan_validasi(String string) {
		WebElement alert = driver.findElement(By.xpath("//label[@id='message9']"));
		String expected = "Email ID is not valid";
		assertEquals(alert.getText(),expected); 
		driver.quit();
	}
}
