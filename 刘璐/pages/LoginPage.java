package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	//ͨ�����췽������driver��ʼ��
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		
		this.driver=driver;
		this.action=new BaseAction(driver);
		
	}
	
//	public AndroidElement edit_username() {
//		return driver.findElementById("com.example.todolist:id/nameET");
//	}
//	
//	public AndroidElement edit_password() {
//		return driver.findElementById("com.example.todolist:id/passwordET");
//	}
//	
//	public AndroidElement btn_login() {
//		return driver.findElementById("com.example.todolist:id/loginBtn");
//	}
//	
//	public MainPage login_sucess(String username,String password) {
//		action.type(edit_username(), username);
//		action.type(edit_password(), password);
//		action.click(btn_login());
//		return new MainPage(driver);
//	
//	}
//	
//	public String login_fail(String username,String password) {
//		action.type(edit_username(), username);
//		action.type(edit_password(), password);
//		action.click(btn_login());
//		return action.getToast();
//	
//	}
	public AndroidElement btn_PhoneLogin() {
		return driver.findElementById("net.onest.hanstyleproject:id/main_btn_login");
	}
	public AndroidElement edit_username() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_et_info");
	}
	public AndroidElement edit_password() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_et_pwd");
	}
	public AndroidElement btn_login() {
		return driver.findElementById("net.onest.hanstyleproject:id/login_btn_login");
	}
	
	public MainPage login_success(String username,String password) throws InterruptedException {
		action.click(btn_PhoneLogin());
		Thread.sleep(2000);
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new MainPage(driver);
	}
	

}
