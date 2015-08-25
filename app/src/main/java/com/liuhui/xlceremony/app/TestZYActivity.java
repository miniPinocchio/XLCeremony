package com.liuhui.xlceremony.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class TestZYActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_zy);
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new MyFragment()).commit();
	}
}
