package pl.huczeq.rtspplayer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import pl.huczeq.rtspplayer.utils.data.DataManager;

public class Settings {

    private static Settings instance;

    public static Settings getInstance(Context context) {
        if(Settings.instance == null)
            Settings.instance = new Settings(context);
        return instance;
    }

    private Context context;
    private final String preferencesName = "Settings";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String KEY_FIRST_LAUNCH = "first_launch";

    public Settings(Context context) {
        this.context = context;
        this.preferences = this.context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
    }

    private void edit() {
        this.editor = this.preferences.edit();
    }

    private void commit() {
        this.commit();
    }

    public boolean isFirstLaunch() {
        return this.preferences.getBoolean(KEY_FIRST_LAUNCH, true);
    }

    public void setFirstLaunch(boolean firstLaunch) {
        edit();
        this.editor.putBoolean(KEY_FIRST_LAUNCH, firstLaunch);
        commit();
    }
}