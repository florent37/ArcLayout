package com.github.florent37.arclayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

public class ArcLayoutSettings {
    public final static int CROP_INSIDE = 0;
    public final static int CROP_OUTSIDE = 1;

    public final static int POSITION_BOTTOM = 0;
    public final static int POSITION_TOP = 1;
    public final static int POSITION_LEFT = 2;
    public final static int POSITION_RIGHT = 3;

    private boolean cropInside = true;
    private float arcHeight;
    private float elevation;

    private int position;

    private static float dpToPx(Context context, int dp) {
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    ArcLayoutSettings(Context context, AttributeSet attrs) {
        TypedArray styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ArcLayout, 0, 0);
        arcHeight = styledAttributes.getDimension(R.styleable.ArcLayout_arc_height, dpToPx(context, 10));

        final int cropDirection = styledAttributes.getInt(R.styleable.ArcLayout_arc_cropDirection, CROP_INSIDE);
        cropInside = (cropDirection == CROP_INSIDE);

        position = styledAttributes.getInt(R.styleable.ArcLayout_arc_position, POSITION_BOTTOM);

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

    public int getPosition() {
        return position;
    }
}
