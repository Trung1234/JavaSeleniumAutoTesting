
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class Exercise1  {
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException{
        setUpDriver();       
        try {
        	//Element which needs to drag.
        	WebElement From=driver.findElement(By.xpath("//*[@id='fourth']/a"));

            //Element on which need to drop.
            WebElement To=driver.findElement(By.xpath("//*[@id='amt7']/li"));
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
    	try {
    		Runtime.getRuntime().addShutdownHook(new Thread() {
    		    public void run() {
    		        if (driver != null) {
    		            driver.quit();
    		        }
    		    }
    		});
		} catch (UnreachableBrowserException e) {
			// Log the exception
			System.out.println("Browser was unreachable");
		}
    }

}