package com.mobile.test.automation.framework.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mobile.test.automation.framework.utils.PrerequisiteUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Configuration
public class MobileDriverConfiguration
{
    @Value("${node.bin.path}")
    private String nodeJsPath;

    @Value("${appium.js.path}")
    private String appiumJsPath;

    @Value("${server.startup.timeout}")
    private int defaultTimeout;

    @Value("${mobile.sdk}")
    private String mobileSdk;

    @Value("${apk.location}")
    private String apkLocation;

    @Value("${main.activity}")
    private String mainActivity;

    @Value("${android.home}")
    private String androidHome;

    @Value("${java.home}")
    private String javaHome;

    private AppiumDriverLocalService localService()
    {
        final File appiumJS = new File(appiumJsPath);
        final File nodeJSExecutable = new File(nodeJsPath);
        final File logFile = new File("logs/appiumlogs.log");

        final AppiumServiceBuilder localServiceBuilder = new AppiumServiceBuilder();

        localServiceBuilder.withAppiumJS(appiumJS).usingAnyFreePort().usingDriverExecutable(nodeJSExecutable)
            .withArgument(AppiumDriverServerArguments.LOG_LEVEL, "info:debug")
            .withArgument(AppiumDriverServerArguments.SESSION_OVERRIDE)
            .withArgument(AppiumDriverServerArguments.LOG_NO_COLORS)
            .withStartUpTimeOut(defaultTimeout, TimeUnit.SECONDS).withLogFile(logFile);

        final AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(localServiceBuilder);

        if (localService.isRunning()) {
            localService.stop();
        }

        localService.start();

        return localService;
    }

    @Bean
    public AndroidDriver<MobileElement> ofAndroid()
    {
        final boolean isNotDriverInitiated = MobileDriverContext.getAndroidDriver() == null;

        if (!isNotDriverInitiated) {
            return MobileDriverContext.getAndroidDriver();
        }

        final DesiredCapabilities extraCapabilities = new DesiredCapabilities();

        final String apkName = new File(apkLocation).getAbsolutePath();
        extraCapabilities.setCapability(MobileCapabilityType.APP, apkName);
        extraCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, mainActivity);

        PrerequisiteUtils.setEnvironmentVariable("ANDROID_HOME", androidHome);
        PrerequisiteUtils.setEnvironmentVariable("JAVA_HOME", javaHome);

        final WebDriver driver = new AndroidDriver<MobileElement>(localService(),
            MobileDriverCapabilties.valueOf(mobileSdk.toUpperCase()).returnCapabilities(extraCapabilities));

        MobileDriverContext.set(driver);

        return MobileDriverContext.getAndroidDriver();
    }

    @Bean
    public AppiumDriver<MobileElement> ofAppium()
    {
        return MobileDriverContext.getAppiumDriver();
    }

    @Bean
    public IOSDriver<MobileElement> ofIOS()
    {
        WebDriver driver = new IOSDriver<IOSElement>(localService(),
            MobileDriverCapabilties.valueOf(mobileSdk.toUpperCase()).returnCapabilities(new DesiredCapabilities()));

        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new MobileDriverActivityListener());

        MobileDriverContext.set(driver);

        return MobileDriverContext.getIOSDriver();
    }
}
