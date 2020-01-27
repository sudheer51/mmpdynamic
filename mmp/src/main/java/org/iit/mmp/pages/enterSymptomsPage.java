package org.iit.mmp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class enterSymptomsPage {
	
	WebDriver driver;

	public enterSymptomsPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public boolean enterSymptoms(String symptoms) {
		
		boolean result = false;
		driver.findElement(By.xpath("//textarea[@id='sym']")).sendKeys(symptoms);
		driver.findElement(By.xpath(
				"//body/div[@class='site-holder']/div[@class='box-holder']/div[@class='content']/div[@class='row']/div[@class='col-md-6']/div[@class='panel panel-cascade']/div/input[1]"))
				.click();
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Verify if the symptoms are displayed in a tabular format.
		//String s1 = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		//System.out.println(s1);
		
		
	    List<WebElement> tbRow = driver.findElements(By.xpath("//tbody/tr[1]/td[3]"));
		String tbdata= tbRow.get(0).getText().toString();
		System.out.println(tbdata); 
		if (symptoms.equals(tbdata)) {
			result = true;
		}
		return result;

	}

}