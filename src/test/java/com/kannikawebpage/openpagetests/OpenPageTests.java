package com.kannikawebpage.openpagetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.kannikawebpage.base.TestUtilities;


public class OpenPageTests extends TestUtilities  {

	@Test
	public void homePageTest() {
		// Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Starting Testing");

		// open test page
		String url = "https://kannikah.github.io/";
		driver.get(url);
		sleep(3000);
		System.out.println("Page is opened.");
		takeScreenshot("WelcomePage opened");
		
		// sleep for 3 seconds
		sleep(3000);
			
		// Close browser
		driver.quit();
	}
	
	private void sleep(long m) {
		try {
			Thread.sleep(m);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
    
	
	
	
}
