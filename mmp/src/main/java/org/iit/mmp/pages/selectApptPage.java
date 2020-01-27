package org.iit.mmp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class selectApptPage {

	WebDriver driver;

	public selectApptPage(WebDriver driver) {

		this.driver = driver;
	}

	public boolean selectApptDatenTime(String doa, String time) {
		String date, month, year;
		String caldt, calmth, calyear;
		WebElement cal;
		boolean res = false;

		// Split the date of appointment(doa) into a String Array
		String dateArray[] = doa.split("/");

		date = dateArray[0];
		month = dateArray[1];
		year = dateArray[2];

		driver.switchTo().frame(driver.findElement(By.id("myframe")));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(" //input[@id='datepicker']")).click();
		cal = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		calyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		// To get the year from the calendar
		while (!calyear.equals(year)) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			calyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			System.out.println(calyear);
		}
		// To get the month from the calendar
		calmth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		while (!calmth.equalsIgnoreCase(month)) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			calmth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println(calmth);
		}

		// To get the date from the calendar
		List<WebElement> rows, cols;
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				caldt = cols.get(j).getText();
				if (caldt.equals(date)) {
					cols.get(j).click();
					break;
				}

			}
		}

		// To select the time of the appointment
		Select dropdown = new Select(driver.findElement(By.id("time")));
		dropdown.selectByVisibleText(time);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Verify if the OK text is displayed for the appointment.
		if (driver.findElement(By.xpath("//div[@id='status']")).isDisplayed()) {
			res = true;
		}
		
		// To click the Continue button.
		driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
		return res;
	}
}