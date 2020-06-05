package com.printf.kidsteacher.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.printf.kidsteacher.R;


public class CommonDialog
{
    Dialog dialog;
    Context context;
    TextView tv_ok,tv_msg;

    public CommonDialog(Context context)
    {
        this.context = context;
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tv_msg = dialog.findViewById(R.id.tv_msg);
        tv_ok = dialog.findViewById(R.id.tv_ok);

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hide();
            }
        });
    }

    public void show(String msg)
    {
        tv_msg.setText(msg);
        dialog.show();
    }

    public void hide()
    {
        dialog.dismiss();
    }
}
