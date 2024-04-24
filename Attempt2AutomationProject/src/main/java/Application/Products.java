package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products {

    private WebDriver webDriver = null;

    public Products(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private WebElement Item1(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div"));
    }

    public void Item1() {
        Item1(this.webDriver).click();

    }
    public void ColorOption() {
        WebElement select = this.webDriver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("Black".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }

    }
    public void SizeOption() {
        WebElement select = this.webDriver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("Large".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }
    }
    public void ColorOption2() {
        WebElement select = this.webDriver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("Black".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }

    }
    public void SizeOption2() {
        WebElement select = this.webDriver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if ("34".equals(option.getText().trim())) {
                option.click();
                break;
            }
        }
    }
}

