package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewHistoryPage {
	
	WebDriver driver;
	public ViewHistoryPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean navigateToHistory(String modulename)
	{
		
		driver.findElement(By.xpath("//button[contains(text(),'View History')]")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println("String length "+ driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View History");
        return result;
		
	}
	
	
}


