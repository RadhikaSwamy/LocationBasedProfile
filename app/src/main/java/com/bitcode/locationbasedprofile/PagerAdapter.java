package com.bitcode.locationbasedprofile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by root on 2/12/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;

    public PagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                Location location=new Location();
                return location;
            case 1:
                Profiles profiles=new Profiles();
                return profiles;
            case 2:
                Events events=new Events();
                return events;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
