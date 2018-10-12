package com.uber.jaredtan.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

public class Beatbox {
    private static final String TAG = "BeatBox";

    private static final String SAMPLE_SOUNDS_DIRECTORY = "sample_sounds";

    private AssetManager mAssets;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
    }

    private void loadSounds() {
        String[] soundNames;
        try {
//            lists the file names of the folder we specift
            soundNames = mAssets.list(SAMPLE_SOUNDS_DIRECTORY);
            Log.i(TAG, "Found " + soundNames.length + " sound");
        } catch (IOException ioe) {
            Log.e(TAG, "couldn't find sample sound", ioe);
            return;
        }
    }
}
