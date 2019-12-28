package com.unity3d.hookplayer;

import android.util.Log;

public class Boostrap
{
    public static native int init();
    public static native void setInitPath(String filePath);
    public static native int useDataDir(String _data_path, String _apk_path);

    private static boolean boostLoaded = false;
    public static void initBaseSo(String filePath)
    {
        if(boostLoaded)
            return;

        System.loadLibrary("main");
        System.loadLibrary("unity");
        System.loadLibrary("boostrap");
        setInitPath(filePath);
        Log.d("Boostrap", "init code:" + init() + "   filePath:" + filePath);
        boostLoaded = true;
    }

    public static void setDataDir(String filePath, String dataPath)
    {
		if(boostLoaded)
            return;
        
		System.loadLibrary("boostrap");
		setInitPath(filePath);
		Log.d("Boostrap", "setDataDir code:" + useDataDir(dataPath, "") + "   dataPath:" + dataPath);
		System.loadLibrary("main");
		System.loadLibrary("unity");
		Log.d("Boostrap", "init code:" + init() + "   filePath:" + filePath);
        boostLoaded = true;
    }
}