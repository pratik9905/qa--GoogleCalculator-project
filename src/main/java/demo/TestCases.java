package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import dev.failsafe.internal.util.Assert;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.getCurrentUrl().contains("google");
        driver.findElement(By.id("APjFqb")).clear();
        driver.findElement(By.id("APjFqb")).sendKeys("calculator");
        driver.findElement(By.className("gNO89b")).click();
        String actual = driver.findElement(By.id("cwos")).getText();
        String expected = "0";
        if(actual.equals(expected)){
            System.out.println(actual);
        }


        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");

        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='+']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='7']")).click();
        Thread.sleep(2000);
        //div[@role='button'][normalize-space()='=']
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='=']")).click();
        Thread.sleep(2000);
        String actual = driver.findElement(By.id("cwos")).getText();
        String expected = "12";
        if(actual.equals(expected)){
            System.out.println(actual);
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='1']")).click();
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='minus']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='8']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='=']")).click();
        Thread.sleep(2000);
        String actualSub = driver.findElement(By.id("cwos")).getText();
        String expectedSub = "7";
        if(actualSub.equals(expectedSub)){
            System.out.println(actualSub);
        }
        Thread.sleep(2000);




        System.out.println("end Test case: testCase02");

    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='1']")).click();
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='multiply']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='3']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='=']")).click();
        Thread.sleep(2000);
        String actualMul = driver.findElement(By.id("cwos")).getText();
        String expectedMul = "30";
        if(actualMul.equals(expectedMul)){
            System.out.println(actualMul);
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='AC']")).click();
        Thread.sleep(2000);
        String actual = driver.findElement(By.id("cwos")).getText();
        String expected = "0";
        if(actual.equals(expected)){
            System.out.println(actual);
        }

        


        System.out.println("end Test case: testCase03");
    }

    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='2']")).click();
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='0']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='divide']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='4']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='button'][normalize-space()='=']")).click();
        Thread.sleep(2000);
        String actualdiv = driver.findElement(By.id("cwos")).getText();
        String expectedDiv = "5";
        if(actualdiv.equals(expectedDiv)){
            System.out.println(actualdiv);
        }
        Thread.sleep(2000);


        System.out.println("end Test case: testCase04");
    }


}
