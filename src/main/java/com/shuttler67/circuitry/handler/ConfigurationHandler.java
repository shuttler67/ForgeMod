package com.shuttler67.circuitry.handler;

import com.shuttler67.circuitry.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile)
    {
        // Create the config object from the given file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase((Reference.MOD_ID)))
        {
            //Resync configs
            loadConfiguration();
        }
    }

    public void  loadConfiguration()
    {
        try
        {
            // Load the config file
            configuration.load();

            // Read in properties from config file
            testValue = configuration.getBoolean(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config");
        }
        catch (Exception e)
        {
            // Log the exception
        }
        finally
        {
            // Save the config file
            if (configuration.hasChanged())
            {
                configuration.save();
            }
        }
    }
}
