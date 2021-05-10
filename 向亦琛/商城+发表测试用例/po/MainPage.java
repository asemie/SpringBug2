package com.appiumDemo.po;

public class MainPage {

    //底部的商场模块的class和index
    private String shopButton = "class=android.widget.TextView";
    private int shopButtonIndex = 1;

    //底部的加号模块的class和index
    private  String addButton = "class=android.widget.ImageView";
    private int addButtonIndex = 2;

    public String getShopButton(){
        return shopButton;
    }

    public int getShopButtonIndex() {
        return shopButtonIndex;
    }


    public String getAddButton(){
        return addButton;
    }

    public int getAddButtonIndex() {
        return addButtonIndex;
    }
}
