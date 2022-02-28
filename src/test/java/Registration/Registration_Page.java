package Registration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import Home_Page_R.*;
import Listener.ExtentTestManager;
import Login_R.*;
import Registration_R.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class Registration_Page {
	Homepage obj = new Homepage();
	Login_In obj1 = new Login_In();
	Registration_page obj2= new Registration_page();
	WebDriver driver;

  @BeforeMethod
  public void openBrowser(ITestContext context) {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(Homepage.URL);
  }
  
 @Test(priority=1, description="To verify that user is able to get 'Register' page.")
 public void NATMO_Register_01() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Create New Account' page. Buttons:Sign In, Forgot Password and Forgot Username. ");
	  boolean found =  driver.findElement(By.xpath(Homepage.label_register)).isDisplayed();
	  Assert.assertEquals(found,true);
	  driver.findElement(By.xpath(Registration_page.label_salution)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.ddl_salution)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_first_name)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_first_name)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_last_name)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_last_name)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_gender)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.ddl_gender)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_educational_qua)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.ddl_educational_qua)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_Profession)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.ddl_Profession)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_other_profession)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_other_profession)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_Organization)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_other_Organization)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_other_Organization)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_Mobile_No)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_Mobile_No)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_username)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_username)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_Email_add)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_Email_add)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_password)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_password)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_confirm_pass)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_confirm_pass)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_about)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txtarea_about)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_RWI)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.chk_RWI)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_subscribe)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.chk_subscribe)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.label_captcha)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.txt_captcha)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.btn_create_new_account)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.btn_forgot_password)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.btn_sign_in)).isDisplayed();
	  Thread.sleep(1000); 
	  driver.findElement(By.xpath(Registration_page.btn_forgot_username)).isDisplayed();
	  Thread.sleep(1000); 
	  
	 
 }
 @Test(priority=2, description="To verify that user is able to perform 'Create New Account' functionality.")
 public void NATMO_Register_02() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select a salutation value from 'Salutation' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_salution)).click();
	  Select dropdown = new Select(driver.findElement(By.xpath(Registration_page.ddl_salution)));  
	  dropdown.selectByVisibleText("Mr.");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid first name in 'First Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_first_name)).sendKeys("meet");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid last name in 'Last Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_last_name)).sendKeys("Gondaliya");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select a gender from 'Gender' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_gender)).click();
	  Select dropdown1 = new Select(driver.findElement(By.xpath(Registration_page.ddl_gender)));  
	  dropdown1.selectByVisibleText("Male");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select an Educational Qualification from 'Educational Qualification' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_educational_qua)).click();
	  Select dropdown2 = new Select(driver.findElement(By.xpath(Registration_page.ddl_educational_qua)));  
	  dropdown2.selectByVisibleText("Graduate");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select a Profession from 'Profession' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown4= new Select(driver.findElement(By.xpath(Registration_page.ddl_Profession)));  
	  dropdown4.selectByVisibleText("Engineer");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select an Organization  from 'Organization' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown3= new Select(driver.findElement(By.xpath(Registration_page.ddl_Organization)));  
	  dropdown3.selectByVisibleText("Others");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid mobile no in 'Mobile No' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Mobile_No)).sendKeys("9023328797");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid username in 'Username' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_username)).sendKeys("Meetgemss");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid E-mail address in 'E-mail Address' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Email_add)).sendKeys("mgondaliya1210@gmail.com");;
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter valid password in 'password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_password)).sendKeys("Asd@1233455");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter valid confirm password in 'Confirm password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_confirm_pass)).sendKeys("Asd@1233455");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter valid math question in 'Math question' textbox.");
	  String capcha = driver.findElement(By.xpath("//span[@class=\"field-prefix\"]")).getText();
	  System.out.println(capcha);
	  String removespace = capcha.replaceAll("\\s+", "");  
	  if(removespace.contains("+")) {
      // get two numbers   
      String[] parts = removespace.split("\\+");  
      String part1 = parts[0];  
      String part2 = parts[1];  
      String[] parts1 = part2.split("\\=");  
      String part11 = parts1[0];  

      // sum two numbers  
     int summation = Integer.parseInt(part1) + Integer.parseInt(part11);  
     String s=String.valueOf(summation);  
     System.out.println(s);
     Thread.sleep(3000);
     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
     Thread.sleep(5000);
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
	  }
	  else if(removespace.contains("*")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\*");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) * Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  else if(removespace.contains("-")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\-");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) - Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  else if(removespace.contains("/")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\/");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) / Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get success message on Home Page.");
 }

 @Test(priority=3, description="To verify that user is able to get 'Forgot Password' page.")
 public void NATMO_Register_03() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Registration_page.btn_forgot_password)).click();
	  Thread.sleep(5000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Password' page");
	  driver.findElement(By.xpath(Login_In.label_forgot_password)).isDisplayed();
	 
 }
 @Test(priority=4, description="To verify that user is able to get 'Sign In' page.")
 public void NATMO_Register_04() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Sign In' button.");
	  driver.findElement(By.xpath(Registration_page.btn_sign_in)).click();
	  Thread.sleep(5000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Sign In' page");
	  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	 
 }
 @Test(priority=5, description="To verify that user is able to get 'Forgot Password' page.")
 public void NATMO_Register_05() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Username' button.");
	  driver.findElement(By.xpath(Registration_page.btn_forgot_username)).click();
	  Thread.sleep(5000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Username' page");
	  driver.findElement(By.xpath(Login_In.label_forgot_username)).isDisplayed(); 
 }
 @Test(priority=6, description="To verify that user is not able to 'Create New Account' in NATMO application with blank credentials.")
 public void NATMO_Register_06() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();

	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation message.");
	  driver.findElement(By.xpath(Registration_page.label_validation_username)).isDisplayed(); 
	  driver.findElement(By.xpath(Registration_page.label_validation_email)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_password)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page. label_validation_firstname)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_lastname)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_salutation)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_organization)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_educational)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_captcha)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_mobile)).isDisplayed();
	  driver.findElement(By.xpath(Registration_page.label_validation_profession)).isDisplayed();
 }
 @Test(priority=7, description="To verify that user is not able to 'Create New Account' in NATMO application with valid password and invalid confirm password.")
 public void NATMO_Register_07() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select a salutation value from 'Salutation' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_salution)).click();
	  Select dropdown = new Select(driver.findElement(By.xpath(Registration_page.ddl_salution)));  
	  dropdown.selectByVisibleText("Mr.");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid first name in 'First Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_first_name)).sendKeys("meet");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid last name in 'Last Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_last_name)).sendKeys("Gondaliya");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select a gender from 'Gender' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_gender)).click();
	  Select dropdown1 = new Select(driver.findElement(By.xpath(Registration_page.ddl_gender)));  
	  dropdown1.selectByVisibleText("Male");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select an Educational Qualification from 'Educational Qualification' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_educational_qua)).click();
	  Select dropdown2 = new Select(driver.findElement(By.xpath(Registration_page.ddl_educational_qua)));  
	  dropdown2.selectByVisibleText("Graduate");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select a Profession from 'Profession' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown4= new Select(driver.findElement(By.xpath(Registration_page.ddl_Profession)));  
	  dropdown4.selectByVisibleText("Engineer");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select an Organization  from 'Organization' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown3= new Select(driver.findElement(By.xpath(Registration_page.ddl_Organization)));  
	  dropdown3.selectByVisibleText("Others");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid mobile no in 'Mobile No' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Mobile_No)).sendKeys("9023328797");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid username in 'Username' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_username)).sendKeys("Meetgemss");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid E-mail address in 'E-mail Address' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Email_add)).sendKeys("mgondaliya1210@gmail.com");;
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter valid password in 'password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_password)).sendKeys("Asd@1233455");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter invalid confirm password in 'Confirm password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_confirm_pass)).sendKeys("Asd@1233455666");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter valid math question in 'Math question' textbox.");
	  String capcha = driver.findElement(By.xpath("//span[@class=\"field-prefix\"]")).getText();
	  System.out.println(capcha);
	  String removespace = capcha.replaceAll("\\s+", "");  
	  if(removespace.contains("+")) {
      // get two numbers   
      String[] parts = removespace.split("\\+");  
      String part1 = parts[0];  
      String part2 = parts[1];  
      String[] parts1 = part2.split("\\=");  
      String part11 = parts1[0];  

      // sum two numbers  
     int summation = Integer.parseInt(part1) + Integer.parseInt(part11);  
     String s=String.valueOf(summation);  
     System.out.println(s);
     Thread.sleep(3000);
     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
     Thread.sleep(5000);
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
	  }
	  else if(removespace.contains("*")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\*");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) * Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  else if(removespace.contains("-")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\-");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) - Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  else if(removespace.contains("/")) {
	      // get two numbers   
	      String[] parts = removespace.split("\\/");  
	      String part1 = parts[0];  
	      String part2 = parts[1];  
	      String[] parts1 = part2.split("\\=");  
	      String part11 = parts1[0];  

	      // sum two numbers  
	     int summation = Integer.parseInt(part1) / Integer.parseInt(part11);  
	     String s=String.valueOf(summation);  
	     System.out.println(s);
	     Thread.sleep(3000);
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  }
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation meesage like, ");
	  driver.findElement(By.xpath("//div[text()=\"Passwords match: \"]")).isDisplayed();
	  driver.findElement(By.xpath("//li[text()=\"The specified passwords do not match.\"]")).isDisplayed();
 }
 @Test(priority=8, description="To verify that user is not able to 'Create New Account' in NATMO application with invalid math question.")
 public void NATMO_Register_08() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Register' functionality from the top panel.");
	 driver.findElement(By.xpath(Homepage.btn_register)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select a salutation value from 'Salutation' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_salution)).click();
	  Select dropdown = new Select(driver.findElement(By.xpath(Registration_page.ddl_salution)));  
	  dropdown.selectByVisibleText("Mr.");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid first name in 'First Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_first_name)).sendKeys("meet");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid last name in 'Last Name' textbox.");
	  driver.findElement(By.xpath(Registration_page.txt_last_name)).sendKeys("Gondaliya");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Select a gender from 'Gender' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_gender)).click();
	  Select dropdown1 = new Select(driver.findElement(By.xpath(Registration_page.ddl_gender)));  
	  dropdown1.selectByVisibleText("Male");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6:</b> Select an Educational Qualification from 'Educational Qualification' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_educational_qua)).click();
	  Select dropdown2 = new Select(driver.findElement(By.xpath(Registration_page.ddl_educational_qua)));  
	  dropdown2.selectByVisibleText("Graduate");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7:</b> Select a Profession from 'Profession' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown4= new Select(driver.findElement(By.xpath(Registration_page.ddl_Profession)));  
	  dropdown4.selectByVisibleText("Engineer");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8:</b> Select an Organization  from 'Organization' drop down.");
	  driver.findElement(By.xpath(Registration_page.ddl_Organization)).click();
	  Select dropdown3= new Select(driver.findElement(By.xpath(Registration_page.ddl_Organization)));  
	  dropdown3.selectByVisibleText("Others");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9:</b> Enter valid mobile no in 'Mobile No' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Mobile_No)).sendKeys("9023328797");
	  Thread.sleep(1000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10:</b> Enter valid username in 'Username' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_username)).sendKeys("Meetgemss");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11:</b> Enter valid E-mail address in 'E-mail Address' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_Email_add)).sendKeys("mgondaliya1210@gmail.com");;
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12:</b> Enter valid password in 'password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_password)).sendKeys("Asd@1233455");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13:</b> Enter valid confirm password in 'Confirm password' text box.");
	  driver.findElement(By.xpath(Registration_page.txt_confirm_pass)).sendKeys("Asd@1233455");
	  Thread.sleep(1000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14:</b> Enter invalid math question in 'Math question' textbox.");
	  
	     driver.findElement(By.xpath(Registration_page.txt_captcha)).sendKeys("fef");
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15:</b> Click on 'Create New Account' button.");
	     driver.findElement(By.xpath(Registration_page.btn_create_new_account)).click();
		  
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validation meesage like, ");
	  driver.findElement(By.xpath("//li[text()=\"The answer you entered for the CAPTCHA was not correct.\"]")).isDisplayed();
 }
  @AfterMethod
  public void screenShot() {
	 driver.close();
  }
}
