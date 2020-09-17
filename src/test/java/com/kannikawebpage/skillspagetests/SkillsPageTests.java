package com.kannikawebpage.skillspagetests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SkillsPageTests {
	WebDriver driver;

	@Test
	public void skillsPageTests() {
		//Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Starting Testing");
		
		//open page
		driver.get("https://kannikah.github.io/");
		System.out.println("Page is opened");
		driver.findElement(By.xpath("//body[@id='myPage']/div[@class='kh-top']//a[@href='#skills']")).click();
		
		// Screenshot
		takeScreenshot();
		
		//Close browser
		driver.quit();
		
		
	}
	
	
	
	private void takeScreenshot() {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String path = System.getProperty("user.dir") 
					+ File.separator + "test-output" 
					+ File.separator + "screenshots"
					+ File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date()) 
					+ File.separator + new SimpleDateFormat("HHmmssSSS").format(new Date()) 
					+ " " + "AboutPage.png";
			try {
				FileUtils.copyFile(scrFile, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	

}

