package com.testng.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsEx4 {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test(groups = {"RegressionTest"})
	public void actionEx4() {

		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("indian historical places");
		Actions a =new Actions(driver);
		a.sendKeys(Keys.DOWN,Keys.DOWN,Keys.DOWN,Keys.ENTER).build().perform();
	}

}
