package AllTests;


import test_utils.Helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ItemMatching extends Helper {
	
	public static Helper h=new Helper();
	
		
			
	@Test
  public void ItemsMatching() {
		
	//Login Into Ebay Site
		h.login();
		

	//Searching In  the name Of Iphone 5s
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
		h.sleep(10);
		
		
		
	//Storing the Listed items into a Array list
		if(driver.findElements(By.id(Or.getProperty("mainContainer_Id"))).size()>0){
			System.out.println("Ebay search main container is Identified");
		}else{
			System.out.println("Ebay search main container Cann't be Identified");
		}
		
		List<WebElement> container1 = driver.findElement(By.id(Or.getProperty("mainContainer_Id"))).findElements(By.cssSelector(Or.getProperty("SubContainers_Cssselector")));
		System.out.println("Number Of Elemets displayed in Search list : " + container1.size());
		
		
		
	//Taking the value of elements displayed in The search list	
		if(driver.findElements(By.cssSelector(Or.getProperty("NumberOfelements_CssSelector"))).size()>0){
			System.out.println("Ebay search elements number box is Identified");
		}else{
			System.out.println("Ebay search elements number box Cann't be Identified");
		}
		
		int w =Integer.parseInt(driver.findElement(By.cssSelector(Or.getProperty("NumberOfelements_CssSelector"))).getText());
		System.out.println("The Number of elements are to be shown in the Search Are : "+w);
		
		
		
		
	//Matching The items listed and value dispalyed 
		for(int i=0; i<1;i++){
		if((container1.size())==w){
			
		System.out.println("Elements Displayed in the search List Matches the Number of Elements Displayed");
		}else{
			System.out.println("Elements Displayed in the search List Not Matches the Number of Elements Displayed");
	              }
	
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
