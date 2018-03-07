package com.shawnlin.numberpicker.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.shawnlin.numberpicker.NumberPicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private String time;
    String strNewValNumber = "";
    String strNewValHorizontal;
    String strNewValNumber2 = "";
    String strNewValNumber3 = "";
    private static String TAG = "NumberPicker";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final NumberPicker numberPicker = findViewById(R.id.number_picker);
        final NumberPicker number_picker2 = findViewById(R.id.number_picker2);
        final NumberPicker number_picker3 = findViewById(R.id.number_picker3);
//        NumberPicker horizontal_number_picker = findViewById(R.id.horizontal_number_picker);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        final TextView tvShowTime = findViewById(R.id.tvShowTime);


        // Set divider color
        numberPicker.setDividerColor(ContextCompat.getColor(this, R.color.colorPrimary));
        numberPicker.setDividerColorResource(R.color.colorPrimary);

        // Set formatter
        numberPicker.setFormatter(getString(R.string.number_picker_formatter));
        numberPicker.setFormatter(R.string.number_picker_formatter);
        String[] data = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
//        numberPicker.setDisplayedValues(data);

        // Set selected text color
        numberPicker.setSelectedTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        numberPicker.setSelectedTextColorResource(R.color.colorPrimary);

        // Set selected text size
        numberPicker.setSelectedTextSize(getResources().getDimension(R.dimen.selected_text_size));
        numberPicker.setSelectedTextSize(R.dimen.selected_text_size);

        // Set text color
        numberPicker.setTextColor(ContextCompat.getColor(this, R.color.dark_grey));
        numberPicker.setTextColorResource(R.color.dark_grey);

        // Set text size
        numberPicker.setTextSize(getResources().getDimension(R.dimen.text_size));
        numberPicker.setTextSize(R.dimen.text_size);

        // Set typeface
        numberPicker.setTypeface(Typeface.create(getString(R.string.roboto_light), Typeface.NORMAL));
        numberPicker.setTypeface(getString(R.string.roboto_light), Typeface.NORMAL);
        numberPicker.setTypeface(getString(R.string.roboto_light));
        numberPicker.setTypeface(R.string.roboto_light, Typeface.NORMAL);
        numberPicker.setTypeface(R.string.roboto_light);

        // Set value
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        strNewValNumber3 = String.valueOf(mYear);
        strNewValNumber = String.valueOf(mMonth);
        strNewValNumber2 = String.valueOf(mDay);

        time = strNewValNumber2 + "/" + strNewValNumber + "/" + strNewValNumber3;

        numberPicker.setMaxValue(12);
        numberPicker.setMinValue(1);
        numberPicker.setValue(mMonth + 1);

        number_picker2.setValue(mDay);
        number_picker3.setValue(mYear);

        // Set fading edge enabled
        numberPicker.setFadingEdgeEnabled(true);

        // Set scroller enabled
        numberPicker.setScrollerEnabled(true);

        // Set wrap selector wheel
        numberPicker.setWrapSelectorWheel(true);

        // OnClickListener
        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Click on current value");
            }
        });

        // OnValueChangeListener
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                Log.d(TAG, String.format(Locale.US, "oldVal: %d, newVal: %d", oldVal, newVal));
                strNewValNumber = String.valueOf(newVal);
            }
        });

        number_picker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                strNewValNumber2 = String.valueOf(newVal);
            }
        });

        number_picker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                strNewValNumber3 = String.valueOf(newVal);
            }
        });

//        horizontal_number_picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//                strNewValHorizontal = String.valueOf(newVal);
//            }
//        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = strNewValNumber2 + "/" + strNewValNumber + "/" + strNewValNumber3;
                tvShowTime.setText(time);


            }
        });

    }

}
