package com.liuhui.xlceremony.app.ui.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.adapter.PhotoAdapter;
import com.liuhui.xlceremony.app.bean.Photo;
import com.liuhui.xlceremony.app.bean.SubPhoto;

import java.util.LinkedList;
import java.util.List;

public class PhotoActivity extends FragmentActivity implements View.OnClickListener{

    private ListView listView;
    private GridView gridView;
    private List<Photo> list;
    private List<SubPhoto> photoList;
    private PhotoAdapter adapter;

    //返回按钮
    private ImageView imageBack;
    //发送按钮
    private TextView txtFasong;


    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        layout= (LinearLayout) findViewById(R.id.kaquan_statusbar);


        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }else{
            layout.setVisibility(View.GONE);
        }




        listView= (ListView) findViewById(R.id.list_view_photo);
        gridView= (GridView) findViewById(R.id.grid_view);

        imageBack= (ImageView) findViewById(R.id.find_photo_back);
        txtFasong= (TextView) findViewById(R.id.find_photo_fasong);

        int[]image={R.mipmap.photo_01,R.mipmap.photo_02,R.mipmap.photo_03};


        list = new LinkedList<Photo>();
        for (int i = 0; i <30 ; i++) {
            Photo photo=new Photo();
            photo.setDay(i+1);
            photo.setMonth(i + 1);
            photo.setYear(2015);
            photo.setClickCount(0);

            photoList = new LinkedList<SubPhoto>();
            for(int j=0;j<i+1;j++) {
                SubPhoto subPhoto = new SubPhoto();
                subPhoto.setResId(image[j%3]);
                subPhoto.setTitle((j+1) + "上传");
                photoList.add(subPhoto);

            }
            photo.setPhotoList(photoList);
            list.add(photo);
        }

        adapter = new PhotoAdapter(this, list);
        adapter.setOnClickListener(this);
        listView.setAdapter(adapter);

        imageBack.setOnClickListener(this);
        txtFasong.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();

        switch (id){
            case R.id.find_photo_back:
                onBackPressed();
                break;
            case R.id.list_view_more:
                int position= (Integer) v.getTag();

                //上面的是每点击一次，往里面增加6个新数据

                //逻辑关系是设置SubPhoto内部存储点击次数的参数clickCount
                //每点击一次就加1，对应的在后面的adapter中就多显示6条
                int count=list.get(position).getClickCount();
                count++;
                list.get(position).setClickCount(count);

                adapter.notifyDataSetChanged();
                break;
            case R.id.find_photo_fasong:
                Toast.makeText(this,"跳转到发送界面",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
