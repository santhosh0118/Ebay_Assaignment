package AllTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import test_utils.Helper;

public class Watchings extends Helper {
  
	public static Helper h=new Helper();
	
  @Test
  public void f() {
	  
	
	//Login
	//  h.sleep(2);	
	 // h.login();
	  	
	  	
	  	
	//Entering the text into textbox
	  	if(driver.findElements(By.id(Or.getProperty("SearchBox_Id"))).size()>0){
			System.out.println("Ebay search textbox is Identified");
			
		}else{
			System.out.println("Ebay search box Cann't be Identified");
		}
		
		driver.findElement(By.id(Or.getProperty("SearchBox_Id"))).sendKeys("iphone 5s");
		
		
		
	//Clicking on search Button
		if(driver.findElements(By.id(Or.getProperty("SearchButton_Id"))).size()>0){
			System.out.println("Ebay search button is Identified");
		}else{
			System.out.println("Ebay search button Cann't be Identified");
		}
		
		driver.findElement(By.id(Or.getProperty("SearchButton_Id"))).click();
		
	 
		
		
	//Storing the search elements into first list.
		
		h.sleep(20);
		if(driver.findElements(By.id(Or.getProperty("mainContainer_Id"))).size()>0){
			System.out.println("Ebay search container is Identified");
		}else{
			System.out.println("Ebay search container Cann't be Identified");
		}
		
		if(driver.findElements(By.cssSelector(Or.getProperty("SubContainers_Cssselector"))).size()>0){
			System.out.println("Ebay elements in search container is Identified");
		}else{
			System.out.println("Ebay Elements in search container Cann't be Identified");
		}
		
		List<WebElement> Main = driver.findElement(By.id(Or.getProperty("mainContainer_Id"))).findElements(By.cssSelector(Or.getProperty("SubContainers_Cssselector")));
		System.out.println("Number Of Elemets displayed in Search list : " + Main.size());
		System.out.println("                                                             ");
	
		
		
		
	//Printing the title names and how many r watching the product.
		h.sleep(3);
		if(driver.findElements(By.cssSelector(Or.getProperty("Title_Cssselector"))).size()>0){
			System.out.println("Ebay search items titles are  Identified");
		}else{
			System.out.println("Ebay search items titles Cann't be Identified");
		}
		
		for(int i=0;i<Main.size();i++){
			System.out.println(Main.get(i).findElement(By.cssSelector(Or.getProperty("Title_Cssselector"))).getText());
			
			if(Main.get(i).findElement(By.cssSelector(Or.getProperty("Watching_Cssselector"))).getText().contains("watching")){
				System.out.println(Main.get(i).findElement(By.cssSelector(Or.getProperty("Watching_Cssselector"))).getText());
				
			}else{
				System.out.println("Watching is not found");
			}
			System.out.println("===================================================================================================");
		}
	}

 
  
  @BeforeMethod
  public void beforeMethod() {
	  //Opening the browser
	  h.browserType();
	  
	  //Opening the websites
	  h.loadPage();
  }

  @AfterMethod
  public void afterMethod() {
	//Closing the browser
	  h.closingBrowser();
  }

}
