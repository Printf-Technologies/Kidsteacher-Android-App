package com.printf.kidsteacher.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.printf.kidsteacher.other.Helper;
import com.printf.kidsteacher.other.Image;
import com.printf.kidsteacher.other.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class DrawViewKids extends View {
    public static int DRAWING_MODE = 6;
    public static final int DRAWING_MODE_BRUSH = 5;
    public static final int DRAWING_MODE_CLIP_ART = 8;
    public static final int DRAWING_MODE_ERASER = 1;
    public static final int DRAWING_MODE_FILL = 7;
    public static final int DRAWING_MODE_MARKER = 6;
    public static final int DRAWING_MODE_PATTERN = 2;
    public static final int DRAWING_MODE_PEN = 3;
    public static final int DRAWING_MODE_PENCIL = 4;
    public static final float STROKE_WIDTH_BRUSH = 80.0f;
    public static final float STROKE_WIDTH_ERASER = 80.0f;
    public static final float STROKE_WIDTH_MARKER = 30.0f;
    public static final float STROKE_WIDTH_PEN = 5.0f;
    public static final float STROKE_WIDTH_PENCIL = 1.0f;
    private static final float TOLERANCE = 5.0f;
    private float angle = 0.0f;
    private Bitmap bgBitmap;
    private Bitmap canvasBitmap;
    public int canvasHeight;
    public int canvasWidth;
    private Cap cap = Cap.ROUND;
    private Bitmap clipArtBitmap = null;
    private int clipArtHeight;
    Matrix clipArtMatrix = null;
    private int clipArtWidth;
    private int color = -16776961;
    Context context;
    private Bitmap foreGroundBitmap;
    private boolean isInitialized = false;
    private boolean isPatternMode = false;
    private Join join = Join.ROUND;
    public float localLeft;
    public float localTop;
    private Paint mBitmapPaint;
    private Canvas mCanvas;
    private Paint mPaint;
    private Path mPath;
    private float mX;
    private float mY;
    BitmapShader patternBMPShader = null;
    private Bitmap patternBitmap;
    private ProgressDialog progressDialog;
    private float scale = 1.0f;
    private float strokeWidth = 80.0f;
    Style style = Style.STROKE;


    public class FloodFill {
        public void floodFill(Bitmap image, Point node, int targetColor, int replacementColor) {
            int width = image.getWidth();
            int height = image.getHeight();
            int target = targetColor;
            int replacement = replacementColor;
            if (target != replacement) {
                Queue<Point> queue = new LinkedList();
                do {
                    int x = node.x;
                    int y = node.y;
                    while (x > 0 && image.getPixel(x - 1, y) == target) {
                        x--;
                    }
                    boolean spanUp = false;
                    boolean spanDown = false;
                    while (x < width && image.getPixel(x, y) == target) {
                        image.setPixel(x, y, replacement);
                        if (!spanUp && y > 0 && image.getPixel(x, y - 1) == target) {
                            queue.add(new Point(x, y - 1));
                            spanUp = true;
                        } else if (spanUp && y > 0 && image.getPixel(x, y - 1) != target) {
                            spanUp = false;
                        }
                        if (!spanDown && y < height - 1 && image.getPixel(x, y + 1) == target) {
                            queue.add(new Point(x, y + 1));
                            spanDown = true;
                        } else if (spanDown && y < height - 1 && image.getPixel(x, y + 1) != target) {
                            spanDown = false;
                        }
                        x++;
                    }
                    node = queue.poll();
                } while (node != null);
            }
        }
    }

    public class FloodFillAsyncTask extends AsyncTask<String, Void, String> {
        ProgressDialog pd;
        Point point;
        int replaceColor;
        int targetColor;

        FloodFillAsyncTask(Point point, int targetColor, int replaceColor) {
            this.point = point;
            this.targetColor = targetColor;
            this.replaceColor = replaceColor;
            this.pd = new ProgressDialog(DrawViewKids.this.context);
            this.pd.setCancelable(false);
            this.pd.setTitle("Please wait...");
            this.pd.setMessage("Filling Color...");
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.pd.show();
        }

        protected String doInBackground(String... params) {
            new FloodFill().floodFill(DrawViewKids.this.canvasBitmap, this.point, this.targetColor, this.replaceColor);
            return null;
        }

        @SuppressLint({"NewApi", "ShowToast"})
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            DrawViewKids.this.invalidate();
            this.pd.dismiss();
        }
    }

    public void init() {
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(this.style);
        this.mPaint.setStrokeJoin(this.join);
        this.mPaint.setStrokeCap(this.cap);
        this.mPaint.setStrokeWidth(this.strokeWidth);
        this.mBitmapPaint = new Paint(4);
        this.canvasHeight = Helper.getScreenHeight(context); //Helper.height; //1080;//1830;//Global.DeviceHeight;
        this.canvasWidth = Helper.getScreenWidth(context); //Helper.width;//1800;//1080;//Global.DeviceWidth;
        this.canvasBitmap = Bitmap.createBitmap(this.canvasWidth, this.canvasHeight, Config.ARGB_8888);
        this.mCanvas = new Canvas(this.canvasBitmap);
    }

    public DrawViewKids(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public DrawViewKids(Context c, AttributeSet attrs) {
        super(c, attrs);
        this.context = c;
        init();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.canvasBitmap != null) {
            canvas.drawBitmap(this.canvasBitmap, 0.0f, 0.0f, this.mBitmapPaint);
        }
        if (this.mPath != null) {
            canvas.drawPath(this.mPath, this.mPaint);
        }
        if (!(DRAWING_MODE != 8 || this.clipArtBitmap == null || this.clipArtMatrix == null)) {
            canvas.drawBitmap(this.clipArtBitmap, this.clipArtMatrix, this.mBitmapPaint);
        }
        if (this.foreGroundBitmap != null) {
            canvas.drawBitmap(this.foreGroundBitmap, (float) ((this.canvasWidth / 2) - (this.foreGroundBitmap.getWidth() / 2)), (float) /*10*/((this.canvasHeight / 2) - (this.foreGroundBitmap.getHeight() / 2)), this.mBitmapPaint);
        }
    }

    private void startTouch(float x, float y) {
        this.mPath.moveTo(x, y);
        this.mX = x;
        this.mY = y;
    }

    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - this.mX);
        float dy = Math.abs(y - this.mY);
        if (dx >= 5.0f || dy >= 5.0f) {
            this.mPath.quadTo(this.mX, this.mY, (this.mX + x) / 2.0f, (this.mY + y) / 2.0f);
            this.mX = x;
            this.mY = y;
        }
        if (DRAWING_MODE == 1) {
            drawPathOnCanvas();
            this.mPath.moveTo(this.mX, this.mY);
        }
    }

    private void upTouch() {
        this.mPath.lineTo(this.mX, this.mY);
        drawPathOnCanvas();
    }

    private void drawClipArtOnCanvas() {
        this.mCanvas.drawBitmap(this.clipArtBitmap, this.clipArtMatrix, this.mBitmapPaint);
        this.clipArtBitmap = null;
        this.clipArtMatrix = null;
    }

    private void drawPathOnCanvas() {
        this.mCanvas.drawPath(this.mPath, this.mPaint);
        this.mCanvas.drawBitmap(this.bgBitmap, this.localLeft, /*10*/this.localTop, null);
        this.mPath.reset();
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if (DRAWING_MODE != 8) {
            switch (event.getAction()) {
                case 0:
                    if (DRAWING_MODE != 7) {
                        startTouch(x, y);
                        invalidate();
                        break;
                    }
//                    if(x < this.canvasBitmap.getWidth())
//                    {
//                        new FloodFillAsyncTask(new Point((int) x, (int) y), this.canvasBitmap.getPixel((int) x, (int) y), this.color).execute(new String[0]);
//                    }
                    if(x < this.canvasBitmap.getWidth() && y < this.canvasBitmap.getHeight())
                    {
                        new FloodFillAsyncTask(new Point((int) x, (int) y), this.canvasBitmap.getPixel((int) x, (int) y), this.color).execute(new String[0]);
                    }
                    break;
                case 1:
                    if (DRAWING_MODE != 7) {
                        upTouch();
                        invalidate();
                        break;
                    }
                    break;
                case 2:
                    if (DRAWING_MODE != 7) {
                        moveTouch(x, y);
                        invalidate();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }

        invalidate();
        return true;
    }

    public void setDrawModeEraser() {
        this.mPath.reset();
        this.mPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.mPaint.setStrokeWidth(80.0f);
        setBackGroundBitmap(this.bgBitmap);
        setForeGroundBitmap(this.foreGroundBitmap);
        invalidate();
    }

    public void resetView() {
        this.foreGroundBitmap = null;
        this.bgBitmap = null;
        this.clipArtBitmap = null;
        this.clipArtMatrix = null;
        this.mPath.reset();
        this.canvasBitmap = Bitmap.createBitmap(this.canvasWidth, this.canvasHeight, Config.ARGB_8888);
        this.mCanvas = new Canvas(this.canvasBitmap);
        invalidate();
    }

    public void clearCanvas() {
        this.mPath.reset();
        this.canvasBitmap = Bitmap.createBitmap(this.canvasWidth, this.canvasHeight, Config.ARGB_8888);
        this.mCanvas = new Canvas(this.canvasBitmap);
        setForeGroundBitmap(this.foreGroundBitmap);
        setBackGroundBitmap(this.bgBitmap);
        invalidate();
    }

    public void setForeGroundBitmap(Bitmap bitmap) {
        this.foreGroundBitmap = Utils.scaleBitmapKeepRatio(bitmap, this.canvasHeight, this.canvasWidth);
        invalidate();
    }

    public void setBackGroundBitmap(Bitmap bitmap) {
        this.bgBitmap = Utils.scaleBitmapKeepRatio(bitmap, this.canvasHeight, this.canvasWidth);
        if (this.bgBitmap != null) {
            float pointLeft = (float) ((this.canvasWidth / 2) - (this.bgBitmap.getWidth() / 2));
            float pointTop = (float) ((this.canvasHeight / 2) - (this.bgBitmap.getHeight() / 2));
            this.mCanvas.drawBitmap(this.bgBitmap, pointLeft, /*10*/pointTop, this.mBitmapPaint);
            this.localLeft = pointLeft;
            this.localTop = pointTop;
        }
        invalidate();
    }

    public void setPatternBitmap(Bitmap bitmap) {
        this.patternBitmap = bitmap;
        this.patternBMPShader = new BitmapShader(this.patternBitmap, TileMode.REPEAT, TileMode.REPEAT);
        this.mPaint.setShader(this.patternBMPShader);
        setPatternMode();
        invalidate();
    }

    void setPatternMode() {
        if (DRAWING_MODE != 1) {
            this.isPatternMode = true;
            DRAWING_MODE = 2;
        }
    }

    public void setColor(int newColor) {
        this.color = newColor;
        if (DRAWING_MODE == 1 || DRAWING_MODE == 8) {
            DRAWING_MODE = 6;
            setBrush(30.0f);
        }
        this.mPaint = new Paint();
        this.mPaint.setColor(this.color);
        this.mPaint.setStrokeWidth(this.strokeWidth);
        this.mPaint.setStyle(this.style);
        this.mPaint.setStrokeJoin(this.join);
        this.mPaint.setStrokeCap(this.cap);
        this.isPatternMode = false;
    }

    public void setBrushMode(int mode) {
        DRAWING_MODE = mode;
        switch (DRAWING_MODE) {
            case 1:
                setDrawModeEraser();
                return;
            case 3:
                setBrush(5.0f);
                return;
            case 4:
                setBrush(1.0f);
                return;
            case 5:
                setBrush(80.0f);
                return;
            case 6:
                setBrush(30.0f);
                return;
            default:
                return;
        }
    }

    public String saveImage() {
        Bitmap image = Bitmap.createBitmap(getWidth(), getHeight(), Config.RGB_565);
        draw(new Canvas(image));
        return Image.saveBitmapAsJPG(image, Utils.getAppName(this.context), this.context);
    }

    void setBrush(float brushSize) {
        if (this.isPatternMode) {
            this.mPaint.setXfermode(null);
            this.mPaint.setShader(this.patternBMPShader);
            setPatternMode();
            this.strokeWidth = brushSize;
            this.mPaint.setStrokeWidth(this.strokeWidth);
            DRAWING_MODE = 2;
            return;
        }
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.color);
        this.mPaint.setStyle(this.style);
        this.mPaint.setStrokeJoin(this.join);
        this.mPaint.setStrokeCap(this.cap);
        this.strokeWidth = brushSize;
        this.mPaint.setStrokeWidth(this.strokeWidth);
        this.mBitmapPaint = new Paint(4);
    }

    private static float getDegreesFromRadians(float angle) {
        return (float) ((((double) angle) * 180.0d) / 3.141592653589793d);
    }


}
