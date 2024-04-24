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

public class Test1 {
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
