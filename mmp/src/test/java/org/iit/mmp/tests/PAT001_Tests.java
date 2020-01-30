package org.iit.mmp.tests;

import org.iit.mmp.pages.AdminPage;
import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.RegistrationPage;
import org.iit.mmp.pages.SubModulePage;
import org.iit.mmp.pages.TestBaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/**
 * 
 * @author qa
 * Description:
 * 	Register the Patient
 *
 */
public class PAT001_Tests extends TestBaseClass{

	@Parameters({"adUname","adPassword","patUname","patPassword"})
	@Test
	public  void register(String adUname,String adPassword,String patUname,String patPassword) throws InterruptedException
	{
		SoftAssert sa= new SoftAssert();

		launchPatientApp();
		launchAdminApp();
		LoginPage lPage = new LoginPage(driver);
		AdminPage adminPage = new AdminPage(driver);
		adminPage.navigatetoDoctorLoginButton();
		adminPage.adminLogin(adUname, adPassword);
		RegistrationPage regPage = new RegistrationPage(driver);
		String ssn = regPage.fetchssn();
		boolean officeloginSuccessResult=adminPage.approvePatient(ssn);
		sa.assertTrue(officeloginSuccessResult);
		boolean logoutSuccess= lPage.logout("Logout");
		sa.assertTrue(logoutSuccess);

		launchPatientApp(); 
		boolean userloginResult=lPage.login(patUname, patPassword) ;
		sa.assertTrue(userloginResult);
		SubModulePage modulePage = new SubModulePage(driver);
		boolean navigatemoduleResult=modulePage.navigateToAmodule(" Profile ","Personal Details");
		sa.assertTrue(navigatemoduleResult);
		Thread.sleep(5000);
		boolean proflogoutResult= lPage.logout("Logout");
		sa.assertTrue(proflogoutResult);
		sa.assertAll();
	}
}

