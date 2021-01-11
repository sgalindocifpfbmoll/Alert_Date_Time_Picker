package com.example.alertdatetimepicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Default values for the date and time
    private int year = 2020, month = 1, day = 1, hour = 0, minute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("ALERT");
        alertDialog.setCancelable(false);
        //
        Button buttonDate = findViewById(R.id.buttonDate);
        Button buttonTime = findViewById(R.id.buttonTime);
        // Date listener
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.setMessage("Do you want to open the date window?");
                alertDialog.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int id) {
                        showDateDialog();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int id) {
                        // Nothing happens. Go back to the main menu
                    }
                });
                alertDialog.show();
            }
        });
        // Time listener
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.setMessage("Do you want to open the time window?");
                alertDialog.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int id) {
                        showTimeDialog();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface alertDialog, int id) {
                        // Nothing happens. Go back to the main menu
                    }
                });
                alertDialog.show();
            }
        });
    }

    private void showDateDialog(){
        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int yearDialog, int monthDialog, int dayOfMonthDialog) {
                // Get the date
                year = yearDialog; month = monthDialog + 1; day = dayOfMonthDialog;
                // Display the toast
                showDateTimeToast();
            }
        },2020, 0, 1);
        //Show el widget
        datePickerDialog.show();
    }

    private void showTimeDialog(){
        final TimePickerDialog datePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDayDialog, int minuteDialog) {
                // Get the time
                hour = hourOfDayDialog; minute = minuteDialog;
                // Display the toast
                showDateTimeToast();
            }
        }, 0, 0, true);
        //Show el widget
        datePickerDialog.show();
    }

    private void showDateTimeToast(){
        Toast toast1 = Toast.makeText(getApplicationContext(), "Year: "+year+", Month: "+month+
                ", Day: "+day+ ", Hour: "+hour+", Minute: "+minute, Toast.LENGTH_SHORT);
        toast1.show();
    }
}