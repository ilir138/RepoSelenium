package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class Homework1 {
    @Test
    public void facebook() {
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        By fNameLocator = By.xpath("//input[@aria-label='First name']");
        By lNameLocator = By.name("lastname");
        By emailLocator = By.xpath("//input[contains(@aria-label, 'Mobile number')]");
        By reEmailLocator = By.name("reg_email_confirmation__");
        By passwordLocator = By.xpath("//input[@autocomplete='new-password' or @aria-label='New password']");
        By signUpLocator = By.xpath("//button[text()='Sign Up' and @name='websubmit']");
        By errorMsgLocator = By.xpath("//div[contains(text(),'Please choose a gender. You can change who can see this later.')]");

        driver.findElement(fNameLocator).sendKeys("First Name");
        driver.findElement(lNameLocator).sendKeys("Last Name");
        driver.findElement(emailLocator).sendKeys("email@test.com");
        driver.findElement(reEmailLocator).sendKeys("email@test.com");
        driver.findElement(passwordLocator).sendKeys("Password");
        driver.findElement(signUpLocator).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        WebElement error = driver.findElement(errorMsgLocator);
        String errorText = error.getText();

        Assert.assertEquals(errorText,"Please choose a gender. You can change who can see this later.","text didn't match");
        driver.close();
    }
    @Test
    public static void darkSky(){
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.darksky.net");
        driver.manage().window().maximize();

        By feelsLikeLocator = By.xpath("//span[@class='feels-like-text']");
        By lowTempLocator = By.xpath("//span[@class='low-temp-text']");
        By highTempLocator = By.xpath("//span[@class='high-temp-text']");

        WebElement feelsLike = driver.findElement(feelsLikeLocator);
        String feelsL = feelsLike.getText();

        WebElement lowTemp = driver.findElement(lowTempLocator);
        String lowT = lowTemp.getText();

        WebElement highTemp = driver.findElement(highTempLocator);
        String highT = highTemp.getText();

        String feelsL2 = feelsL.replace("˚"," ").trim();

        String lowT2 = lowT.replace("˚"," ").trim();

        String highTt2 = highT.replace("˚"," ").trim();


        int feels = Integer.parseInt(feelsL2);
        int low = Integer.parseInt(lowT2);
        int high = Integer.parseInt(highTt2);

        if(high>feels && feels>low){
            System.out.println(feels + " is between " + high + " and " +low);
        }
        else {
            System.out.println(feels + " is not between " + high + " and " +low);
        }

        driver.close();


    }

}
