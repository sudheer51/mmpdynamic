package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyPastDiagnosisPage {
	
	WebDriver driver;
	public VerifyPastDiagnosisPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean verifyPastDiagnosis(String diagnosis)
	{
    	driver.findElement(By.xpath("//input[@value='Past Diagnosis']")).click();
		System.out.println("String " + driver.findElement(By.xpath("//h3[@class='panel-title']")).getText());
		System.out.println("String length "+ driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().length());
		boolean result = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText().contains("View Past Diagnosis");
        return result;
	}
}


