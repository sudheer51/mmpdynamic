package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubModulePage {

	WebDriver driver;
	public SubModulePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public  boolean navigateToAmodule(String  moduleName,String check) throws InterruptedException 
{
		
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println("String length "+ driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View History");
        return result;
		
	}
	
}
  
	 
	 