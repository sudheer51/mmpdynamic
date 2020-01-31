package org.iit.mmp.tests;


import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.NavigatePage;

import org.iit.mmp.pages.ViewHistoryPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.iit.mmp.pages.TestBaseClass;
import org.iit.mmp.pages.VerifyPastAppointmentPage;
import org.iit.mmp.pages.VerifyPastDiagnosisPage;
import org.iit.mmp.pages.VerifyPastPrescriptionPage;




public class PAT008_Tests extends TestBaseClass {
	
	
	
	@Test
	public void validateViewHistoryTab() 
	{
		
		SoftAssert sa = new SoftAssert();

		LoginPage lp = new LoginPage(driver);
		boolean result1 = lp.login("ria1","Ria12345");
		sa.assertTrue(result1);
		
		NavigatePage np = new NavigatePage(driver);
		boolean result2 = np.navigateToModule("Profile");
		sa.assertTrue(result2);
		
		ViewHistoryPage hp = new ViewHistoryPage(driver);
		boolean result3 = hp.navigateToHistory("View History");
		sa.assertTrue(result3);
		
		VerifyPastAppointmentPage pa = new VerifyPastAppointmentPage(driver);
		boolean result4 = pa.verifyPastAppointments("Past Appointments");
		sa.assertTrue(result4);
		
		VerifyPastDiagnosisPage pd = new VerifyPastDiagnosisPage(driver);
		boolean result5 = pd.verifyPastDiagnosis("Past diagnosis");
		sa.assertTrue(result5);
		
		VerifyPastPrescriptionPage pp = new VerifyPastPrescriptionPage(driver);
		boolean result6 = pp.verifyPastPrescription("Past Prescription");
		sa.assertTrue(result6);
		
		sa.assertAll();
		
		
		
	}
	
	
	
	
	
	
	

}
