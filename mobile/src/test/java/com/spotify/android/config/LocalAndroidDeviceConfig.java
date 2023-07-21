package com.spotify.android.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocalAndroidDeviceConfig extends DeviceConfig {

    private boolean noReset;
}
