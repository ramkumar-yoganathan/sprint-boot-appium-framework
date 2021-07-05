package com.mobile.test.automation.framework.screens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.test.automation.framework.AndroidBaseScreen;
import com.mobile.test.automation.framework.config.MobileDriverConfiguration;
import com.mobile.test.automation.framework.config.TestDataConfiguration;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

@Component
public class HomeScreen extends AndroidBaseScreen
{
    @Autowired
    private TestDataConfiguration dataFaker;

    @Autowired
    private MobileDriverConfiguration driver;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().text(\"Buy 101 devices\"))", className = "android.widget.RadioButton")
    private AndroidElement androidBuy101DevicesRadio;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().text(\"Use Testdroid Cloud\"))", className = "android.widget.RadioButton")
    private AndroidElement androidUseTestdroidCloudRadio;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().text(\"Ask mom for help\"))", className = "android.widget.RadioButton")
    private AndroidElement androidAskmomforhelpRadio;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.bitbar.testdroid:id/editText1\"))", className = "android.widget.EditText")
    private AndroidElement androidNameText;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.bitbar.testdroid:id/button1\"))", className = "android.widget.Button")
    private AndroidElement androidAnswerButton;

    public void checkThatGivenAnswerIsCorrect()
    {
        androidBuy101DevicesRadio.click();
        androidUseTestdroidCloudRadio.click();
        androidAskmomforhelpRadio.click();
        androidNameText.sendKeys(dataFaker.faker().name().firstName());
        driver.ofAppium().hideKeyboard();
        androidAnswerButton.click();
    }

    @Override
    public boolean isActivityLoaded()
    {
        return false;
    }
}
