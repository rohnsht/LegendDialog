package com.rohan.legendDialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rohan.legendDialog.utils.ColorUtil;
import com.rohan.legendDialog.utils.DrawableUtil;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageDialog {

    private CircleImageView iv_icon;
    private TextView tv_title, tv_message;
    private Button btn_positive;

    private Context context;
    private AlertDialog dialog;
    private DrawableUtil drawableUtil;

    public MessageDialog(Context context, String header, String message, String okStr) {
        this.context = context;
        drawableUtil = new DrawableUtil(context);

        dialog = createDialog(header, message, okStr);
    }

    private AlertDialog createDialog(String header, String message, String okStr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.LegendDialog);

        View view = LayoutInflater.from(context).inflate(R.layout.single_option_dialog, null);
        iv_icon = view.findViewById(R.id.iv_icon);
        tv_title = view.findViewById(R.id.tv_title);
        tv_message = view.findViewById(R.id.tv_message);
        btn_positive = view.findViewById(R.id.btn_positive);

        builder.setView(view);
        builder.setCancelable(false);

        tv_title.setText(header);
        tv_message.setText(message);
        btn_positive.setText(okStr);
        btn_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        setButtonColor(typedValue.data);

        dialog = builder.create();
        return dialog;
    }

    public void setLogo(int resId) {
        iv_icon.setImageResource(resId);
    }

    public void setTitleColor(int color) {
        tv_title.setTextColor(color);
    }

    public void setButtonColor(int color) {
        int rippleColor = ColorUtil.darken(color, 0.3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Drawable rippleDrawable = drawableUtil.getRippleDrawabl(color, rippleColor);
            btn_positive.setBackground(rippleDrawable);
        } else {
            Drawable stateListDrawable = drawableUtil.getStateListDrawable(color, rippleColor);
            btn_positive.setBackground(stateListDrawable);
        }
    }

    public void setButtonTextColor(int color) {
        btn_positive.setTextColor(color);
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setMessage(String message) {
        tv_message.setText(message);
    }

    public void setButtonText(String btnText) {
        btn_positive.setText(btnText);
    }

    public void show() {
        this.dialog.show();
    }

}
