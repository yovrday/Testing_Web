package com.juaracoding.Test_Web.palindrom;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//Ahmad Chaidar SQA Batch 7
public class PalidromTest {
	String str ;
    private boolean actual;
	@Given("memasukan kata berupa {string}")
	public void memasukan_kata_berupa(String string) {
		str = string;	
	}
	@When("cek palidrom")
	public void cek_palidrom() {
	       String tampungPalindrom = "";
	       for (int i=str.length(); i > 0; i--) {
	    	   String tampung = str.substring(i-1, i);
	    	   tampungPalindrom += tampung;
	       }
	       if (str.equals(tampungPalindrom)) {
	    	   actual = true ;
	       } else {
	    	   actual = false ;
	       }
	}
	@Then("hasil harus {string}")
	public void hasil_harus(String string) {
		boolean expect = Boolean.parseBoolean(string);
		   assertEquals(actual, expect);
	}
}
