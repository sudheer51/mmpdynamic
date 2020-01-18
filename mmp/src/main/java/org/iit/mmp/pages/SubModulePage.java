package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubModulePage {

	WebDriver driver;
	public SubModulePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean navigateToAmodule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("Information");
		return result;
	}
}
