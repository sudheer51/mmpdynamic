package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigatePage {
	WebDriver driver;
	public NavigatePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public boolean navigateToModule(String modulename)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+modulename+"')]")).click();
		WebElement e = driver.findElement(By.xpath("//td[contains(text(),'Send Messages')]"));
		System.out.println("Send Message page is displayed ?"+e.isDisplayed());
		WebElement f = driver.findElement(By.xpath("//input[@id='subject']"));
		System.out.println("Contact reason displayed? "+f.isDisplayed());
		WebElement g = driver.findElement(By.xpath("//textarea[@id='message']"));
		System.out.println("Enter message field is displayed? "+g.isDisplayed());
		WebElement h = driver.findElement(By.xpath("//tr[4]//td[1]//input[1]"));
		System.out.println("Send button is displayed? "+h.isDisplayed());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("Messages");
		return result;

	}	



}
