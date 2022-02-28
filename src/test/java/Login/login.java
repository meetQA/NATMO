package Login;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
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
public class login {
	Homepage obj = new Homepage();
	Login_In obj1 = new Login_In();
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
  @Test(priority=1, description="To verify that user is able to get 'Sign In' page.")
  public void NATMO_Sign_In_01() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Sign in' page. Buttons:Create new account, Forgot Password and Forgot Username. ");
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  boolean found1 =  driver.findElement(By.xpath(Login_In.label_email_add)).isDisplayed();
	  Assert.assertEquals(found1,true);
	  boolean found2 =  driver.findElement(By.xpath(Login_In.txt_email_add)).isDisplayed();
	  Assert.assertEquals(found2,true);
	  boolean found3 =  driver.findElement(By.xpath(Login_In.label_password)).isDisplayed();
	  Assert.assertEquals(found3,true);
	  boolean found4 =  driver.findElement(By.xpath(Login_In.txt_password)).isDisplayed();
	  Assert.assertEquals(found4,true);
	  boolean found5 =  driver.findElement(By.xpath(Login_In.label_captcha)).isDisplayed();
	  Assert.assertEquals(found5,true);
	  boolean found6 =  driver.findElement(By.xpath(Login_In.txt_captcha)).isDisplayed();
	  Assert.assertEquals(found6,true);
	  boolean found7 =  driver.findElement(By.xpath(Login_In.btn_login_in)).isDisplayed();
	  Assert.assertEquals(found7,true);
	  boolean found8 =  driver.findElement(By.xpath(Login_In.btn_create_new_account)).isDisplayed();
	  Assert.assertEquals(found8,true);
	  boolean found9 =  driver.findElement(By.xpath(Login_In.btn_forgot_password)).isDisplayed();
	  Assert.assertEquals(found9,true);
	  boolean found10 =  driver.findElement(By.xpath(Login_In.btn_forgot_username)).isDisplayed();
	  Assert.assertEquals(found10,true);
  }
  
  @Test(priority=2, description="To verify that user is able to perform 'Sign In' functinality.")
  public void NATMO_Sign_In_02() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter valid username or registered email address in 'Username or Registered email address' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_email_add)).sendKeys("mgondaliya121@gmail.com");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid login password in 'Login Password' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_password)).sendKeys("Asd@1234");
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
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
	    
	     
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
		  }
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get successful login in particular department.");
	  driver.findElement(By.xpath(Login_In.label_validation_message)).isDisplayed();
  }
  
  @Test(priority=3, description="To verify that user is able to get 'Create New Account' page.")
  public void NATMO_Sign_In_03() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Create New Account' button.");
	  driver.findElement(By.xpath(Login_In.btn_create_new_account)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Create New Account' page");
	  driver.findElement(By.xpath(Homepage.label_register)).isDisplayed();
	  
  }
  @Test(priority=4, description="To verify that user is able to get 'Forgot Password' page.")
  public void NATMO_Sign_In_04() throws InterruptedException {
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Password' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_password)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Password' page");
	  driver.findElement(By.xpath(Login_In.label_forgot_password)).isDisplayed();
	  
  }
  @Test(priority=5, description="To verify that user is able to get 'Forgot Username' page.")
  public void NATMO_Sign_In_05() throws InterruptedException {
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Forgot Username' button.");
	  driver.findElement(By.xpath(Login_In.btn_forgot_username)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should redirect on 'Forgot Username' page");
	  driver.findElement(By.xpath(Login_In.label_forgot_username)).isDisplayed();
	  
  }
  @Test(priority=6, description="To verify that user is not able to 'Login in' in NATMO application with blank credentials.")
  public void NATMO_Sign_In_06() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000); 
	  boolean found =  driver.findElement(By.xpath(Homepage.label_sign_in)).isDisplayed();
	  Assert.assertEquals(found,true);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Click on 'Log In' button.");
	  driver.findElement(By.xpath(Login_In.btn_login_in)).click();
	  Thread.sleep(5000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, 1)Username or Registered email address field is required. 2)Login Password field is required. 3)Math question field is required.");
	  driver.findElement(By.xpath(Login_In.label_validation_email)).isDisplayed();
	  driver.findElement(By.xpath(Login_In.label_validation_pass)).isDisplayed();
	  driver.findElement(By.xpath(Login_In.label_validation_captcha)).isDisplayed();
  }
  @Test(priority=7, description="To verify that user is not able to 'Login in' in NATMO application with valid Username or Registered email address and invalid Login Password and Math question.")
  public void NATMO_Sign_In_07() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter valid username or registered email address in 'Username or Registered email address' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_email_add)).sendKeys("mgondaliya121@gmail.com");
	  Thread.sleep(2000);
	 ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter invalid login password in 'Login Password' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_password)).sendKeys("Asd@1234");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter invalid math question in 'Math question' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys("78888");
	     Thread.sleep(5000);
	    ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, Sorry, unrecognized username or password. Have you forgotten your password?");
	  driver.findElement(By.xpath("//li[text()=\"Sorry, unrecognized username or password. \"]")).isDisplayed();
  }
  @Test(priority=8, description="To verify that user is not able to 'Login in' in NATMO application with valid Login Password and invalid Username or Registered email address and Math question.")
  public void NATMO_Sign_In_08() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter invalid username or registered email address in 'Username or Registered email address' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_email_add)).sendKeys("mgondaliya121@gmail.com");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter valid login password in 'Login Password' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_password)).sendKeys("Asd@1234");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4:</b> Enter invalid math question in 'Math question' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_captcha)).sendKeys("78888");
	     Thread.sleep(5000);
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, Sorry, unrecognized username or password. Have you forgotten your password?");
	  driver.findElement(By.xpath("//li[text()=\"Sorry, unrecognized username or password. \"]")).isDisplayed();
  }
  @Test(priority=9, description="To verify that user is not able to 'Login in' in NATMO application with valid Math question and invalid Username or Registered email address and Login Password.")
  public void NATMO_Sign_In_09() throws InterruptedException {
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on 'Sign In' functionality from the top panel.");
	  driver.findElement(By.xpath(Homepage.btn_sign_in)).click();
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Enter invalid username or registered email address in 'Username or Registered email address' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_email_add)).sendKeys("mgondaliya121@gmail.com");
	  Thread.sleep(2000);
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Enter invalid login password in 'Login Password' textbox.");
	  driver.findElement(By.xpath(Login_In.txt_password)).sendKeys("Asd@1234");
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
     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
	    
	     
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
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
	     ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5:</b> Click on 'Login in' button.");
	     driver.findElement(By.xpath(Login_In.btn_login_in)).click();
		  }
	  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> User should get validtion message like, Sorry, unrecognized username or password. Have you forgotten your password?");
	  driver.findElement(By.xpath(Login_In.label_validation_message)).isDisplayed();
  }
  @AfterMethod
  public void screenShot() {
	  driver.close();
  }

}
