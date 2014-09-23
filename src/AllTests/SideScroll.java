package AllTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import test_utils.Helper;

public class SideScroll extends Helper{
 
	public static Helper h=new Helper();	

@Test
  public void Sideescroll() {
	
	//Login 
		h.login();
	
		
	//Clicking on the ebay logo to load the page completly.
		if(driver.findElements(By.id(Or.getProperty("EbayLogo_id"))).size()>0){
			System.out.println("Ebay logo Element Identified");
			
		}else{
			System.out.println("Ebay Element Cann't be Identify");
		}
		
		driver.findElement(By.id(Or.getProperty("EbayLogo_id"))).click();
		
		h.sleep(5);
		
		
		
	//Verifying Wether container found or not.
		if(driver.findElements(By.className(Or.getProperty("ScrollContainer_class"))).size()>0){
			System.out.println("Container Element Identified");
			
		}else{
			System.out.println("Container Element Cann't be Identify");
		}
		
		if(driver.findElements(By.className(Or.getProperty("Radiobuttons_TagName"))).size()>0){
			System.out.println("Elements in Container are Identified");
			
		}else{
			System.out.println("Elements in Container Cann't be Identify");
		}
		
		
		
		
	//Storing the container Elements into Arraylist
		List<WebElement> sidescroll = driver.findElement(By.className(Or.getProperty("ScrollContainer_class"))).findElements(By.className(Or.getProperty("Radiobuttons_TagName")));
		System.out.println("Number of items in container  : " + sidescroll.size());
		
		
		
	//Clicking the links and Printing their class.
		for(int i=0;i<sidescroll.size();i++){
			
			//System.out.println("Class Name After Selecting The Item : " + sidescroll.get(i).getAttribute("aria-label"));
			//System.out.println("Class Name Before Selecting The Item : " + sidescroll.get(i).getAttribute("class"));
			sidescroll.get(i).click();
					
			if(sidescroll.get(i).getAttribute("class").equals("pg sel")){
				
				System.out.println(sidescroll.get(i).getAttribute("aria-label") +"  is Selected");
			}else{
				System.out.println("not selected");
			}
			
		}
		
		
		
	//Verifying the right click button
		System.out.println("                                                             ");
		System.out.println("Verifying links using Right Arrow ");
		System.out.println("======================================================================================");
		for (int j=0;j<sidescroll.size();j++){
			
			driver.findElement(By.cssSelector("button.arrow.right")).click();
			if(sidescroll.get(j).getAttribute("class").equals("pg sel")){
				
				System.out.println(sidescroll.get(j).getAttribute("aria-label") +"  is Selected");
			}else{
				System.out.println("not selected");
			}
			
		
		}
		
		
		
	//Verifying the left click button 
		System.out.println("                                                             ");
		System.out.println("Verifying links using left Arrow ");
		System.out.println("======================================================================================");	
		for (int k = sidescroll.size()-1;k>=0;k--){
			
			System.out.println(sidescroll.get(k).getAttribute("aria-label") +"  is Selected");
			driver.findElement(By.cssSelector("button.arrow.left")).click();
					
		} 
	  
  }

  @BeforeMethod
  public void beforeMethod() {
	 
	  //Opening the browser
	  	h.browserType();
	  	
	  //Loading the website
	  	h.loadPage();
		  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  //Closing the browser
	  h.closingBrowser();
	  
  }

}
