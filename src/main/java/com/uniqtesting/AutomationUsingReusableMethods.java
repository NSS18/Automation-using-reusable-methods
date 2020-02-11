package com.uniqtesting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


// class of five methods
public class AutomationUsingReusableMethods {

   static protected WebDriver driver;

// 1.Opening browser
   @Before
   public void openBrowser()
   {
      System.setProperty("webdriver.chrome.driver","src\\test\\java\\BrowserDrivers\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

   }



// 2.Closing Browser
   @After
   public void closingBrowser()
   {
      driver.quit();
   }



// 3.Timestamp method for unique text
   public String timeStamp()
   {
      DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
      Date date = new Date();
      return(dateFormat.format(date));
   }

// 4.To click on element
   public void clickOnElement(By by)
   {
      driver.findElement(by).click();
   }

// 5.To type inside text box
   public void enterText(By by,String text)
   {
      driver.findElement(by).sendKeys(text);
   }

// 6.To wait until element is clickable
   public void waitForClickable(By by,int time)
   {
      WebDriverWait wait = new WebDriverWait(driver,time);
      wait.until(elementToBeClickable(by));
   }

// 7.To wait until element is visible
   public void waitForVisible(By by,int time)
   {
       WebDriverWait wait = new WebDriverWait(driver,time);
       wait.until(visibilityOfElementLocated(by));
   }

// 8.To wait until element found on web page
   public void waitForElementPresent(By by,int time)
   {
      WebDriverWait wait = new WebDriverWait(driver,time);
      wait.until(presenceOfElementLocated(By.id("FirstName")));

   }

// 9.To select from drop down box by index
   public void selectFromDropdownByIndex(By by,int index)
   {
      Select select = new Select(driver.findElement(by));
      select.selectByIndex(index);
   }

// 10.To select from drop down box by value
   public void selectFromDropdownByValue(By by,String value)
   {
      Select select = new Select(driver.findElement(by));
      select.selectByValue(value);

   }

// 11.To select from drop down box by text
   public void selectFromDropdownByText(By by,String text)
   {
      Select select = new Select(driver.findElement(by));
      select.selectByVisibleText(text);
   }

// 12.To get text from element
   public String getTextFromElement(By by)
   {
      String actual=driver.findElement(by).getText();
      return actual;
   }

// -------nopCommerce demo Website automation using reusable methods-----
   @Test
   public void userShouldAbleToRegisterSuccessfullyOnNopCommerceWebsite() {

      // To get url
      driver.get("https://demo.nopcommerce.com/");

      // Clicking on register
      clickOnElement(By.linkText("Register"));

       // To wait until gender is clickable
       waitForClickable(By.id("gender-female"),10);

      // To select gender
      clickOnElement((By.id("gender-female")));

      // To enter first name
      enterText(By.id("FirstName"),"Nidhi");

      // To enter last name
      enterText(By.id("LastName"),"shah");

      // To select date of birth
      selectFromDropdownByIndex((By.name("DateOfBirthDay")),5);
      selectFromDropdownByText(By.name("DateOfBirthMonth"),"January");
      selectFromDropdownByValue(By.name("DateOfBirthYear"),"1984");

      // To enter unique email address every time
      enterText(By.id("Email"),"shah.nidhi18+"+timeStamp()+"@gmail.com");

      // To enter password
      enterText(By.id("Password"),"shah123A");

      // To confirm password
      enterText(By.id("ConfirmPassword"),"shah123A");

      // To click on register button
      clickOnElement(By.id("register-button"));

      // To check testcase failed or pass by matching particular text on web page
      Assert.assertEquals("failed","Your registration completed",getTextFromElement(By.xpath("//div[@class=\"result\"]")));


   }
//-------------------------------END OF NOP COMMERCE DEMO WEBSITE TESTCASE----------------------------------------------

// --------Registration for para bank--------------------
   @Test
   public void userShouldAbleToRegisterOnParaBank() {

      // To get url
      driver.get("https://parabank.parasoft.com/parabank/index.htm");

      // To wait until register button is clickable
      waitForVisible(By.linkText("Register"),50);

      // To click on register button
      clickOnElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));

      // To enter first name
      enterText(By.id("customer.firstName"),"Abhay");

      // To enter last name
      enterText(By.id("customer.lastName"),"Sharma");

      // To enter address
      enterText(By.id("customer.address.street"),"11 Francis Road");

      // To enter City
      enterText(By.id("customer.address.city"),"London");

      // To enter state
      enterText(By.name("customer.address.state"),"United Kingdom");

      // To enter zip code
      enterText(By.id("customer.address.zipCode"),"Ha1 2qz");

      // To enter phone number
      enterText(By.id("customer.phoneNumber"),"12345678");

      // To enter ssn
      enterText(By.id("customer.ssn"),"ssn001");

      // To enter username
      enterText(By.id("customer.username"),"Nidhi123");

      // To enter password
      enterText(By.id("customer.password"),"123456789");

      // To enter confirm password
      enterText(By.id("repeatedPassword"),"123456789");

      // To click on register
      clickOnElement(By.className("button"));

      // To get current Url
      String currenturl=driver.getCurrentUrl();

      // Actual Url
      String actualurl="https://parabank.parasoft.com/parabank/about.htm";

      // To verify we are on right url
      Assert.assertEquals("Failed",actualurl,currenturl);


   }
//...............................END OF PARA BANK WEBSITE TESTCASE......................................................


   //-----User registration on https://vocab.elevenplusexams--------------
   @Test
   public void userShouldBeAbleToNavigateOnSecondPageOfElevenplusexams()  {
      // To open url
      driver.get("https://vocab.elevenplusexams.co.uk/");

      // To wait for element to be clickable
       waitForClickable(By.xpath("//*[@id=\"signup\"]/div/div/a"),30);

      // To click on signup
      clickOnElement(By.xpath("//*[@id=\"signup\"]/div/div/a"));

      // To enter user name
      enterText(By.id(("user_name")),"Rosy");

      // To enter email address
      enterText(By.id("user_email"),"x5y13z01"+timeStamp()+"@yahoo.com");

      // To enter password
      enterText(By.id("user_password"),"qw001w");

      // To enter confirmed password
      enterText(By.id("user_password_confirmation"),"qw001w");

      // To click on go
      clickOnElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input"));

      // To enter player name
      enterText(By.cssSelector("input#player_name"),"abc34+" +timeStamp());

      // To select player gender
      selectFromDropdownByText(By.cssSelector("select#player_gender"),"Girl");

      // To select region
      selectFromDropdownByValue(By.id("player_region_id"),"27");

      // To select subject
      clickOnElement(By.xpath("//*[@id=\"player_subject_ids_\" and @value=\"4\"]"));

      // To click go
      clickOnElement(By.xpath("//*[@id=\"new_player\"]/div[5]/input"));

      // Actual url
      String actualurl = "https://vocab.elevenplusexams.co.uk/static/index";

      // To get current url
      String currenturl = driver.getCurrentUrl() ;

      // To verify we are on right url
      Assert.assertEquals("Failed-You are not on"+actualurl,actualurl,currenturl);




   }

//...............................END OF ELEVEN PLUS TESTCASE..........................................................


   // to check welcome message on https://opensource-demo.orangehrmlive.com/
    @Test
    public void userShouldAbleToSeeWelcomMessegeOnOrangeehrm()
    {
        // To get url
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // To wait until login button visible
        waitForVisible(By.xpath("//*[@id=\"btnLogin\"]"),40);

        // To enter username
        enterText(By.id("txtUsername"),"Admin");

        // To enter password
        enterText(By.name("txtPassword"),"admin123");

        // To click on login
        clickOnElement(By.xpath("//*[@id=\"btnLogin\"]"));

        // To click on menu (Admin)
        clickOnElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));

        // To verify user can see welcome admin on web page
        Assert.assertEquals("Failed-you can't see welcome Admin","Welcome Admin",getTextFromElement(By.linkText("Welcome Admin")));
    }

//................................END OF ORANGEHRM TESTCASE..........................................................

    //https://zenar.io/

    @Test
    public void zenar() {

        // To open url
        driver.get("https://zenar.io/");

        // To check element Download visible on webpage
        waitForVisible( By.xpath("//*[@id=\"plgslt_Slot_Main_Menu\"]/ul[2]/li/a"),50);

        // To click on menu Guides
        clickOnElement(By.xpath("//*[@id=\"plgslt_Slot_Main_Menu\"]/ul[4]/li/a"));

        // To click on User Guides
        clickOnElement(By.linkText("User Guides"));

        // To verify we can see user guide - pdf on the webpage
        Assert.assertEquals("Failed","User guides",getTextFromElement(By.xpath("//*[@id=\"plgslt_Main_2\"]/div[1]/h1")));
    }


    //---------------------------END OF ZENAR TESTCASE----------------------------------------------------------------






}
