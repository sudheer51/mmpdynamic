package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public boolean login(String username,String password)
	{
		
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		boolean result = driver.findElement(By.tagName("h3")).getText().contains("ria1");
		return result;
	}	
	/*
	 * Logout from the given module
	 */
	public  boolean logout(String  moduleName) throws InterruptedException 
	{
			boolean result=false;
			WebElement e=driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]"));
			System.out.println(e.getText());
			e.click();
			result = driver.getTitle().contains("NAMTG");
			return result;
	}
	
}

