package Home_Page;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Geo_Portal_R.Geo_Portal;
import io.github.bonigarcia.wdm.WebDriverManager;
import Home_Page_R.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Listener.ExtentTestManager;
import Listener.Extra_Screen;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class HomePage {
	Homepage obj = new Homepage();
	Extra_Screen objss = new Extra_Screen();
	WebDriver driver;
	Geo_Portal obj3 = new Geo_Portal();
	String Classname = "Hoempage_extras";
  @Test(priority=1, description="To verify that user is able to get 'Home' page of 'NATMO' application.")
  public void NATMO_HOME_01() {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Check Url of Natmo Application ");
	  String actualURL=driver.getCurrentUrl();
	  String expectedURL=Homepage.URL;
	  Assert.assertEquals(actualURL, expectedURL);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Check Title of Natmo Application ");
	  String actualTitle=driver.getTitle();
	  String expectedTitle="National Atlas & Thematic Mapping Organisation";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  @Test(priority=2, description="To verify that user is able to perform 'Covid-19 Dashboard' link from home page.")
  public void NATMO_HOME_02() throws InterruptedException {
	  String Covid_19 = driver.findElement(By.xpath(Homepage.Covid_19)).getText();
	  Assert.assertEquals(Covid_19, "Covid-19 Dashboard");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Covid-19 Dashboard' link from top panel.");
	  driver.findElement(By.xpath(Homepage.Covid_19)).click();
	  Thread.sleep(5000);	  
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
     // Now iterate using Iterator
	 Iterator<String> I1= s.iterator();
     while(I1.hasNext()){
    	 String child_window=I1.next();
         if(!parent.equals(child_window)){
        	 driver.switchTo().window(child_window);
             String actualTitle = driver.switchTo().window(child_window).getTitle();
             String expectedTitle="COVID-19 Dashboard prepared by NATMO";
	         ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'COVID_19 IN INDIA' related information page.");
	         Assert.assertEquals(actualTitle, expectedTitle);
	         Thread.sleep(2000);
	         } 
         }
     }
  @Test(priority=03, description="To verify that user is able to perform 'Screen Reader Access' link from home page.")
  public void NATMO_HOME_03() throws InterruptedException {
	  String screen_reader = driver.findElement(By.xpath(Homepage.screen_reader)).getText();
	  Assert.assertEquals(screen_reader, "Screen Reader Access");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Screen Reader Access' link from top panel.");
	  driver.findElement(By.xpath(Homepage.screen_reader)).click();
	  Thread.sleep(5000);
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();
      // Now iterate using Iterator
	  Iterator<String> I1= s.iterator();
      while(I1.hasNext()){
    	  String child_window=I1.next();
          if(!parent.equals(child_window)){
        	  driver.switchTo().window(child_window);
              String actualTitle = driver.switchTo().window(child_window).getTitle(); 
	          String expectedTitle="Screen Reader Access | National Atlas & Thematic Mapping Organisation";
	          ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'Screen Reader Access' related information page.");
	          Assert.assertEquals(actualTitle, expectedTitle);
	          Thread.sleep(2000);
	          }
          }	  
      }
  
  @Test(priority=4, description="To verify that user is able to perform 'Increase Font Size' link from home page.")
  public void NATMO_HOME_04() throws InterruptedException {
	  String Font_normal = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_normal);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Increase Font Size' link from top panel.");
	  driver.findElement(By.xpath(Homepage.font_increase)).click();
	  Thread.sleep(2000);
	  String Font_increase = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_increase);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Font size should be increases on home page of the 'NATMO' application.");
	  Assert.assertNotEquals(Font_normal,Font_increase);
	  }
  @Test(priority=5, description="To verify that user is able to perform 'Reset Font Size' link from home page.")
  public void NATMO_HOME_05(Method method) throws InterruptedException {
	  String Font_normal = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_normal);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Increase Font Size' link from top panel.");
	  driver.findElement(By.xpath(Homepage.font_increase)).click();
	  Thread.sleep(2000);
	  String Font_increase = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_increase);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Font size should be increases on home page of the 'NATMO' application.");
	  Assert.assertNotEquals(Font_normal,Font_increase);
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Reset Font Size' link from top panel.");
	  driver.findElement(By.xpath(Homepage.font_normal)).click();
	  Thread.sleep(2000);
	  String Font_normal1 = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_normal1);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Font size should be reset on home page of the 'NATMO' application.");
	  Assert.assertNotEquals(Font_increase,Font_normal1);
	  }
  @Test(priority=6, description="To verify that user is able to perform 'Decrease Font Size' link from home page.")
  public void NATMO_HOME_06() throws InterruptedException {
	  String Font_normal = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_normal);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Decrease Font Size' link from top panel.");
	  driver.findElement(By.xpath(Homepage.font_decrease)).click();
	  Thread.sleep(2000);
	  String Font_decrease = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("font-size");
	  System.out.println("font size " + Font_decrease);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Font size should be decrease on home page of the 'NATMO' application.");
	  Assert.assertNotEquals(Font_normal,Font_decrease);
	  }
  @Test(priority=7, description="To verify that user is able to change font color in 'White' on home page of NATMO application.")
  public void NATMO_HOME_07(Method method) throws InterruptedException {
	  String white_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font white color " + white_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Green color' from top panel on home page.");
	  driver.findElement(By.xpath(Homepage.green)).click();
	  String green_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font green color " + green_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the font color in 'Green' color.");
	  Assert.assertNotEquals(green_color, white_color);
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'White color' from top panel on home page.");
	  driver.findElement(By.xpath(Homepage.white)).click();
	  String white_color1 = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font white color " + white_color1);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the font color in 'White' color.");
	  Assert.assertNotEquals(green_color, white_color1);
	  }
  @Test(priority=8, description="To verify that user is able to change font color in 'Green' on home page of NATMO application.")
  public void NATMO_HOME_08() throws InterruptedException {
	  String white_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font white color " + white_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Green color' from top panel on home page.");
	  driver.findElement(By.xpath(Homepage.green)).click();
	  String green_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font green color " + green_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on 'User should display the font color in 'Green' color.");
	  Assert.assertNotEquals(green_color, white_color);
	  }
  @Test(priority=9, description="To verify that user is able to change font color in 'Yellow' on home page of NATMO application.")
  public void NATMO_HOME_09() throws InterruptedException {
	  String white_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font white color " + white_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Yellow color' from top panel on home page.");
	  driver.findElement(By.xpath(Homepage.yellow)).click();
	  String yellow_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font yellow  color " + yellow_color);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on 'User should display the font color in 'Yellow' color.");
	  Assert.assertNotEquals(white_color, yellow_color);
	  }
  @Test(priority=10, description="To verify that user is able to change font color in 'Red' on home page of NATMO application.")
  public void NATMO_HOME_10() throws InterruptedException {
	  String white_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font white color " + white_color);
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Red color' from top panel on home page.");
	  driver.findElement(By.xpath(Homepage.red)).click();
	  String red_color = driver.findElement(By.xpath(Homepage.skip_main_content)).getCssValue("color");
	  System.out.println("font red color " + red_color);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Click on 'User should display the font color in 'Red' color.");
	  Assert.assertNotEquals(white_color,red_color);
	  }
  @Test(priority=11, description="To verify that user is able to change language (english to Hindi)/(Hindi to English) from home page of NATMO application.")
  public void NATMO_HOME_11(Method method) throws InterruptedException {
	  String english_text = driver.findElement(By.xpath(Homepage.skip_main_content)).getText();
	  System.out.println("language " + english_text);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Hindi' language from top panel.");
	  driver.findElement(By.xpath(Homepage.btn_Hindi)).click();
	  Thread.sleep(5000);
	  String hindi_text = driver.findElement(By.xpath(Homepage.btn_skip_to_navigation_hindi)).getText();
	  System.out.println("language in hindi" + hindi_text);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the the home page in 'Hindi' Language.");
	  Assert.assertEquals(hindi_text,"नेविगेशन पर जाएं");
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'English' language from top panel.");
	  driver.findElement(By.xpath(Homepage.btn_English)).click();
	  Thread.sleep(5000);
	  String english_text1 = driver.findElement(By.xpath(Homepage.skip_main_content)).getText();
	  System.out.println("language " + english_text1);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the the home page in 'English' Language.");
	  Assert.assertEquals(english_text1,"Skip to main content");  
	  }
  @Test(priority=12, description="To verify that user is able to get 'Sign In' page.")
  public void NATMO_HOME_12() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' link from top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Sign In' page.");
	  Assert.assertEquals(found,true);  
	  }
  @Test(priority=13, description="To verify that user is able to get 'Register' page.")
  public void NATMO_HOME_13() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' link from top panel.");
	  driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Create New Account' page.");
	  boolean found =  driver.findElement(By.xpath(Homepage.label_register)).isDisplayed();
	  Assert.assertEquals(found,true);
	  }
  @Test(priority=14, description="To verify that user is able to perform 'Geoportal' link.")
  public void NATMO_HOME_14() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Geo-portal' link from top panel.");
	  driver.findElement(By.xpath(Homepage.btn_geoportal)).click();
	  Thread.sleep(2000); 
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();

	while(I1.hasNext())
	{

	String child_window=I1.next();


	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);

	String actualTitle = driver.switchTo().window(child_window).getTitle();
      
	  String expectedTitle="NATMO Geoportal";
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'Geo-portal' page.");
	  Assert.assertEquals(actualTitle, expectedTitle);
	}
	}
  }
  
  @Test(priority=15, description="To verify that user is able to perform 'Search' functionality.")
  public void NATMO_HOME_15() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<Step-1:</b> Enter map services in 'Map Services' text box.");
	   driver.findElement(By.xpath(Homepage.txt_searchbox)).sendKeys("Agricultural Atlas");
	   Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Search' button.");
	   driver.findElement(By.xpath(Homepage.btn_search)).click();
	   Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on search result page.");  
	   String aa=driver.getTitle();
	   System.out.println(aa);
	   Assert.assertNotEquals(aa,"Home - National Atlas & Thematic Mapping Organisation");
	  
  }
  @Test(priority=16, description="To verify that user is get the images change automatically functionality on home page.")
  public void NATMO_HOME_16() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Observe home page images and wait for specific time to change the images automatically.");
	  System.out.println(driver.findElement(By.xpath(Homepage.img_1)).isDisplayed()); 
	  Assert.assertEquals(true, driver.findElement(By.xpath(Homepage.img_1)).isDisplayed());
	  Thread.sleep(5000);  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Observe home page images and wait for specific time to change the images automatically.");
	  System.out.println(driver.findElement(By.xpath(Homepage.img_2)).isDisplayed()); 
	  Assert.assertEquals(true, driver.findElement(By.xpath(Homepage.img_2)).isDisplayed());
	  Thread.sleep(2000); 
	  }
  @Test(priority=17, description="To verify that user is able to change images by clicking next/previous button from home page.")
  public void NATMO_HOME_17(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on next button from home page.");
	  driver.findElement(By.xpath(Homepage.btn_next)).click(); 
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next images on home page.");
	  System.out.println(driver.findElement(By.xpath(Homepage.img_2)).isDisplayed()); 
	  Assert.assertEquals(true, driver.findElement(By.xpath(Homepage.img_2)).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on previous button from home page.");
	  driver.findElement(By.xpath(Homepage.btn_previous)).click(); 
	  Thread.sleep(2000);  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous images on home page."); 
	  System.out.println(driver.findElement(By.xpath(Homepage.img_1)).isDisplayed()); 
	 Assert.assertEquals(true, driver.findElement(By.xpath(Homepage.img_1)).isDisplayed());
	 }
  @Test(priority=18, description="To verify that user is able stop the images change automatically functionality on home page.")
  public void NATMO_HOME_18() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on stop button from home page.");
	  driver.findElement(By.xpath(Homepage.btn_stop)).click(); 
	  Thread.sleep(2000);  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Observe home page images and wait for specific time to change the images automatically.");
	  System.out.println(driver.findElement(By.xpath(Homepage.img_2)).isDisplayed()); 
	  Assert.assertNotEquals(true, driver.findElement(By.xpath(Homepage.img_2)).isDisplayed());
	  } 
  @Test(priority=19, description="To verify that user is get the latest news on home page.")
  public void NATMO_HOME_19() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Observe the middle section oh home page.");
	  driver.findElement(By.xpath(Homepage.label_latest_news)).isDisplayed(); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the latest news about the NATMO application.");	 
	  Assert.assertEquals(true,driver.findElement(By.xpath(Homepage.label_latest_news)).isDisplayed());	   
	  }
  @Test(priority=20, description="To verify that user is get the more deatails about latest news on home page.")
  public void NATMO_HOME_20() throws InterruptedException {
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on more button on latest news.");
		 driver.findElement(By.xpath(Homepage.link_more_details)).click(); 
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the latest news about the NATMO application.");	 
		 String parent=driver.getWindowHandle();
		  Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		String actualTitle = driver.switchTo().window(child_window).getTitle();
	      
		  String expectedTitle="NATMO to observe 65<sup>th</sup> Foundation Day on 18<sup>th</sup> August 2021. | National Atlas & Thematic Mapping Organisation";
		
		  Assert.assertEquals(actualTitle, expectedTitle);
		}
		}	   
	
  }
  @Test(priority=21, description="To verify that user is able to perform 'Ebook Services' link.")
  public void NATMO_HOME_21() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Ebook Services' link.");
		  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_Ebook_Services));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).perform();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover 'Atlas' link.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.lnk_Atlas));
		  action.moveToElement(ele1).perform();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Atlas of Agricultural Resources' link.");
		  driver.findElement(By.xpath(Geo_Portal.lnk_Atlas_of_Agricultural_Resources)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate to the more details of 'atlas of Agricultural Resouces' page.");
		  String parent=driver.getWindowHandle();
		  Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		String actualTitle = driver.switchTo().window(child_window).getTitle();
	      
		  String expectedTitle="National Atlas & Thematic Mapping Organisation";
		  Assert.assertEquals(actualTitle, expectedTitle);
		}
		} 
		String a = driver.findElement(By.xpath("//h2[@class=\"pane-title\"]")).getText();
		System.out.println(a);
		Assert.assertEquals("Atlas of Agricultural Resources", a);
	
  }
  @Test(priority=22, description="To verify that user is able to perform 'Home' link.")
  public void NATMO_HOME_22() throws InterruptedException {  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Home' link.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Home)).click();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on home page of NATMO application.");
	  Assert.assertEquals(driver.getTitle(), "National Atlas & Thematic Mapping Organisation");  
	  }
  @Test(priority=23, description="To verify that user is able to perform 'map/Atlas Services' link.")
  public void NATMO_HOME_23(Method method) throws InterruptedException {
	 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Map/Atlas Services' link.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_map_atlas_services));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  List<WebElement> element1 = driver.findElements(By.xpath("//li[@class=\"has-sub drop-left menu-link-map-atlas-services\"]/ul/li"));
	  System.out.println(element1.size());
	  String[] stringArray2 = new String[element1.size()];
	  String[] stringArray1 = { "All", "Atlas Services", "Map Services" };
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of Map/Atlas services like:All,Atlas Services, Map Services ");
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray2[i]=driver.findElements(By.xpath("//li[@class=\"has-sub drop-left menu-link-map-atlas-services\"]/ul/li")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray2[i]);
		  } 
	  System.out.println("Original Array Elements:" + Arrays.toString(stringArray2)); 
	  Assert.assertEquals(stringArray2, stringArray1);	
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'All' link.");
	  driver.findElement(By.xpath(Geo_Portal.lnk_All)).click();
	  Thread.sleep(4000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on all details about map/atlas service page.");
	  System.out.println(driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "Search | National Atlas & Thematic Mapping Organisation");	
  }
  @Test(priority=24, description="To verify that user is able to perform 'Theme' link.")
  public void NATMO_HOME_24(Method method) throws InterruptedException {

	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Theme' link.");
		  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_Theme));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).perform();
		  List<WebElement> element1 = driver.findElements(By.xpath("//li[@class=\"menu-link-themes has-sub\"]/ul/li"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  String[] stringArray1 = { "-All", "Administrative and Political", "Agriculture", "Banking and Financial Services","Climate", "Demography", "District Planning Map Series", "Education", "Environment", "Landuse-Landcover", "Forest and Vegetation", "Geology", "Golden Map Services", "Health", "History and Culture", "Housing and Settlement", "Hydrology", "Industries","Infrastructure, Utility and Services",
		  		 "Livestock, Poultry and Fisheries",
		  		 "Natural Hazards",
		  		 "Natural Resources",
		  		 "Oceanography",
		  		 "Physiography and Geomorphology",
		  		 "Power and Energy Resources",
		  		 "Science and Technology",
		  		"Social Environs",
		  		 "Soil",
		  		 "Tourism",
		  		 "Trade and Commerce",
		  		"Transport and Communication",
		  		 "Wildlife"};
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of Theme: ");
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//li[@class=\"menu-link-themes has-sub\"]/ul/li")).get(i).getText();
			 Thread.sleep(1000);
			
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  } 
		  System.out.println("Original Array Elements:" + Arrays.toString(stringArray2)); 
		  Assert.assertEquals(stringArray2, stringArray1);	
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Administrative and political' link.");
		  driver.findElement(By.xpath(Geo_Portal.lnk_Adm_and_pol)).click();
		  Thread.sleep(4000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on particular theme dataset.");
		  driver.findElement(By.xpath("//div[@class=\"view-content\"]/ul/li[1]")).click();
		  Thread.sleep(4000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'NATMO Geoportal' with selected dataset.");
		  String parent=driver.getWindowHandle();
		  Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		String actualTitle = driver.switchTo().window(child_window).getTitle();
	      
		  String expectedTitle="Search | National Atlas Thematic Mapping Organisation";
		  Assert.assertNotEquals(actualTitle, expectedTitle);
		}
		} 
		 }
  @Test(priority=25, description="To verify that user is able to perform 'WMS Services' functionality from 'OGC Services'.")
  public void NATMO_HOME_25(Method method) throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'OGC services' link.");
		  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_OGC_Services));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).perform();
		  List<WebElement> element1 = driver.findElements(By.xpath("//li[@class=\"menu-link-ogc-services has-sub\"]/ul/li"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  String[] stringArray1 = { "WMS Services", "WFS Services"};
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of Theme: ");
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//li[@class=\"menu-link-ogc-services has-sub\"]/ul/li")).get(i).getText();
			 Thread.sleep(1000);
			
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  } 
		  System.out.println("Original Array Elements:" + Arrays.toString(stringArray2)); 
		  Assert.assertEquals(stringArray2, stringArray1);	
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
			ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover on 'WMS Services' link.");
			  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.lnk_WMS_Services)); 
			  action.moveToElement(ele1).perform();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'NSA- Administrative' option.");
		  driver.findElement(By.xpath(Geo_Portal.lnk_NSA_adm)).click();
		  Thread.sleep(4000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'NATMO Geoportal' with Administrative details.");
		  String parent=driver.getWindowHandle();
		  Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		String actualTitle = driver.switchTo().window(child_window).getTitle();
	      
		  String expectedTitle="NATMO Geoportal";
		  Assert.assertEquals(actualTitle, expectedTitle);
		}
		} 
		 }
  @Test(priority=26, description="To verify that user is able to perform 'NATMO's Portal' link.")
  public void NATMO_HOME_26() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'NATMO's Portal' link from top panel.");
	  driver.findElement(By.xpath(Homepage.lnk_NATMO_Portal)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'NATMO's Portal' page.");
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();

	while(I1.hasNext())
	{

	String child_window=I1.next();


	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);

	String actualTitle = driver.switchTo().window(child_window).getTitle();
      
	  String expectedTitle="Home - National Atlas & Thematic Mapping Organisation";
	  Assert.assertEquals(actualTitle, expectedTitle);
	}
	}  
		 
		 }
  @Test(priority=27, description="To verify that user is able to perform 'About Us' link.")
  public void NATMO_HOME_27() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'About us' link from home page.");
	  driver.findElement(By.xpath(Geo_Portal.lnk_About_Us)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on About Us page.");
	  Assert.assertEquals("About Us | National Atlas & Thematic Mapping Organisation", driver.getTitle());  
		 
		 }
  @Test(priority=28, description="To verify that user is able to perform 'Tourist Map' from middle section.")
  public void NATMO_HOME_28() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Tourist Map' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_Tourist_Map)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Tourist Map' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"Tourist Map\"]")).isDisplayed());  
		 
		 }
  @Test(priority=29, description="To verify that user is able to perform 'Agricultural Atlas' from middle section.")
  public void NATMO_HOME_29() throws InterruptedException {
	 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Agricultural Atlas' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_Agricultural_Atlas)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Agricultural Atlas' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"Agricultural Atlas\"]")).isDisplayed());  
		 
		 }
  @Test(priority=30, description="To verify that user is able to perform 'District Planning Map Series' from middle section.")
  public void NATMO_HOME_30() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'District Planning Map Series' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_District_Planning_Map_Series)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'District Planning Map Series' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"District Planning Map Series\"]")).isDisplayed());  
		 
		 }
  @Test(priority=31, description="To verify that user is able to perform 'Golden Map Services' from middle section.")
  public void NATMO_HOME_31() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Golden Map Services' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_Golden_Map_Services )).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Golden Map Services' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"Golden Map Services\"]")).isDisplayed());  
		 
		 }
  @Test(priority=32, description="To verify that user is able to perform 'National Atlas' from middle section.")
  public void NATMO_HOME_32() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'National Atlas' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_National_Atlas )).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'National Atlas' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"National Atlas\"]")).isDisplayed());  
		 
		 }
  @Test(priority=33, description="To verify that user is able to perform 'National School Atlas' from middle section.")
  public void NATMO_HOME_33() throws InterruptedException {
	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'National School Atlas' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_National_School_Atlas  )).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'National School Atlas' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"National School Atlas\"]")).isDisplayed());  
		 
		 }
  @Test(priority=34, description="To verify that user is able to perform 'State Atlas' from middle section.")
  public void NATMO_HOME_34() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on next button from home page.");
	  driver.findElement(By.xpath(Homepage.btn_next1 )).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'State Atlas' from middle section.");
	  driver.findElement(By.xpath(Homepage.lnk_State_Atlas )).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'State Atlas' page.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div[@class=\"item-list\"]/ul/li/a[text()=\"State Atlas\"]")).isDisplayed());  
		 
		 }
  @Test(priority=35, description="To verify that user is able to perform 'Contact Us' from bottom section.")
  public void NATMO_HOME_35() throws InterruptedException {  
    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Contact Us' from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Contact_Us)).click();
	  Thread.sleep(2000);  
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Contact Us' page.");
		  Assert.assertEquals("Contact Us | National Atlas & Thematic Mapping Organisation", driver.getTitle());  
  }
  @Test(priority=36, description="To verify that user is able to perform 'Help' from bottom section.")
  public void NATMO_HOME_36() throws InterruptedException {  
    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Help' from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Help)).click();
	  Thread.sleep(2000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Help' page.");
	  String parent=driver.getWindowHandle();
	  Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();

	while(I1.hasNext())
	{

	String child_window=I1.next();


	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);

	String actualTitle = driver.switchTo().window(child_window).getTitle();
      
	  String expectedTitle="NATMO";
	  Assert.assertEquals(actualTitle, expectedTitle);
	}
	}  
  }
  @Test(priority=37, description="To verify that user is able to perform 'FAQ' from bottom section.")
  public void NATMO_HOME_37() throws InterruptedException {  
    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'FAQ' from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_FAQ)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'FAQ' page.");
		  Assert.assertEquals("FAQ | National Atlas & Thematic Mapping Organisation", driver.getTitle());
  }
  @Test(priority=38, description="To verify that user is able to perform 'Skip to main Content' link")
  public void NATMO_HOME_38() throws InterruptedException {
	  String skip_main_content = driver.findElement(By.xpath(Homepage.skip_main_content)).getText();
	 Assert.assertEquals(skip_main_content, "Skip to main content");
	  Thread.sleep(2000);
	  JavascriptExecutor j = (JavascriptExecutor) driver;
      Long v = (Long) j.executeScript("return window.pageYOffset;");
      System.out.println("Scroll position before launch: " + v);
   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Skip to main Content' link from top panel.");
	  driver.findElement(By.xpath(Homepage.skip_main_content)).click();
	  Thread.sleep(5000);
	  Long w = (Long) j.executeScript("return window.pageYOffset;");
	     System.out.println("Scroll position after launch: " + w);
	   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should skip the main content on home page of 'NATMO' application.");
	     Assert.assertNotEquals(v,w);
	  
	
  }
  @Test(priority=39, description="To verify that user is able to perform 'Skip to Navigation Content' link")
  public void NATMO_HOME_39() throws InterruptedException {
	  String skip_to_navigation = driver.findElement(By.xpath(Homepage.skip_to_navigation)).getText();
	  Assert.assertEquals(skip_to_navigation, "Skip to Navigation");
	  Thread.sleep(2000);
	  JavascriptExecutor j = (JavascriptExecutor) driver;
      Long v = (Long) j.executeScript("return window.pageYOffset;");
      System.out.println("Scroll position before launch: " + v);
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Skip to Navigation Content' link from top panel.");
	  driver.findElement(By.xpath(Homepage.skip_to_navigation)).click();
	  Thread.sleep(5000); 
    // JavascriptExecutor a= (JavascriptExecutor) driver;
     Long w = (Long) j.executeScript("return window.pageYOffset;");
     System.out.println("Scroll position after launch: " + w);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should skip the navigation on home page of 'NATMO' application.");
     Assert.assertNotEquals(v,w);
  }
  @Test(priority=40, description="To verify that user is able to perform 'Facebook' icon from bottom section.")
  public void NATMO_HOME_40() throws InterruptedException {  
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Facebook' icon from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Facebook )).click();
	  Thread.sleep(2000);   
  }
  
  @Test(priority=41, description="To verify that user is able to perform 'Linkedin' icon from bottom section.")
  public void NATMO_HOME_41() throws InterruptedException {
	  
    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Linkedin' icon from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Linkedin )).click();
	  Thread.sleep(2000);   
  }
  @Test(priority=42, description="To verify that user is able to perform 'Twitter' icon from bottom section.")
  public void NATMO_HOME_42() throws InterruptedException {
	  
    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Twitter' icon from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Twitter )).click();
	  Thread.sleep(2000);   
  }
  @Test(priority=43, description="To verify that user is able to perform 'Mail' icon from bottom section.")
  public void NATMO_HOME_43() throws InterruptedException {
	  
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Mail' icon from bottom section.");
	  driver.findElement(By.xpath(Homepage.btn_Mail )).click();
	  Thread.sleep(2000);   
  }
  @BeforeClass
  public void setDriver() {
	 
  }
  @BeforeMethod
  public void openBrowser(ITestContext context) {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(Homepage.URL);
  }

 
  @AfterMethod
  public void afterClass() {
	  driver.quit();
	  }
  }
