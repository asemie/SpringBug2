package com.appiumDemo.po;

public class EntrancePage {

    //登录按钮的class和下标
    private String loginButton = "class=android.widget.Button";
    private int loginButtonIndex = 0;

    //注册
    private String registButton = "class=android.widget.Button";
    private int registButtonIndex = 1;

    public String getLoginButton() {
        return loginButton;
    }

    public int getLoginButtonIndex() {
        return loginButtonIndex;
    }

    public String getRegistButton() {
        return registButton;
    }

    public int getRegistButtonIndex() {
        return registButtonIndex;
    }

}
