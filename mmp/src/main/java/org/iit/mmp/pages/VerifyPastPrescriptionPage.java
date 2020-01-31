package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyPastPrescriptionPage {
	
	WebDriver driver;
	public VerifyPastPrescriptionPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean verifyPastPrescription(String appointments)
	{
		driver.findElement(By.xpath("//input[@value='Past Appointments']")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println("String length "+ driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("Patient Portal");
        return result;
       
        
	}

}
