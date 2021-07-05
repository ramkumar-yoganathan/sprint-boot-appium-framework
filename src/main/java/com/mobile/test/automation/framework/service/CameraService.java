package com.mobile.test.automation.framework.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.mobile.test.automation.framework.config.MobileDriverContext;

@Service
public class CameraService
{
    @Autowired
    private Faker faker;

    @Bean
    public void takeScreenShot()
    {
        final String filePath =
            String.format("%s/target/images/%s.png", System.getProperty("user.dir"), faker.funnyName().name());
        final File screenshotFile =
            ((TakesScreenshot) MobileDriverContext.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(filePath));
        } catch (final IOException ex) {
        }
    }

}
