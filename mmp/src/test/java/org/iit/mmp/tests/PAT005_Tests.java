package org.iit.mmp.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.SubModulePage;
import org.iit.mmp.pages.InformationPage;
import org.iit.mmp.pages.TestBaseClass;
public class PAT005_Tests extends TestBaseClass{	 
	@Test
	public void validateInformationTab()
	{ 
		SoftAssert sa = new SoftAssert();
		//Creation of object invokes the Constructor method
		LoginPage l1= new LoginPage(driver);
		boolean result1 = l1.login("ria1","Ria12345");
		sa.assertTrue(result1);
		
		//Creation of object invokes the Constructor method
		SubModulePage moduleObj = new SubModulePage(driver);
		boolean result2 = moduleObj.navigateToAmodule("Information");
		sa.assertTrue(result2);
		
		InformationPage infoObj = new InformationPage(driver);
		String actual =infoObj.fetchInformationMessage();
 		String expected="Manage My Patient (MMP) becomes your practice’s command center, delivering robust, real-time analytics through customizable reports and dashboards to ensure you know how your business is performing on the metrics that matter most.";
 		sa.assertEquals(actual, expected);
 		
		//Mandatory statement
		sa.assertAll();
		
	}
	 
	 
	 
	 
}
