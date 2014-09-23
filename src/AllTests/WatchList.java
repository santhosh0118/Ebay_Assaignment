package AllTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import test_utils.Helper;

public class WatchList extends Helper {
	
	public static Helper h=new Helper();
	
  
@Test
  public void f() {
	  
	//Login 
		h.login();
	
		
	//clicking on My-Ebay
		h.sleep(10);
		
		if(driver.findElements(By.id(Or.getProperty("MyEbay_Id"))).size()>0){
			System.out.println("My-Ebay item is Identified");
		}else{
			System.out.println("My-Ebay item Cann't be Identified");
		}
		
		driver.findElement(By.id(Or.getProperty("MyEbay_Id"))).click();
		
		
		
			
	//Listing the items watched till now and storing into first list.
		
		h.sleep(20);
		
		if(driver.findElements(By.id("IDD240")).size()>0){
			System.out.println("Watched list Container Element Identified");
			
		}else{
			System.out.println("Watched list Container Element cann't Identified");
		}
		
		if(driver.findElements(By.className("my_itl-itR")).size()>0){
			System.out.println("Items in Watched list Container Identified");
			
		}else{
			System.out.println("Items in Watched list Container cann't Identified");
		}
		
		List<WebElement> list2 = driver.findElement(By.id("IDD240")).findElements(By.className("my_itl-itR"));
		System.out.println("Number of Elements Watched Yet  : " + list2.size());
		
		System.out.println("Titles Of the Items Watched");
		System.out.println("=====================================================================");
		
	//Printing the Titles of the items watched
		
		if(driver.findElements(By.className("g-asm002")).size()>0){
			System.out.println("Title sub-container is found in Watched items");
			
		}else{
			System.out.println("Title sub-container is not found in Watched items");
		}
		
		for(int i=0;i<list2.size();i++){
		System.out.println(list2.get(i).findElement(By.className("g-asm002")).getAttribute("title"));
		//list2.get(i).click();
		
	}
		
}
 
  @BeforeMethod
  public void beforeMethod() {
	 
	  //Choosing and opening the browser
	  h.browserType();
	  	
	  	
	  //Opening the Website
	  	h.loadPage();
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	 //Closing the browser
	 h.closingBrowser();
	  
  }

}
