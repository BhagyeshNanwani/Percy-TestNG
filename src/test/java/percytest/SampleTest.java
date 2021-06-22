package percytest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.percy.selenium.Percy;

public class SampleTest {
	
	private static Percy percy;
	
	private static WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
	    System.setProperty("webdriver.chrome.driver", "/Users/bhagyesh/Desktop/ChromeDriver/chromedriver");
	    
	    ChromeOptions options = new ChromeOptions();
	    
	    driver = new ChromeDriver(options);
	    
	    percy = new Percy(driver);
	}
	 
	 
	@Test
	public void test() {
		// TODO Auto-generated method stub

		driver.get("https://www.google.com/");
		
		percy.snapshot("Google");
		
		WebElement searchbar = driver.findElement(By.name("q"));
		
		searchbar.sendKeys("BrowserStack");
		
		searchbar.sendKeys(Keys.ENTER);		
		
		percy.snapshot("BrowserStack - Google Search");
		

	}
	
	
	
	@AfterMethod
    	public void teardown() {
		
        driver.quit();
        
    }

}
