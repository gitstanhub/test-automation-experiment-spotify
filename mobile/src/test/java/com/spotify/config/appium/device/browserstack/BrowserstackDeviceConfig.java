package com.spotify.config.appium.device.browserstack;

import com.spotify.config.appium.device.commons.DeviceConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BrowserstackDeviceConfig extends DeviceConfig {
}
