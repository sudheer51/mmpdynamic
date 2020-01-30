package org.iit.mmp.pages;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver driver;
	Map<Integer,String[]> allUsersMap;
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String fetchssn() throws InterruptedException
	{
		
		allUsersMap= getAllUserData();	
		String[] data=fillData(allUsersMap,0);
		String userName=data[0];
		String password=data[1];
		String ssn=data[2];
		return ssn;
	}
	/*
	 * Adding Data to the HashMap
	 */
	
	
	public  HashMap<Integer,String[]> getAllUserData() throws InterruptedException
	{
		int unique_id = (int)(new Date().getTime() / 10000);
		System.out.println("unique id :" + unique_id);
		String userName= "tester";
		String email="test@gmail.com";
		HashMap<Integer,String[]> userMap= new HashMap<Integer,String[]>();
		int userkey=1;
		String [] ssn_array = new String[10] ;
		for (int i = 0 ; i < 10; i++) {
			ssn_array[i] = Integer.toString(unique_id++);
		}
		userMap.put(userkey++, new String[]{"PatientAA","PatientLL","01/01/2000","12345678",ssn_array[0],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[0]+email,"Testdata1",userName+ssn_array[0],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientBB","PatientMM","01/01/2000","12345678",ssn_array[1],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[1]+email,"Testdata1",userName+ssn_array[1],"Testdata1","okay"}); 
		return userMap;   
	}
 
/*
 * Enter the Userdetails to register in the site MMP
 */
	public  String[] fillData(Map<Integer,String[]> allUsersMap,Integer userKey)
	{

		driver.findElement(By.xpath("//input[@value='Register']")).click();
		String[] userDetails = allUsersMap.get(userKey);
		driver.findElement(By.id("firstname")).sendKeys(userDetails[0]);
		driver.findElement(By.id("lastname")).sendKeys(userDetails[1]);
		driver.findElement(By.id("datepicker")).sendKeys(userDetails[2]);
		driver.findElement(By.id("license")).sendKeys(userDetails[3]);
		driver.findElement(By.id("ssn")).sendKeys(userDetails[4]);
		driver.findElement(By.id("state")).sendKeys(userDetails[5]);
		driver.findElement(By.id("city")).sendKeys(userDetails[6]);
		driver.findElement(By.id("address")).sendKeys(userDetails[7]);
		driver.findElement(By.id("zipcode")).sendKeys(userDetails[8]);
		driver.findElement(By.id("age")).sendKeys(userDetails[9]);
		driver.findElement(By.id("height")).sendKeys(userDetails[10]);
		driver.findElement(By.id("weight")).sendKeys(userDetails[11]);
		driver.findElement(By.id("pharmacy")).sendKeys(userDetails[12]);
		driver.findElement(By.id("pharma_adress")).sendKeys(userDetails[13]);
		driver.findElement(By.id("email")).sendKeys(userDetails[14]);
		driver.findElement(By.id("password")).sendKeys(userDetails[15]);
		driver.findElement(By.id("username")).sendKeys(userDetails[16]);
		driver.findElement(By.id("confirmpassword")).sendKeys(userDetails[17]);

		Select options= new Select(driver.findElement(By.id("security")));
		List<WebElement> list= options.getOptions();
		int size= list.size();
		System.out.println("security list size:"+size); 
		options.selectByIndex(0);
		
		driver.findElement(By.id("answer")).sendKeys(userDetails[18]);
		String[] data= new String[3];
		data[0]=userDetails[16];
		data[1]=userDetails[15];
		data[2]=userDetails[4];
		
		System.out.println("Patient first name: " + userDetails[0]);
		System.out.println("User name: " + data[0]);
		System.out.println("Password: " + data[1]);
		System.out.println("ssn: " + data[2]);
		
		driver.findElement(By.name("register")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
		return data;
	}

}
