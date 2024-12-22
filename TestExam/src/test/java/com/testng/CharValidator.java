package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class CharValidator {
	
	//initialized the driver
	WebDriver driver = null;
	String valueToEnter = "4561234";
	
	@BeforeSuite
	  public void beforeSuite() {
		// Getting the chromedriver object
		driver = new ChromeDriver();
	  }
  @Test
  public void f() throws InterruptedException {
	  //open link
	  driver.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
	  driver.manage().window().maximize();
	  
	  //wait for 3 sec
	  Thread.sleep(3000);
	  
	  //enter no in input tag
	  WebElement inputobj = driver.findElement(By.xpath("/html/body/div/div[3]/form/p[1]/input[1]"));
	  inputobj.clear();
	  inputobj.sendKeys(valueToEnter);
	  
	  Thread.sleep(1000);
	  
	  //click the button to submit
	  WebElement buttonobj = driver.findElement(By.xpath("/html/body/div/div[3]/form/p[2]/input"));
	  buttonobj.click();
	  
	  //getvalue of input tag
	  WebElement resultobj = driver.findElement(By.xpath("/html/body/div/div[3]/form/p[1]/input[2]"));
	  String result = resultobj.getAttribute("value");
	  System.out.println("Result: "+result);
	  
	  
	  //compair your result here
	  if(result.equals("Valid Value")) {
		  System.out.println("Your number is valid 7 character");
	  }else {
		  System.out.println("no is invalid");
	  }
	  
	  Thread.sleep(2000);
  }
  

  @AfterSuite
  public void afterSuite() {
	  driver.close();
  }

}
