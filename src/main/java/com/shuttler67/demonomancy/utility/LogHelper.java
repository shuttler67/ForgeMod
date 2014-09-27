package com.shuttler67.demonomancy.utility;

import com.shuttler67.demonomancy.reference.Reference;
import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper {

    public static void log(Level logLevel, Object... objects)
    {
        String text = "";
        for (Object object : objects) {
            text += String.valueOf(object) + "; ";
        }
        FMLLog.log(Reference.MOD_NAME, logLevel, text);
    }

    public static void all(Object... objects)
    {
        log(Level.ALL, objects);
    }

    public static void debug(Object... objects)
    {
        log(Level.DEBUG, objects);
    }

    public static void error(Object... objects)
    {
        log(Level.ERROR, objects);
    }

    public static void fatal(Object... objects)
    {
        log(Level.FATAL, objects);
    }

    public static void info(Object... objects)
    {
        log(Level.INFO, objects);
    }

    public static void off(Object... objects)
    {
        log(Level.OFF, objects);
    }

    public static void trace(Object... objects)
    {
        log(Level.TRACE, objects);
    }

    public static void warn(Object... objects)
    {
        log(Level.WARN, objects);
    }
}
