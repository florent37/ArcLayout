package com.github.florent37.singledateandtimepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.github.florent37.singledateandtimepicker.widget.WheelDayPicker;
import com.github.florent37.singledateandtimepicker.widget.WheelHourPicker;
import com.github.florent37.singledateandtimepicker.widget.WheelMinutePicker;
import com.github.florent37.singledateandtimepicker.widget.WheelPicker;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class SingleDayAndDatePicker extends LinearLayout {

    public static final boolean IS_CYCLIC_DEFAULT = true;
    public static final boolean IS_CURVED_DEFAULT = false;
    public static final boolean CAN_BE_ON_PAST_DEFAULT = false;

    private WheelDayPicker daysPicker;
    private WheelMinutePicker minutesPicker;
    private WheelHourPicker hoursPicker;

    private Listener listener;

    private int textColor;
    private int selectedTextColor;
    private int textSize;
    private boolean isCyclic;
    private boolean isCurved;

    private boolean canBeOnPast;

    public SingleDayAndDatePicker(Context context) {
        this(context, null);
    }

    public SingleDayAndDatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SingleDayAndDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        inflate(context, R.layout.single_day_picker, this);

        daysPicker = (WheelDayPicker) findViewById(R.id.daysPicker);
        minutesPicker = (WheelMinutePicker) findViewById(R.id.minutesPicker);
        hoursPicker = (WheelHourPicker) findViewById(R.id.hoursPicker);

        for (WheelPicker wheelPicker : Arrays.asList(daysPicker, minutesPicker, hoursPicker)) {
            wheelPicker.setItemTextColor(textColor);
            wheelPicker.setSelectedItemTextColor(selectedTextColor);
            wheelPicker.setItemTextSize(textSize);
            wheelPicker.setCyclic(isCyclic);
            wheelPicker.setCurved(isCurved);
        }

        daysPicker.setOnDaySelectedListener(new WheelDayPicker.OnDaySelectedListener() {
            @Override
            public void onDaySelected(WheelDayPicker picker, int position, String name, Date date) {
                updateListener();
                checkInPast(picker);
            }
        });

        minutesPicker.setOnMinuteSelectedListener(new WheelMinutePicker.OnMinuteSelectedListener() {
            @Override
            public void onMinuteSelected(WheelMinutePicker picker, int position, int minutes) {
                updateListener();
                checkInPast(picker);
            }
        });

        hoursPicker.setOnHourSelectedListener(new WheelHourPicker.OnHourSelectedListener() {
            @Override
            public void onHourSelected(WheelHourPicker picker, int position, int hours) {
                updateListener();
                checkInPast(picker);
            }
        });
    }

    private void checkInPast(final WheelPicker picker) {
        picker.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!canBeOnPast && isInPast(getDate())) {
                    picker.scrollTo(picker.getDefaultItemPosition());
                }
            }
        }, 400);
    }

    private boolean isInPast(Date date) {
        final Calendar todayCalendar = Calendar.getInstance();
        final Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        return dateCalendar.before(todayCalendar);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public Date getDate(){
        final int hour = hoursPicker.getCurrentHour();
        final int minute = minutesPicker.getCurrentMinute();

        final Calendar calendar = Calendar.getInstance();
        final Date dayDate = daysPicker.getCurrentDate();
        calendar.setTime(dayDate);
        calendar.set(Calendar.HOUR, hour);
        calendar.set(Calendar.MINUTE, minute);

        final Date time = calendar.getTime();
        return time;
    }

    private void updateListener() {
        final int hour = hoursPicker.getCurrentHour();
        final int minute = minutesPicker.getCurrentMinute();
        final String displayed = daysPicker.getCurrentDay() + " " + hour + ":" + minute;

        if (listener != null) {
            listener.onDateChanged(displayed, getDate());
        }
    }

    public void setCanBeOnPast(boolean canBeOnPast) {
        this.canBeOnPast = canBeOnPast;
    }

    public boolean canBeOnPast() {
        return canBeOnPast;
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SingleDayAndDatePicker);

        textColor = a.getColor(R.styleable.SingleDayAndDatePicker_picker_textColor,
            getResources().getColor(R.color.picker_default_text_color));
        selectedTextColor = a.getColor(R.styleable.SingleDayAndDatePicker_picker_selectedTextColor,
            getResources().getColor(R.color.picker_default_selected_text_color));
        textSize = a.getDimensionPixelSize(R.styleable.SingleDayAndDatePicker_picker_textSize,
            getResources().getDimensionPixelSize(R.dimen.WheelItemTextSize));
        isCurved = a.getBoolean(R.styleable.SingleDayAndDatePicker_picker_curved, IS_CURVED_DEFAULT);
        isCyclic = a.getBoolean(R.styleable.SingleDayAndDatePicker_picker_cyclic, IS_CYCLIC_DEFAULT);
        canBeOnPast = a.getBoolean(R.styleable.SingleDayAndDatePicker_picker_canBeOnPast, CAN_BE_ON_PAST_DEFAULT);

        a.recycle();
    }

    public interface Listener {
        void onDateChanged(String displayed, Date date);
    }
}
