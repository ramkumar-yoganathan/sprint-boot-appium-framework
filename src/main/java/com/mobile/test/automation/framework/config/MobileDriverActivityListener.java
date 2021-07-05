package com.mobile.test.automation.framework.config;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobile.test.automation.framework.service.CameraService;

import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

public class MobileDriverActivityListener implements AppiumWebDriverEventListener
{
    @Autowired
    private CameraService camera;

    @Override
    public void afterAlertAccept(final WebDriver driver)
    {

    }

    @Override
    public void afterAlertDismiss(final WebDriver driver)
    {

    }

    @Override
    public void afterChangeValueOf(final WebElement element, final WebDriver driver)
    {

    }

    @Override
    public void afterChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend)
    {

    }

    @Override
    public void afterClickOn(final WebElement element, final WebDriver driver)
    {

    }

    @Override
    public void afterFindBy(final By by, final WebElement element, final WebDriver driver)
    {
        camera.takeScreenShot();
    }

    @Override
    public <X> void afterGetScreenshotAs(final OutputType<X> target, final X screenshot)
    {

    }

    @Override
    public void afterGetText(final WebElement element, final WebDriver driver, final String text)
    {

    }

    @Override
    public void afterNavigateBack(final WebDriver driver)
    {

    }

    @Override
    public void afterNavigateForward(final WebDriver driver)
    {

    }

    @Override
    public void afterNavigateRefresh(final WebDriver driver)
    {

    }

    @Override
    public void afterNavigateTo(final String url, final WebDriver driver)
    {

    }

    @Override
    public void afterScript(final String script, final WebDriver driver)
    {

    }

    @Override
    public void afterSwitchToWindow(final String windowName, final WebDriver driver)
    {

    }

    @Override
    public void beforeAlertAccept(final WebDriver driver)
    {

    }

    @Override
    public void beforeAlertDismiss(final WebDriver driver)
    {

    }

    @Override
    public void beforeChangeValueOf(final WebElement element, final WebDriver driver)
    {

    }

    @Override
    public void beforeChangeValueOf(final WebElement element, final WebDriver driver, final CharSequence[] keysToSend)
    {

    }

    @Override
    public void beforeClickOn(final WebElement element, final WebDriver driver)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeFindBy(final By by, final WebElement element, final WebDriver driver)
    {

    }

    @Override
    public <X> void beforeGetScreenshotAs(final OutputType<X> target)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeGetText(final WebElement element, final WebDriver driver)
    {

    }

    @Override
    public void beforeNavigateBack(final WebDriver driver)
    {

    }

    @Override
    public void beforeNavigateForward(final WebDriver driver)
    {

    }

    @Override
    public void beforeNavigateRefresh(final WebDriver driver)
    {

    }

    @Override
    public void beforeNavigateTo(final String url, final WebDriver driver)
    {

    }

    @Override
    public void beforeScript(final String script, final WebDriver driver)
    {

    }

    @Override
    public void beforeSwitchToWindow(final String windowName, final WebDriver driver)
    {

    }

    @Override
    public void onException(final Throwable throwable, final WebDriver driver)
    {

    }

}
