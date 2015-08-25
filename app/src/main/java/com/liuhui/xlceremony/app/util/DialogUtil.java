package com.liuhui.xlceremony.app.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.liuhui.xlceremony.app.R;
import com.liuhui.xlceremony.app.ui.customview.DialogAddFriend;

/**
 * Created with InetlliJ IDEA.
 * Project: com.liuhui.xlceremony.app.util
 * user  Pinocchio
 * Date 2015/8/25
 * Email:liu594545591@126.com
 */
public class DialogUtil  {
    private  Context context;
    private AlertDialog.Builder builder;

    public DialogUtil(Context context) {
        this.context = context;
    }


    public void createDialog(String buttonTxt,String title,
                             String msg, final CallBack callBack) {
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(buttonTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                callBack.isConfirm(true);
            }
        });
        builder.create().show();
    }
    public interface CallBack {
        public void isConfirm(boolean flag);
    }

    /**
     * 有待完善
     * @param message
     * @param layoutInflater
     */
    public void createToasts(String message,LayoutInflater layoutInflater) {
        // Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        View view = layoutInflater.inflate(R.layout.dialog_add_friend, null);
        TextView textView = (TextView)view.findViewById(R.id.text);
        textView.setText(message);

        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    public void createDialog(String message) {
        final DialogAddFriend confirmDialog = new DialogAddFriend(context);
        confirmDialog.setMessage(message);
        confirmDialog.show();
    }

}
