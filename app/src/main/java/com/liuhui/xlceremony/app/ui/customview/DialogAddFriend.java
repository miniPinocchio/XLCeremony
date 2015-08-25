package com.liuhui.xlceremony.app.ui.customview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.liuhui.xlceremony.app.R;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.ui.customview
 * user  Pinocchio
 * Date 2015/8/25
 * Email:liu594545591@126.com
 */
public class DialogAddFriend extends Dialog{
    private Context context;

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private ClickListenerInterface clickListenerInterface;
    public DialogAddFriend(Context context) {
        super(context, R.style.MyDialogStyle);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    private void init() {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.dialog_add_friend, null);
        setContentView(view);
        //确定
        TextView dialogOk=  (TextView) view.findViewById(R.id.dialog_ok);
        dialogOk.setOnClickListener(new clickListener());

        TextView dialogCancel=  (TextView) view.findViewById(R.id.dialog_cancel);
        dialogCancel.setOnClickListener(new clickListener());

        TextView Message=  (TextView) view.findViewById(R.id.dialog_message);
        Message.setText("此好友为一度人脉"+message+"的好友,点击确定发送短信请求"+message+"介绍认识");

        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.6
        dialogWindow.setAttributes(lp);
    }
    public interface ClickListenerInterface {
        public void doConfirm();
    }
    public void setClickListener(ClickListenerInterface clickListenerInterface) {
        this.clickListenerInterface = clickListenerInterface;
    }
    private class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.dialog_ok:
                    //TODO 添加好友
                    dismiss();
                    break;
                case R.id.dialog_cancel:

                    break;
            }
        }
    };
}
