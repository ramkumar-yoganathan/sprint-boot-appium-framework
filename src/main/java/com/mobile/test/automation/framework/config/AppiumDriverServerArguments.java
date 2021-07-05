package com.mobile.test.automation.framework.config;

import io.appium.java_client.service.local.flags.ServerArgument;

public enum AppiumDriverServerArguments implements ServerArgument
{
    AVD("--avd"),
    LOG("--log"),
    LOG_LEVEL("--log-level"),
    LOG_NO_COLORS("--log-no-colors"),
    SESSION_OVERRIDE("--session-override");

    private String argument;

    AppiumDriverServerArguments(final String newArgument)
    {
        argument = newArgument;
    }

    @Override
    public String getArgument()
    {
        return argument;
    }
}
