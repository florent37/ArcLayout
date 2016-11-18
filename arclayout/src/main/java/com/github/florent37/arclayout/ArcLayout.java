package com.github.florent37.arclayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ArcLayout extends FrameLayout {

    ArcLayoutSettings settings;

    int height = 0;

    int width = 0;

    Path clipPath, outlinePath;

    Paint paint;

    private PorterDuffXfermode pdMode;

    public ArcLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ArcLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        settings = new ArcLayoutSettings(context, attrs);
        settings.setElevation(ViewCompat.getElevation(this));

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);

        pdMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }

    private void calculateLayout() {
        if (settings == null) {
            return;
        }
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        if (width > 0 && height > 0) {

            clipPath = createClipPath();

        }
    }

    private Path createClipPath() {
        final Path path = new Path();

        float verticalHeight = settings.getArcHeight();
        float horizontalPadding = settings.getArcPadding();
        final RectF arrowOval = new RectF();

        if(settings.isCropInside()) {
            path.moveTo(0, height);
            path.lineTo(0, height - verticalHeight);

            arrowOval.set(-horizontalPadding, height - verticalHeight * 2, width + horizontalPadding, height);

            path.arcTo(arrowOval, 180, -180, true);
            path.lineTo(width, height);
            path.lineTo(0, height);
        } else {
            path.moveTo(0, height);
            path.lineTo(0, height - verticalHeight);

            arrowOval.set(-horizontalPadding, height - verticalHeight, width + horizontalPadding, height + verticalHeight);
            path.arcTo(arrowOval, -180, 180, true);
            path.lineTo(width, height);
            path.lineTo(0, height);
        }

        return path;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            calculateLayout();
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int saveCount = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        super.dispatchDraw(canvas);

        paint.setXfermode(pdMode);
        canvas.drawPath(clipPath, paint);

        canvas.restoreToCount(saveCount);
        paint.setXfermode(null);
    }
}
