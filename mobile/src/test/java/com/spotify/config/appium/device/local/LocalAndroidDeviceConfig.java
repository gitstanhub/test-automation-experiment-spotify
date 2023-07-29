package com.spotify.config.appium.device.local;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocalAndroidDeviceConfig extends LocalDeviceConfig {

    private boolean noReset;
}
