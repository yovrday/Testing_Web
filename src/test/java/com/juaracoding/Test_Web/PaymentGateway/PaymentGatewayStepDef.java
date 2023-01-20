package com.juaracoding.Test_Web.PaymentGateway;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//Ahmad Chaidar SQA Batch 7
public class PaymentGatewayStepDef {
	private WebDriver driver ;
	private String baseURL = "https://demo.guru99.com/payment-gateway/index.php";
	private WebDriverWait wait;
	
	@Given("berada di halaman produk")
	public void berada_di_halaman_produk() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				wait = new WebDriverWait(driver, Duration.ofSeconds(40));
				driver.get(baseURL);
				driver.manage().window().maximize();
			}	

	@When("pilih quantity tertentu")
	public void pilih_quantity_tertentu() {
		Select quantity2 = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		quantity2.selectByValue("3");
	}

	@When("menekan tombol buy now")
	public void menekan_tombol_buy_now() {
		WebElement buybutton = driver.findElement(By.xpath("//input[@value='Buy Now']"));
		buybutton.click();
	}

	@When("berada di halaman payment process")
	public void berada_di_halaman_payment_process() {
		try {
	    	Thread.sleep(1000);
	    } catch (InterruptedException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	}

	@When("isi card number {string}")
	public void isi_card_number(String string) {
		WebElement cardnum = driver.findElement(By.xpath("//input[@id='card_nmuber']"));
		cardnum.sendKeys(string);
	}

	@When("pilih expiration month")
	public void pilih_expiration_month() {
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByValue("5");
	}

	@When("pilih expiration year")
	public void pilih_expiration_year() {
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByValue("2026");
	}

	@When("isi CVV code {string}")
	public void isi_CVV_code(String string) {
		WebElement cvv = driver.findElement(By.xpath("//input[@id='cvv_code']"));
		cvv.sendKeys(string);
	}

	@When("menekan tombol pay")
	public void menekan_tombol_pay() {
		WebElement buybutton = driver.findElement(By.xpath("//input[@name='submit']"));
		buybutton.click();   
	}

	@Then("dapat order id")
	public void dapat_order_id() {
		WebElement alert = driver.findElement(By.cssSelector("div[class='table-wrapper'] h2"));
		String expected = "Payment successfull!";
		assertEquals(alert.getText(), expected); 
	}
}
