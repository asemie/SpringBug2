package com.syf.pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.syf.utils.BaseAction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MessagePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	// 构造方法
	public MessagePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	// 信息
	public AndroidElement btn_message() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_message");
	}

	// 写信
	public AndroidElement btn_writeLetter() {
		return driver.findElementById("net.onest.hanstyleproject:id/letter_tv_write");
	}

	// 发送
	public AndroidElement btn_send() {
		return driver.findElementById("net.onest.hanstyleproject:id/doodle_btn_finish");
	}

	//收件人不能为空弹窗确定
	public AndroidElement btn_affrim() {
		return driver.findElementById("net.onest.hanstyleproject:id/dialog_enter_btn_02");
	}
	
	//+收件人
	public AndroidElement add_receiver() {
		return driver.findElementById("net.onest.hanstyleproject:id/letter_content_receiver_head");
	}
	
	//收件人选择
	public AndroidElement select_receiver() {
		return driver.findElementById("net.onest.hanstyleproject:id/cb_receiver");
	}
	
	//收件人确定
	public AndroidElement receiver_affrim() {
		return driver.findElementById("net.onest.hanstyleproject:id/btn_submit");
	}
	
	public void clickMessage() {
		action.click(btn_message());
	}

	public void clickSend1() {
		action.click(btn_writeLetter());
		action.click(btn_send());
		action.click(btn_affrim());
	}
	
	public void clickSend2() {
		action.click(btn_writeLetter());
		action.click(add_receiver());
		action.click(select_receiver());
		action.click(receiver_affrim());
		action.click(btn_send());
	}
	
	public void write_letter(int x1, int y1, int x2, int y2, int x3, int y3) {
		action.click(btn_writeLetter());
		action.multiTouch(x1, y1, x2, y2, x3, y3);
		action.click(btn_send());
	}
	
	
}
