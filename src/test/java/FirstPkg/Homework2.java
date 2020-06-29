package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework2 {
    /**
     * Homework 1:
     * 1. Launch Darksky
     * 2. Go to DarkSy API Homepage
     * 3. Click on 'blog Past' link
     * 4. Verify Blog page title is 'Dark Sky Blog'
     * 5. Verify Page Banner Text is SAME as Tile Header-Text (Dark Sky Has a New Home).
     * 6. Verify the Tile-Date is SAME as Blog Date
     * 7. Go Back and Verify user lands on Dark Sky API HomePage
     */
    @Test
    public void verifyBanner(){
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.darksky.net");
        driver.manage().window().maximize();

        By apiHomepageLocator = By.xpath("//a[@href='/dev']");
        By blogPostLocator = By.xpath("//a[text()='blog post']");
        By pageBannerLocator = By.xpath("//a[text()='Dark Sky Has a New Home']");
        By tileHeaderTextLocator = By.xpath("//p[text()='Dark Sky Has a New Home']");
        By blogDateLocator = By.xpath("//time[text()='March 31, 2020']");
        By tileDateLocator = By.xpath("//p[text()='Mar 31, 2020']");

        driver.findElement(apiHomepageLocator).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(blogPostLocator).click();

        String blogTitle = driver.getTitle();
        String bannerText = driver.findElement(pageBannerLocator).getText();
        String tileHeaderText = driver.findElement(tileHeaderTextLocator).getText();
        String blogDate = driver.findElement(blogDateLocator).getText();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String tileDate = driver.findElement(tileDateLocator).getText();
        String tileDateUpdate = tileDate.replace("r","rch");

        Assert.assertEquals(blogTitle,"Dark Sky Blog","Page title didn't match.");
        Assert.assertEquals(bannerText,tileHeaderText,"Text didn't match.");
        Assert.assertEquals(blogDate,tileDateUpdate,"Tile date is not the same as Blog date");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.navigate().back();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    /**
     * Homepage 2:
     * Sign Up Flow:
     * Enter data in all fields as per your wish but use emailAddress as given below.
     * Verify user get "Please enter a valid mobile number or email address." for below email addresses:
     * 1. test####
     * 2. %%winvalied$$$
     * 3. %%$$emailAddress.co^^
     */
    @Test
    public void SignUp (){

        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        By fNameLocator = By.xpath("//input[@aria-label='First name']");
        By lNameLocator = By.name("lastname");
        By emailLocator = By.xpath("//input[contains(@aria-label, 'Mobile number')]");
        By reEmailLocator = By.name("reg_email_confirmation__");
        By passwordLocator = By.xpath("//input[@autocomplete='new-password' or @aria-label='New password']");
        By monthDropdownLocator = By.id("month");
        By dayDropdownLocator = By.xpath("//select[@id='day']");
        By yearDropdownLocator = By.xpath("//select[@id='year']");
        By genderButtonLocator = By.xpath("//input[@type='radio' and @value='2']");
        By signUpLocator = By.xpath("//button[text()='Sign Up' and @name='websubmit']");


        WebElement firstName = driver.findElement(fNameLocator);
        WebElement lastName = driver.findElement(lNameLocator);
        WebElement emailBox = driver.findElement(emailLocator);
        WebElement reEmail = driver.findElement(reEmailLocator);
        WebElement password = driver.findElement(passwordLocator);
        WebElement month = driver.findElement(monthDropdownLocator);
        WebElement day = driver.findElement(dayDropdownLocator);
        WebElement year = driver.findElement(yearDropdownLocator);
        WebElement maleGender = driver.findElement(genderButtonLocator);
        WebElement signUp = driver.findElement(signUpLocator);


        String[] emails = {"test####", "%%winvalied$$$", "%%$$emailAddress.co^^"};
        Select sMonth = new Select(month);
        Select sDay = new Select(day);
        Select sYear = new Select(year);


        for (String email: emails){
            firstName.sendKeys("test");
            lastName.sendKeys("testlast");
            emailBox.sendKeys(email);
            password.sendKeys("password138");
            sMonth.selectByValue("12");
            sDay.selectByValue("1");
            sYear.selectByValue("1988");
            maleGender.click();
            signUp.click();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String errorMsg = driver.findElement(By.xpath("//div[text()='Please enter a valid mobile number or email address.']")).getText();

            Assert.assertEquals(errorMsg,"Please enter a valid mobile number or email address.","Message did not match.");

           driver.close();
        }
        
    }
}
