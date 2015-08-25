package com.liuhui.xlceremony.app.ui.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.liuhui.xlceremony.app.util.LogUtil;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.customview
 * user  Pinocchio
 * Date 2015/8/20
 * Email:liu594545591@126.com
 */
public class MyLetterListView extends View {
    OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    String[] b = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"
            , "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    int choose = -1;
    Paint paint = new Paint();
    boolean showBkg = false;

    public MyLetterListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyLetterListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLetterListView(Context context) {
        super(context);
    }

    /**
     * 绘制右侧快速导航栏
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBkg) {
            //选中的字母颜色
            canvas.drawColor(Color.parseColor("#40000000"));
        }

        //当前view的高度
        int height = getHeight();
        int width = getWidth();
        //单个字母的高度
        int singleHeight = height / b.length;
        for (int i = 0; i < b.length; i++) {
            paint.setColor(Color.WHITE);
            //字体样式
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            //抗锯齿
            paint.setAntiAlias(true);
            if (i == choose) {
                paint.setColor(Color.parseColor("#FFFFFF"));
                //使用TextPaint的仿“粗体”设置setFakeBoldText为true。目前还无法支持仿“斜体”方法
                paint.setFakeBoldText(true);
            }else {
                paint.setColor(Color.parseColor("#0083FF"));
            }
            //每个字母的位置
            float xPos = width / 2 - paint.measureText(b[i]) / 2;
            float yPos = singleHeight * i + singleHeight;
            //绘制
            canvas.drawText(b[i], xPos, yPos, paint);
            paint.reset();
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        //当前位置相对于控件本身的y值
        final float y = event.getY();
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;

        //
        final int c = (int) (y / getHeight() * b.length);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBkg = true;
                if (oldChoose != c && listener != null) {
                    if (c > 0 && c < b.length) {
                        listener.onTouchingLetterChanged(b[c]);
                        LogUtil.d(b[c]);
                        choose = c;
                        invalidate();
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c > 0 && c < b.length) {
                        listener.onTouchingLetterChanged(b[c]);
                        choose = c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                showBkg = false;
                choose = -1;
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnTouchingLetterChangedListener(
            OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener {
        public void onTouchingLetterChanged(String s);
    }
}