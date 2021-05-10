package com.appiumDemo.po;

public class LoginPage {

    //账号输入框的class和数组中下标
    private String username="class=android.widget.EditText";
    private int usernameIndex=2;

    //密码输入框的class和数组下标
    private String pwd="class=android.widget.EditText";
    private int pwdIndex=2;

    //登陆界面登录按钮的class和下标
    private String loginButton="class=android.widget.Button";
    private int loginButtonIndex=1;

    //主页元素
    private String mainPageElem = "resource-id=net.onest.hanstyleproject:id/publish";

    public String getUsername() {
        return username;
    }

    public int getUsernameIndex() {
        return usernameIndex;
    }

    public String getPwd() {
        return pwd;
    }

    public int getPwdIndex() {
        return pwdIndex;
    }

    public String getLoginButton() {
        return loginButton;
    }

    public int getLoginButtonIndex() {
        return loginButtonIndex;
    }

    public String getMainPageElem() {
        return mainPageElem;
    }

}
