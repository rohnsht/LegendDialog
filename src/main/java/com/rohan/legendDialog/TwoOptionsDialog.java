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

public class TwoOptionsDialog {

    private AlertDialog dialog;

    private CircleImageView iv_logo;
    private TextView tv_title, tv_message;
    private Button btn_positive, btn_negative;

    private Context mCtx;
    private DrawableUtil drawableUtil;

    public TwoOptionsDialog(Context context, String header, String message, String okStr,
                            String cancelStr, final View.OnClickListener mlistener) {
        mCtx = context;
        drawableUtil = new DrawableUtil(context);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(R.layout.two_options_dialog, null);
        iv_logo = view.findViewById(R.id.iv_logo);
        tv_title = view.findViewById(R.id.tv_title);
        tv_message = view.findViewById(R.id.tv_message);
        btn_positive = view.findViewById(R.id.btn_positive);
        btn_negative = view.findViewById(R.id.btn_negative);

        builder.setView(view);
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        tv_title.setText(header);
        tv_message.setText(message);
        btn_positive.setText(okStr);
        btn_negative.setText(cancelStr);
        btn_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(v);
                dialog.dismiss();
            }
        });
        btn_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(v);
                dialog.dismiss();
            }
        });

        TypedValue typedValue = new TypedValue();

        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        setPositiveButtonColor(typedValue.data);
        context.getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        setNegativeButtonColor(typedValue.data);
    }

    public void setLogo(Drawable logo) {
        iv_logo.setImageDrawable(logo);
    }

    public void setTitleColor(int color) {
        tv_title.setTextColor(color);
    }

    public void setPositiveButtonColor(int color) {
        int rippleColor = ColorUtil.darken(color, 0.3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Drawable rippleDrawable = drawableUtil.getRippleDrawabl(color, rippleColor);
            btn_positive.setBackground(rippleDrawable);
        } else {
            Drawable stateListDrawable = drawableUtil.getStateListDrawable(color, rippleColor);
            btn_positive.setBackground(stateListDrawable);
        }
    }

    public void setNegativeButtonColor(int color) {
        int rippleColor = ColorUtil.darken(color, 0.3);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Drawable rippleDrawable = drawableUtil.getRippleDrawabl(color, rippleColor);
            btn_negative.setBackground(rippleDrawable);
        } else {
            Drawable stateListDrawable = drawableUtil.getStateListDrawable(color, rippleColor);
            btn_negative.setBackground(stateListDrawable);
        }
    }

    public void setPositiveButtonTextColor(int color) {
        btn_positive.setTextColor(color);
    }

    public void setNegativeButtonTextColor(int color) {
        btn_negative.setTextColor(color);
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
