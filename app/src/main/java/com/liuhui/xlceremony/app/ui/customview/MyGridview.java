package com.liuhui.xlceremony.app.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2015/8/22.
 */

/**
 *    要重写GridView中的onMeasure方法，因为直接用ListView嵌套GridView是会出问题的
 */
public class MyGridview extends GridView {
    public MyGridview(Context context) {
        super(context);
    }

    public MyGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
