package com.appiumDemo.po;

public class ReleasePage {

    //输入框的class和index
    private String testView = "class=android.widget.EditText";
    private int testViewIndex = 0;

    //发表按钮的class和index
    private String releaseButton = "class=android.widget.Button";
    private int releaseButtonIndex = 1;

    //上传图片按钮的class和index
    private String fileButton = "class=android.widget.ImageView";
    private  int fileButtonIndex = 1;

    //上传图片
    private String filePicButton = "id=net.onest.hanstyleproject:id/check_view";
    private int filePicButtonIndex = 1;

    //确认上传图片按钮
    private String fileConfirm = "id=net.onest.hanstyleproject:id/button_apply";
    private int fileConfirmIndex = 1;

    //已上传图片
    private  String hasFile = "id=net.onest.hanstyleproject:id/single_img";
    private int hasFileIndex = 0;

    //当前页面元素
    private String releasePageElem = "//*[@text='发表']";

    public String getTestView() {
        return testView;
    }

    public int getTestViewIndex() {
        return testViewIndex;
    }

    public String getReleaseButton() {
        return releaseButton;
    }

    public int getReleaseButtonIndex() {
        return releaseButtonIndex;
    }

    public String getFileButton() {
        return fileButton;
    }

    public int getFileButtonIndex() {
        return fileButtonIndex;
    }

    public String getReleasePageElem() {
        return releasePageElem;
    }

    public String getFilePicButton() {
        return filePicButton;
    }

    public int getFilePicButtonIndex() {
        return filePicButtonIndex;
    }

    public String getFileConfirm() {
        return fileConfirm;
    }

    public int getFileConfirmIndex() {
        return fileConfirmIndex;
    }

    public String getHasFile() {
        return hasFile;
    }

    public int getHasFileIndex() {
        return hasFileIndex;
    }
}
