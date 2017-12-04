package com.bitcode.locationbasedprofile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 2/12/17.
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderLocation> {
    Context mContxt;
    ArrayList<SavedLocation> mArrLocationList;

    public AdapterRecyclerView(Context mContxt, ArrayList<SavedLocation> mArrLocationList) {
        this.mContxt = mContxt;
        this.mArrLocationList = mArrLocationList;
    }

    @Override
    public ViewHolderLocation onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mContxt);
        View view=inflater.inflate(R.layout.lay_adapter_location,null);

        ViewHolderLocation viewHolderLocation=new ViewHolderLocation(view);
        return viewHolderLocation;
    }

    @Override
    public void onBindViewHolder(ViewHolderLocation holder, int position) {

        final SavedLocation savedLocation=mArrLocationList.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderLocation extends RecyclerView.ViewHolder {
        TextView txtLocName, txtProfName;
        public ViewHolderLocation(View itemView) {
            super(itemView);
            txtLocName=itemView.findViewById(R.id.txtLocName);
            txtProfName=itemView.findViewById(R.id.txtProfName);
        }
    }


   }
