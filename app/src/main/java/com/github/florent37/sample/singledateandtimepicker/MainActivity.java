package com.github.florent37.sample.singledateandtimepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.github.florent37.singledateandtimepicker.SingleDayAndDatePicker;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingleDayAndDatePicker singleDayAndDatePicker = (SingleDayAndDatePicker) findViewById(R.id.single_day_picker);
        singleDayAndDatePicker.setListener(new SingleDayAndDatePicker.Listener() {
            @Override
            public void onDateChanged(String displayed, Date date) {
                display(displayed);
            }
        });
    }

    private void display(String toDisplay) {
        Toast.makeText(this, toDisplay, Toast.LENGTH_SHORT).show();
    }
}
