package com.appiumDemo.testcase;

import com.appiumDemo.core.BaseTest;
import com.appiumDemo.po.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRelease extends BaseTest {

    private EntrancePage entrancePage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ReleasePage releasePage;

    @BeforeClass
    public void selectLogin(){
        entrancePage = new EntrancePage();
        engine.click(entrancePage.getLoginButton(),entrancePage.getLoginButtonIndex());

        loginPage=new LoginPage();
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15373107561");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());

        mainPage = new MainPage();
        engine.click(mainPage.getAddButton(),mainPage.getAddButtonIndex());

        releasePage = new ReleasePage();
    }

    //test1 输入任意文字并发表
    @Test
    public void test01(){
        engine.click(releasePage.getTestView(),releasePage.getTestViewIndex());
        engine.clearAndType(releasePage.getTestView(),releasePage.getTestViewIndex(),"xiangyichen!");
        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));

    }

    //test2 不输入任何直接发表
    @Test
    public void test02(){
        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));
    }

    //test3 输入100个空格并发表
    @Test
    public void test03(){
        engine.click(releasePage.getTestView(),releasePage.getTestViewIndex());
        engine.clearAndType(releasePage.getTestView(),releasePage.getTestViewIndex(),"                          " +
                "                                                         ");
        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));

    }

    //test4 输入200个1并发表
    @Test
    public void test04(){
        engine.click(releasePage.getTestView(),releasePage.getTestViewIndex());
        engine.clearAndType(releasePage.getTestView(),releasePage.getTestViewIndex(),"111111111111111111111111111" +
                "11111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));

    }

    //test5 输入文字并上传图片在发表
    @Test
    public void test05(){
        engine.click(releasePage.getTestView(),releasePage.getTestViewIndex());
        engine.clearAndType(releasePage.getTestView(),releasePage.getTestViewIndex(),"xiangyichen!");

        engine.click(releasePage.getFileButton(),releasePage.getFileButtonIndex());
        engine.click(releasePage.getFilePicButton(),releasePage.getFilePicButtonIndex());
        engine.click(releasePage.getFileConfirm(),releasePage.getFileConfirmIndex());

        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));

    }

    //test6 不输入文字 上传图片并发表
    @Test
    public void test06(){
        engine.click(releasePage.getFileButton(),releasePage.getFileButtonIndex());
        engine.click(releasePage.getFilePicButton(),releasePage.getFilePicButtonIndex());
        engine.click(releasePage.getFileConfirm(),releasePage.getFileConfirmIndex());

        engine.click(releasePage.getReleaseButton(),releasePage.getReleaseButtonIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));
    }

    //test7 删除已上传图片
    @Test
    public void test07(){
        engine.click(releasePage.getTestView(),releasePage.getTestViewIndex());
        engine.clearAndType(releasePage.getTestView(),releasePage.getTestViewIndex(),"xiangyichen!");

        engine.click(releasePage.getFileButton(),releasePage.getFileButtonIndex());
        engine.click(releasePage.getFilePicButton(),releasePage.getFilePicButtonIndex());
        engine.click(releasePage.getFileConfirm(),releasePage.getFileConfirmIndex());

        engine.click(releasePage.getHasFile(),releasePage.getHasFileIndex());

        Assert.assertFalse(engine.isElementPresent(releasePage.getReleasePageElem(),0));
    }

}
