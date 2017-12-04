package com.bitcode.locationbasedprofile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by root on 2/12/17.
 */

public class CustomProfileScreen extends Fragment{
    ImageView mImgMedia, mImgalarm,mImgnotification, mImgring, mImgmessage;
    TextView mTxtMedia, mTxtAlarm, mTxtNotification, mTxtRing, mTxtMessage, mTxtWallpaper;
    SeekBar mSeekMedia, mSeekAlarm, mSeekNotify, mSeekRing, mSeekMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.lay_custom_profile,null);

        mImgMedia=view.findViewById(R.id.imgmedia);
        mImgalarm=view.findViewById(R.id.imgalarm);
        mImgnotification=view.findViewById(R.id.imgnotification);
        mImgring=view.findViewById(R.id.imgring);
        mImgmessage=view.findViewById(R.id.imgmessage);

        mTxtMedia=view.findViewById(R.id.txtmedia);
        mTxtAlarm=view.findViewById(R.id.txtalarm);
        mTxtNotification=view.findViewById(R.id.txtnotification);
        mTxtRing=view.findViewById(R.id.txtring);
        mTxtMessage=view.findViewById(R.id.txtmessage);
        mTxtWallpaper=view.findViewById(R.id.changeWallpaper);


        Bundle bundle=getArguments();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_profile,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
