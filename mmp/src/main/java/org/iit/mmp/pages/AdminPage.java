package org.iit.mmp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {

	WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void navigatetoDoctorLoginButton() throws InterruptedException
	{
		WebElement e=driver.findElement(By.xpath("//a[contains(text(),'Office Login')]"));
		e.getText();
		System.out.println(e.getText());
		e.click();

		WebElement myelement = driver.findElement(By.xpath("//a[@class='button' and text()='Login']"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement);
		Thread.sleep(5000);
		myelement.click(); 
		System.out.println("inside office login");
		Thread.sleep(4000);
	}
	/*
	 * Login with Admin credentials
	 */
	public void adminLogin(String adUname,String adPassword) throws InterruptedException 
	{
		WebElement e1=driver.findElement(By.id("username"));
		e1.sendKeys(adUname);
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys(adPassword);
		Thread.sleep(4000);
		driver.findElement(By.name("admin")).click();
		
	}
	 
	public  boolean approvePatient(String ssnp) throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(text(), 'Users')] ")).click();

		Select dd=new Select(driver.findElement(By.id("search")));
		dd.selectByVisibleText("Pending");
		Thread.sleep(5000);
		WebElement unameElement = driver.findElement(By.xpath("//table/tbody/tr/td[normalize-space(text())= '"+ssnp+"']/preceding-sibling::td/a"));
		unameElement.click();

		Select status2= new Select(driver.findElement(By.xpath("//select[@id='sapproval']")));
		status2.selectByVisibleText("Accepted");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert alert1=driver.switchTo().alert();
		boolean result=false;
		if(alert1!=null)
		{
			result=true;	
		}
		alert1.accept();

		return result;
	}
 
 
}
