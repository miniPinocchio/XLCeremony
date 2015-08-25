package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.adapter
 * 2015/8/20.
 */
public class StategyListAdapter extends SimpleAdapter{

    public StategyListAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }
}
