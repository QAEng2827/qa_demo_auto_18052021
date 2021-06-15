import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GoogleTest {
    private static ChromeDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());


    // расширила пример с поиском Selenium

    @Before
    public void setUp(){
        try {
            logger.info("Test starting...");
            File chromeFF = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromeFF.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info("Driver was loaded...");
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.get("https://www.google.com");
            logger.info("Opening Google...");
        } catch (Exception e){
            logger.info("Mistake: ", e);
        }

    }

    //закрываем браузер
    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser closed");

    }
    @Test
    public void searchingInGoogleTest(){
        System.out.println(webDriver.getCurrentUrl());
        logger.info(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
        logger.info(webDriver.getTitle());

        webDriver.findElement(By.xpath("//img[@alt = 'Google']"));
        webDriver.findElement(By.xpath("//input[@title='Поиск']")).click();
        logger.info("Found search field");

      //  Thread.sleep(1000);



        webDriver.findElement(By.xpath("//div/div/input[@name='q']")).sendKeys("selenium");
        webDriver.findElement(By.xpath("//div/div/input[@name='q']")).sendKeys(Keys.ENTER);
        logger.info("Input value in search field - selenium");


        webDriver.findElement(By.xpath("//div[@class='g']//a[@href='https://www.selenium.dev/']")).click();

                System.out.println(webDriver.getCurrentUrl());
        logger.info(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
        logger.info(webDriver.getTitle());
       Assert.assertEquals("SeleniumHQ Browser Automation", webDriver.getTitle());
        if ( webDriver.getTitle().equals("SeleniumHQ Browser Automation")){
        logger.info("Titles are equal");
        } else {logger.info("Titles are not equal");}




    }

}
