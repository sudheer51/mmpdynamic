package org.iit.mmp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class selectDoctorPage {

	WebDriver driver;

	public selectDoctorPage(WebDriver driver) {

		this.driver = driver;
	}

	public boolean selectDoctor(String drName) {

		boolean result = false;

		// Find and click the Create new appointment button.
		driver.findElement(By.xpath("//div[@class='panel panel-cascade']//div//a//input")).click();

		// Find the list of available doctors
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list-inline list-users']"));
		System.out.println("The size of the list is " + list.size());
		for (int i = 0; i <= list.size(); i++) {
			String name = list.get(i).getText().toString();
			System.out.println("The values are: " + name);
			
			if (name.contains(drName)) {
				String s = list.get(i).getText();
				System.out.println(s);
				result = true;
				
				// Click on the Book Appointment button for the selected doctor

				driver.findElement(By.xpath("//td[" + (++i) + "]//button[1]")).click();
				break;
			}

		}
		return result;
	}

}
