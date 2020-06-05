package com.printf.kidsteacher.other;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
    public static String getFileContentFromAssets(String filePath, Context context) throws Throwable {
        Throwable th;
        String file = filePath;
        BufferedReader bufferedReader = null;
        try {
            StringBuilder buf = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(context.getAssets().open(file)));
            boolean isFirst = true;
            while (true) {
                try {
                    String str = in.readLine();
                    if (str == null) {
                        break;
                    }
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        buf.append('\n');
                    }
                    buf.append(str);
                } catch (IOException e) {
                    bufferedReader = in;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = in;
                }
            }
            String stringBuilder = buf.toString();
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e2) {
                    Log.e("", "Error closing asset " + file);
                }
            }
            bufferedReader = in;
            return stringBuilder;
        } catch (IOException e3) {
            try {
                Log.e("", "Error opening asset " + file);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        Log.e("", "Error closing asset " + file);
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        Log.e("", "Error closing asset " + file);
                    }
                }
                throw th;
            }
        }
    }

    public static Bitmap scaleBitmapKeepRatio(Bitmap srcBitmap, int desiredHeight, int desiredWidth) {
        int newHeight;
        int newWidth;
        int oldHeight = srcBitmap.getHeight();
        int oldWidth = srcBitmap.getWidth();
        if (oldHeight > oldWidth) {
            newHeight = desiredHeight;
            newWidth = (newHeight * oldWidth) / oldHeight;
        } else {
            newWidth = desiredWidth;
            newHeight = (newWidth * oldHeight) / oldWidth;
        }
        if (newWidth > desiredWidth) {
            int tempOldWidth = newWidth;
            newWidth = desiredWidth;
            newHeight = (newWidth * newHeight) / tempOldWidth;
        }
        if (newHeight > desiredHeight) {
            int tempOldHeight = newHeight;
            newHeight = desiredHeight;
            newWidth = (newHeight * newWidth) / tempOldHeight;
        }
        return Bitmap.createScaledBitmap(srcBitmap, newWidth, newHeight, true);
    }

    public static Bitmap scaleBitmap(Bitmap srcBitmap, int desiredHeight, int desiredWidth) {
        return Bitmap.createScaledBitmap(srcBitmap, desiredWidth, desiredHeight, true);
    }

    public static String getAppName(Context context) {
        String appName = "";
        try {
            PackageManager pm = context.getPackageManager();
            return (String) pm.getApplicationLabel(pm.getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception e) {
            return appName;
        }
    }

    public static Bitmap getBitmapFromAsset(Context context, String file) {
        Bitmap bitmap = null;
        Options op = new Options();
        op.inPreferredConfig = Config.ARGB_8888;
        try {
            bitmap = BitmapFactory.decodeStream(context.getAssets().open(file), null, op);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
