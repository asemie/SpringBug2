package com.appiumDemo.testcase;

import com.appiumDemo.core.BaseTest;
import com.appiumDemo.po.EntrancePage;
import com.appiumDemo.po.LoginPage;
import com.appiumDemo.po.MainPage;
import com.appiumDemo.po.ShopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShop extends BaseTest {
    private EntrancePage entrancePage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private ShopPage shopPage;

    @BeforeClass
    public void selectLogin(){
        entrancePage = new EntrancePage();
        engine.click(entrancePage.getLoginButton(),entrancePage.getLoginButtonIndex());

        loginPage=new LoginPage();
        engine.type(loginPage.getUsername(),loginPage.getUsernameIndex(),"15373107561");
        engine.type(loginPage.getPwd(),loginPage.getPwdIndex(),"zzzzzz");
        engine.click(loginPage.getLoginButton(),loginPage.getLoginButtonIndex());

        mainPage = new MainPage();
        engine.click(mainPage.getShopButton(),mainPage.getShopButtonIndex());

        shopPage =new ShopPage();
    }

    //test1 点击输入框输入商品 点击搜索
    @Test
    public void test01(){
        engine.click(shopPage.getGoodsName(),shopPage.getGoodsNameIndex());
        engine.clearAndType(shopPage.getGoodsName(),shopPage.getGoodsNameIndex(),"汉服");

        engine.click(shopPage.getSearchButton(),shopPage.getSearchButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test2 不输入商品 直接搜索
    @Test
    public void test02(){
        engine.click(shopPage.getSearchButton(),shopPage.getSearchButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test3 进入购物车页面
    @Test
    public  void  test03(){
        engine.click(shopPage.getEnterCartButton(),shopPage.getEnterCartButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test4 点击商品分类页面
    @Test
    public  void  test04(){
        engine.click(shopPage.getGoodsKind(),shopPage.getGoodsKindIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test5 点击加入购物车
    @Test
    public  void  test05(){
        engine.click(shopPage.getShopCartButton(),shopPage.getShopCartButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test6 点击商品图片 进入详情页
    @Test
    public  void  test06(){
        engine.click(shopPage.getGoodsPic(),shopPage.getGoodsPicIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test7 点击输入框 输入错误商品 进行搜索
    @Test
    public void test07(){
        engine.click(shopPage.getGoodsName(),shopPage.getGoodsNameIndex());
        engine.clearAndType(shopPage.getGoodsName(),shopPage.getGoodsNameIndex(),"huhwcuwheoohs");

        engine.click(shopPage.getSearchButton(),shopPage.getSearchButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }
    //test8 点击输入框 输入十个空格进行搜索
    @Test
    public void test08(){
        engine.click(shopPage.getGoodsName(),shopPage.getGoodsNameIndex());
        engine.clearAndType(shopPage.getGoodsName(),shopPage.getGoodsNameIndex(),"          ");

        engine.click(shopPage.getSearchButton(),shopPage.getSearchButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }

    //test9 点击输入框 输入50个1进行搜索
    @Test
    public void test09(){
        engine.click(shopPage.getGoodsName(),shopPage.getGoodsNameIndex());
        engine.clearAndType(shopPage.getGoodsName(),shopPage.getGoodsNameIndex(),"11111111111111111111" +
                "111111111111111111111111111111");

        engine.click(shopPage.getSearchButton(),shopPage.getSearchButtonIndex());

        Assert.assertFalse(engine.isElementPresent(shopPage.getShopPageElem(),0));
    }
}
