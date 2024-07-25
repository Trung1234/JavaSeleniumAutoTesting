
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise2  {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
        setUpDriver();

        //Double click the button to launch an alertbox
        Actions action = new Actions(driver);
        WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        action.doubleClick(link).perform();
//Switch to the alert box and click on OK button
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text\n" +alert.getText());
        alert.accept();


        Thread.sleep(5000);
        closeDriver();
    }

    private static void setUpDriver() throws InterruptedException {
        // Set the path to the chromedriver executable if needed
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" http://demo.guru99.com/test/simple_context_menu.html");
        //Mazimize current window
        driver.manage().window().maximize();

//Delay execution for 5 seconds to view the maximize operation
        Thread.sleep(5000);

    }



    /**
     * Method to close the drive
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}