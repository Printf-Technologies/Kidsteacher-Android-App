package com.printf.kidsteacher.other;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class Image {
    public static Bitmap textToBitmap(String text, int fontSize, int color, Typeface typeFace, Context context) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typeFace);
        paint.setStyle(Style.FILL);
        paint.setColor(color);
        paint.setTextSize((float) fontSize);
        paint.setTextAlign(Align.LEFT);
        Rect result = new Rect();
        paint.getTextBounds(text, 0, text.length(), result);
        float height = (float) result.height();
        Bitmap myBitmap = Bitmap.createBitmap(((int) ((float) result.width())) + 1, ((int) height) + (fontSize / 4), Config.ARGB_8888);
        new Canvas(myBitmap).drawText(text, 0.0f, height, paint);
        return myBitmap;
    }

    public static String saveBitmapAsJPG(Bitmap image, String sdFolder, Context context) {
        File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/" + sdFolder);
        myDir.mkdirs();
        String fname = UUID.randomUUID() + ".jpg";
        File file = new File(myDir, fname);
        String savedPath = myDir + "/" + fname;
        boolean result = false;
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            result = image.compress(CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            MediaScannerConnection.scanFile(context, new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return savedPath;
        }
        return null;
    }

    public static String saveTempBitmapAsJPG(Bitmap image, String sdFolder, Context context) {
        File myDir = new File(Environment.getExternalStorageDirectory().toString() + "/" + sdFolder + "/.temp");
        myDir.mkdirs();
        String fname = UUID.randomUUID() + ".jpg";
        File file = new File(myDir, fname);
        String savedPath = myDir + "/" + fname;
        boolean result = false;
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            result = image.compress(CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            MediaScannerConnection.scanFile(context, new String[]{file.getPath()}, new String[]{"image/jpeg"}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return savedPath;
        }
        return null;
    }

    public static void shareImage(String imagePath, Context context) {
        Uri uriToImage = Uri.parse(imagePath);
        Intent shareIntent = new Intent();
        shareIntent.setAction("android.intent.action.SEND");
        shareIntent.putExtra("android.intent.extra.STREAM", uriToImage);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent, "Share Image Using"));
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static Bitmap getScaleBitmap(Bitmap inBitmap, int maxWidth, int maxHeight) {
        float aspectRatio = ((float) inBitmap.getWidth()) / ((float) inBitmap.getHeight());
        int newWidth = maxWidth;
        int newHeight = maxHeight;
        if (newHeight > newWidth) {
            newHeight = Math.round(((float) newWidth) * aspectRatio);
        } else {
            newWidth = Math.round(((float) newHeight) * aspectRatio);
        }
        Bitmap bitmap = Bitmap.createScaledBitmap(inBitmap, newWidth, newHeight, true);
        Bitmap background = Bitmap.createBitmap(maxWidth, maxHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(background);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, (float) ((maxWidth - newWidth) / 2), (float) ((maxHeight - newHeight) / 2), paint);
        return background;
    }
}
