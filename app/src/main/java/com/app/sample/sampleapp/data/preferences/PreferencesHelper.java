package com.app.sample.sampleapp.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by thibaud.bourgeois on 10/11/2015.
 * Preferences helper class
 */
public class PreferencesHelper {

    private static SharedPreferences preferences;

    public static final String PREF_FILE_NAME = "sample_pref_file";

    @Inject
    public PreferencesHelper(Context context) {
        preferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void storeStringValue(String key, String value) {
        preferences.edit()
            .putString(key, value)
            .apply();
    }

    public String getStringValue(String key) {
        return preferences.getString(key, null);
    }

    public void clear() {
        preferences.edit().clear().apply();
    }

}
