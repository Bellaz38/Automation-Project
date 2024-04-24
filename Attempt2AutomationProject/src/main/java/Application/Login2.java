package Application;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login2 {
    private WebDriver webDriver = null;

    public Login2(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void loadWebsite() {

        String url = Util.BASE_URL_STRING;
        this.webDriver.get(url);
        this.webDriver.manage().window().maximize();

    }

   // private WebElement ClickDismiss(WebDriver webDriver) {
    //    return webDriver.findElement(By.xpath("/html/body/p[1]/a"));

   // public void ClickOnDismiss() {
      //  ClickDismiss(this.webDriver).click();



    private WebElement MyAccount(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a"));
    }
    public void ClickMyAccount() {
        MyAccount(this.webDriver).click();

    }
//    public static void username( WebDriver driver, String username) {
//        //driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
//        WebElement userName = driver.findElement(By.id("username"));
//public WebElement Username( String Username) {
    //driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(Username);
    //WebElement webElement = this.webDriver.findElement(By.id("Username"));
    //webElement.sendKeys(Username);

    //return webElement;
//        System.out.println("userName: "+userName);
//        userName.sendKeys("Testing 234");
//    }

    public void username(String username) {
        this.webDriver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
    }

    public void password(String password) {
        this.webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
    }

    public void login() {
        //driver.findElement(By.className("woocommerce-button button woocommerce-form-login__submit")).click();
        this.webDriver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    private WebElement LogOut(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
    }

    public void LogOut() {
        LogOut(this.webDriver).click();
    }
    private WebElement Burger(WebDriver webDriver){
        return webDriver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
    }
    public void Burger(){
        Burger(this.webDriver).click();
    }
}

