package com.liuhui.xlceremony.app.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.liuhui.xlceremony.app.AppManager;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.util.LogUtil;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.base
 * user  Pinocchio
 * Date 2015/8/17
 * Email:liu594545591@126.com
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final int ACTIVITY_RESUME = 0;
    private static final int ACTIVITY_STOP = 1;
    private static final int ACTIVITY_PAUSE = 2;
    private static final int ACTIVITY_DESTROY = 3;

    public int activityState;

    // 是否允许全屏
    private boolean mAllowFullScreen = true;

    /**
     * 设置是否允许屏幕全屏
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }


    /**
     *  新的Activity进入的动画 默认是从右往左，
     * @return int
     */
    protected int getEnterAnimationId(){
        return R.anim.anim_slide_to_left;
    }

    /**
     * 退出时样式，设置的默认是从上往下，
     * @return  int
     */
    protected  int getExitAnimationId(){
        return R.anim.anim_drop_down;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtil.i("---------onCreate ");

        // 从左往右动画
        overridePendingTransition(getEnterAnimationId(),0);
        
        // 竖屏锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initViews();

        
        AppManager.getAppManager().addActivity(this);
    }

    /**
     * 初始化布局：首行需要setContentView()
     */
    protected abstract void initViews();

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i("---------onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i("---------onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i("---------onPause ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i("---------onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i("---------onDestroy ");
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 退出Activity，并且给退出的Activity 指定一个退出动画
     */
    @Override
    public void finish() {
        super.finish();
        // 从上往下退出
        overridePendingTransition(0,getExitAnimationId());
    }
}
