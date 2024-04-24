import Application.*;
import Utilities.Credential;
import Utilities.Drivers;
import com.poiji.bind.Poiji;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Test3 {
    private WebDriver webDriver;


    @Parameters({"browser", "url"})

    @BeforeTest
    public void setup() {
        String browser = "chrome";
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


            //Complete Order and Checkout
            login.loadWebsite();
            login.username(Credential.get(1).getUserName());
            login.password(Credential.get(1).getPassword());
            login.login();
            Thread.sleep(3000);
            cart.Add2Cart();
            Thread.sleep(3000);
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

