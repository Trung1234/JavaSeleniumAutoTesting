
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise1  {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
        setUpDriver();
        //Element which needs to drag.
//        WebElement From=driver.findElement(By.xpath("//*[@id='credit0']/a"));
//
//        //Element on which need to drop.
//        WebElement To=driver.findElement(By.id("shoppingCart4"));

        //Element which needs to drag.
        try {
        	WebElement From=driver.findElement(By.xpath("//*[@id='fourth']/a"));

            //Element on which need to drop.
            WebElement To=driver.findElement(By.xpath("//*[@id='amt7']/li"));
            //WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));
            //Using Action class for drag and drop.
            Actions act=new Actions(driver);

            //Dragged and dropped.
            act.dragAndDrop(From, To).build().perform();

            Thread.sleep(3000);
        }finally {
        	 closeDriver();
        }
        
       
    }

    private static void setUpDriver() throws InterruptedException {
        // Set the path to the chromedriver executable if needed
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
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