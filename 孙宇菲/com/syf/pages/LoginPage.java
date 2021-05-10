package com.syf.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import com.syf.utils.BaseAction;

public class LoginPage {

	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	//通过构造方法对于driver初始化
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		
		this.driver=driver;
		this.action=new BaseAction(driver);
		
	}
	
	public AndroidElement btn_login1() {
		return driver.findElementById("net.onest.hanstyleproject:id/main_btn_login");
	}
	
	public AndroidElement edit_username() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_et_info");
	}
	
	public AndroidElement edit_password() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_et_pwd");
	}
	
	public AndroidElement btn_login2() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_btn_login");
	}
	
	public MessagePage login_sucess(String username,String password) {
		action.click(btn_login1());
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login2());
		return new MessagePage(driver);
	
	}
}
