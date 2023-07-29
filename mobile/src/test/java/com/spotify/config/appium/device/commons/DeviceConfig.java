package com.spotify.config.appium.device.commons;

import lombok.Data;

@Data
public abstract class DeviceConfig {

    private String configItemName;
    private String platformName;
    private String deviceName;
    private String platformVersion;
}
