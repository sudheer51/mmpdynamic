package org.iit.mmp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	//default,private,protected,public
	protected WebDriver driver;
	protected String url;
	protected String adminurl;
	@Parameters({"url","adminurl"})
	@BeforeClass
	public void intiateDriver(String url,String adminurl)
	{

		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
		driver.get(url);
		String title = driver.getTitle();
		System.out.println("Title :" +title);
		this.url= url;
		this.adminurl = adminurl;
	}
	public void launchPatientApp()
	{
		driver.get(url);
	}
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	public void launchAdminApp()
	{
		driver.get(adminurl);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
