package com.kannikawebpage.jobdetailstests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RnzJobDetailsTests {
	WebDriver driver;
	
	@Test
	public void rnzJobTest() {
		 // Create driver
		 System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		 driver = new ChromeDriver();
		 System.out.println("Start Testing Experience Page");
		 
		 //open page
		 driver.get("https://kannikah.github.io/");
		 System.out.println("Main page is open.");
		 driver.findElement(By.xpath("//body[@id='myPage']/div[@class='kh-top']//a[@href='#experience']")).click();
		 driver.findElement(By.xpath("//div[@id='experience']/div[4]/button[1]/b[.='Software Engineer / Ringzero Networks Thailand']")).click();
		 
		// Verification that Ring Zero job details is displayed
		 Assert.assertTrue(driver.findElement(By.id("rnz")).isDisplayed());
		
		 		 
		 // Close browser
		 driver.quit();
	}
	
	

}
