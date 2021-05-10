package com.appiumDemo.po;

public class ShopPage {

    //商品、店铺输入框id
    private String goodsName = "id=net.onest.hanstyleproject:id/market_et_search";
    private int goodsNameIndex = 0;

    //搜索按钮id
    private String searchButton = "id=net.onest.hanstyleproject:id/market_img_search";
    private int searchButtonIndex = 2;

    //进入购物车按钮id
    private String enterCartButton = "id=net.onest.hanstyleproject:id/market_img_cart";
    private int enterCartButtonIndex = 0;

    //加入购物车按钮id
    private String shopCartButton = "id=net.onest.hanstyleproject:id/grid_item_btn_add";
    private int shopCartButtonIndex = 0;

    //商品图片id
    private String goodsPic = "id=net.onest.hanstyleproject:id/grid_item_img";
    private int goodsPicIndex = 0;

    //商品分类图片id
    private String goodsKind = "id=net.onest.hanstyleproject:id/market_img_yueqi";
    private int goodsKindIndex = 0;

    private String shopPageElem = "//*[@text='请输入商品、店铺']";

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsNameIndex() {
        return goodsNameIndex;
    }

    public String getSearchButton() {
        return searchButton;
    }

    public int getSearchButtonIndex() {
        return searchButtonIndex;
    }

    public String getEnterCartButton() {
        return enterCartButton;
    }

    public int getEnterCartButtonIndex() {
        return enterCartButtonIndex;
    }

    public String getShopCartButton() {
        return shopCartButton;
    }

    public int getShopCartButtonIndex() {
        return shopCartButtonIndex;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public int getGoodsPicIndex() {
        return goodsPicIndex;
    }

    public int getGoodsKindIndex() {
        return goodsKindIndex;
    }

    public String getGoodsKind() {
        return goodsKind;
    }


    public String getShopPageElem(){
        return shopPageElem;
    }
}
