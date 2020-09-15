package com.google.android.exoplayer2.demo;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import nl.bravobit.ffmpeg.FFprobe;

public final class FFmpegUtil {
  private static final String TAG = "FFmpegUtil";
  private static Display display;
  private static double defaultDisplayRefreshRate;

  public static void create(AppCompatActivity activity) {
    display = activity.getWindowManager().getDefaultDisplay();
    defaultDisplayRefreshRate = display.getRefreshRate();
    LayoutParams params = activity.getWindow().getAttributes();
    params.preferredRefreshRate = display.getSupportedRefreshRates()[0];
  }

  public static void release(AppCompatActivity activity) {
    // windowManager = activity.getWindowManager();
    display = activity.getWindowManager().getDefaultDisplay();
    defaultDisplayRefreshRate = display.getRefreshRate();
  }

  private FFmpegUtil() {}
}
