package com.mobile.test.automation.framework;

import javax.annotation.PostConstruct;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobile.test.automation.framework.config.MobileDriverConfiguration;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class AndroidBaseScreen
{
    @Autowired
    public MobileDriverConfiguration driver;

    public abstract boolean isActivityLoaded();

    @PostConstruct
    public void loadActivityElements()
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver.ofAndroid()), this);
    }
}
