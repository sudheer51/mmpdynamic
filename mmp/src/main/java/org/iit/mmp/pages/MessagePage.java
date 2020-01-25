package org.iit.mmp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagePage {
	WebDriver driver;
	public MessagePage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void writeMessage() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("Appointment");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hello");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr[4]//td[1]//input[1]")).click();
		Thread.sleep(3000);

		Alert a;
		a = driver.switchTo().alert();
		Thread.sleep(2000);
		String alertmessage = a.getText();
		if(alertmessage.contains("Messages Successfully sent.")) {
			System.out.println("This use case passed");
		}
		a.accept();
	}	
	
		
}
