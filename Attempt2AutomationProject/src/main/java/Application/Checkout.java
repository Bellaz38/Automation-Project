package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Checkout {

    private WebDriver webDriver = null;

    public Checkout(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private WebElement Proceed2Checkout(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"checkout\"]"));
    }

    public void Proceed2Checkout(){
        Proceed2Checkout(this.webDriver).click();

    }
}
