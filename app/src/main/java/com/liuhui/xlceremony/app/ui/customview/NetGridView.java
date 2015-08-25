package com.liuhui.xlceremony.app.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.customview
 * user  Pinocchio
 * Date 2015/8/21
 * Email:liu594545591@126.com
 */
public class NetGridView extends GridView {
    public NetGridView(Context context) {
        this(context, null);
    }

    public NetGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NetGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
