package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Class {
    @Test
    public void verifyUrl() {
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com";
        driver.get(url);

        String actualUrl = driver.getCurrentUrl();
        //String expectedUrl = "https://www.google.com/";

        Assert.assertEquals(actualUrl, "https://www.google.com/", "Url didn't match");
        driver.close();



        /*driver.get("https://twitter.com/explore");
        By emailLocator = By.name("session[username_or_email]");
        WebElement emailBox = driver.findElement(emailLocator);
        emailBox.sendKeys("test@email.com");

        By passLocator = By.name("session[password]");
        WebElement passBox = driver.findElement(passLocator);
        passBox.sendKeys("test");

        By loginButtonLocator = By.id("LoginForm_Login_Button");
        WebElement login = driver.findElement(loginButtonLocator);
        login.click();
*/





    }
}
