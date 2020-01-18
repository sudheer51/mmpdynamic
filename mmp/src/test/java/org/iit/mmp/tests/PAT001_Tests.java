package org.iit.mmp.tests;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PAT001_Tests {
	static WebDriver driver;

	@Test
	public  void register() throws InterruptedException
	{
		SoftAssert sa= new SoftAssert();

		Map<Integer,String[]> allUsersMap = getAllUserData();	

		int index=1;
		for(Integer userKey : allUsersMap.keySet()) 
		{
			index=index++;
			String userurl="http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
			launchBrowser(userurl);

			String[] data=fillData(allUsersMap,index,userKey);
			String userName=data[0];
			String password=data[1];
			String ssn=data[2];
			
			String Adminurl="http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/";
			launchBrowser(Adminurl);

			boolean officeloginSuccessResult=officeLogin(ssn);
			sa.assertTrue(officeloginSuccessResult);
			boolean logoutSuccess= logout("Logout");
			sa.assertTrue(logoutSuccess);

			launchBrowser(userurl);
			boolean userloginResult=login(userName, password) ;
			sa.assertTrue(userloginResult);
			boolean navigatemoduleResult=navigateToAmodule(" Profile ","Personal Details");
			sa.assertTrue(navigatemoduleResult);
			Thread.sleep(5000);
			boolean proflogoutResult= logout("Logout");
			sa.assertTrue(proflogoutResult);
			sa.assertAll();
		}

	}
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
		/*userMap.put(userkey++, new String[]{"PatientCC","PatientNN","01/01/2000","12345678",ssn_array[2],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[2]+email,"Testdata1",userName+ssn_array[2],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientDD","PatientPP","01/01/2000","12345678",ssn_array[3],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[3]+email,"Testdata1",userName+ssn_array[3],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientEE","PatientQQ","01/01/2000","12345678",ssn_array[4],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[4]+email,"Testdata1",userName+ssn_array[4],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientFF","PatientRR","01/01/2000","12345678",ssn_array[5],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[5]+email,"Testdata1",userName+ssn_array[5],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientGG","PatientSS","01/01/2000","12345678",ssn_array[6],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[6]+email,"Testdata1",userName+ssn_array[6],"Testdata1","okay"});
	    userMap.put(userkey++, new String[]{"PatientHH","PatientTT","01/01/2000","12345678",ssn_array[7],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[7]+email,"Testdata1",userName+ssn_array[7],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientJJ","PatientUU","01/01/2000","12345678",ssn_array[8],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[8]+email,"Testdata1",userName+ssn_array[8],"Testdata1","okay"});
		userMap.put(userkey++, new String[]{"PatientKK","PatientVV","01/01/2000","12345678",ssn_array[9],"ny","ny","nycity","10001","19","175","55","ccs","ccs123",ssn_array[9]+email,"Testdata1",userName+ssn_array[9],"Testdata1","okay"});
       */
		return userMap;   
	}

	public  void launchBrowser(String url) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\deepa\\Downloads\\chromedriver_win32_v79\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.getTitle();
	}

	public  String[] fillData(Map<Integer,String[]> allUsersMap,int index,Integer userKey)
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
		if (index>5)
		{index=1;}
		options.selectByIndex(index);
		
		driver.findElement(By.id("answer")).sendKeys(userDetails[18]);
		String[] data= new String[3];//userDetails[4];
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
	public  boolean officeLogin(String ssnp) throws InterruptedException
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

		WebElement e1=driver.findElement(By.id("username"));
		e1.sendKeys("Thomas_444");
		Thread.sleep(4000);
		driver.findElement(By.id("password")).sendKeys("Edison_444");
		Thread.sleep(4000);
		driver.findElement(By.name("admin")).click();
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

	public  boolean logout(String  moduleName) throws InterruptedException 
	{
		boolean result=false;
		WebElement e=driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]"));
		//WebDriverWait wait1 = new WebDriverWait(driver, 30);
		//wait1.until(ExpectedConditions.elementToBeClickable(e));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait3 = new WebDriverWait(driver, 30);
		//wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'"+moduleName+"']")));

		System.out.println(e.getText());
		e.click();
		if (e!=null) {
			result= true;
		}
		Thread.sleep(2000);
		driver.close();
		return result;

	}

	public  boolean login(String userName,String password) 
	{
		Boolean result=false;
		System.out.println("inside login");
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();

		String user=driver.findElement(By.tagName("h3")).getText();
		if (user.contains(userName)) {
			result= true;
		}
		return result;
	}

	public  boolean navigateToAmodule(String  moduleName,String check) throws InterruptedException 
	{
		boolean result=false;
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
		WebElement e=driver.findElement(By.xpath("//h3[@class='panel-title']"));
		result = e.getText().contains(check);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", e);
		Thread.sleep(4000);
		return result;	
	}
}
