package com.example.event;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateTimePicker extends AppCompatActivity implements View.OnClickListener {
    private EditText datePicker, timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);
        init();
    }

    private void init() {
        datePicker = findViewById(R.id.selectDate);
        timePicker = findViewById(R.id.selectTime);
        datePicker.setOnClickListener(this);
        timePicker.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        if (v == timePicker) {
            Calendar calendar = Calendar.getInstance();
            int hh = calendar.get(Calendar.HOUR);
            int mm = calendar.get(Calendar.MINUTE);
            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    timePicker.setText(hourOfDay + " : " + minute);
                }
            }, hh, mm, true);
            dialog.show();
        }
        if (v == datePicker) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    datePicker.setText(day + "/" + (month + 1) + "/" + year);
                }
            }, year, month, day);
            dialog.show();
        }

    }
}