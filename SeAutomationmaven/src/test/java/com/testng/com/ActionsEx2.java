package com.testng.com;

import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEx2 {
	WebDriver driver;
	Logger log = LogManager.getLogger(ActionsEx2.class);
	@BeforeMethod
public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://the-internet.herokuapp.com/jqueryui/menu");
		
		log.info("Browser is launched successfully");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		log.info("Browser is closed successfully");
	}
	
	@Test(groups = {"RegressionTest"})
	public void actionEx2() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions a =new Actions(driver);
		WebElement enabled = driver.findElement(By.xpath("//li[@id='ui-id-3']/a"));
		WebElement downloads = driver.findElement(By.xpath("//li[@id='ui-id-4']/a"));
		WebElement excel = driver.findElement(By.xpath("//li[@id='ui-id-7']/a"));
		
		a.moveToElement(enabled).pause(1000).moveToElement(downloads).pause(1000).moveToElement(excel).click().build().perform();
		log.info("LOG:: Test is passed");
	}
	
}
