package Utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Drivers {
    public Drivers() {

    }

    // public FirefoxDriver getNewFirefox() {
    //   System.setProperty("webdriver.gecko.driver", "C:\\Users\\jaymo\\IdeaProjects\\AutomationProject\\src\\main\\resources\\geckodriver.exe");
    //   return new FirefoxDriver();



    public ChromeDriver getNewChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaymo\\IdeaProjects\\Attempt3AutomationProject\\src\\main\\resources\\chromedriver.exe");
        return new ChromeDriver();

    }

    public EdgeDriver getNewEdge() {
       //System.setProperty("webdriver.edge.driver", "C:\\Users\\jaymo\\IdeaProjects\\Attempt3AutomationProject\\src\\main\\resources\\msedgedriver.exe");
        return new EdgeDriver();
    }

}




