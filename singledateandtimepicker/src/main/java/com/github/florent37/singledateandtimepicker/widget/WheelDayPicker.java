package com.github.florent37.singledateandtimepicker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.github.florent37.singledateandtimepicker.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WheelDayPicker extends WheelPicker {

    public static final int DAYS_PADDING = 364;
    private int defaultIndex;

    private int todayPosition;

    private SimpleDateFormat simpleDateFormat;

    private OnDaySelectedListener onDaySelectedListener;

    public WheelDayPicker(Context context) {
        this(context, null);
    }

    public WheelDayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.simpleDateFormat = new SimpleDateFormat("EEE d MMM", getCurrentLocale());

        updateDays();

        updateDefaultDay();
    }

    @Override
    protected void onItemSelected(int position, Object item) {
        if (null != onDaySelectedListener) {
            final String itemText = (String)item;
            final Date date = convertItemToDate(position);
            onDaySelectedListener.onDaySelected(this, position, itemText, date);
        }
    }

    @Override
    public int getDefaultItemPosition() {
        return defaultIndex;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public Locale getCurrentLocale(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return getResources().getConfiguration().getLocales().get(0);
        } else{
            //noinspection deprecation
            return getResources().getConfiguration().locale;
        }
    }

    private void updateDays() {
        final List<String> data = new ArrayList<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, -1 * DAYS_PADDING - 1);
        for(int i= (-1) * DAYS_PADDING;i<0;++i) {
            instance.add(Calendar.DAY_OF_MONTH, 1);
            data.add(simpleDateFormat.format(instance.getTime()));
        }

        todayPosition = data.size();
        defaultIndex = todayPosition;

        //today
        data.add(getResources().getString(R.string.picker_today));

        instance = Calendar.getInstance();

        for(int i=0;i<DAYS_PADDING;++i) {
            instance.add(Calendar.DATE, 1);
            data.add(simpleDateFormat.format(instance.getTime()));
        }

        super.setData(data);
    }

    public void setOnDaySelectedListener(OnDaySelectedListener onDaySelectedListener) {
        this.onDaySelectedListener = onDaySelectedListener;
    }


    private void updateDefaultDay() {
        setSelectedItemPosition(defaultIndex);
    }

    public int getDefaultDayIndex() {
        return defaultIndex;
    }

    public Date getCurrentDate(){
        return convertItemToDate(super.getCurrentItemPosition());
    }

    private Date convertItemToDate(int itemPosition){
        Date date = null;
        String itemText = (String)getData().get(itemPosition);
        final Calendar todayCalendar = Calendar.getInstance();
        if(itemPosition == todayPosition){
            date = todayCalendar.getTime();
        } else {
            try {
                date = simpleDateFormat.parse(itemText);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if(date != null){
            //try to know the year
            final Calendar dateCalendar = Calendar.getInstance();
            dateCalendar.setTime(date);

            todayCalendar.add(Calendar.DATE, (itemPosition - todayPosition));

            dateCalendar.set(Calendar.YEAR, todayCalendar.get(Calendar.YEAR));
            date = dateCalendar.getTime();
        }

        return date;
    }

    public String getCurrentDay() {
        return String.valueOf(getData().get(getCurrentItemPosition()));
    }

    public interface OnDaySelectedListener {
        void onDaySelected(WheelDayPicker picker, int position, String name, Date date);
    }
}