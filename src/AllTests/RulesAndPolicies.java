package AllTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import test_utils.Helper;

public class RulesAndPolicies extends Helper{
	//public static Helper h=new Helper();
	public static Helper h=new Helper();
	
	
	@Test
  public void RulesAndPoliciess(){
	  	
		//Login Into Ebay Site
		h.sleep(10);	
		h.login();
		
		
			
		//Clicking on Policies 
			
		h.sleep(10);
		if(driver.findElements(By.linkText(Or.getProperty("Policies_LinkText"))).size()>0){
				System.out.println("Ebay Policies link Text is Identified");
				
			}else{
				System.out.println("Ebay Policies link Text Cann't be Identified");
			}
			
			driver.findElement(By.linkText(Or.getProperty("Policies_LinkText"))).click();
		
			
			
		//Storing the links displayed into a list
			h.sleep(3);
			if(driver.findElements(By.name(Or.getProperty("MainContainer_Name"))).size()>0){
				System.out.println("Ebay Policies container is Identified");
				
			}else{
				System.out.println("Ebay Policies container Cann't be Identified");
			}
			
			if(driver.findElements(By.tagName(Or.getProperty("LinksInContainer_TagName"))).size()>0){
				System.out.println("Ebay elements in Policies container is Identified");
				
			}else{
				System.out.println("Ebay elements in Policies container Cann't be Identified");
			}
			
		List<WebElement> list1 = driver.findElement(By.name(Or.getProperty("MainContainer_Name"))).findElements(By.tagName(Or.getProperty("LinksInContainer_TagName")));
		System.out.println("Number of Links Found  : " + list1.size());
		
				
		
		//Creating a new Array List
		ArrayList<String> list2 = new ArrayList<String>();
		
		
		
		//Getting the hrefs of elements stored in first list & Adding the href's into second list  
		for(int i=0;i<list1.size();i++){
			list2.add(list1.get(i).getAttribute("href"));
			
			}
		
		
		
		//geting the links and printing their titles
		System.out.println("Titles OF all the Links");
		System.out.println("=================================================================================");
		for(int j=0;j<list2.size();j++){
		driver.get(list2.get(j));
		System.out.println(driver.getTitle());
		}

	}


  @BeforeMethod
  public void beforeMethod() {
	  
	//Opening The Browser
		h.browserType();
		
	//Loading the Ebay Website	
		h.loadPage();
		
  }

  @AfterMethod
  public void afterMethod() {
	//Closing the Browser 
		
	  h.closingBrowser();
		  
  }

}
