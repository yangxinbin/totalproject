package com.example.yangxb.okdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by yangxb on 17-10-12.
 */

public class OKDialog {
    private static final int WARNINGMESSAGE = 0;
    private static final int SLECTMESSAGE = 1;
    AlertDialog.Builder builder;

    public void dialogMessage(int type, Context context,int intIcon,String title,String message,String[] slect){
        switch (type){
            case WARNINGMESSAGE:
                warnDialog(context,intIcon,title,message);
            case SLECTMESSAGE:
                slectDialog(context,intIcon,title,slect);

        }


    }

    private void slectDialog(final Context context,int intIcon,String title,String[] slect) {
        builder = new AlertDialog.Builder(context);
        builder.setIcon(intIcon);
        builder.setTitle(title);
        //    指定下拉列表的显示数据
        final String[] cities = slect;
        //    设置一个下拉的列表选择项
        builder.setItems(cities, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "选择的城市为：" + cities[which], Toast.LENGTH_SHORT).show();
            }
        });
        showDialog();
    }

    private void warnDialog(final Context context,int intIcon,String title,String message) {
        //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
        builder = new AlertDialog.Builder(context);
        //    设置Title的图标
        builder.setIcon(intIcon);
        //    设置Title的内容
        builder.setTitle(title);
        //    设置Content来显示一个信息
        builder.setMessage(message);
        //    设置一个PositiveButton
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "positive: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        //    设置一个NegativeButton
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "negative: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        //    设置一个NeutralButton
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "neutral: " + which, Toast.LENGTH_SHORT).show();
            }
        });
        showDialog();
    }

    public void showDialog(){
        builder.show();
    }
}
