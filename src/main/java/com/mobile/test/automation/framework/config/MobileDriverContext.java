package com.mobile.test.automation.framework.config;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

@SuppressWarnings("unchecked")
public final class MobileDriverContext
{
    private static InheritableThreadLocal<WebDriver> threadContext = new InheritableThreadLocal<>();

    public static AndroidDriver<MobileElement> getAndroidDriver()
    {
        return (AndroidDriver<MobileElement>) threadContext.get();
    }

    public static AppiumDriver<MobileElement> getAppiumDriver()
    {
        return (AppiumDriver<MobileElement>) threadContext.get();
    }

    public static IOSDriver<MobileElement> getIOSDriver()
    {
        return (IOSDriver<MobileElement>) threadContext.get();
    }

    public static WebDriver getWebDriver()
    {
        return threadContext.get();
    }

    public static void set(final WebDriver driver)
    {
        threadContext.set(driver);
    }

    private MobileDriverContext()
    {
        // Use this class as static. Avoiding instantiate.
    }
}
