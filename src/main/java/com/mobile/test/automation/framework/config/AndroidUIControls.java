package com.mobile.test.automation.framework.config;

public enum AndroidUIControls
{
    BUTTON("android.widget.Button"),

    CHECK_BOX("android.widget.CheckBox"),

    EDIT_TEXT("android.widget.EditText"),

    IMAGE("android.widget.Image"),

    IMAGE_VIEW("android.widget.ImageView"),

    RELATIVE_LAYOUT("android.widget.RelativeLayout"),

    SWITCH("android.widget.Switch"),

    TEXT_VIEW("android.widget.TextView"),

    VIEW("android.view.View");

    private String androidUiControl;

    AndroidUIControls(final String androidUiControl)
    {
        this.androidUiControl = androidUiControl;
    }

    @Override
    public String toString()
    {
        return androidUiControl;
    }
}
