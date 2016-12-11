package com.github.florent37.arclayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

public class ArcLayoutSettings {
    public final static int CROP_INSIDE = 1;
    public final static int CROP_OUTSIDE = 2;
    private boolean cropInside = true;
    private float arcHeight;
    private float elevation;

    private static float dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    ArcLayoutSettings(Context context, AttributeSet attrs) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ArcHeader, 0, 0);
        arcHeight = styledAttributes.getDimension(R.styleable.ArcHeader_arc_height, dpToPx(context, 10));

        final int cropDirection = styledAttributes.getInt(R.styleable.ArcHeader_arc_cropDirection, CROP_INSIDE);
        cropInside = (cropDirection & CROP_INSIDE) == CROP_INSIDE;

        styledAttributes.recycle();
    }

    public float getElevation() {
        return elevation;
    }

    public void setElevation(float elevation) {
        this.elevation = elevation;
    }

    public boolean isCropInside() {
        return cropInside;
    }

    public float getArcHeight() {
        return arcHeight;
    }
}
