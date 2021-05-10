package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.LoginPage;

public class LoginPageTest extends BaseDriver {
	LoginPage loginPage;
	@BeforeClass
	public void initPage() {
		loginPage=new LoginPage(driver);
	}
	@Test
	public void test_login_success() throws InterruptedException {
		loginPage.login_success("18330278360", "111111");
		assertEquals(driver.currentActivity(), ".content.activity.ContentActivity");
		
	}
	

//	@Test
//	public void test_login_fail() {
//
//		String message=loginPage.login_fail("1", "2");
//
//		assertEquals(message, "�û��������������");
//		
//		
//	}

}
