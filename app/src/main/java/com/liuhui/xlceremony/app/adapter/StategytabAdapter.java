package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Ziv on Android Studio
 * com.liuhui.xlceremony.app.adapter
 * 2015/8/20.
 */
public class StategytabAdapter extends ArrayAdapter<TextView>{
    
    public StategytabAdapter(Context context, int resource) {
        super(context, resource);
    }
    
    public StategytabAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }
}
