package com.example.timepickerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvTimeResult;
    private Button btTimePicker;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimeResult = (TextView) findViewById(R.id.tv_timeresult);
        btTimePicker = (Button) findViewById(R.id.bt_showtimepicker);
        btTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
    }

    private void showTimeDialog(){

        /**
         * Calendar untuk mendapatkan waktu saat ini
         */

        Calendar calendar = Calendar.getInstance();

        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfday, int minute) {
                /**
                 * method dipanggil untuk memilih waktu datepicker
                 */
                tvTimeResult.setText("Waktu Dipilih = " + hourOfday + ":" + minute);
            }
        },
                /**
                 * Menampilkan jam saat ini ketika timepicker pertama kali dibuka
                 */
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),

                /**
                 * Cek format waktu
                 */
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
}