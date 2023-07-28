package com.spotify.config.appium.device;

import lombok.Data;

@Data
public abstract class DeviceConfig {

    private String configItemName;
    private String platformName;
    private String deviceName;
    private String osVersion;
    private String udid;
    private String automationName;
}
