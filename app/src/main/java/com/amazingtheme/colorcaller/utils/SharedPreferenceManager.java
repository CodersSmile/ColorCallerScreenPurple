package com.amazingtheme.colorcaller.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    private static final String PREF_NAME = "ImagePrefs";
    private static final String KEY_IMAGE_URL = "image_url";
    Context context;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    private static SharedPreferences share(Context context) {
        return context.getSharedPreferences("preferences", 0);
    }
    public static void putPhoto(Context context, String str) {
        share(context).edit().putString("photo", str).apply();
    }

    public void setImageUrl(String imageUrl) {
        editor.putString(KEY_IMAGE_URL, imageUrl);
        editor.apply();
    }

    public String getImageUrl() {
        return sharedPreferences.getString(KEY_IMAGE_URL, null);
    }
    public boolean isImageDownloaded(String imageUrl) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("image_theme", Context.MODE_PRIVATE);
        String storedImageUrl = sharedPreferences.getString("image_url", null);

        return imageUrl != null && imageUrl.equals(storedImageUrl);
    }

}
