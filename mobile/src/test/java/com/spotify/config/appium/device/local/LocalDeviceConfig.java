package com.spotify.config.appium.device.local;

import com.spotify.config.appium.device.commons.DeviceConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class LocalDeviceConfig extends DeviceConfig {

    private String udid;
    private String automationName;
}
