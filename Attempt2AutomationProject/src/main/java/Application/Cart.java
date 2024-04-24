package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
    private WebDriver webDriver = null;
    public Cart(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //private WebElement ToolsQADemoSite(WebDriver webDriver) {
     //   return webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/section/div/div/div/span[1]/a/span"));
    //}

    //public void ToolsQADemoSite() {
      //  ToolsQADemoSite(this.webDriver).click();

    //}


    private WebElement Add2Cart(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
    }

    public void Add2Cart() {
        Add2Cart(this.webDriver).click();
    }


    private WebElement Search(WebDriver webDriver) {
        return webDriver.findElement(By.className("icon_search"));

    }

    public void Search() {
        WebElement Search = this.webDriver.findElement(By.className("icon_search"));
        Search(this.webDriver).click();


    }

    private WebElement Search2(WebDriver webDriver) {
        return webDriver.findElement(By.className("note-search"));


    }

    public void Search2() {
        WebElement Search2 = this.webDriver.findElement(By.className("form-control"));
        Search2(this.webDriver).click();
        Search2.sendKeys("BLACK LUX GRAPHIC T-SHIRT");

        Search2.submit();

    }

    private WebElement Add2Cart2(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
    }

    public void Add2Cart2() {
        Add2Cart2(this.webDriver).click();
    }
    private WebElement CartButton(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
    }
     public void CartButton() {
         CartButton(this.webDriver).click();

     }
}