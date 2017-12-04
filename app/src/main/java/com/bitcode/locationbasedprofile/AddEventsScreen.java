package com.bitcode.locationbasedprofile;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by root on 2/12/17.
 */

public class AddEventsScreen extends Fragment {

    Button mBtnSelectDay, mBtnFromTime, mBtnToTime;
    TextView mTxtDay, mTxtFromTime,mTxtToTime, mTxtProfileEvent;
    Spinner mSpinnerEvents;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lay_add_events,null);

        mBtnSelectDay= (Button) view.findViewById(R.id.btnDay);
        mBtnFromTime= (Button) view.findViewById(R.id.btnFromTime);
        mBtnToTime=view.findViewById(R.id.btnToTime);
        mTxtDay= (TextView) view.findViewById(R.id.txtDayDate);
        mTxtFromTime= (TextView) view.findViewById(R.id.txtFromTime);
        mTxtToTime= (TextView) view.findViewById(R.id.txtToTime);
        mTxtProfileEvent=view.findViewById(R.id.txtSelectProfile);

        mSpinnerEvents=view.findViewById(R.id.spinnerEvent);
        String [] profiles={"Normal","Silent","Vibrate"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,profiles);
        mSpinnerEvents.setAdapter(adapter);

        Bundle bundle=getArguments();
        setHasOptionsMenu(true);

        mBtnSelectDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        mTxtDay.setText(day+"/"+(month+1)+"/"+year);
                    }
                },2017,10,05);
                datePickerDialog.show();
            }
        });


        mBtnFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {

                        String timeSet = "";
                        if (hour > 12) {
                            hour -= 12;
                            timeSet = "PM";
                        } else if (hour == 0) {
                            hour += 12;
                            timeSet = "AM";
                        } else if (hour == 12)
                            timeSet = "PM";
                        else
                            timeSet = "AM";

                        String minutes="";
                        if (minute < 10)
                            minutes = "0" + minute;
                        else
                            minutes = String.valueOf(minute);

                        mTxtFromTime.setText(hour + ":" + minutes + " " + timeSet);

                    }
                },10,00,false);
                timePickerDialog.show();

            }
        });

        mBtnToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog=new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {

                        String timeSet = "";
                        if (hour > 12) {
                            hour -= 12;
                            timeSet = "PM";
                        } else if (hour == 0) {
                            hour += 12;
                            timeSet = "AM";
                        } else if (hour == 12)
                            timeSet = "PM";
                        else
                            timeSet = "AM";

                        String minutes="";
                        if (minute < 10)
                            minutes = "0" + minute;
                        else
                            minutes = String.valueOf(minute);

                        mTxtToTime.setText(hour + ":" + minutes + " " + timeSet);

                    }
                },10,10,false);
                timePickerDialog.show();

            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_event,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.save:


        }

        return true;
    }}
