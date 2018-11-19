package com.rohan.legendDialog.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class DrawableUtil {

    private Context context;

    public DrawableUtil(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Drawable getRippleDrawabl(int normalColor, int rippleColor) {
        Drawable normalDrawable = getGradientDrawable(normalColor, 24);
        return new RippleDrawable(ColorStateList.valueOf(rippleColor), normalDrawable, null);
    }

    public Drawable getStateListDrawable(int normalColor, int pressedColor) {
        Drawable normalDrawable = getGradientDrawable(normalColor, 24);
        Drawable pressedDrawble = getGradientDrawable(pressedColor, 24);

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawble);
        stateListDrawable.addState(new int[]{}, normalDrawable);

        return stateListDrawable;
    }


    private Drawable getGradientDrawable(int color, int cornerRadius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(cornerRadius * context.getResources().getDisplayMetrics().density);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        return gradientDrawable;
    }
}
