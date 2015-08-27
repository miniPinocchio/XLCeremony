package com.liuhui.xlceremony.app.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.liuhui.xlceremony.app.R;

public class SearchActivity extends AppCompatActivity {

    private ListView mListView;
    private String userInput;
    //private List<Date> dateList=new ArrayList<Date>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach);
        
    }
}
