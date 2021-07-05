package com.mobile.test.automation.framework.config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public enum MobileDriverCapabilties
{
    ANDROID {
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities)
        {
            final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, 30 * 1000);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                AutomationName.ANDROID_UIAUTOMATOR2);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 10);
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            desiredCapabilities.merge(extraCapabilities);

            return desiredCapabilities;
        }

    },

    CHROME {
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities)
        {
            final ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.addArguments("disable-infobars");
            browserOptions.addArguments("--start-maximized");
            browserOptions.merge(extraCapabilities);
            return browserOptions;
        }

    },

    IOS {
        @Override
        public MutableCapabilities returnCapabilities(final DesiredCapabilities extraCapabilities)
        {
            final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            desiredCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60 * 1000);
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
            desiredCapabilities.merge(extraCapabilities);

            return desiredCapabilities;
        }

    };

    public abstract MutableCapabilities returnCapabilities(DesiredCapabilities desiredCapabilities);
}
