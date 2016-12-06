package com.github.florent37.singledateandtimepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelHourPicker extends WheelPicker {

    public static final int MIN_HOUR = 1;
    public static final int MAX_HOUR = 24;
    public static final int STEP_HOUR = 1;

    private OnHourSelectedListener hoursSelectedListener;

    private int defaultHour;

    public WheelHourPicker(Context context) {
        this(context, null);
    }

    public WheelHourPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        final String format = "%1$02d"; // two digits

        final List<String> hours = new ArrayList<>();
        for (int hour = MIN_HOUR; hour <= MAX_HOUR; hour += STEP_HOUR)
            hours.add(String.format(format, hour));
        super.setData(hours);

        defaultHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        updateDefaultHour();
    }

    @Override
    protected void onItemSelected(int position, Object item) {
        if(hoursSelectedListener != null){
            hoursSelectedListener.onHourSelected(this, position, convertItemToMinute(item));
        }
    }

    private void updateDefaultHour() {
        setSelectedItemPosition(defaultHour - 1);
    }

    @Override
    public void setData(List data) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelHourPicker");
    }

    @Override
    public int getDefaultItemPosition() {
        return defaultHour;
    }

    public void setOnHourSelectedListener(OnHourSelectedListener hoursSelectedListener) {
        this.hoursSelectedListener = hoursSelectedListener;
    }

    public void setDefaultHour(int hour) {
        defaultHour = hour;
        updateDefaultHour();
    }

    private int convertItemToMinute(Object item){
        return Integer.valueOf(String.valueOf(item));
    }

    public int getCurrentHour() {
        return convertItemToMinute(getData().get(getCurrentItemPosition()));
    }

    public interface OnHourSelectedListener {
        void onHourSelected(WheelHourPicker picker, int position, int hours);
    }
}