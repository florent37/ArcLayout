package com.github.florent37.singledateandtimepicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WheelMinutePicker extends WheelPicker {
    public static final int MIN_MINUTES = 0;
    public static final int MAX_MINUTES = 55;
    public static final int STEP_MINUTES = 5;

    private int defaultMinute;

    private OnMinuteSelectedListener onMinuteSelectedListener;

    public WheelMinutePicker(Context context) {
        this(context, null);
    }

    public WheelMinutePicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        final String format = "%1$02d"; // two digits

        List<String> minutes = new ArrayList<>();
        for (int min = MIN_MINUTES; min <= MAX_MINUTES; min += STEP_MINUTES)
            minutes.add(String.format(format, min));
        super.setData(minutes);

        defaultMinute = Calendar.getInstance().get(Calendar.MINUTE);

        updateDefaultMinute();
    }

    public void setOnMinuteSelectedListener(OnMinuteSelectedListener onMinuteSelectedListener) {
        this.onMinuteSelectedListener = onMinuteSelectedListener;
    }

    @Override
    protected void onItemSelected(int position, Object item) {
        if (onMinuteSelectedListener != null) {
            onMinuteSelectedListener.onMinuteSelected(this, position, convertItemToMinute(item));
        }
    }

    private int findIndexOfMinute(int minute) {
        final List data = getData();
        for (int i = 0; i < data.size(); ++i) {
            final String object = (String) data.get(i);
            final Integer value = Integer.valueOf(object);
            if (minute < value) {
                return i - 1;
            }
        }
        return 0;
    }

    private void updateDefaultMinute() {
        setSelectedItemPosition(findIndexOfMinute(defaultMinute));
    }

    public void setDefaultMinute(int minutes) {
        this.defaultMinute = minutes;
        updateDefaultMinute();
    }

    @Override
    public int getDefaultItemPosition() {
        return findIndexOfMinute(defaultMinute);
    }

    private int convertItemToMinute(Object item) {
        return Integer.valueOf(String.valueOf(item));
    }

    public int getCurrentMinute() {
        return convertItemToMinute(getData().get(getCurrentItemPosition()));
    }

    public interface OnMinuteSelectedListener {
        void onMinuteSelected(WheelMinutePicker picker, int position, int minutes);
    }
}