package com.mobile.test.automation.framework.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class PrerequisiteUtils
{
    private static final Logger logger = Logger.getLogger(PrerequisiteUtils.class.getName());

    @SuppressWarnings("unchecked")
    public static void setEnvironmentVariable(final String key, final String value)
    {
        try {
            final Map<String, String> environment = System.getenv();
            final Field field = environment.getClass().getDeclaredField("m");
            field.setAccessible(true);
            final Map<String, String> writableEnv = (Map<String, String>) field.get(environment);
            writableEnv.put(key, value);
        } catch (final Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    private PrerequisiteUtils()
    {
        // Use this class as static. Avoiding instantiate.
    }
}
