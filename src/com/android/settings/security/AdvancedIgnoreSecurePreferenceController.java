package com.android.settings.security;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.core.TogglePreferenceController;

public class AdvancedIgnoreSecurePreferenceController extends TogglePreferenceController {

    private static final String PREF_KEY = "advanced_bypass_secure";
    private static final String SYS_PROP = "persist.sys.bypass_secure";

    public AdvancedIgnoreSecurePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        // reads system prop defaulting to false
        return SystemProperties.getBoolean(SYS_PROP, false);
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        // based on toggle - flip prop(persist.sys.bypass_secure) value true or false
        SystemProperties.set(SYS_PROP, isChecked ? "true" : "false");
        return true;
    }

    @Override
    public int getSliceHighlightMenuRes() {
        return 0;
    }
}
