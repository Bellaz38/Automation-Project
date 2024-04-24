package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class Confirmation {

    private WebDriver webDriver = null;

    public Confirmation(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void NameField() {
        WebElement NameField = this.webDriver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        NameField.clear();
        NameField.sendKeys("Bellah");
        //NameField.submit();
    }

    private WebElement ViewCart(WebDriver webDriver) {
        return webDriver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/div/a"));
    }

    public void ViewCart() {
        ViewCart(this.webDriver).click();
    }

    public void SurNameField() {
        WebElement SurNameField = webDriver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        SurNameField.clear();
        SurNameField.sendKeys("Modisane");
        //SurNameField.submit();

    }

    public void CompanyField() {
        WebElement CompanyField = this.webDriver.findElement(By.xpath("//*[@id=\"billing_company\"]"));
        CompanyField.clear();
        CompanyField.sendKeys("Kaputec");
        CompanyField.submit();
    }

    public void Country() {
        WebElement Country = this.webDriver.findElement(By.xpath("//*[@id=\"select2-billing_country-container\"]"));
        Select dropdown = new Select(Country);
        dropdown.selectByVisibleText("Somalia");
        ///Country.clear();
        //Country.click();
        //Country.sendKeys("Somalia");

    }

    public void StreetAdd1() {
        WebElement StreetAdd1 = this.webDriver.findElement(By.xpath(" //*[@id=\"billing_address_1\"]"));
        StreetAdd1.clear();
        StreetAdd1.sendKeys("21 Layfiedl");

    }

    public void StreetAdd2() {
        WebElement StreetAdd2 = this.webDriver.findElement(By.xpath(" //*[@id=\"billing_address_1\"]"));
        StreetAdd2.clear();
        StreetAdd2.sendKeys("Klenene");
    }
    public void Town() {
        WebElement Town = this.webDriver.findElement(By.xpath("//*[@id=\"billing_city\"]"));
        Town.clear();
        Town.sendKeys("Pretoria");
    }
    public void Province() {
        WebElement Province = this.webDriver.findElement(By.xpath("//*[@id=\"billing_city\"]"));
        Province.sendKeys("Gauteng");
        Province.submit();

    }
    public void ZipCode() {
        WebElement ZipCode = this.webDriver.findElement(By.xpath("//*[@id=\"postal-code\"]"));
        ZipCode.clear();
        ZipCode.sendKeys("0152");
    }
    public void CellNumber() {
        WebElement CellNumber = this.webDriver.findElement(By.xpath("//*[@id=\"billing_phone\"]"));
        CellNumber.clear();
        CellNumber.sendKeys("0715809282");
    }
    public void Email() {
        WebElement Email = this.webDriver.findElement(By.xpath("//*[@id=\"billing_email\"]"));
        Email.clear();
        Email.sendKeys("modbjay@gmail.com");
    }

    public void termsAndConditions() {
        WebElement termsAndConditions = this.webDriver.findElement(By.xpath("//*[@id=\"terms\"]"));
        System.out.println("termsAndConditions.getText: "+termsAndConditions.getText());
        System.out.println("termsAndConditions.isDisplayed: "+termsAndConditions.isDisplayed());
        termsAndConditions.click();
    }

    public void Continue() {
        WebElement PlaceOrder = this.webDriver.findElement(By.xpath("//*[@id=\"continue\"]"));
        PlaceOrder.click();
    }
}