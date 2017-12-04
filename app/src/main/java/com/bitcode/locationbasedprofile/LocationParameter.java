package com.bitcode.locationbasedprofile;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.xw.repo.BubbleSeekBar;
import com.xw.repo.BubbleSeekBar.OnProgressChangedListenerAdapter;

/**
 * Created by root on 2/12/17.
 */

public class LocationParameter extends AppCompatActivity{

    TextView mTxtLocationName, mTxtProfile, mTxtRadius,mTxtSeekProgress;
    EditText mEditLocationName;
    Spinner mSpinner;
    BubbleSeekBar mSeekBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_location_parameters);

        mTxtLocationName= (TextView) findViewById(R.id.txtLocationName);
        mTxtProfile= (TextView) findViewById(R.id.txtprofilelocation);
        mTxtRadius= (TextView) findViewById(R.id.txtradius);
        mEditLocationName= (EditText) findViewById(R.id.locationName);
        mSpinner= (Spinner) findViewById(R.id.spinnerProfiles);
        mSeekBar= (BubbleSeekBar) findViewById(R.id.bubleSeekBar);
        mTxtSeekProgress= (TextView) findViewById(R.id.txtSeek);

        final String [] profiles={"Normal","Silent","Vibrate"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,profiles);
        mSpinner.setAdapter(adapter);
        Intent intent=getIntent();

       mSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
           @Override
           public void onProgressChanged(int progress, float progressFloat) {
               mTxtSeekProgress.setText(String.format(String.valueOf(progress)));
           }

           @Override
           public void getProgressOnActionUp(int progress, float progressFloat) {

           }

           @Override
           public void getProgressOnFinally(int progress, float progressFloat) {

           }
       });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_location,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}

