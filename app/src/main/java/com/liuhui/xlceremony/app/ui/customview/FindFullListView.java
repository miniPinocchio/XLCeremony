package com.liuhui.xlceremony.app.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2015/8/8.
 */
public class FindFullListView extends ListView {


    public FindFullListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hmode = MeasureSpec.getMode(heightMeasureSpec);
        int hsize = MeasureSpec.getSize(heightMeasureSpec);
        switch (hmode){
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }

    heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
