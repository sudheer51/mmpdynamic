package org.iit.mmp.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SubModulePage {

	WebDriver driver;
	public SubModulePage(WebDriver driver)
	{
		this.driver = driver;
	}
	public  boolean navigateToAmodule(String  moduleName,String check) throws InterruptedException 
	{
		boolean result=false;
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
		WebElement e=driver.findElement(By.xpath("//h3[@class='panel-title']"));
		result = e.getText().contains(check);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", e);
		Thread.sleep(4000);
		return result;	
	}
}
  
	 
	 