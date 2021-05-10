package com.syf.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.syf.base.BaseDriver;
import com.syf.pages.LoginPage;
import com.syf.pages.MessagePage;
import com.syf.utils.ReadProperties;

public class MessagePageTest extends BaseDriver{

	MessagePage messagePage;

	@BeforeClass
	public void login_message() {
		
		try {
			String login_phone=ReadProperties.getPropertyValue("login_phone");
			String login_pwd=ReadProperties.getPropertyValue("login_pwd");
			LoginPage loginPage = new LoginPage(driver);
			messagePage = loginPage.login_sucess(login_phone,login_pwd);
			messagePage.clickMessage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	@Test
//	//画斜线 不填写收件人 直接点击发送
//	public void write_letter1() {
//		messagePage.write_letter(1, 1, 2, 2, 10, 10);
//	}
	
	@Test(priority=1)
	//不填写内容 直接发送
	public void write_letter1() {
		messagePage.clickSend1();
	}
	
	@Test(priority=2)
	//不填写内容 选择收件人 直接发送
	public void write_letter2() {
		messagePage.clickSend2();
	}
	
}
