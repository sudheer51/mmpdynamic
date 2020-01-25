package org.iit.mmp.tests;

import org.iit.mmp.pages.LoginPage;
import org.iit.mmp.pages.NavigatePage;
import org.iit.mmp.pages.TestBaseClass;
import org.iit.mmp.pages.MessagePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PAT009_Tests extends TestBaseClass {
	@Test
	public void validate() throws InterruptedException
	{
		SoftAssert sa = new SoftAssert();
		
		LoginPage lobj = new LoginPage(driver);
		boolean result1 = lobj.login("ria1","Ria12345");
		sa.assertTrue(result1);
		
		NavigatePage nobj = new NavigatePage(driver);
		boolean result2 = nobj.navigateToModule("Messages");
		sa.assertTrue(result2);

		MessagePage wobj= new MessagePage(driver);
		try {
			wobj.writeMessage();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sa.assertAll();
	}

}


