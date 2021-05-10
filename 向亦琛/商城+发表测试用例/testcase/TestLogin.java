package com.appiumDemo.testcase;

import com.appiumDemo.core.BaseTest;
import com.appiumDemo.po.EntrancePage;
import com.appiumDemo.po.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    private EntrancePage entrancePage;
    private LoginPage loginPage;

    @BeforeClass
    public void selectLogin(){
        entrancePage = new EntrancePage();
        engine.click(entrancePage.getLoginButton(),entrancePage.getLoginButtonIndex());
        loginPage = new LoginPage();
    }

    //test1
    //打开登录界面，输入用户名和密码，查看能否成功登录
    @Test
    public void test01(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15373107561");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertTrue(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test2
    //打开登录界面，输入用户名，输入不同密码，查看是否能登录
    @Test
    public void test02(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15373107561");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"xyc");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test3
    //打开登录界面，不输入用户名密码，查看是否能登录
    @Test
    public void test03(){
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test4
    //打开登录界面，输入错误的用户名和正确的密码
    @Test
    public void test04(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15311111111");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test5
    //打开登录界面，输入错误的用户名和错误的密码
    @Test
    public void test05(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"11111111");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"xyc");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test6
    //输入正确的用户名不输入密码
    public void test06(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15373107561");
        //engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test7
    //输入正确的密码不输入用户名
    public void test07(){
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test8 输入空格加正确用户名 输入密码
    public void test08(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex()," 15373107561");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

    //test9 输入非正常格式的用户名和正确密码
    public void test09(){
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"153！！！！");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());
        Assert.assertFalse(engine.isElementPresent(loginPage.getMainPageElem(),0));
    }

}
