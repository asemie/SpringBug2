package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//	初始化
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

	// 小知识

	public AndroidElement btn_tips() {
		AndroidElement parents = driver.findElementById("net.onest.hanstyleproject:id/child_tabs");
		return (AndroidElement) parents.findElementById("net.onest.hanstyleproject:id/ln_tips");

	}

	public List<MobileElement> list_tips() {
		AndroidElement parents = driver.findElementById("net.onest.hanstyleproject:id/lv_tips");
		return parents.findElementsByClassName("android.widget.LinearLayout");
	}

	// tips_收藏
	public AndroidElement tips_collect() {
		return driver.findElementById("net.onest.hanstyleproject:id/iv_collect");
	}

	// tips_分享
	public AndroidElement tips_share() {
		return driver.findElementById("net.onest.hanstyleproject:id/iv_share");
	}

	// 评论
	public AndroidElement comment() {
		return driver.findElementById("net.onest.hanstyleproject:id/et_comment");
	}

	// 评论_发送
	public AndroidElement comment_send() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_send");
	}

	// 关注
	public AndroidElement follow() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_follow");
	}

	// all_follow
	public List<MobileElement> all_follow() {
		AndroidElement parent = driver.findElementById("net.onest.hanstyleproject:id/lv_follow");
		return parent.findElementsByClassName("android.widget.LinearLayout");
	}

	// follow_like
	public AndroidElement follow_like() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_like");
	}

	// follow_share
	public AndroidElement follow_share() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_share");
	}

	// follow_comment
	public AndroidElement follow_comment() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_comment");
	}

//	follow_comment_delete
	public AndroidElement follow_comment_delete() {
		return driver.findElementById("net.onest.hanstyleproject:id/tv_delete");
	}

	// 确定删除
	public AndroidElement delete_ok() {
		return driver.findElementById("android:id/button1");
	}

	// 取消删除
	public AndroidElement delete_cancel() {
		return driver.findElementById("android:id/button2");
	}

	// back
	public AndroidElement back() {
		return driver.findElementById("net.onest.hanstyleproject:id/item_comment_back");
	}

	// head
	public AndroidElement head() {
		return driver.findElementById("net.onest.hanstyleproject:id/item_detail_head");
	}

//	cancel_follow
	

	// tips_点击第一个
	public void tips_click_first() {
		btn_tips().click();
		list_tips().get(0).click();
	}

	// 点击收藏
	public void tips_click_collect() {
		tips_collect().click();
	}

	// 点击分享
	public void tips_click_share() {
		tips_share().click();
	}

	// tips_发表评论
	public void tips_comment(String comment) {
		action.type(comment(), comment);
		comment_send().click();
	}

	// tips连续发表多条评论
	public void tips_comment_many(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			action.type(comment(), list.get(i));
			comment_send().click();
		}
	}

	// 点击关注
	public void click_follow() {
		follow().click();
	}

	// 第一个动态关注_点赞
	public void follow_click_like() {
		all_follow().get(0).click();
		follow_like().click();
	}

	// 第一个动态关注_分享
	public void follow_click_share() {
		all_follow().get(0).click();
		follow_share().click();
	}

	// follow发表评论
	public void follow_send_comment(String comment) {
		follow_comment().click();
		action.type(comment(), comment);
		comment_send().click();

	}

	// follow连续发表多条评论
	public void follow_comment_many(List<String> list) {

		for (int i = 0; i < list.size(); i++) {
			follow_comment().click();
			action.type(comment(), list.get(i));// clear
			comment_send().click();
		}
	}

	// 确定删除评论
	public void action_delete_ok() {
		follow_comment_delete().click();
		delete_ok().click();
	}

	// 取消删除评论
	public void action_delete_cancel() {
		follow_comment_delete().click();
		delete_cancel().click();
	}

//		详情后back
	public void action_back() {
		back().click();
	}

//	详情后点击头像
	public void click_head() {
		head().click();
	}

}
