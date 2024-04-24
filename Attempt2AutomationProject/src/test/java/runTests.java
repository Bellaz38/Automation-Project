import Application.*;
import Utilities.Credential;
import Utilities.Drivers;
import com.poiji.bind.Poiji;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class runTests {
    private WebDriver webDriver;


    @Parameters({"browser", "url"})

    @BeforeTest
    public void setup() {
        String browser = "edge";
        System.out.println("Browser: " + browser);
        Drivers drivers = new Drivers();
        if (browser.equals("chrome")) {
            webDriver = drivers.getNewChrome();
        } else if (browser.equals("edge")) {
            webDriver = drivers.getNewEdge();
        }
    }

    @Test
    public void execute() {
        ClassLoader classLoader = runTests.class.getClassLoader();
        URL resource = classLoader.getResource("Data.xlsx");
        assert resource != null;
        List<Credential> Credential = Poiji.fromExcel(new File(resource.getPath()), Credential.class);
        try {
            Login2 login = new Login2(webDriver);
            Cart cart = new Cart(webDriver);
            Products product = new Products(webDriver);
            Confirmation confirmation = new Confirmation(webDriver);
            Checkout checkout = new Checkout(webDriver);


            //Invalid Login
            login.loadWebsite();
            login.username(Credential.get(0).getUserName());
            login.password(Credential.get(0).getPassword());
            login.login();
            webDriver.getTitle();
            String actualresult = webDriver.getTitle();
            String expectedresult = "Swag Labs";
            Assert.assertEquals(actualresult, expectedresult, "Actual Title");
            System.out.println("Epic sadface: Username and password do not match any user in this service");

            //Valid Login add to Cart
            login.loadWebsite();
            login.username(Credential.get(1).getUserName());
            login.password(Credential.get(1).getPassword());
            login.login();
            webDriver.getTitle();
            String actualTitle = webDriver.getTitle();
            String expectedTitle = "Swag Labs";
            Assert.assertEquals(actualTitle, expectedTitle, "Actual Title");
            System.out.println("Logged in Successfully to " + actualTitle);
            Thread.sleep(3000);
            cart.Add2Cart2();
            webDriver.getTitle();
            String actualtitle = webDriver.getTitle();
            String expectedtitle = "Swag Labs";
            Assert.assertEquals(actualtitle, expectedtitle, "Actual Title");
            System.out.println("Item added successfully to cart ");
            login.Burger();
            login.LogOut();


            //Complete Order and Checkout
            login.loadWebsite();
            login.username(Credential.get(1).getUserName());
            login.password(Credential.get(1).getPassword());
            login.login();
            Thread.sleep(3000);
            cart.Add2Cart();
            webDriver.getTitle();
            String Actualtitle = webDriver.getTitle();
            String Expectedtitle = "Swag Labs";
            Assert.assertEquals(Actualtitle, Expectedtitle, "Actual Title");
            System.out.println("Item added successfully to cart ");
            cart.CartButton();
            Thread.sleep(3000);
            checkout.Proceed2Checkout();
            confirmation.NameField();
            confirmation.SurNameField();
            confirmation.ZipCode();
            Thread.sleep(3000);
            confirmation.Continue();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @AfterTest
    public void tearDown() {
        if (webDriver != null) {
            //webDriver.quit();
        }
    }
}



   /*         //Valid Login add to Cart
            login.loadWebsite();
            WebElement webElement = login.username(Credential.get(1).getUserName());
            Assert.assertEquals(webElement.getAttribute("value"),Credential.get(1).getUserName());
            login.password(Credential.get(1).getPassword());
            login.login();

            webDriver.getTitle();
            String actualTitle = webDriver.getTitle();
            String expectedTitle = "My Account – ToolsQA Demo Site";
            Assert.assertEquals(actualTitle, expectedTitle, "Actual Title");
            System.out.println("Logged in Successfully to" + actualTitle);



            cart.Add2Cart();
            cart.

            webDriver.getTitle();
            String actualtitle = webDriver.getTitle();
            String expectedtitle = "Black Cross Back Maxi Dress – ToolsQA Demo Site";
            Assert.assertEquals(actualtitle, expectedtitle, "Actual Title");
            System.out.println("Black Cross Back Maxi Dress added to cart Successfully " + actualTitle);
            login.ClickMyAccount();
            login.LogOut();


            //Complete Order
            login.loadWebsite();
            login.ClickMyAccount();
            login.username(Credential.get(1).getUserName());
            login.password(Credential.get(1).getPassword());
            login.login();
            cart.ToolsQADemoSite();
            cart.Search();
            cart.Search2();
            product.ColorOption2();
            product.SizeOption2();
            cart.Add2Cart2();
            confirmation.ViewCart();
            checkout.Proceed2Checkout();
            confirmation.NameField();
            confirmation.SurNameField();
            confirmation.CompanyField();
            confirmation.termsAndConditions();
            confirmation.PlaceOrder();

            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    @AfterTest
    public void tearDown() {
        if (webDriver != null) {
            //webDriver.quit();

        }
    }

}
*/