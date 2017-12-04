package com.bitcode.locationbasedprofile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;


public class Profiles extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView mTxtNormal,mTxtSilent, mTxtVibrate;
    FloatingActionButton fab;
    ArrayList<TextView> mArrList;
    LinearLayout linearLayout;
    int counter = 0;
    TextView textView;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Profiles() {

    }


    public static Profiles newInstance(String param1, String param2) {
        Profiles fragment = new Profiles();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_profiles,null);
        mTxtNormal=view.findViewById(R.id.txtNormal);
        mTxtSilent=view.findViewById(R.id.txtSilent);
        mTxtVibrate=view.findViewById(R.id.txtSilent);


        linearLayout=view.findViewById(R.id.list);
        fab=view.findViewById(R.id.floating);


        mArrList = new ArrayList<>();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView = new TextView(getContext());
                linearLayout.addView(textView);
                mArrList.add(counter,textView);
                textView.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                textView.setTextSize(20);
                textView.setPaddingRelative(16,16,16,16);
                textView.setBackgroundColor(Color.LTGRAY);
                textView.setText("Custom Profile"+counter);
                textView.setLayoutParams(layoutParams);
                counter++;
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainActivity mainActivity= (MainActivity) getContext();
                        CustomProfileScreen customProfileScreen=new CustomProfileScreen();
                        Bundle bundle=new Bundle();
                        customProfileScreen.setArguments(bundle);
                        mainActivity.fragmentManager.beginTransaction().addToBackStack("").replace(R.id.content_frame,customProfileScreen,null).commit();
                    }
                });
            }
        });



        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
