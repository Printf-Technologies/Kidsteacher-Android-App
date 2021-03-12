package com.printf.kidsteacher.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.printf.kidsteacher.R;
import com.printf.kidsteacher.mainactivity.MainActivity;

import java.util.LinkedList;
import java.util.Queue;



public class DrawingView extends View {

    //drawing path
    private Path drawPath;
    //drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    //initial color
    private int paintColor = 0xFF660000, paintAlpha = 255;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;
    //brush sizes
    private float brushSize, lastBrushSize;
    //erase flag
    private boolean erase=false;

    Bitmap mBitmap,mBitmapOrignal=null;
    final Point p1 = new Point();
    ProgressDialog pd;
    Context context;
    int img=-1;
    boolean first = true;
    int Bitmapheight=330;

    public DrawingView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context = context;
        setupDrawing(context);
    }

    /*public DrawingView(Context context,int width,int height)
    {
        super(context);
        Bitmapheight = height;
        setupDrawing(context);
    }*/

    //setup drawing
    private void setupDrawing(Context context){

        //prepare for drawing and setup paint stroke properties
        brushSize = 20;//getResources().getInteger(R.integer.medium_size);
        lastBrushSize = brushSize;
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(brushSize);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);

        /*-----------------------------------------------------------------------------*/
        /*if(img != -1)
        {
            mBitmap = BitmapFactory.decodeResource(getResources(), img).copy(Bitmap.Config.ARGB_8888, true);

            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            mBitmap = Bitmap.createScaledBitmap(mBitmap,width,height,true);
            mBitmapOrignal = Bitmap.createScaledBitmap(mBitmap,width,height,true);
            pd = new ProgressDialog(context);
            Log.e("TAG","img not -1");
        }*/
        /*-----------------------------------------------------------------------------*/
        Log.e("TAG","setupDrawing");
    }

    //size assigned to view
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //if(canvasBitmap == null)
        //{canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);}
        drawCanvas = new Canvas(canvasBitmap);
        Log.e("TAG","onSizeChanged");

        if(img != -1)
        {
            DisplayMetrics display = context.getResources().getDisplayMetrics();
            int width = display.widthPixels;
            int height = display.heightPixels;
            canvasBitmap = BitmapFactory.decodeResource(getResources(), img).copy(Bitmap.Config.ARGB_8888, true);
            canvasBitmap = Bitmap.createScaledBitmap(mBitmap,width,height-200/*Bitmapheight*/,true);
            drawCanvas = new Canvas(canvasBitmap);
        }
    }

    //draw the view - will be called after touch event
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
        /*-----------------------------------------------------------------------------*/
        //if(DrawingActivity.IsBrush == false )
        //if(mBitmapOrignal != null)
        canvas.drawBitmap(mBitmapOrignal, 0, 0, canvasPaint);
        /*-----------------------------------------------------------------------------*/
        Log.e("TAG","onDraw");
        if(first && mBitmapOrignal != null)
        {
            canvasBitmap=mBitmapOrignal;
            first= false;
            invalidate();
        }
        //canvasBitmap,mBitmapOrignal(need to assign value)
    }

    //register user touches as drawing action
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        //respond to down, move and up events
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //drawPath.moveTo(touchX, touchY);
                if(MainActivity.IsBrush == true)
                {
                    p1.x = (int) touchX;
                    p1.y = (int) touchY;
                    final int sourceColor = mBitmap.getPixel((int) touchX, (int) touchY);
                    final int targetColor = drawPaint.getColor();
                    new TheTask(canvasBitmap/*mBitmapOrignal*/, p1, sourceColor, targetColor).execute();
                    invalidate();
                }
                else
                {
                    drawPath.moveTo(touchX, touchY);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                //drawPath.lineTo(touchX, touchY);
                if(MainActivity.IsBrush == false)
                {drawPath.lineTo(touchX, touchY);}
                break;
            case MotionEvent.ACTION_UP:
                if(MainActivity.IsBrush == false)
                {
                    drawPath.lineTo(touchX, touchY);
                    drawCanvas.drawPath(drawPath, drawPaint);
                    drawPath.reset();
                }
                break;
            default:
                return false;
        }
        //redraw
        invalidate();
        return true;

    }

    //update color
    public void setColor(String newColor){
        invalidate();
        //check whether color value or pattern name
        if(newColor.startsWith("#")){
            paintColor = Color.parseColor(newColor);
            drawPaint.setColor(paintColor);
            drawPaint.setShader(null);
        }
        else{
            //pattern
            int patternID = getResources().getIdentifier(
                    newColor, "drawable", "com.example.drawingfun");
            //decode
            Bitmap patternBMP = BitmapFactory.decodeResource(getResources(), patternID);
            //create shader
            BitmapShader patternBMPshader = new BitmapShader(patternBMP,
                    Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            //color and shader
            drawPaint.setColor(0xFFFFFFFF);
            drawPaint.setShader(patternBMPshader);
        }
    }

    //set brush size
    public void setBrushSize(float newSize){
        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        brushSize=pixelAmount;
        drawPaint.setStrokeWidth(brushSize);
    }

    //get and set last brush size
    public void setLastBrushSize(float lastSize){
        lastBrushSize=lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }

    //set erase true or false
    public void setErase(boolean isErase){
        erase=isErase;
        if(erase) {
            drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            drawPaint.setColor(getResources().getColor(R.color.colorWhite));}
        else {
            drawPaint.setXfermode(null); }
    }

    //start new drawing
    public void startNew(){
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    //return current alpha
    public int getPaintAlpha(){
        return Math.round((float)paintAlpha/255*100);
    }

    //set alpha
    public void setPaintAlpha(int newAlpha){
        paintAlpha=Math.round((float)newAlpha/100*255);
        drawPaint.setColor(paintColor);
        drawPaint.setAlpha(paintAlpha);
    }

    public void setBitmap(Context cont,int img,int Adwidth,int Adheight)
    {
        this.img = img;
        Bitmapheight = Adheight;
        mBitmap = BitmapFactory.decodeResource(getResources(), img).copy(Bitmap.Config.ARGB_8888, true);

        //Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        /*Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;*/
        int width = display.widthPixels;
        int height = display.heightPixels;
        int orientation = getResources().getConfiguration().orientation;
        Log.e("TAG", "orientation  = " + orientation);
        Log.e("TAG","width = "+width);
        Log.e("TAG","height = "+height);

        /*float density = context.getResources().getDisplayMetrics().density;
        float dp = Adheight / density;Log.e("TAG","v = "+(int)dp);
        Bitmapheight = (int)dp;*/

        mBitmap = Bitmap.createScaledBitmap(mBitmap,width,/*Adheight*/height-Adheight,true);
        mBitmapOrignal = Bitmap.createScaledBitmap(mBitmap,width,/*Adheight*/height-Adheight,true);
        canvasBitmap = Bitmap.createScaledBitmap(mBitmap,width,/*Adheight*/height-Adheight,true);
        pd = new ProgressDialog(context);
        invalidate();
    }

    class TheTask extends AsyncTask<Void, Integer, Void> {

        Bitmap bmp;
        Point pt;
        int replacementColor, targetColor;

        public TheTask(Bitmap bm, Point p, int sc, int tc) {
            this.bmp = bm;
            this.pt = p;
            this.replacementColor = tc;
            this.targetColor = sc;
            pd.setMessage("Filling....");
            pd.show();
        }

        @Override
        protected void onPreExecute() {
            pd.show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected Void doInBackground(Void... params) {
            FloodFill f = new FloodFill();
            f.floodFill(bmp, pt, targetColor, replacementColor);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            pd.dismiss();
            invalidate();
        }
    }

    public class FloodFill {
        public void floodFill(Bitmap image, Point node, int targetColor,
                              int replacementColor) {
            int width = image.getWidth();
            int height = image.getHeight();
            int target = targetColor;
            int replacement = replacementColor;
            if (target != replacement) {
                Queue<Point> queue = new LinkedList<Point>();
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
                        if (!spanUp && y > 0
                                && image.getPixel(x, y - 1) == target) {
                            queue.add(new Point(x, y - 1));
                            spanUp = true;
                        } else if (spanUp && y > 0
                                && image.getPixel(x, y - 1) != target) {
                            spanUp = false;
                        }
                        if (!spanDown && y < height - 1
                                && image.getPixel(x, y + 1) == target) {
                            queue.add(new Point(x, y + 1));
                            spanDown = true;
                        } else if (spanDown && y < height - 1
                                && image.getPixel(x, y + 1) != target) {
                            spanDown = false;
                        }
                        x++;
                    }
                } while ((node = queue.poll()) != null);
            }
        }
    }
}
