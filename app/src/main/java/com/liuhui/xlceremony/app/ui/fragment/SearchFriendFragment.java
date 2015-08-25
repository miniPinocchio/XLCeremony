package com.liuhui.xlceremony.app.ui.fragment;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.ui.customview.MyLetterListView;
import com.liuhui.xlceremony.app.util.LogUtil;
import com.liuhui.xlceremony.app.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.fragment
 * user  Pinocchio
 * Date 2015/8/24
 * Email:liu594545591@126.com
 */
public class SearchFriendFragment extends Fragment implements View.OnClickListener {
    private BaseAdapter adapter;
    private ListView personList;
    private TextView overlay;
    private MyLetterListView letterListView;
    private AsyncQueryHandler asyncQuery;
    private static final String NAME = "name", NUMBER = "number", SORT_KEY = "sort_key";
    private HashMap<String, Integer> alphaIndexer;//存放存在的汉语拼音首字母和与之对应的列表位置
    private String[] sections;//存放存在的汉语拼音首字母
    private Handler handler;
    private OverlayThread overlayThread;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_relationship_list_friends, container, false);

        initOverlay();
        personList = (ListView) view.findViewById(R.id.list_view);
        letterListView = (MyLetterListView) view.findViewById(R.id.MyLetterListView01);

        letterListView.setOnTouchingLetterChangedListener(new MyLetterListView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {

                if (alphaIndexer.get(s) != null) {
                    int position = alphaIndexer.get(s);
                    personList.setSelection(position);
                    LogUtil.d(position + "");
                    overlay.setText(sections[position]);
                    overlay.setVisibility(View.VISIBLE);
                    handler.removeCallbacks(overlayThread);
                    //延迟一秒后执行，让overlay为不可见
                    handler.postDelayed(overlayThread, 1500);
                }

            }
        });

        asyncQuery = new MyAsyncQueryHandler(getActivity().getContentResolver());
        initData();
        alphaIndexer = new HashMap<String, Integer>();

        handler = new Handler();
        overlayThread = new OverlayThread();
        return view;

    }

    public void initData() {
        Uri uri = Uri.parse("content://com.android.contacts/data/phones");
        String[] projection = {"_id", "display_name", "data1", "sort_key"};
        asyncQuery.startQuery(0, null, uri, projection, null, null,
                "sort_key COLLATE LOCALIZED asc");

    }



    //查询联系人
    private class MyAsyncQueryHandler extends AsyncQueryHandler {

        public MyAsyncQueryHandler(ContentResolver cr) {
            super(cr);

        }

        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                List<ContentValues> list = new ArrayList<ContentValues>();
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    ContentValues cv = new ContentValues();
                    cursor.moveToPosition(i);
                    String name = cursor.getString(1);
                    String number = cursor.getString(2);
                    String sortKey = cursor.getString(3);
                    if (number.startsWith("+86")) {
                        cv.put(NAME, name);
                        cv.put(NUMBER, number.substring(3));  //去掉+86
                        cv.put(SORT_KEY, sortKey);
                    } else {
                        cv.put(NAME, name);
                        cv.put(NUMBER, number);
                        cv.put(SORT_KEY, sortKey);
                    }
                    list.add(cv);
                }
                if (list.size()>0){
                    setAdapter(list);
                }
            }
        }

    }
    private void setAdapter(List<ContentValues> list) {
        adapter = new ListFriendAdapter(getActivity(), list);
        personList.setAdapter(adapter);

        adapter.registerDataSetObserver(new DataSetObserver() {
            /**
             * 当Adapter notifyDataSetChanged()的时候
             * 自动被回调,就可以遍历新的数据了
             */
            @Override
            public void onChanged() {
                //TODO 计算人数
                double sum = 0;
               
            }

            @Override
            public void onInvalidated() {
                super.onInvalidated();
            }
        });

    }



    //初始化汉语拼音首字母弹出提示框
    private void initOverlay() {

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        overlay = (TextView) inflater.inflate(R.layout.relationship_list_friends_overlay,
                null);
        overlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(overlay, lp);
    }



    //设置overlay不可见
    private class OverlayThread implements Runnable {

        @Override
        public void run() {
            overlay.setVisibility(View.GONE);
        }

    }

    private class ListFriendAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private List<ContentValues> list;
        private CompoundButton.OnCheckedChangeListener listener;

        public ListFriendAdapter(Context context, List<ContentValues> list) {
            this.inflater = LayoutInflater.from(context);
            this.list = list;
            alphaIndexer = new HashMap<String, Integer>();
            sections = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                //当前汉语拼音首字母
                String currentStr = getAlpha(list.get(i).getAsString(SORT_KEY));
                //上一个汉语拼音首字母，如果不存在为“ ”
                String previewStr = (i - 1) >= 0 ? getAlpha(list.get(i - 1).getAsString(SORT_KEY)) : " ";

                if (!previewStr.equals(currentStr)) {
                    String name = getAlpha(list.get(i).getAsString(SORT_KEY));
                    alphaIndexer.put(name, i);
                    sections[i] = name;
                }
            }
        }



        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.relationship_list_friend_item,parent,false);
                holder = new ViewHolder();
                holder.alpha = (TextView) convertView.findViewById(R.id.alpha);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.number = (TextView) convertView.findViewById(R.id.number);
                holder.impressTxt = (TextView) convertView.findViewById(R.id.list_friend_impress);
                holder.scoreTxt = (TextView) convertView.findViewById(R.id.list_friend_score);
                holder.gift = (ImageView) convertView.findViewById(R.id.list_friend_gift_img);
                holder.impress = (ImageView) convertView.findViewById(R.id.list_friend_impress_img);
                holder.score = (ImageView) convertView.findViewById(R.id.list_friend_score_img);
                holder.personImg = (ImageView) convertView.findViewById(R.id.list_friend_person_img);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.contacts_check);

                holder.checkBox.setOnCheckedChangeListener(listener);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            ContentValues cv = list.get(position);
            holder.name.setText(cv.getAsString(NAME));
            holder.number.setText(cv.getAsString(NUMBER));
            //当前首字母
            String currentStr = getAlpha(list.get(position).getAsString(SORT_KEY));

            //前一个首字母
            String previewStr = (position - 1) >= 0 ? getAlpha(list.get(position - 1).getAsString(SORT_KEY)) : " ";
            if (!previewStr.equals(currentStr)) {
                holder.alpha.setVisibility(View.VISIBLE);
                holder.alpha.setText(currentStr);
            } else {
                holder.alpha.setVisibility(View.GONE);
            }
            return convertView;
        }

        private class ViewHolder {
            TextView alpha;
            TextView name;
            TextView number;
            TextView impressTxt;
            TextView scoreTxt;
            ImageView gift;
            ImageView impress;
            ImageView score;
            ImageView personImg;
            CheckBox checkBox;

        }
        //获得汉语拼音首字母
        private String getAlpha(String str) {
            if (str == null) {
                return "#";
            }

            if (str.trim().length() == 0) {
                return "#";
            }

            char c = str.trim().substring(0, 1).charAt(0);
            // 正则表达式，判断首字母是否是英文字母
            Pattern pattern = Pattern.compile("^[A-Za-z]+$");
            if (pattern.matcher(String.valueOf(c)).matches()) {
                return (String.valueOf(c)).toUpperCase();
            } else {
                return "#";
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_friend_gift_img:
                Toast.makeText(getActivity(),"礼物",Toast.LENGTH_LONG).show();
                break;
            case R.id.list_friend_impress_img:
                ToastUtil.toastLong("印象");
                break;
            case R.id.list_friend_score_img:
                ToastUtil.toastLong("积分");
                break;
            case R.id.list_friend_person_img:
                ToastUtil.toastLong("头像");
                break;
        }
    }
}
