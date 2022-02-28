package Geo_Portal;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Geo_Portal_R.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import Home_Page_R.*;
import Listener.ExtentTestManager;
import Listener.Extra_Screen;
import Login_R.*;
import Registration_R.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Arrays;  
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.jsoup.Connection.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import java.lang.reflect.Method;
public class Geoportal {
	Homepage obj = new Homepage();
	Login_In obj1 = new Login_In();
	Registration_page obj2= new Registration_page();
	Geo_Portal obj3 = new Geo_Portal();
	Extra_Screen objss = new Extra_Screen();
	WebDriver driver;
  String Classname = "Geoportal_extras";
  @BeforeClass
  public void setDriver() {
	
  }
  @BeforeMethod
  public void openBrowser(ITestContext context) throws InterruptedException {
	  // ExtentTestManager.getTest().log(Status.INFO, "Open Browser.");
	  
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  //ExtentTestManager.getTest().log(Status.INFO, "Enter the URL of NATMO application in address bar.");
	  driver.get(Homepage.URL);
	 // ExtentTestManager.getTest().log(Status.INFO, "Click on Geoportal link from the top panel.");
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
	  Assert.assertEquals(actualTitle, expectedTitle);
	}
	}
	driver.switchTo().frame(Geo_Portal.iframe);
	  Thread.sleep(5000);
	  
  }
 
 
  @Test(priority=1, description = "To verify that user is able to perform collapse/expand functionality on layer panel.")
  public void NATMO_Geoportal_01(Method method) throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on collapse button on layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Layer_Collapse)).click();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> layer panel should collapse as per selection.");
	  driver.findElement(By.xpath(Geo_Portal.Layer_panel_off)).isDisplayed();
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on expand button on layer panel");
	  driver.findElement(By.xpath(Geo_Portal.btn_Layer_expand)).click();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b>Layer panel should expand as per selection.");
	  driver.findElement(By.xpath(Geo_Portal.Layer_panel_on)).isDisplayed();
	
  }
  
  @Test(priority=2, description = "To verify that user is able to Search particular layer in search layer tetbox.")
  public void NATMO_Geoportal_02() throws InterruptedException {
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Enter layer name in search layer textbox.");
	  driver.findElement(By.xpath(Geo_Portal.txt_search_layer)).sendKeys("District ");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get searched layer in layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.label_District_layer)).isDisplayed();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should not  get this layer in layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.label_National_Capital_layer)).isDisplayed();
	  
}
  @Test(priority=3, description = "To verify that user is able to perform 'Add Layer' functionality.")
  public void NATMO_Geoportal_03() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_add_layer)).click();
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select layer from the 'Layer' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_search_layer)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys("Education");
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the options of selected layer on 'add a Layer' dialog.");
	  driver.findElement(By.xpath(Geo_Portal.label_Education_Add_Layer_ddm)).isDisplayed();
  }
  @Test(priority=4, description = "To verify that user is able to get the particular layer details.")
  public void NATMO_Geoportal_04() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_add_layer)).click();
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select layer from the 'Layer' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_search_layer)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys("Education");
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on (i) information icon from 'Add a layer' dialog. ");
	  driver.findElement(By.xpath(Geo_Portal.btn_information_layer)).click();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on selected layer information page.");
		 driver.findElement(By.xpath(Geo_Portal.label_Education_informationpage)).isDisplayed();
  }
  @Test(priority=5, description = "To verify that user is able to perform 'View in Geoportal' functionality.")
  public void NATMO_Geoportal_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_add_layer)).click();
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select layer from the 'Layer' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_search_layer)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys("Education");
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'View in Geoportal' button from add a layer dialog.");
	  driver.findElement(By.xpath(Geo_Portal.btn_view_in_Geoportal)).click();
	  Thread.sleep(2000);
	  driver.switchTo().frame(Geo_Portal.iframe);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be display on 'layer' panel.");
	  driver.findElement(By.xpath(Geo_Portal.label_Education_layer)).isDisplayed();
  }
  
  @Test(priority=6, description = "To verify that user is able to close the 'Add a layer' dialog.")
  public void NATMO_Geoportal_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_add_layer)).click();
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'close' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_close_Add_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Add a Layer' dialog should closed.");
	 boolean f =  driver.findElement(By.xpath(Geo_Portal.dialog_Add_Layer)).isDisplayed();
	 System.out.println(f);
	  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.dialog_Add_Layer)).isDisplayed() );
  }
  @Test(priority=7, description = "To verify that user is able to perform 'Remove Slected Layer' functionality.")
  public void NATMO_Geoportal_07(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_add_layer)).click();
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select layer from the 'Layer' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_search_layer)).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys("Education");
	  driver.findElement(By.xpath(Geo_Portal.txt_search)).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'View in Geoportal' button from add a layer dialog.");
	  driver.findElement(By.xpath(Geo_Portal.btn_view_in_Geoportal)).click();
	  Thread.sleep(2000);
	  driver.switchTo().frame(Geo_Portal.iframe);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select any Layer from added layer.");
	  driver.findElement(By.xpath(Geo_Portal.label_Taluka_Headquarter_layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Remove Selected Layer' functionality from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Remove_Selected_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the suggestion message 'Individual layer can not be removed. Do you want to remove entire group of layers?'");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.label_message_remove_layer)).isDisplayed() );
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'OK' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_ok_Remove_Selected_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Successfully message should be displayed.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.label_Success_message_remove_layer)).isDisplayed() );
	  }
  @Test(priority=8, description = "To verify that user is able to perform collapse/expand functionality for particuler group.")
  public void NATMO_Geoportal_08(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on particular group icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_collapse_particular_layer)).click();
	  Thread.sleep(2000);
	   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get collapsed mode of the particular layer group.");
	  Assert.assertEquals(false, driver.findElement(By.xpath("//div/li[1]/ul[@style=\"position: relative; visibility: visible; display: none; left: 0px; top: 0px; z-index: auto;\"]")).isDisplayed() );
	  Thread.sleep(2000);
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on particular group icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_expand_particular_layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get expand mode of the particular layer group.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//div/li[1]/ul[@style=\"position: relative; visibility: visible; display: block; left: 0px; top: 0px; z-index: auto;\"]")).isDisplayed() );
  }
  @Test(priority=9, description = "To verify that user is able to perform 'Select All' functionality for sublayers.")
  public void NATMO_Geoportal_09() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on checkbox which is ahead of group.");
	  driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
	  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> All sublayers data should be display on map and all checkbox selected.");
	  for(int i =0; i<element.size(); i++) {
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
	  }
  }
  @Test(priority=10, description = "To verify that user is able to perform 'Un Select All' functionality for sublayers.")
  public void NATMO_Geoportal_10(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on checkbox which is ahead of group.");
	  driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
	  List<WebElement> element = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
	  System.out.println(element.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> All sublayers data should be display on map and all checkbox selected.");
	  for(int i =0; i<element.size(); i++) {
		  Assert.assertEquals(true, element.get(i).isDisplayed() );
	  }
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on checkbox which is ahead of group.");
		  driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
		  Thread.sleep(2000);
		  List<WebElement> element1 = driver.findElements(By.xpath("//div/li[2]/ul/li/div[1]/input[@checked]"));
		  System.out.println(element1.size());
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b>  All sublayers data should be display on map and all checkbox selected.");
		  for(int i =0; i<element1.size(); i++) {
			  Assert.assertEquals(false, element1.get(i).isDisplayed() );
		  } 
  }
  @Test(priority=11, description = "To verify that user is able to perform 'Select' particuler sublayers.")
  public void NATMO_Geoportal_11() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on checkbox which is ahead of group.");
	  driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on checkbox which is ahead of group.");
      driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular layer from sublayer."); 
	  driver.findElement(By.xpath(Geo_Portal.chk_National_Capital_Layer)).click();
	  Thread.sleep(4000);	
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should be display on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_National_Capital)).isDisplayed() );
  }
  @Test(priority=12, description = "To verify that user is able to perform 'un Select' particuler sublayers.")
  public void NATMO_Geoportal_12(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on checkbox which is ahead of group.");
	  driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on checkbox which is ahead of group.");
      driver.findElement(By.xpath(Geo_Portal.chk_Administrative_All_Layer)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select particular layer from sublayer."); 
	  driver.findElement(By.xpath(Geo_Portal.chk_National_Capital_Layer)).click();
	  Thread.sleep(4000);	
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should be display on map.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_National_Capital)).isDisplayed() );
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Un Select particular layer from sublayer."); 
	  driver.findElement(By.xpath(Geo_Portal.chk_National_Capital_Layer)).click();
	  Thread.sleep(4000);	
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Layer data should not display on map.");
	  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.img_National_Capital)).isDisplayed() );
  }
  @Test(priority=13, description = "To verify that user is able to perform 'Get Layer Information' functionality.")
  public void NATMO_Geoportal_13(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Right click on particular layer.");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(Geo_Portal.label_District_layer)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the information of particular layer.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.label_information_window)).isDisplayed() );
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'OK' button of information pop up.");
	 driver.findElement(By.xpath(Geo_Portal.btn_ok_information)).click();
	 Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Information pop up should be close.");
		  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.label_information_window)).isDisplayed() );	  
  }
  @Test(priority=14, description = "To verify that user is able to perform close the Information pop up.")
  public void NATMO_Geoportal_14(Method method) throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Right click on particular layer.");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(Geo_Portal.label_District_layer)); 
	  action.contextClick(link).perform();
	  Thread.sleep(4000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Get layer Information' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Get_Layer_information)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the information of particular layer.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.label_information_window)).isDisplayed() );
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'close' button of information pop up.");
	 driver.findElement(By.xpath(Geo_Portal.btn_close_information)).click();
	 Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Information pop up should be close.");
	 Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.label_information_window)).isDisplayed() );	  
  }
  @Test(priority=15, description = "To verify that user is able to perform 'Zoom to layer Extent' functionality.")
  public void NATMO_Geoportal_15() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Zoom in' functionality from the bottom panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_In)).click();
	  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_In)).click();
      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Right click on particular layer.");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(Geo_Portal.label_District_layer)); 
	  action.contextClick(link).perform();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Zoom to layer Extent' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_to_Layer_Extent)).click();
	  Thread.sleep(4000);
	  String sa = driver.findElement(By.xpath("//div[@class=\"xtb-text\"]/a")).getText();
	  System.out.println(sa);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the map specific zoom level.");
	  String va = "1:18000000";
	  Assert.assertNotEquals(va, sa);
  }
  @Test(priority=16, description = "To verify that user is able to perform 'Change layer opacity' functionality.")
  public void NATMO_Geoportal_16() throws InterruptedException {
	// ExtentTestManager.getTest().log(Status.INFO, "Right click on particular layer.");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(Geo_Portal.label_District_layer)); 
	  action.contextClick(link).perform();
	  Thread.sleep(2000);
	// ExtentTestManager.getTest().log(Status.INFO, "Click on 'Change Layer opacity' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Change_Layer_opacity)).click();
	  Thread.sleep(2000);	  
  }
  @Test(priority=17, description = "To verify that user is able to perform 'Attribute Information' functionality.")
  public void NATMO_Geoportal_17() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Right click on particular layer.");
	  Actions action = new Actions(driver);
	  WebElement link =driver.findElement(By.xpath(Geo_Portal.label_District_layer)); 
	  action.contextClick(link).perform();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on Attribute Information' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Attribute_Information)).click();
	  Thread.sleep(2000);
	  String aa= driver.switchTo().alert().getText();
	  Assert.assertEquals(aa, "Attribute information is not availaible for this layer.");
	   }
  @Test(priority=18, description = "To verify that user is able to perform 'Add WMS Service' functionality.")
  public void NATMO_Geoportal_18() throws InterruptedException {
	// ExtentTestManager.getTest().log(Status.INFO, "Click on 'Add WMS Service' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Add_WMS_Service)).click();
	  
	   }
  @Test(priority=20, description = "To verify that user is able to cancel the add server dialog.")
  public void NATMO_Geoportal_20() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add WMS Service' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Add_WMS_Service)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select add a new server option from 'View Available data from' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Selet_WMS_Service)).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(Geo_Portal.ddl_WMS_Service)).click();
	  Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Cancel' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Cancel_WMS_Service)).click();
		  Thread.sleep(2000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Add new Server' dialog should close.");
		   boolean aa=driver.findElement(By.xpath(Geo_Portal.dailog_Add_New_Server)).isDisplayed();
		   System.out.println(aa);
		  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.dailog_Add_New_Server)).isDisplayed());
  }
  @Test(priority=21, description = "To verify that user is able to close the add server dialog.")
  public void NATMO_Geoportal_21() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add WMS Service' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Add_WMS_Service)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select add a new server option from 'View Available data from' dropdown.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Selet_WMS_Service)).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(Geo_Portal.ddl_WMS_Service)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Close' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Cancel_WMS_Service)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Add new Server' dialog should close.");
		   boolean aa=driver.findElement(By.xpath(Geo_Portal.dailog_Add_New_Server)).isDisplayed();
		   System.out.println(aa);
		  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.dailog_Add_New_Server)).isDisplayed());
  }
  @Test(priority=22, description = "To verify that user is able to close the Available Layer.")
  public void NATMO_Geoportal_22() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Add WMS Service' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Add_WMS_Service)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'close' button from Available label pop up window.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_Available_Layer)).click();
		  Thread.sleep(2000);
   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Available laYer' pop up window should be closed.");
		  Assert.assertEquals(false, driver.findElement(By.xpath(Geo_Portal.dialog_Available_Layer)).isDisplayed());
  }
  @Test(priority=23, description="To verify that user is able to perform 'Search' functionality.")
  public void NATMO_Geoportal_23() throws InterruptedException {
	  driver.switchTo().defaultContent();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Enter map services in 'Map Services' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_Search_Map_Service)).sendKeys("Agricultural Density");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Search' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Search_Map_Service)).click();
		  Thread.sleep(4000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on search result page.");
		  Assert.assertEquals(driver.getTitle(), "Search | National Atlas & Thematic Mapping Organisation");
  }
  @Test(priority=24, description="To verify that user is able to perform 'Home' Link.")
  public void NATMO_Geoportal_24() throws InterruptedException {
	  driver.switchTo().defaultContent();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Home' link.");
	 driver.findElement(By.xpath(Geo_Portal.btn_Home)).click();
     Thread.sleep(4000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on home page of NATMO application.");
     Assert.assertEquals(driver.getTitle(), "National Atlas & Thematic Mapping Organisation");  
		
  }
  @Test(priority=25, description="To verify that user is able to perform 'Atlas of Agricultural resources' Link.")
  public void NATMO_Geoportal_25(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Ebook Services' link.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_Ebook_Services));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  List<WebElement> element1 = driver.findElements(By.xpath("//li[@class=\"menu-link-ebook-services has-sub\"]/ul/li"));
	  System.out.println(element1.size());
	  String[] stringArray2 = new String[element1.size()];
	  String[] stringArray1 = { "Atlas", "Monograph", "Booklet" };
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of ebook services like:Atlas, Monograph, Booklet ");
	  for(int i =0; i<element1.size(); i++) {
		 
		 stringArray2[i]=driver.findElements(By.xpath("//li[@class=\"menu-link-ebook-services has-sub\"]/ul/li")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element1.size(); i++) {
			 
		  System.out.println(stringArray2[i]);
		  } 
	  System.out.println("Original Array Elements:" + Arrays.toString(stringArray2)); 
	  Assert.assertEquals(stringArray2, stringArray1);
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover 'Atlas' link.");
	  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.lnk_Atlas));
	  action.moveToElement(ele1).perform();
	  List<WebElement> element2 = driver.findElements(By.xpath("//li[@class=\"first menu-link-atlas has-sub\"]/ul/li"));
	  System.out.println(element2.size());
	  String[] stringArray3 = new String[element2.size()];
	  String[] stringArray4 = { "Atlas of Agricultural Resources", "Atlas of Rural India", "Cultural Heritage Atlas Of India", "Hydrological Atlas", "Indian Ocean Atlas","Irrigation Atlas of India", "National Atlas", "Science and Technology Atlas of India", "Socio Economic Atlas", "State Atlas of Goa", "State Atlas of Punjab", "Water Resources Development Atlas" };
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get list of Atlas like:'Atlas of Agricultural Resources', 'Atlas of Rural India', 'Cultural Heritage Atlas Of India', 'Hydrological Atlas', 'Indian Ocean Atlas','Irrigation Atlas of India', 'National Atlas', 'Science and Technology Atlas of India', 'Socio Economic Atlas', 'State Atlas of Goa', 'State Atlas of Punjab', 'Water Resources Development Atlas' ");
	  for(int i =0; i<element2.size(); i++) {
		 
		 stringArray3[i]=driver.findElements(By.xpath("//li[@class=\"first menu-link-atlas has-sub\"]/ul/li")).get(i).getText();
		 Thread.sleep(2000);
	  } 
	  for(int i =0; i<element2.size(); i++) {
			 
		  System.out.println(stringArray3[i]);
		  } 
	  System.out.println("Original Array Elements:" + Arrays.toString(stringArray3)); 
	  Assert.assertEquals(stringArray3, stringArray4);
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
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
  @Test(priority=26, description="To verify that user is able to perform 'Flip right' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_26(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Flip Right' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Flip_Right)).click();
	  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the next page of atlas of agricultural resources ebook.");
	  Assert.assertEquals("2 / 110", driver.findElement(By.xpath(Geo_Portal.label_Page_No)).getText());		  
  }
  @Test(priority=27, description="To verify that user is able to perform 'Flip left' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_27(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Flip Right' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Flip_Right)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the next page of atlas of agricultural resources ebook.");
	  System.out.println(driver.findElement(By.xpath(Geo_Portal.label_Page_No)).getText());
	  Assert.assertEquals("2 / 110", driver.findElement(By.xpath(Geo_Portal.label_Page_No)).getText());
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Flip Right' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Flip_Left)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the previous page of atlas of agricultural resources ebook.");
		  Assert.assertEquals("1 / 110", driver.findElement(By.xpath(Geo_Portal.label_Page_No)).getText());
  }
  @Test(priority=28, description="To verify that user is able to perform 'One page view' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_28(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'One-page view' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_one_page_view)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the view of ebook in one page.");
     Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.one_page_view)).isDisplayed(), true); 
   } 
  @Test(priority=29, description="To verify that user is able to perform 'Two page view' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_29(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'One-page view' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_one_page_view)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the view of ebook in one page.");
	  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.one_page_view)).isDisplayed(), true); 
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Two-page view' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_two_page_view)).click();
		  Thread.sleep(2000);
      ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the view of ebook in two page.");
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.two_page_view)).isDisplayed(), true);   
  } 
  @Test(priority=30, description="To verify that user is able to perform 'thumbnail view' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_30(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Thumbnail view' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_thumbnail_view)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the view of ebook in Thumbnail view page.");
	  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.thumbnail_view)).isDisplayed(), true);    
  } 
  @Test(priority=31, description="To verify that user is able to perform 'Zoom in' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_31(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Zoom in' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_zoom_in)).click();
	  Thread.sleep(2000);
	  System.out.println(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"));
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the zoom in level of ebook should be change.");
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"), "1012px");    
  } 
  @Test(priority=32, description="To verify that user is able to perform 'Zoom out' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_32(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Zoom in' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_zoom_in)).click();
		  Thread.sleep(2000);
		  System.out.println(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the zoom in level of ebook should be change.");
		  Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"), "1012px"); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Zoom out' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_zoom_out)).click();
		  Thread.sleep(2000);
		  System.out.println(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the zoom out level of ebook should be change.");
		  Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"), "792px");  
  } 
  @Test(priority=33, description="To verify that user is able to perform 'Toggle fullscreen' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_33(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Toggle fullscreen' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Toggle_fullscreen)).click();
		  Thread.sleep(2000);
		  System.out.println(driver.findElement(By.xpath("//div[@class=\"BRtwopageview\"]")).getCssValue("width"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the book in full screen.");
		  Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"ui-full br-ui-full BookReader no-touch fullscreenActive BRmode2Up\"]")).isDisplayed(), true);     
  } 
  @Test(priority=34, description="To verify that user is able to perform 'Show/hide navbar' functionality from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_34(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'hide' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_hide_show_navbar)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Nav bar should be hide.");
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.nav_bar)).isDisplayed(), false);
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'show' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_hide_show_navbar)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Nav bar should be show.");
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.nav_bar)).isDisplayed(), true);
  } 
  @Test(priority=35, description="To verify that user is able to get particular page number from 'Atlas of Agricultural resources' book.")
  public void NATMO_Geoportal_35(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	 objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Drag the page number to change page of ebook.");
	WebElement priceSlider = driver.findElement(By.xpath(Geo_Portal.btn_drag_particular_page));
	
	
	Dimension sliderSize = priceSlider.getSize();
	int sliderWidth = sliderSize.getWidth();
	
	int xCoord = priceSlider.getLocation().getX();
					
	Actions builder = new Actions(driver);   
	builder.moveToElement(priceSlider)
		   .click()
		   .dragAndDropBy
		     (priceSlider,xCoord + sliderWidth, 0)
		   .build()
		   .perform();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should change the particular page number on ebook.");
	Assert.assertEquals("14 / 110", driver.findElement(By.xpath(Geo_Portal.label_Page_No)).getText());
  }  
  @Test(priority=36, description="To verify that user is able to perform 'map/Atlas Services' link.")
  public void NATMO_Geoportal_36(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on particular map atlas service dataset.");
		  driver.findElement(By.xpath(Geo_Portal.lnk_particular_map)).click();
		  Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should navigate on 'Natmo Geoportal' with selected map atlas services dataset.");
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
	      System.out.println(actualTitle);
		}
		} 
		String q=driver.findElement(By.xpath(Geo_Portal.label_Map_Geoportal)).getText();
		Assert.assertEquals("Ancient India (Physical)", q);	
  }
  @Test(priority=37, description="To verify that user is able to perform that 'search', 'sort by', 'show' functionality.")
  public void NATMO_Geoportal_37(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the 'map/atlas services' in search textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_Search_Map_Atlas_Service)).sendKeys("Irrigation");
		  Thread.sleep(2000);
	      ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the sort by order in 'Sort by' dropdown.");
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_sort_by));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("title");
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the show entries in 'Show' dropdown.");
		  WebElement testDropDown1 = driver.findElement(By.xpath(Geo_Portal.ddm_show_entries));  
		  Select dropdown1 = new Select(testDropDown1); 
		  dropdown1.selectByValue("24");
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Apply' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply)).click();
		  Thread.sleep(2000); 
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result.");
		  Assert.assertEquals("Irrigation",driver.findElement(By.xpath("//h4[@title=\"Irrigation\"]")).getText() );	  
  }
  @Test(priority=38, description="To verify that user is able to perform that 'search', 'sort by', 'show' functionality.")
  public void NATMO_Geoportal_38(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the 'map/atlas services' in search textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_Search_Map_Atlas_Service)).sendKeys("Irrigation");
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the sort by order in 'Sort by' dropdown.");
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_sort_by));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("title");
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the show entries in 'Show' dropdown.");
		  WebElement testDropDown1 = driver.findElement(By.xpath(Geo_Portal.ddm_show_entries));  
		  Select dropdown1 = new Select(testDropDown1); 
		  dropdown1.selectByValue("24");
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Apply' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply)).click();
		  Thread.sleep(2000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the searched result.");
		  Assert.assertEquals("Irrigation",driver.findElement(By.xpath("//h4[@title=\"Irrigation\"]")).getText() );	
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Reset' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Reset)).click();
		  Thread.sleep(2000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Searched result should be reset.");
		  Assert.assertNotEquals("Irrigation",driver.findElement(By.xpath("//h4[@title=\"Administrative\"]")).getText() );	 
  }
  @Test(priority=39, description="To verify that user is able to perform that 'List View' functionality.")
  public void NATMO_Geoportal_39(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'List View' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_list_view)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get result in list view.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.List_view)).isDisplayed());	
  }
  @Test(priority=40, description="To verify that user is able to perform 'Pagination' functionality.")
  public void NATMO_Geoportal_40(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'next' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Next_Page)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of map atlas service.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class=\"pager-current active\"]/span[text()=\"2\"]")).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Previous' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Previous_Page)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous page of map atlas service.");
		 Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class=\"pager-current active first\"]/span[text()=\"1\"]")).isDisplayed());
		 objss.Screenshot(driver, Classname ,method.getName()+"_03" );
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on particular page number.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Particular_Page)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular page of map atlas service.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class=\"pager-current active\"]/span[text()=\"7\"]")).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_04" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'last' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_last_Page)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get last page of map atlas service.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class=\"pager-current active last\"]/span[text()=\"104\"]")).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_05" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'First' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_First_Page)).click();
		  Thread.sleep(2000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get first page of map atlas service.");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//li[@class=\"pager-current active first\"]/span[text()=\"1\"]")).isDisplayed());
		  
  }
  @Test(priority=41, description="To verify that user is able to perform 'Edit' functionality from 'Filter by Map Extent' option.")
  public void NATMO_Geoportal_41(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Edit' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Edit)).click();
		  Thread.sleep(4000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Filter by Map Extent' option should be active.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.btn_Apply_FME)).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
		  driver.switchTo().frame(Geo_Portal.iframe);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Map Extent' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_map_extent)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Pan' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Pan)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Zoom In' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_in_FME)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Zoom Out' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_Out_FME)).click();
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Apply' button from filter by map extent option.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_FME)).click();
		  
  } 
  @Test(priority=42, description="To verify that user is able to perform filter option 'Map/Atlas' page.")
  public void NATMO_Geoportal_42() throws InterruptedException {
	  driver.switchTo().defaultContent();
		// ExtentTestManager.getTest().log(Status.INFO, "Move mouse hover on 'Map/Atlas Services' link.");
		  WebElement ele = driver.findElement(By.xpath(Geo_Portal.lnk_map_atlas_services));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).perform();
		  List<WebElement> element1 = driver.findElements(By.xpath("//li[@class=\"has-sub drop-left menu-link-map-atlas-services\"]/ul/li"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  String[] stringArray1 = { "All", "Atlas Services", "Map Services" };
		// ExtentTestManager.getTest().log(Status.INFO, "User should get list of Map/Atlas services like:All,Atlas Services, Map Services ");
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//li[@class=\"has-sub drop-left menu-link-map-atlas-services\"]/ul/li")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  } 
		  System.out.println("Original Array Elements:" + Arrays.toString(stringArray2)); 
		  Assert.assertEquals(stringArray2, stringArray1);	
		// ExtentTestManager.getTest().log(Status.INFO, "Click on 'All' link.");
		  driver.findElement(By.xpath(Geo_Portal.lnk_All)).click();
		  Thread.sleep(4000);
		 }
  @Test(priority=43, description="To verify that user is able to perform 'Administrative and Political' link.")
  public void NATMO_Geoportal_43(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
  @Test(priority=44, description="To verify that user is able to perform 'NSA-Administrative' link.")
  public void NATMO_Geoportal_44(Method method) throws InterruptedException {
	  driver.switchTo().defaultContent();
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
	   
	   String expectedTitle="NATMO Geoportal";
		  Assert.assertEquals(driver.getTitle(), expectedTitle);
		  
		 }
  @Test(priority=45, description="To verify that user is able to perform 'About Us' link.")
  public void NATMO_Geoportal_45() throws InterruptedException {
	  driver.switchTo().defaultContent();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'About us' link from home page.");
	  driver.findElement(By.xpath(Geo_Portal.lnk_About_Us)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on About Us page.");
	  Assert.assertEquals("About Us | National Atlas & Thematic Mapping Organisation", driver.getTitle());  
		 
		 }
  @Test(priority=46, description="To verify that user is able to perform collapse/expand functionality for dashboard window.")
  public void NATMO_Geoportal_46(Method method) throws InterruptedException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Dashboard' icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_dashboard_collapse)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should collapse of dashboard window as per selection.");
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.dashboard_collapse)).isDisplayed()); 
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Dashboard' icon.");
	 driver.findElement(By.xpath(Geo_Portal.btn_dashboard_expand)).click();
		  Thread.sleep(4000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should expand of dashboard window as per selection.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.dashboard_expand)).isDisplayed());  
  } 
  @Test(priority=47, description="To verify that user is able to perform 'Pointer' functionality.")
  public void NATMO_Geoportal_47() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'pointer' icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_pointer)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Pointer functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\" Pointer\"]")).isDisplayed());  
 }
  @Test(priority=48, description="To verify that user is able to perform 'Identify'tool functionality.")
  public void NATMO_Geoportal_48(Method method) throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Identify' icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_identify)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Identify functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\" Identify\"]")).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on particular attribute on map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(950,220).click().perform();
		  Thread.sleep(6000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the 'Feature info' pop up.");
		  Assert.assertEquals("visible",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
 }
  @Test(priority=49, description="To verify that user is able to close the 'Feature info' pop up.")
  public void NATMO_Geoportal_49(Method method) throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Identify' icon.");
	  driver.findElement(By.xpath(Geo_Portal.btn_identify)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Identify functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\" Identify\"]")).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on particular attribute on map.");
	  Actions action = new Actions(driver);
	  action.moveByOffset(950,220).click().perform();
		  Thread.sleep(6000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the 'Feature info' pop up.");
		  Assert.assertEquals("visible",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on close button on 'Feature info' pop up.");
      driver.findElement(By.xpath("//div[@class=\"x-tool x-tool-close\"]")).click();
    ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should close the 'Feature info' pop up.");
      Assert.assertEquals("hidden",driver.findElement(By.xpath("//div[@class=\" gx-popup x-window x-resizable-pinned\"]")).getCssValue("visibility"));
      
 }
  @Test(priority=50, description="To verify that user is able to perform 'pan' functionality.")
  public void NATMO_Geoportal_50() throws InterruptedException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'pan' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_pan)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Pan functionality is activated");
		  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and text()=\" Pan\"]")).isDisplayed());
 }
  @Test(priority=51, description="To verify that user is able to perform 'Refresh' functionality.")
  public void NATMO_Geoportal_51(Method method) throws InterruptedException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on collapse button on layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Layer_Collapse)).click();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> layer panel should collapse as per selection.");
	  driver.findElement(By.xpath(Geo_Portal.Layer_panel_off)).isDisplayed();
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Refresh' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_refresh)).click();
      
 }
  @Test(priority=52, description="To verify that user is able to perform 'Zoom in' functionality.")
  public void NATMO_Geoportal_52(Method method) throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Zoom' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_zoom_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'zoom in' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_zoom_in_dashboard)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Zoom in functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and @title=\"Activate this tool to Zoom In\"]")).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Draw the area on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get specific zoom level on map.");
	  Assert.assertNotEquals("1:18000000", driver.findElement(By.xpath("//div[@id=\"scale-text\"]/a")).getText());
 }
  @Test(priority=53, description="To verify that user is able to perform 'Zoom out' functionality.")
  public void NATMO_Geoportal_53(Method method) throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Zoom' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_zoom_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'zoom in' functionality.");
	 driver.findElement(By.xpath(Geo_Portal.btn_zoom_in_dashboard)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Zoom in functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and @title=\"Activate this tool to Zoom In\"]")).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Draw the area on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get specific zoom level on map.");
	  Assert.assertNotEquals("1:18000000", driver.findElement(By.xpath("//div[@id=\"scale-text\"]/a")).getText());
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'zoom out' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_zoom_out_dashboard)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Draw the area on map.");
		  robot.mouseMove(950,220);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  Thread.sleep(3000);
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get specific zoom level on map.");
		  Assert.assertEquals("1:18000000", driver.findElement(By.xpath("//div[@id=\"scale-text\"]/a")).getText());
 }
  @Test(priority=54, description="To verify that user is able to perform 'Full Extent' functionality.")
  public void NATMO_Geoportal_54(Method method) throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Zoom' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_zoom_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'zoom in' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_zoom_in_dashboard)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Zoom in functionality is activated");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//a[@class=\"active\" and @title=\"Activate this tool to Zoom In\"]")).isDisplayed());
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Draw the area on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  Thread.sleep(3000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get specific zoom level on map.");
	  Assert.assertNotEquals("1:18000000", driver.findElement(By.xpath("//div[@id=\"scale-text\"]/a")).getText());
	  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Full Extent' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_full_extent)).click();
		  Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get view map in full extended format.");
		  String aa = driver.findElement(By.xpath("//div[@id=\"scale-text\"]/a")).getText();
		  System.out.println(aa);
		  Assert.assertNotEquals("1:18000000", aa);
 }
  @Test(priority=55, description="To verify that user is able to perform 'Swipe By Layer' functionality.")
  public void NATMO_Geoportal_55() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Layer' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Swipe on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.delay(1500);
		  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  System.out.println(a1);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
		  Assert.assertNotEquals(a1,a2);
		
		  
 }
  @Test(priority=56, description="To verify that user is able stop the 'Swipe By Layer' functionality.")
  public void NATMO_Geoportal_56() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Layer' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Swipe By Layer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'OK' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe pop up should close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=57, description="To verify that user is able close the start/stop popup swipe by layer functionality.")
  public void NATMO_Geoportal_57() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Layer' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Close' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Stop swipe pop up should be close.");	
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Swipe By Layer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
		  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'close' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe pop up should be close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=58, description="To verify that user is not able to perform swipe by layer functionality without select layer.")
  public void NATMO_Geoportal_58() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Swipe By Layer' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get suggestion pop up like 'Select Proper Layer Before Swipe Start'.");	
     Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.val_message_swipe_popup)).isDisplayed(), true);	  
		   }
  @Test(priority=59, description="To verify that user is able to perform 'Swipe By Horizontal' functionality.")
  public void NATMO_Geoportal_59() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Horizontal' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Swipe on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.delay(1500);
		  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  System.out.println(a1);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
		  Assert.assertNotEquals(a1,a2);
}
  @Test(priority=60, description="To verify that user is able stop the 'Swipe By horizontal' functionality.")
  public void NATMO_Geoportal_60() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Horizontal' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Swipe By Horizontal' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'OK' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe horizantal pop up should close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=61, description="To verify that user is able close the start/stop popup swipe by horizontal functionality.")
  public void NATMO_Geoportal_61() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Horizontal' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Close' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Stop swipe pop up should be close.");	
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Swipe By Horizontal' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'close' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe pop up should be close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=62, description="To verify that user is not able to perform swipe by horizontal functionality without select layer.")
  public void NATMO_Geoportal_62() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Swipe By Horizontal' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_horizontal)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get suggestion pop up like 'Select Proper Layer Before Swipe Start'.");	
     Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"Select Proper Layer Before Swipe Horizontal Start\"]")).isDisplayed(), true);	  
		   }
  @Test(priority=63, description="To verify that user is able to perform 'Swipe By Pointer' functionality.")
  public void NATMO_Geoportal_63() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Pointer' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Swipe on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.delay(1500);
		  String a1 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  System.out.println(a1);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  String a2 = driver.findElement(By.xpath("//div[@id=\"OpenLayers_Layer_WMS_88\"]")).getCssValue("clip");
		  Thread.sleep(3000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected layer should be swipe as per mouse moves on map.");
		  Assert.assertNotEquals(a1,a2);
}
  @Test(priority=64, description="To verify that user is able stop the 'Swipe By Pointer' functionality.")
  public void NATMO_Geoportal_64() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Pointer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'OK' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Swipe By Pointer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
		  Thread.sleep(3000); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'OK' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_ok_swipe_popup)).click(); 
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe pop up should close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=65, description="To verify that user is able close the start/stop popup swipe by pointer functionality.")
  public void NATMO_Geoportal_65() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Select the particular layer from layer panel.");
	  driver.findElement(By.xpath(Geo_Portal.btn_label_International_Boundary_layer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Swipe By Pointer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Close' button of the start swipe popup.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Stop swipe pop up should be close.");	
		  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Move mouse hover a 'swipe' functionality.");
		  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
		  action.moveToElement(ele1).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Swipe By Pointer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'close' button of the start swipe pop up.");
			  driver.findElement(By.xpath(Geo_Portal.btn_close_swipe_popup)).click(); 
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Stop swipe pop up should be close.");	
			  Assert.assertEquals(driver.findElement(By.xpath(Geo_Portal.dialog_swipe_popup)).isDisplayed(), false);	  
		   }
  @Test(priority=66, description="To verify that user is not able to perform swipe by pointer functionality without select layer.")
  public void NATMO_Geoportal_66() throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover a 'swipe' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_swipe_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Swipe By Pointer' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_swipe_by_pointer)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get suggestion pop up like 'Select Proper Layer Before Swipe Start'.");	
     Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"Select Proper Layer Before Swipe Pointer Start\"]")).isDisplayed(), true);	  
		   }
  @Test(priority=67, description="To verify that user is able to perform 'Coordinates' functionality with select 'DMS' option.")
  public void NATMO_Geoportal_67() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter the longitude values in 'DMS' text box.' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_d)).sendKeys("73");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_m)).sendKeys("11");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_s)).sendKeys("23");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the latitude values in 'DMS' text box.' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_d)).sendKeys("21");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_m)).sendKeys("30");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_s)).sendKeys("36");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the zoom level on 'Zoom' drop down."); 
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_zoom));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("12000000");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the check box of 'Remember Locations'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_remember_loc)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the check box of 'Remember markers on close'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_gtc_clear_marker)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Go' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_gtc_go)).click(); 
	   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the pin point on map selected coordinates.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_Pin_point)).isDisplayed());    
  }
  @Test(priority=68, description="To verify that user is able to perform remove markers using 'Remove Markers' option.")
  public void NATMO_Geoportal_68(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter the longitude values in 'DMS' text box.");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_d)).sendKeys("73");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_m)).sendKeys("11");
		  driver.findElement(By.xpath(Geo_Portal.txt_long_s)).sendKeys("23");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the latitude values in 'DMS' text box.");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_d)).sendKeys("21");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_m)).sendKeys("30");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_s)).sendKeys("36");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the zoom level on 'Zoom' drop down."); 
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_zoom));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("12000000");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the check box of 'Remember Locations'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_remember_loc)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the check box of 'Remember markers on close'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_gtc_clear_marker)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Go' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_gtc_go)).click(); 
		  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
		  System.out.println(element.size());
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the pin point on map selected coordinates.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_Pin_point)).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Remove Markers' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_rm_marker)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Pin point should be remove on map.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
		  System.out.println(element1.size());
		  Assert.assertNotEquals(element1.size(), element.size());
  }
  @Test(priority=69, description="To verify that user is able to perform 'Coordinates' functionality with select 'DD' option.")
  public void NATMO_Geoportal_69() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the radio button of 'DD' option.");
		  driver.findElement(By.xpath(Geo_Portal.chk_latlonl)).click();  
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the longitude values in 'Lon[Grad]' text box.");
		  driver.findElement(By.xpath(Geo_Portal. txt_long_grad)).sendKeys("73.19");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter the latitude values in 'Lat[Grad]' text box.");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_grad)).sendKeys("21.51");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the zoom level on 'Zoom' drop down."); 
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_zoom));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("12000000");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the check box of 'Remember Locations'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_remember_loc)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the check box of 'Remember markers on close'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_gtc_clear_marker)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Go' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_latlon_go)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the pin point on map selected coordinates.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_Pin_point)).isDisplayed());    
  }
  @Test(priority=70, description="To verify that user is able to perform remove markers using 'Remove Markers' option.")
  public void NATMO_Geoportal_70(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the radio button of 'DD' option.");
		  driver.findElement(By.xpath(Geo_Portal.chk_latlonl)).click();  
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the longitude values in 'Lon[Grad]' text box.");
		  driver.findElement(By.xpath(Geo_Portal. txt_long_grad)).sendKeys("73.19");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter the latitude values in 'Lat[Grad]' text box.");
		  driver.findElement(By.xpath(Geo_Portal.txt_lat_grad)).sendKeys("21.51");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the zoom level on 'Zoom' drop down."); 
		  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_zoom));  
		  Select dropdown = new Select(testDropDown); 
		  dropdown.selectByValue("12000000");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the check box of 'Remember Locations'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_remember_loc)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the check box of 'Remember markers on close'.");
		  driver.findElement(By.xpath(Geo_Portal.chk_gtc_clear_marker)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Go' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_latlon_go)).click(); 
		  List<WebElement> element = driver.findElements(By.xpath("//div/div/img"));
		  System.out.println(element.size());
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the pin point on map selected coordinates.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.img_Pin_point)).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Click on 'Remove Markers' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_rm_marker)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Pin point should be remove on map.");
		  List<WebElement> element1 = driver.findElements(By.xpath("//div/div/img"));
		  System.out.println(element1.size());
		  Assert.assertNotEquals(element1.size(), element.size());
  }
  @Test(priority=71, description="To verify that user is able to perform collapse/expand of 'Go To Coordinates' dialog.")
  public void NATMO_Geoportal_71() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on collapse button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_collapase_GTC)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse as per selection.");
		  Assert.assertEquals("none",  driver.findElement(By.xpath(Geo_Portal.btn_expand_GTC)).getCssValue("display")); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on expand button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_expand_GTC)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse as per selection.");
		  Assert.assertEquals("none",  driver.findElement(By.xpath(Geo_Portal.btn_collapase_GTC)).getCssValue("display"));		  
  }
  @Test(priority=72, description="To verify that user is able to close the 'Go To Coordinates' dialog.")
  public void NATMO_Geoportal_72() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on close button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_GTC)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Go To Coordinates' dialog should close.");
		  Assert.assertEquals("none",  driver.findElement(By.xpath("//div[@class=\"ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable two-column coordinatepopup\"]")).getCssValue("display"));		  
  }
  @Test(priority=73, description="To verify that user is able to perform 'Coordinates' functionality without select any values using 'DMS' option.")
  public void NATMO_Geoportal_73() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Coordinates' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Coordinates)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Go' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_gtc_go)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, 'Please enter valid value in DMS.'.");
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.val_message_GTC)).isDisplayed());		  
  }
  @Test(priority=77, description="To verify that user is able to perform 'Length' functionality using 'Foot/Mile' unit option.")
  public void NATMO_Geoportal_77() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Measure' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_measure_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover on 'Length' functionality.");
	  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_Length));
	  action.moveToElement(ele1).perform();
	  Thread.sleep(3000); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Foot/Mile' radio button.");
	  driver.findElement(By.xpath(Geo_Portal.chk_foot_mile)).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Length' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Length)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the line between two selected locations.");
	  System.out.println( driver.findElement(By.xpath(Geo_Portal.polyline)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polyline)).isDisplayed());	
  }
  @Test(priority=74, description="To verify that user is able to perform 'Length' functionality using 'Meter/km' unit option.")
  public void NATMO_Geoportal_74() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Measure' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_measure_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover on 'Length' functionality.");
	  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_Length));
	  action.moveToElement(ele1).perform();
	  Thread.sleep(3000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Meter/Km' radio button.");
	  driver.findElement(By.xpath("//div/div[2]/input[@name=\"measurementunit\"]")).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Length' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Length)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the line between two selected locations.");
	  System.out.println( driver.findElement(By.xpath(Geo_Portal.polyline)).isDisplayed());
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polyline)).isDisplayed());	
  }
  @Test(priority=75, description="To verify that user is able to perform 'Area' functionality using 'Sq.Foot/Sq.Mile' unit option.")
  public void NATMO_Geoportal_75() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Measure' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_measure_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover on 'Area' functionality.");
	  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_Area));
	  action.moveToElement(ele1).perform();
	  Thread.sleep(3000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Sq.Foot/Sq.Mile' radio button.");
	  driver.findElement(By.xpath("//div/div[1]/input[@name=\"measurementunit\"]")).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Area' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Area)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select more than two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the polygon between more than two selected locations.");
	  
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());	
  }
  @Test(priority=76, description="To verify that user is able to perform 'Area' functionality using 'Sq.Meter/Sq.Km' unit option.")
  public void NATMO_Geoportal_76() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Measure' functionality.");
	  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_measure_features));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  Thread.sleep(3000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Move mouse hover on 'Area' functionality.");
	  WebElement ele1 = driver.findElement(By.xpath(Geo_Portal.btn_Area));
	  action.moveToElement(ele1).perform();
	  Thread.sleep(3000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Sq.Meter/Sq.Km' radio button.");
	  driver.findElement(By.xpath("//div/div[2]/input[@name=\"measurementunit\"]")).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Area' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Area)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select more than two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the polygon between more than two selected locations.");
	  
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());	
  }
  @Test(priority=78, description="To verify that user is able to perform 'Set Scale' functionality.")
  public void NATMO_Geoportal_78() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'set scale' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Set_Scale)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the scale from 'Custom Scale' dropdown.");
	  WebElement testDropDown = driver.findElement(By.xpath(Geo_Portal.ddm_Custom_Scale));  
	  Select dropdown = new Select(testDropDown); 
	  dropdown.selectByValue("10000000");
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter the scale in 'User Define Scale' textbox.");
	  driver.findElement(By.xpath(Geo_Portal.txt_Define_Scale)).sendKeys("5000");
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Go' button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Go_Scale)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should change zoom in level of map with selected scale.") ;
	  System.out.println(driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText());
	  Assert.assertEquals("1:2000000", driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText() );	
  }
  @Test(priority=79, description="To verify that user is able to close  'Set Scale' dialog.")
  public void NATMO_Geoportal_79() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'set scale' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Set_Scale)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on close button.");
	  driver.findElement(By.xpath(Geo_Portal. btn_Close_SS)).click(); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'set Scale' dialog should be close.");
	  Assert.assertEquals("none", driver.findElement(By.xpath("//div[@class=\"ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable single-column\"]")).getCssValue("display") );	  
  } 
  @Test(priority=80, description="To verify that user is able to perform 'Draw Points' functinality.")
  public void NATMO_Geoportal_80() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
	  Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Points' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Points)).click(); 
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Draw the points on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(900,500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the draw points on map.");  
	  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.circle)).isDisplayed() );	  
  }
  @Test(priority=81, description="To verify that user is able to perform 'Draw Line' functinality.")
  public void NATMO_Geoportal_81() throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Line' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_line)).click(); 
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(1300,450);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw line on map.");
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polyline)).isDisplayed());  
  }
  @Test(priority=84, description="To verify that user is able to perform 'Draw Polygon' functinality.")
  public void NATMO_Geoportal_84() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b>Click on 'Draw Features' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
	  Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  robot.mouseMove(1200,400);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseMove(850,300);
	  robot.delay(1500);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
	  
	  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());  
  }
  @Test(priority=85, description="To verify that user is able to perform 'Draw Text Lable' functinality.")
  public void NATMO_Geoportal_85() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Text label' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Draw_text_label)).click(); 
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on particular attribute on map.");
	  Robot robot = new Robot();
	  robot.mouseMove(950,220);
	  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	  robot.delay(1500);
	  driver.findElement(By.xpath(Geo_Portal.txt_Attribute_label)).sendKeys("Testing");
	  driver.findElement(By.xpath(Geo_Portal.txt_Attribute_label)).sendKeys(Keys.ENTER);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the label on selected location on map.");
	  
	  Assert.assertEquals(true,  driver.findElement(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"text\"]/*[text()=\"Testing\"]")).isDisplayed());  
  }
  @Test(priority=86, description="To verify that user is able to perform 'Modify Geometry' functinality.")
  public void NATMO_Geoportal_86(Method method) throws InterruptedException, AWTException {
	   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Modify Geometry' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Modify_Geometry)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Modify the polygon Geometry on map.");
		  
		  driver.findElement(By.xpath(Geo_Portal.polygone)).click();
		  WebElement a1= driver.findElement(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"circle\"][5]"));	  
		  int xCoord1 = a1.getLocation().getX();
			 int yCoord1 = a1.getLocation().getY();
			 System.out.println(xCoord1 + "  " + yCoord1);
			 robot.mouseMove(1200,400);
			 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			 robot.mouseMove(1300,375);
			
			  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				 robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should modify the polygon Geometry on map.");		  
				  WebElement a2= driver.findElement(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"circle\"][5]"));	  
				  int xCoord2 = a2.getLocation().getX();
					 int yCoord2 = a2.getLocation().getY();
					 System.out.println(xCoord2 + "  " + yCoord2);
	 	Assert.assertNotEquals(xCoord1, xCoord2);
	 	Assert.assertNotEquals(yCoord1, yCoord2);
  }
  @Test(priority=87, description="To verify that user is able to perform 'clip' functinality.")
  public void NATMO_Geoportal_87(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		  driver.findElement(By.xpath(Geo_Portal.btn_Modify_Geometry)).click(); 
		  driver.findElement(By.xpath(Geo_Portal.polygone)).click();
		  List<WebElement> element1 = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"circle\"]"));
		  System.out.println(element1.size());
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Clip' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Clip)).click(); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the polygon for clip.");
		
		  robot.mouseMove(950,230);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1000,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(920,260);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should display the clip on selected polygon.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Modify_Geometry)).click(); 
		  driver.findElement(By.xpath(Geo_Portal.polygone)).click();
		  List<WebElement> element2 = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"circle\"]"));
		  System.out.println(element2.size());
		  Assert.assertNotEquals(element1.size(),element2.size());
 } 
 
  @Test(priority=89, description="To verify that user is able to perform 'Drag Geometry' functinality.")
  public void NATMO_Geoportal_89(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		  System.out.println(driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Drag Geometry' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Drag_Geometry)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Drag the polygon geometry on map.");
		  WebElement a1= driver.findElement(By.xpath(Geo_Portal.polygone));
		  WebElement a2= driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon));
		  Actions action = new Actions(driver);
		  action.clickAndHold(a1);
		  action.moveToElement(a2).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should able to drag the geometry on map.");
		  Assert.assertEquals("rgb(0,119,255)", driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		 
 }  
  @Test(priority=88, description="To verify that user is able to perform 'select Geometry' functinality.")
  public void NATMO_Geoportal_88(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		  System.out.println(driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'select Geometry' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Select_Geometry)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select polygon geometry on map.");
		  driver.findElement(By.xpath(Geo_Portal.polygone)).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should able to select the polygon geometry on map. 2.Selected geometry on map should display in orange color.");
		  System.out.println(driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		  Assert.assertEquals("rgb(255, 204, 0)", driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		 
 } 
  @Test(priority=90, description="To verify that user is able to perform 'Delete selected Geometries' functinality.")
  public void NATMO_Geoportal_90() throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
          ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed()); 
		  System.out.println(driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		  List<WebElement> element1 = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
		  System.out.println(element1.size());
		    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'select Geometry' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Select_Geometry)).click(); 
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select polygon geometry on map.");
		  driver.findElement(By.xpath(Geo_Portal.polygone)).click();
		  Thread.sleep(2000);
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Delete Selected Geometries' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Delete_selected_Geometry)).click();
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should delete the selected geometries on map.");
		  List<WebElement> element = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
		  System.out.println(element.size());
		  Assert.assertNotEquals(element1.size(),element.size()); 
 }  
  @Test(priority=91, description="To verify that user is able to perform 'Delete All Geometries' functinality.")
  public void NATMO_Geoportal_91(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Draw Features' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_Feature)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Polygon' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Draw_polygon)).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(850,300);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
          ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the draw polygon on map.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		  System.out.println(driver.findElement(By.xpath(Geo_Portal.polygone)).getCssValue("fill"));
		  List<WebElement> element1 = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
		  System.out.println(element1.size());
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Delete All Geometries' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Delete_All_Geometry)).click();
		   ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> All geometries should be deleted on map.");
		  List<WebElement> element = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
		  System.out.println(element.size());
		  Assert.assertEquals(element1.size(),element.size()); 
 }  
  
  @Test(priority=92, description="To verify that user is able to perform 'Grid On/Off' functinality on screen.")
  public void NATMO_Geoportal_92() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Grid On/Off' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Grid_On_Off)).click();
	  Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> User should view  the grid lines on screen."); 
	  Assert.assertEquals(true,driver.findElement(By.xpath(Geo_Portal.Grid_Lines )).isDisplayed()); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Grid On/Off'' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Grid_On_Off)).click();
		  Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should off the grid lines on screen."); 
		  
		  System.out.println(driver.findElement(By.xpath("//a[@title=\"On/Off Graticule\"]")).getCssValue("Class"));
		  Assert.assertEquals("",driver.findElement(By.xpath("//a[@title=\"On/Off Graticule\"]")).getCssValue("Class")); 
  }
  @Test(priority=93, description="To verify that user is able to perform 'Query Builder' functinality with 'All' query without spatial filter option.")
  public void NATMO_Geoportal_93() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(5000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  } 
  
  @Test(priority=94, description="To verify that user is able to perform 'Query Builder' functinality with 'Attribute query' without spatial filter option.")
  public void NATMO_Geoportal_94() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Attribute Query' radio button from 'Apply query On?' option.");
	  driver.findElement(By.xpath(Geo_Portal.radio_attrqur)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific fields.");
	  driver.findElement(By.xpath("//option[text()=\"Length\"]")).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the mathematical expression.");
	  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on unique values.");
		  driver.findElement(By.xpath("//option[text()=\"13.1470259116161\"]")).click();
		  driver.findElement(By.xpath("//textarea[@class=\"form-control values\"]")).sendKeys("\"Length\">='13.1470259116161'");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(5000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  } 
  @Test(priority=95, description="To verify that user is able to perform 'Query Builder' functinality with 'Attribute query' using 'within' spatial filter option.")
  public void NATMO_Geoportal_95() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Attribute Query' radio button from 'Apply query On?' option.");
	  driver.findElement(By.xpath(Geo_Portal.radio_attrqur)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific fields.");
	  driver.findElement(By.xpath("//option[text()=\"Length\"]")).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the mathematical expression.");
	  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on unique values.");
		  driver.findElement(By.xpath("//option[text()=\"202428.333062698\"]")).click();
		  driver.findElement(By.xpath("//textarea[@class=\"form-control values\"]")).sendKeys("\"Length\">='202428.333062698'");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the 'within' option for spatial filter.");
		  driver.findElement(By.xpath(Geo_Portal.radio_within)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the layer from layer drop down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_spatial_layers )).click();
		  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the fields from fields drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_spatial_layer_field-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\"Status\"]" )).click();	  
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the mathematical expression from the drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_query_operator-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\">=\"]" )).click();	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter buffer value in 'Buffer' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_buffer)).sendKeys("10000") ;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(20000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  } 
  
  @Test(priority=96, description="To verify that user is able to perform 'Query Builder' functinality with 'Attribute query' using 'intersects' spatial filter option.")
  public void NATMO_Geoportal_96() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Attribute Query' radio button from 'Apply query On?' option.");
	  driver.findElement(By.xpath(Geo_Portal.radio_attrqur)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific fields.");
	  driver.findElement(By.xpath("//option[text()=\"Length\"]")).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the mathematical expression.");
	  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on unique values.");
		  driver.findElement(By.xpath("//option[text()=\"202428.333062698\"]")).click();
		  driver.findElement(By.xpath("//textarea[@class=\"form-control values\"]")).sendKeys("\"Length\">='202428.333062698'");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the 'intersects' option for spatial filter.");
		  driver.findElement(By.xpath(Geo_Portal.radio_Intersects)).click();
		  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the layer from layer drop down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_spatial_layers )).click();
		  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the fields from fields drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_spatial_layer_field-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\"Status\"]" )).click();	  
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the mathematical expression from the drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_query_operator-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\">=\"]" )).click();	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter buffer value in 'Buffer' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_buffer)).sendKeys("10000") ;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(20000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  }
  @Test(priority=97, description="To verify that user is able to perform 'Query Builder' functinality with 'All' using 'within' spatial filter option.")
  public void NATMO_Geoportal_97() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'within' option for spatial filter.");
		  driver.findElement(By.xpath(Geo_Portal.radio_within)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the layer from layer drop down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_spatial_layers )).click();
		  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the fields from fields drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_spatial_layer_field-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\"Status\"]" )).click();	  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the mathematical expression from the drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_query_operator-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\">=\"]" )).click();	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter buffer value in 'Buffer' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_buffer)).sendKeys("1000") ;
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(15000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  }
  @Test(priority=98, description="To verify that user is able to perform 'Query Builder' functinality with 'All' using 'intersects' spatial filter option.")
  public void NATMO_Geoportal_98() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'intersects' option for spatial filter.");
		  driver.findElement(By.xpath(Geo_Portal.radio_Intersects)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the layer from layer drop down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_spatial_layers )).click();
		  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the fields from fields drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_spatial_layer_field-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\"Status\"]" )).click();	  
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select the mathematical expression from the drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_query_operator-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\">=\"]" )).click();	 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Enter buffer value in 'Buffer' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_buffer)).sendKeys("1000") ;
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
	  Thread.sleep(15000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
	  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));   
  }
  @Test(priority=99, description="To verify that user is able to perform 'Clear' functinality.")
  public void NATMO_Geoportal_99() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
	  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
	  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select the 'Attribute Query' radio button from 'Apply query On?' option.");
	  driver.findElement(By.xpath(Geo_Portal.radio_attrqur)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Double click on specific fields.");
	  driver.findElement(By.xpath("//option[text()=\"Length\"]")).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the mathematical expression.");
	  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Double click on unique values.");
		  driver.findElement(By.xpath("//option[text()=\"202428.333062698\"]")).click();
		  driver.findElement(By.xpath("//textarea[@class=\"form-control values\"]")).sendKeys("\"Length\">='202428.333062698'");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select the 'intersects' option for spatial filter.");
		  driver.findElement(By.xpath(Geo_Portal.radio_Intersects)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select the layer from layer drop down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_spatial_layers )).click();
		  driver.findElement(By.xpath("//li[text()=\"international boundary\"]" )).click();	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Select the fields from fields drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_spatial_layer_field-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\"Status\"]" )).click();	  
			ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Select the mathematical expression from the drop down.");
		  driver.findElement(By.xpath("//span[@id=\"select2-ddl_query_operator-container\"]" )).click();
		  driver.findElement(By.xpath("//li[text()=\">=\"]" )).click();	 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter buffer value in 'Buffer' textbox.");
		  driver.findElement(By.xpath(Geo_Portal.txt_buffer)).sendKeys("100") ;
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Click on 'Apply' button."); 
	  driver.findElement(By.xpath(Geo_Portal.btn_Clear_QB )).click();
	  Thread.sleep(5000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Selected fields should be clear.");  
	  Assert.assertEquals("",driver.findElement(By.xpath("//textarea[@class=\"form-control values\"]")).getText());   
  }
  @Test(priority=100, description="To verify that user is able to perform 'collapse/expand' functinality for 'Query Builder' dialog.")
  public void NATMO_Geoportal_100(Method method) throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on collapse/expand button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_collapse_QB )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
	  Assert.assertEquals("none",driver.findElement(By.xpath(Geo_Portal.btn_collapse_QB)).getCssValue("display"));
	  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on collapse/expand button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_expand_QB )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		  Assert.assertEquals("block",driver.findElement(By.xpath(Geo_Portal.btn_collapse_QB)).getCssValue("display"));   	
	
  }
  @Test(priority=101, description="To verify that user is able to perform 'Close' 'Query Builder' dialog.")
  public void NATMO_Geoportal_101() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on close button.");
	  driver.findElement(By.xpath(Geo_Portal.btn_close_QB )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should be closed.");
	  Assert.assertEquals("",driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).getCssValue("Class")); 	
  }
  @Test(priority=102, description="To verify that user is able to perform 'Locations'functionality from result tab.")
  public void NATMO_Geoportal_102(Method method) throws InterruptedException, AWTException {
        ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display")); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Locations'functionality from result tab."); 
		  driver.findElement(By.xpath("//tr[1]/td/a/i[@class=\"fa fa-map-marker\"]")).click(); 
		  Thread.sleep(5000);
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on particular on map.");
		  
  }
  @Test(priority=103, description="To verify that user is able to perform 'Clear'functionality from result tab.")
  public void NATMO_Geoportal_103(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));  
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Clear'functionality from result tab."); 
		  driver.findElement(By.xpath("//div[@id=\"div_qb_result_parent\"]/button[text()=\"Clear\"]")).click();
		  Thread.sleep(5000);
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should clear the all records display in result tab.");
		  Assert.assertEquals("block",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display"));  
  }
  @Test(priority=104, description="To verify that user is able to perform 'Pagination' functionality from result tab.")
  public void NATMO_Geoportal_104(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display")); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b>  Click on 'Next' functionality from result tab."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_next_QB)).click();
		  Thread.sleep(5000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get next page of result tab.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"Showing 5 to 8 of 792 entries\"]")).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Previous' functionality from result tab.");
		  driver.findElement(By.xpath(Geo_Portal.btn_previous_QB)).click();
		  Thread.sleep(5000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get previous page of result tab.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"Showing 1 to 4 of 792 entries\"]")).isDisplayed());
		  objss.Screenshot(driver, Classname ,method.getName()+"_03" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on particular page no.");
		  driver.findElement(By.xpath(Geo_Portal.btn_3_page_QB)).click();
		  Thread.sleep(5000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get particular page of result tab.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"Showing 9 to 12 of 792 entries\"]")).isDisplayed()); 
  }
  @Test(priority=105, description="To verify that user is able to perform 'Sorting' functionality from result tab.")
  public void NATMO_Geoportal_105(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display")); 
		  List<WebElement> element1 = driver.findElements(By.xpath("//tbody/tr/td[8]"));
		  System.out.println(element1.size());
		  String[] stringArray2 = new String[element1.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray2[i]=driver.findElements(By.xpath("//tbody/tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray2[i]);
			  }  
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on any column title");
		  driver.findElement(By.xpath("//th[text()=\"objectid\"]")).click();
		  driver.findElement(By.xpath("//th[text()=\"objectid\"]")).click();
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
		 
		  List<WebElement> element2 = driver.findElements(By.xpath("//tbody/tr/td[8]"));
		  System.out.println(element2.size());
		  String[] stringArray3 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray3[i]=driver.findElements(By.xpath("//tbody/tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element1.size(); i++) {
				 
			  System.out.println(stringArray3[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray2);
		  objss.Screenshot(driver, Classname ,method.getName()+"_02" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on any column title");
		  driver.findElement(By.xpath("//th[text()=\"objectid\"]")).click();
		  
		  Thread.sleep(2000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get records in Ascending/Descending order.");
		 
		  List<WebElement> element4 = driver.findElements(By.xpath("//tbody/tr/td[8]"));
		  System.out.println(element4.size());
		  String[] stringArray4 = new String[element2.size()];
		  for(int i =0; i<element1.size(); i++) {
			 
			 stringArray4[i]=driver.findElements(By.xpath("//tbody/tr/td[8]")).get(i).getText();
			 Thread.sleep(2000);
		  } 
		  for(int i =0; i<element4.size(); i++) {
				 
			  System.out.println(stringArray4[i]);
			  } 
		  Assert.assertNotEquals(stringArray3,stringArray4);
  }
  @Test(priority=106, description="To verify that user is able to perform 'Show on Enties' functionality from result tab.")
  public void NATMO_Geoportal_106(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display")); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "S<b>Step-4:</b> elect entries on 'Show on entries' drop down."); 
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\"tbl_qb_result_length\"]")));  
		  dropdown.selectByValue("10");  
		  Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the selected no. of entries in one page.");
		  List<WebElement> element = driver.findElements(By.xpath("//tbody/tr/td[8]"));
		  System.out.println(element.size());
		  Thread.sleep(5000);
		  Assert.assertEquals(11,element.size());
  }
  @Test(priority=107, description="To verify that user is able to perform 'Search' functionality from result tab.")
  public void NATMO_Geoportal_107(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Query Builder' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Query_Builder )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Target layer' drop-down.");
		  driver.findElement(By.xpath(Geo_Portal.ddl_Target_Layer )).click();
		  driver.findElement(By.xpath("//li[text()=\"state and union territory boundary\"]" )).click();	    
			 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Apply' button."); 
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_QB )).click();
		  Thread.sleep(10000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should display the result on result tab. 2.User should get the records on map with specific zoom level.");  
		  Assert.assertEquals("none",driver.findElement(By.xpath("//div[@id=\"tabs-1\"]")).getCssValue("display")); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter result in search textbox."); 
		  driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("756");
		  Thread.sleep(5000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get only searched records in result tab.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//td[text()=\"1033\"]")).isDisplayed());
  }
  @Test(priority=108, description="To verify that user is able to perform 'Create My Map' functionality.")
  public void NATMO_Geoportal_108() throws InterruptedException, AWTException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Create My Map' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).click();
	  Thread.sleep(1000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Layer' drop down.");
	  Select dropdown = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_boundary\"]")));  
	  dropdown.selectByVisibleText("ALL India State Boundary"); 
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Upload the 'CSV File' in browser section.");
	  WebElement upload_file =  driver.findElement(By.xpath(Geo_Portal.btn_Upload_CSV ));

	  upload_file.sendKeys("C:/Users/meet.g/Downloads/ALL India State Boundary.csv");
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the value column from 'Value Column' drop down.");	  
	  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_valuecolumn\"]")));  
	  dropdown1.selectByVisibleText("code");  
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the classify from 'Classify' drop down.");
	  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_classify\"]")));  
	  dropdown2.selectByVisibleText("Quantities"); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'Apply' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Apply_CMP)).click(); 
  }
  @Test(priority=109, description="To verify that user is able to perform 'Clear' functionality.")
  public void NATMO_Geoportal_109() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Create My Map' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select the layer from 'Layer' drop down.");
		  Select dropdown = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_boundary\"]")));  
		  dropdown.selectByVisibleText("ALL India State Boundary"); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Upload the 'CSV File' in browser section.");
		  WebElement upload_file =  driver.findElement(By.xpath(Geo_Portal.btn_Upload_CSV ));

		  upload_file.sendKeys("C:/Users/meet.g/Downloads/ALL India State Boundary.csv");
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Select the value column from 'Value Column' drop down.");	  
		  Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_valuecolumn\"]")));  
		  dropdown1.selectByVisibleText("code");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select the classify from 'Classify' drop down.");
		  Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_classify\"]")));  
		  dropdown2.selectByVisibleText("Quantities");  
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Click on 'clear' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Clear_CMP)).click(); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 1.User should clear the all selected values from 'Create My Map' dialog. 2.Layer should not clear from layer drop down.");
		  Assert.assertEquals(false,driver.findElement(By.xpath("//select[@data-select2-id=\"ddl_map_valuecolumn\"]")).isDisplayed());
  }
  @Test(priority=110, description="To verify that user is able 'Download CSV' file.")
  public void NATMO_Geoportal_110() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Create My Map' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Download CSV' button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Download_CSV )).click(); 
		
  }
  @Test(priority=111, description="To verify that user is able to perform 'collapse/expand' functionality.")
  public void NATMO_Geoportal_111(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Create My Map' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'collapse/expand' button.");
		  driver.findElement(By.xpath(Geo_Portal. btn_collapse_CMP )).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		  Assert.assertEquals("block",driver.findElement(By.xpath(Geo_Portal.btn_expand_CMP)).getCssValue("display"));
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on collapse/expand button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_expand_CMP )).click();
		  Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		 Assert.assertEquals("none",driver.findElement(By.xpath(Geo_Portal.btn_expand_CMP)).getCssValue("display")); 
  }
  @Test(priority=112, description="To verify that user is able to perform 'close' functionality.")
  public void NATMO_Geoportal_112() throws InterruptedException, AWTException {
	    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Create My Map' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on close button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_CMP)).click();
		  Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Create My Map' Dialog should close.");
		  Assert.assertEquals("",driver.findElement(By.xpath(Geo_Portal.btn_create_My_Map )).getCssValue("Class")); 	
  }
  @Test(priority=113, description="To verify that user is able to perform the 'Elevation Profile' functionality.")
  public void NATMO_Geoportal_113() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Elevation Profile' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Elevation_profile )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Line' feature.");
		  driver.findElement(By.xpath(Geo_Portal.btn_draw_EP )).click();
		  Thread.sleep(1000);	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select two locations on map.");
		  
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Elevation Profile (DEM) dialog should open at bottom panel.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//a[@title=\"Create Elevation Profile\"]" )).isDisplayed()); 	
  }
  @Test(priority=114, description="To verify that user is able to perform the collapse/expand functionality 'Elevation Profile' dialog .")
  public void NATMO_Geoportal_114(Method method) throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Elevation Profile' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Elevation_profile )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Line' feature.");
		  driver.findElement(By.xpath(Geo_Portal.btn_draw_EP )).click();
		  Thread.sleep(1000);	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select two locations on map.");
		  
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Elevation Profile (DEM) dialog should open at bottom panel.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//a[@title=\"Create Elevation Profile\"]" )).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'collapse/expand' button.");
		  driver.findElement(By.xpath(Geo_Portal. btn_collapse_EP )).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		  Assert.assertEquals("block",driver.findElement(By.xpath(Geo_Portal.btn_expand_EP)).getCssValue("display"));
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on collapse/expand button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_expand_EP )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		 Assert.assertEquals("none",driver.findElement(By.xpath(Geo_Portal.btn_expand_EP)).getCssValue("display"));  
  }
  @Test(priority=115, description="To verify that user is able to perform the close functionality 'Elevation Profile' dialog .")
  public void NATMO_Geoportal_115(Method method) throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Elevation Profile' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Elevation_profile )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Draw Line' feature.");
		  driver.findElement(By.xpath(Geo_Portal.btn_draw_EP )).click();
		  Thread.sleep(1000);	
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click and select two locations on map.");
		  
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Elevation Profile (DEM) dialog should open at bottom panel.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//a[@title=\"Create Elevation Profile\"]" )).isDisplayed()); 
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on close button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_EP)).click();
		  Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Create My Map' Dialog should close.");
		  Assert.assertEquals("",driver.findElement(By.xpath(Geo_Portal.btn_Elevation_profile )).getCssValue("Class")); 	
  }
  @Test(priority=116, description="To verify that user is able to perform 'Zoom Previous' functionality from bottom panel.")
  public void NATMO_Geoportal_116() throws InterruptedException, AWTException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Zoom Next' functionality.");
	  String a1 = driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText();
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_Next )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Zoom Previous' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_Previous )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the previous zoom level of map.");
		  Assert.assertEquals(a1, driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText()); 		
  }
  @Test(priority=117, description="To verify that user is able to perform 'Zoom Next' functionality from bottom panel.")
  public void NATMO_Geoportal_117() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Zoom Next' functionality.");
	  String a1 = driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText();
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_Next )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the next zoom level of map.");
		  Assert.assertNotEquals(a1, driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText()); 		
  }
  @Test(priority=118, description="To verify that user is able to perform 'Zoom In' functionality from bottom panel.")
  public void NATMO_Geoportal_118() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Zoom Next' functionality.");
	  String a1 = driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText();
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_In )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the next zoom level of map.");
		  Assert.assertNotEquals(a1, driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText()); 		
  }
  @Test(priority=119, description="To verify that user is able to perform 'Zoom out' functionality from bottom panel.")
  public void NATMO_Geoportal_119() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Zoom Next' functionality.");
	  String a1 = driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText();
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_In )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Zoom Out' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Zoom_Out )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the previous zoom level of map.");
		  Assert.assertEquals(a1, driver.findElement(By.xpath("//a[@class=\"open-scale-window\"]")).getText()); 		
  }
  @Test(priority=120, description="To verify that user is able to perform 'Current Location' functionality from bottom panel.")
  public void NATMO_Geoportal_120() throws InterruptedException, AWTException {
	    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Current Location' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Current_Location)).click();
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the 'Current Location' functionality.");
		  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.btn_Current_Location)).isDisplayed()); 		
  }
  @Test(priority=121, description="To verify that user is able to perform 'Clear Selection' functionality from bottom panel.")
  public void NATMO_Geoportal_121(Method method) throws InterruptedException, AWTException {
	    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Move mouse hover on 'Measure' functionality.");
		  WebElement ele = driver.findElement(By.xpath(Geo_Portal.btn_measure_features));
		  Actions action = new Actions(driver);
		  action.moveToElement(ele).perform();
		  Thread.sleep(3000); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Area' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Area)).click(); 
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Select more than two location on map.");
		  Robot robot = new Robot();
		  robot.mouseMove(950,220);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.delay(1500);
		  robot.mouseMove(1200,400);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  robot.mouseMove(1300,450);
		  robot.delay(1500);
		  robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the polygon between more than two selected locations.");
		  
		  Assert.assertEquals(true,  driver.findElement(By.xpath(Geo_Portal.polygone)).isDisplayed());	
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
				 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Click on 'Clear Selection' functionality.");
					  driver.findElement(By.xpath(Geo_Portal.btn_Clear_selection)).click();
					 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get the 'Clear selection' functionality.");
					  Assert.assertEquals(true, driver.findElement(By.xpath(Geo_Portal.btn_Clear_selection)).isDisplayed()); 	
  }
  @Test(priority=122, description="To verify that user is able to perform 'Legend' functionality from bottom panel.")
  public void NATMO_Geoportal_122() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b>  Click on 'Legend' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Legend)).click();
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b>User should get the dialog of 'Legend' functionality.");
	  Assert.assertEquals(true, driver.findElement(By.xpath("//span[text()=\"Legend\"]")).isDisplayed());
			  	
  }
  @Test(priority=123, description="To verify that user is able to perform 'collapse/expand' for legend dialog.")
  public void NATMO_Geoportal_123(Method method) throws InterruptedException, AWTException {
	    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Legend' functionality.");
		  driver.findElement(By.xpath(Geo_Portal.btn_Legend)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'collapse/expand' button.");
		  driver.findElement(By.xpath(Geo_Portal. btn_collapse_Legend )).click(); 
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		  Assert.assertEquals("block",driver.findElement(By.xpath(Geo_Portal.btn_expand_Legend)).getCssValue("display"));
		  objss.Screenshot(driver, Classname ,method.getName()+"_01" );
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b>Click on collapse/expand button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_expand_Legend )).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Dialog should collapse/expand as per selection.");
		 Assert.assertEquals("none",driver.findElement(By.xpath(Geo_Portal.btn_expand_Legend)).getCssValue("display")); 
  }
  @Test(priority=124, description="To verify that user is able to perform 'close' functionality for legend dialog..")
  public void NATMO_Geoportal_124() throws InterruptedException, AWTException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Legend' functionality.");
	  driver.findElement(By.xpath(Geo_Portal.btn_Legend)).click();
	  Thread.sleep(5000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on close button.");
		  driver.findElement(By.xpath(Geo_Portal.btn_close_Legend)).click();
		  Thread.sleep(1000);
		 ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> 'Create My Map' Dialog should close.");
		  Assert.assertEquals("",driver.findElement(By.xpath(Geo_Portal.btn_Legend )).getCssValue("Class")); 	
  }
  @Test(priority=125, description="To verify that user is able to get current 'Longitude/latitude' value at footer panel.")
  public void NATMO_Geoportal_125() throws InterruptedException, AWTException {
	
		 ExtentTestManager.getTest().log(Status.INFO, "User should get the current 'Longitude/latitude' value at footer panel.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"EPSG:4326\"]")).isDisplayed());
		  
  }
  @Test(priority=126, description="To verify that user is able to get current version information of application at footer panel.")
  public void NATMO_Geoportal_126() throws InterruptedException, AWTException {
	
		 ExtentTestManager.getTest().log(Status.INFO, "User should get the current version information of application at footer panel.");
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"Lat:\"]")).isDisplayed());
		  Assert.assertEquals(true,driver.findElement(By.xpath("//div[text()=\"Long:\"]")).isDisplayed()); 
  }
  

  @AfterMethod
  public void afterClass() {
	 
	driver.quit();
  }

}
