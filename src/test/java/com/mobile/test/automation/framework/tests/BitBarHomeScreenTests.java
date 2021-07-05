package com.mobile.test.automation.framework.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.mobile.test.automation.framework.screens.HomeScreen;

@SpringBootTest
public class BitBarHomeScreenTests extends AbstractTestNGSpringContextTests
{
    @Autowired
    private HomeScreen homeScreen;

    @Test
    public void checkThatGivenAnswerIsCorrect()
    {
        homeScreen.checkThatGivenAnswerIsCorrect();
    }
}
