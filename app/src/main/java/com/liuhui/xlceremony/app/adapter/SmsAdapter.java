package com.liuhui.xlceremony.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.liuhui.xlceremony.app.R;

import java.util.List;

/**
 * Created by Administrator on 2015/8/20.
 */
public class SmsAdapter extends BaseAdapter {

    private Context context;
    private List<String> strings;

    private TextView textView;
    private Button btnSend;

    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public SmsAdapter(Context context, List<String> strings) {
        this.context = context;
        this.strings = strings;
    }



    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.sms_list_item,parent,false);
            textView= (TextView) convertView.findViewById(R.id.txt_sms);
            btnSend= (Button) convertView.findViewById(R.id.sms_button_send);

        }

        textView.setText(strings.get(position));
        btnSend.setOnClickListener(onClickListener);


        return convertView;
    }
}
