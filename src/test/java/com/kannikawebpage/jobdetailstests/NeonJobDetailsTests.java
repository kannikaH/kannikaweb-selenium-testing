package com.kannikawebpage.jobdetailstests;

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
import org.testng.Assert;
import org.testng.annotations.Test;

public class NeonJobDetailsTests {
	WebDriver driver;
	
	@Test
	public void neonJobTest() {
		 // Create driver
		 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println("Start Testing Experience Page");
		 
		 //open page
		 driver.get("https://kannikah.github.io/");
		 System.out.println("Main page is open.");
		 driver.findElement(By.xpath("//body[@id='myPage']/div[@class='kh-top']//a[@href='#experience']")).click();
		 driver.findElement(By.xpath("//div[@id='experience']/div[6]/button[1]/b[.='Application Engineer / Neon InfoTech South East Asia']")).click();
		 // Screenshot
		 takeScreenshot();
		 
		// Verification that Neon job details is displayed
		 Assert.assertTrue(driver.findElement(By.id("neon")).isDisplayed());
		
		 		 
		 // Close browser
		 driver.quit();
		
	}
	
	private void takeScreenshot() {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  String path = System.getProperty("user.dir") 
					+ File.separator + "test-output" 
					+ File.separator + "screenshots"
					+ File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date()) 
					+ File.separator + new SimpleDateFormat("HHmmssSSS").format(new Date()) 
					+ " " + "ExperiencePage.png";
			try {
				FileUtils.copyFile(scrFile, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
