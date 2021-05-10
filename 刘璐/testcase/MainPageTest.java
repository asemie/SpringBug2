package testcase;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.LoginPage;
import pages.MainPage;

public class MainPageTest extends BaseDriver {
	MainPage mainPage;

	@BeforeClass
	public void login() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		mainPage = loginPage.login_success("18330278360", "111111");
	}

	// 点击小知识
	@Test(priority = 1)
	public void test_tips() {
		mainPage.tips_click_first();

	}

	@Test(priority = 2)
	public void test_tips_collect() {
		mainPage.tips_click_collect();
	}

	@Test(priority = 3)
	public void test_tips_cancelcollect() {
		mainPage.tips_click_collect();
	}

	@Test(priority = 4)
	public void test_share() {
		mainPage.follow_click_share();
	}

	@Test(priority = 5)
	public void test_comment1() {
		mainPage.tips_comment("123");
	}

	@Test(priority = 6)
	public void test_comment2() {
		mainPage.tips_comment("abc");
	}

	@Test(priority = 7)
	public void test_comment3() {
		mainPage.tips_comment("123abc");
	}

	@Test(priority = 8)
	public void test_comment4() {
		mainPage.tips_comment("..m/---");
	}

	@Test(priority = 9)
	public void test_comment5() {
		mainPage.tips_comment("     ");
	}

	@Test(priority = 10)
	public void test_comment6() {
		mainPage.tips_comment("123" + "\n" + "123");
	}

	@Test(priority = 11)
	public void test_comments() {
		List<String> list = new ArrayList<String>();
		list.add("1123");
		list.add("acd");
		mainPage.tips_comment_many(list);
	}

	// follow
//	动态详情
	@Test(priority = 12)
	public void test_follow_share() {
		mainPage.click_follow();
		mainPage.follow_click_share();

	}

//	点赞
	@Test(priority = 13)
	public void test_follow_like() {
		mainPage.follow_click_like();
	}

//	取消点赞
	@Test(priority = 14)
	public void test_follow_cancelLike() {
		mainPage.follow_click_like();
	}

	@Test(priority = 15)
	public void test_follow_comment1() {
		mainPage.follow_send_comment("test评论");
	}

	@Test(priority = 16)
	public void test_follow_comment2() {
		mainPage.follow_send_comment("123");
	}

	@Test(priority = 17)
	public void test_follow_comment3() {
		mainPage.follow_send_comment("test评论===//");
	}

	@Test(priority = 18)
	public void test_follow_comment4() {
		mainPage.follow_send_comment("    ");
	}

	@Test(priority = 19)
	public void test_follow_comment5() {
		mainPage.follow_send_comment("    lld" + "\n" + "dd");
	}

	@Test(priority = 20)
	public void test_follow_comments() {
		List<String> list = new ArrayList<String>();
		list.add("122.ds");
		list.add(",ddww第二条评论");
		mainPage.follow_comment_many(list);
	}

	// 删除评论cancel
	@Test(priority = 21)
	public void test_delete_comment1() {
		mainPage.action_delete_cancel();
	}

	// 删除评论ok
	@Test(priority = 22)
	public void test_delete_comment2() {
		mainPage.action_delete_ok();
	}

	@Test(priority = 23)
	public void test_head() {
		mainPage.click_head();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
