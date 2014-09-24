package test_utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import test_base.TestBase;

public class Helper extends TestBase {
	public static Helper h;
	
	
	//Selecting Browser Type and Opening browser
	public void browserType() {
		
	//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		//driver = new ChromeDriver();
			
	 if(config.getProperty("browserType").equalsIgnoreCase("Firefox")) {
			  driver= new FirefoxDriver();
		  }
		  else if(config.getProperty("browserType").equalsIgnoreCase("Chrome")) {
			  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }
		  else {
			  if(config.getProperty("browserType").equalsIgnoreCase("IE"))
			  System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			  driver=new InternetExplorerDriver();
		  }	 
	}
	
	
	//Login Page
	
	public void login(){
		
		driver.findElement(By.linkText(Or.getProperty("Signin_LinkTest"))).click();
		driver.findElement(By.id(Or.getProperty("Username_Id"))).sendKeys("ksanthoshreddys@gmail.com");
		driver.findElement(By.id(Or.getProperty("Password_Id"))).sendKeys("kalpanareddy405");
		
		WebElement Checkboxx = driver.findElement(By.id(Or.getProperty("Checkbox_Id")));
		
		//If checkbox is not selected by default .
		if(!Checkboxx.isSelected()){
			Checkboxx.click();
		}else
			Checkboxx.click();
		
		driver.findElement(By.id(Or.getProperty("Submit_Id"))).submit();
		System.out.println("=================================> Login Succesfull <======================================");
		
		
	}
	
	
	//Opening the required URL
	public void loadPage() {
		driver.get(config.getProperty("testUrl"));
		driver.manage().window().maximize();
		
	}
	
	
	//Quitting the browser
	public void closingBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	//Wait Method
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			
		}
	}
		
	
}
