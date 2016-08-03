package com.amadeus.publish;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUsers {

	WebDriver driver;
	@BeforeClass
	public void setUp() throws InterruptedException{
		
		driver = new ChromeDriver();
		driver.get("http://192.168.0.100/wp-admin/");
		
		//login
		driver.findElement(By.id("user_login")).sendKeys("user");
		driver.findElement(By.id("user_pass")).sendKeys("bitnami");
		driver.findElement(By.id("wp-submit")).click();
		Thread.sleep(2000L);
		
		
	}
	
	@Test
	public void createUsers() throws InterruptedException{
		
		//Navigate to Add New Posts
		WebElement posts = driver.findElement(By.id("menu-posts"));
		Actions action = new Actions(driver);
		action.moveToElement(posts).perform();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@id='menu-posts']/ul/li[3]/a")).click();

		
	}
}
