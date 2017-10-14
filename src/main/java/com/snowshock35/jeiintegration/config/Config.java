/*
 * MIT License
 *
 * Copyright (c) 2017 SnowShock35
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.snowshock35.jeiintegration.config;

import com.snowshock35.jeiintegration.JEIIntegration;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class Config {
    static final String CATEGORY_HANDLERS = "Handler Settings";
    static final String CATEGORY_TOOLTIPS = "Tooltip Settings";
    static final String CATEGORY_MISCELLANEOUS = "Miscellaneous Settings";

    private static final String defaultBurnTimeTooltipMode = "disabled";
    private static final String defaultDurabilityTooltipMode = "disabled";
    private static final String defaultFluidRegInfoTooltipMode = "disabled";
    private static final String defaultRegistryNameTooltipMode = "disabled";
    private static final String defaultMaxStackSizeTooltipMode = "disabled";
    private static final String defaultMetadataTooltipMode = "disabled";
    private static final String defaultNbtTooltipMode = "disabled";
    private static final String defaultOreDictEntriesTooltipMode = "disabled";
    private static final String defaultUnlocalizedNameTooltipMode = "disabled";

    private final Configuration config;
    private String burnTimeTooltipMode = "";
    private String durabilityTooltipMode = "";
    private String fluidRegInfoTooltipMode = "";
    private String registryNameTooltipMode = "";
    private String maxStackSizeTooltipMode = "";
    private String metadataTooltipMode = "";
    private String nbtTooltipMode = "";
    private String oreDictEntriesTooltipMode = "";
    private String unlocalizedNameTooltipMode = "";

    public Config(FMLPreInitializationEvent e) {
        final File configFile = new File(e.getModConfigurationDirectory(), JEIIntegration.MOD_ID + ".cfg");
        config = new Configuration(configFile, "1.0.0");

        loadConfig();
    }

    private void loadConfig() {
        config.setCategoryLanguageKey(CATEGORY_HANDLERS, "config.jeiintegration.handlers");
        config.setCategoryLanguageKey(CATEGORY_TOOLTIPS, "config.jeiintegration.tooltips");
        config.setCategoryLanguageKey(CATEGORY_MISCELLANEOUS, "config.jeiintegration.miscellaneous");
        config.addCustomCategoryComment(CATEGORY_HANDLERS, I18n.format("config.jeiintegration.handlers.comment"));
        config.addCustomCategoryComment(CATEGORY_TOOLTIPS, I18n.format("config.jeiintegration.tooltips.comment"));
        config.addCustomCategoryComment(CATEGORY_MISCELLANEOUS, I18n.format("config.jeiintegration.miscellaneous.comment"));

        burnTimeTooltipMode = config.getString("burnTimeTooltipMode", CATEGORY_TOOLTIPS, defaultBurnTimeTooltipMode, I18n.format("config.jeiintegration.tooltips.burnTimeTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.burnTimeTooltipMode");
        durabilityTooltipMode = config.getString("durabilityTooltipMode", CATEGORY_TOOLTIPS, defaultDurabilityTooltipMode, I18n.format("config.jeiintegration.tooltips.durabilityTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.durabilityTooltipMode");
        fluidRegInfoTooltipMode = config.getString("fluidRegInfoTooltipMode", CATEGORY_TOOLTIPS, defaultFluidRegInfoTooltipMode, I18n.format("config.jeiintegration.tooltips.fluidRegInfoTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.fluidRegInfoTooltipMode");
        registryNameTooltipMode = config.getString("registryNameTooltipMode", CATEGORY_TOOLTIPS, defaultRegistryNameTooltipMode, I18n.format("config.jeiintegration.tooltips.registryNameTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.registryNameTooltipMode");
        maxStackSizeTooltipMode = config.getString("maxStackSizeTooltipMode", CATEGORY_TOOLTIPS, defaultMaxStackSizeTooltipMode, I18n.format("config.jeiintegration.tooltips.maxStackSizeTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.maxStackSizeTooltipMode");
        metadataTooltipMode = config.getString("metadataTooltipMode", CATEGORY_TOOLTIPS, defaultMetadataTooltipMode, I18n.format("config.jeiintegration.tooltips.metadataTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.metadataTooltipMode");
        nbtTooltipMode = config.getString("nbtTooltipMode", CATEGORY_TOOLTIPS, defaultNbtTooltipMode, I18n.format("config.jeiintegration.tooltips.nbtTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.nbtTooltipMode");
        oreDictEntriesTooltipMode = config.getString("oreDictEntriesTooltipMode", CATEGORY_TOOLTIPS, defaultOreDictEntriesTooltipMode, I18n.format("config.jeiintegration.tooltips.oreDictEntriesTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.oreDictEntriesTooltipMode");
        unlocalizedNameTooltipMode = config.getString("unlocalizedNameTooltipMode", CATEGORY_TOOLTIPS, defaultUnlocalizedNameTooltipMode, I18n.format("config.jeiintegration.tooltips.unlocalizedNameTooltipMode.comment"), new String[] {"disabled", "enabled", "onShift", "onDebug", "onShiftAndDebug"}, "config.jeiintegration.tooltips.unlocalizedNameTooltipMode");

        if (config.hasChanged()) {
            config.save();
        }
    }

    public Configuration getConfig() {
        return config;
    }

    public String getBurnTimeTooltipMode() {
        return burnTimeTooltipMode;
    }

    public String getDurabilityTooltipMode() {
        return durabilityTooltipMode;
    }

    public String getFluidRegInfoTooltipMode() {
        return fluidRegInfoTooltipMode;
    }

    public String getRegistryNameTooltipMode() {
        return registryNameTooltipMode;
    }

    public String getMaxStackSizeTooltipMode() {
        return maxStackSizeTooltipMode;
    }

    public String getMetadataTooltipMode() {
        return metadataTooltipMode;
    }

    public String getNbtTooltipMode() {
        return nbtTooltipMode;
    }

    public String getOreDictEntriesTooltipMode() {
        return oreDictEntriesTooltipMode;
    }

    public String getUnlocalizedNameTooltipMode() {
        return unlocalizedNameTooltipMode;
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (JEIIntegration.MOD_ID.equals(eventArgs.getModID())) {
            loadConfig();
        }
    }
}
