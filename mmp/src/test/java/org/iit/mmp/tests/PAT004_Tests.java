  
package org.iit.mmp.tests;

import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.enterSymptomsPage;
import org.iit.mmp.pages.SubModulePage;
import org.iit.mmp.pages.TestBaseClass;
import org.iit.mmp.pages.selectApptPage;
import org.iit.mmp.pages.selectDoctorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PAT004_Tests extends TestBaseClass  {
	
	WebDriver driver;

	@Test
	
	/*
	 * @author : Elizabeth J
	 * validateScheduleAppointmenttab is used to Schedule a doctor appointment. 
	 * the navigateToAmodule is to select the required link from the web page. 
	 * the selectDoctor method is to select the required doctor. 
	 * the selectApptDatenTime is to select the date and time of the appointment. 
	 * the enterSymptoms method is to enter they symptoms of the illness.
	 */

	public void validateScheduleAppointmenttab() {
		
		SoftAssert sa = new SoftAssert();
		
		SubModulePage mod1 = new SubModulePage(driver);
		boolean res2 = mod1.navigateToAmodule("Schedule Appointment");
		sa.assertTrue(res2);

		selectDoctorPage dr1 = new selectDoctorPage(driver);
		boolean res3 = dr1.selectDoctor("Dr.Charlie");
		sa.assertTrue(res3);

		selectApptPage appt1 = new selectApptPage(driver);
		boolean res4 = appt1.selectApptDatenTime("14/February/2020", "11Am");
		sa.assertTrue(res4);

		enterSymptomsPage symp1 = new enterSymptomsPage(driver);
		boolean res5 = symp1.enterSymptoms("Flu symptoms of fever, cold and chills.");
		sa.assertTrue(res5);
		
		sa.assertAll();
		
	}
}