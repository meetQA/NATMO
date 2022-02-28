package Forgot_Password;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import Forgot_Password_R.Forgot_Password;
import io.github.bonigarcia.wdm.WebDriverManager;
import Home_Page_R.*;
import Listener.ExtentTestManager;
import Login_R.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;

public class Forgot_password {
	Homepage obj = new Homepage();
	Login_In obj1 = new Login_In();
	Forgot_Password obj2 = new Forgot_Password();
	WebDriver driver;

  @BeforeClass
  public void setDriver( ){
	  // ExtentTestManager.getTest().log(Status.INFO, "Open Browser.");
	 
  }
  @BeforeMethod
  public void openBrowser(ITestContext context) {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	//ExtentTestManager.getTest().log(Status.INFO, "Enter the URL of NATMO application in address bar.");
	  driver.get(Homepage.URL);
  }
  @Test(priority=1, description="To verify that user is able to get 'Forgot Password' page.")
  public void NATMO_Forgot_Password_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Password' page. Buttons:Create new account, Sign In and Forgot Username. ");
	  driver.findElement(By.xpath(Login_In.label_forgot_password)).isDisplayed();
  }
  
  @Test(priority=2, description="To verify that user is able to change password in 'Forgot password' page.")
  public void NATMO_Forgot_Password_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid username or Registered email address in 'Username or e-mail address' textbox.");
	  driver.findElement(By.xpath(obj2.txt_Username)).sendKeys("mgondaliya1210@gmail.com");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter valid math question in 'Math question' textbox.");
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
     driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys(s);
     Thread.sleep(5000);
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'E-mail new password' button.");
     driver.findElement(By.xpath(Forgot_Password.btn_Email_new_Password)).click();
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
	     driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'E-mail new password' button.");
	     driver.findElement(By.xpath(Forgot_Password.btn_Email_new_Password)).click();
	    
	     
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
	     driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'E-mail new password' button.");
	     driver.findElement(By.xpath(Forgot_Password.btn_Email_new_Password)).click();
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
	     driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys(s);
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'E-mail new password' button.");
	     driver.findElement(By.xpath(Forgot_Password.btn_Email_new_Password)).click();
		  }
  }
  
  @Test(priority=3, description="To verify that user is able to get 'Create New Account' page.")
  public void NATMO_Forgot_Password_03() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Create New Account' button.");
	  driver.findElement(By.xpath(Login_In.btn_create_new_account)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Create New Account' page");
	  driver.findElement(By.xpath(Homepage.label_register)).isDisplayed();
	  
  }
  @Test(priority=4, description="To verify that user is able to get 'Sign In' page.")
  public void NATMO_Forgot_Password_04() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Sign In' button.");
	  driver.findElement(By.xpath(Forgot_Password.btn_Sign_In)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Sign In' page");
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  
  }
  @Test(priority=5, description="To verify that user is able to get 'Forgot Username' page.")
  public void NATMO_Forgot_Password_05() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'Forgot Username' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_username)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Username' page");
	  driver.findElement(By.xpath(Login_In.label_forgot_username)).isDisplayed();
	  
  }
  @Test(priority=6, description="To verify that user is not able to get new password with blank credentials.")
  public void NATMO_Forgot_Password_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Click on 'E-mail new password' button.");
	  driver.findElement(By.xpath(Forgot_Password.btn_Email_new_Password)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, 1)Username or e-mail address field is required. 2)Math question field is required.");
	  driver.findElement(By.xpath(Forgot_Password.label_validation_email)).isDisplayed();
	  driver.findElement(By.xpath(Forgot_Password.label_captcha)).isDisplayed();
  }
 
  @AfterMethod
  public void screenShot() {
	  driver.close();
  }

}
