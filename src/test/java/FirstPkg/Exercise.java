package FirstPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise {
    @Test
    public void exercise(){
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        By maleLocator = By.xpath("//input[@type='radio' and @value='2']");
        WebElement maleRadio = driver.findElement(maleLocator);
        boolean isMaleSelected = maleRadio.isSelected();

        Assert.assertFalse(isMaleSelected,"Male radio button is default selected");

        if (!isMaleSelected){
            maleRadio.click();
        }

        isMaleSelected = maleRadio.isSelected();

        Assert.assertTrue(isMaleSelected, "Male radio button is now selected");

        By monthDropdownLocator = By.id("month");
        WebElement monthDropdown = driver.findElement(monthDropdownLocator);
        By dayDropdownLocator = By.xpath("//select[@id='day']");
        WebElement dayDropDown = driver.findElement(dayDropdownLocator);
        By yearDropdownLocator = By.xpath("//select[@id='year']");
        WebElement yearDropdown = driver.findElement(yearDropdownLocator);


        Select month = new Select(monthDropdown);
        month.selectByValue("12");

        Select day = new Select(dayDropDown);
        day.selectByValue("1");

        Select year = new Select(yearDropdown);
        year.selectByValue("1988");
        // driver.close();

    }
    @Test
    public void amazon(){

        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");
        By searchLocator = By.xpath("//input[@name='field-keywords']");
        By searchButtonLocator = By.xpath("//input[@class='nav-input' and @value='Go']");
        By watchLingLocator = By.xpath("//span[starts-with(text(), 'Carl BUCHERER Ladies')]");
        By addButtonLocator = By.xpath("//input[@id='add-to-cart-button']");
        By cartButtonLocator = By.xpath("//a[contains(text(), 'Cart') and @id='hlb-view-cart-announce']");
        By msgLocator = By.xpath("//span[contains(text(),'Only 1 left in stock')]");
        By quantityDropdownLocator = By.xpath("//select[@name='quantity']");
        By msg2Locator = By.xpath("//span[contains(text(),'This seller has ')]");

        driver.findElement(searchLocator).sendKeys("Carl BUCHERER Ladies' 18 K Gold Tank Wrist Watch with Diamonds. Super-Slim. Switzerland");
        driver.findElement(searchButtonLocator).click();
        driver.findElement(watchLingLocator).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(addButtonLocator).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(cartButtonLocator).click();

        WebElement msgElement = driver.findElement(msgLocator);
        String productLeft = msgElement.getText();
        System.out.println(productLeft);
        Assert.assertEquals(productLeft,"Only 1 left in stock - order soon.","didn't match");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement quantityDropdown = driver.findElement(quantityDropdownLocator);
        Select qty = new Select(quantityDropdown);
        qty.selectByValue("5");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement msg2Element = driver.findElement(msg2Locator);
        String errorMsg = msg2Element.getText();
        System.out.println(errorMsg);
        String expectedErrorMsg = "This seller has only 1 of these available. To see if more are available from another seller, go to the product detail page.";

        Assert.assertEquals(errorMsg,expectedErrorMsg,"didn't match");

    }
}
