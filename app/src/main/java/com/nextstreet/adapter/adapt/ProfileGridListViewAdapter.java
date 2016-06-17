package com.nextstreet.adapter.adapt;
/**
 * Copyright 2015 Subhransu Mishra
 * All Rights Reserved by Subhransu Mishra, Founder, Wiseread
 * Purpose & restrictions: Only TA and Instructor of SER494 have rights to access the sourcecode. By accessing the source code
 * you agree not to use source code or share source code with anyone.
 *
 * @author Subhransu Mishra s.mishra@asu.edu
 *         MS Software Engineering, CIDSE, ASU
 *
 * @version May 1st 2015
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import edu.asu.msse.ssmishr2.nextstreet.R;


public class ProfileGridListViewAdapter extends BaseAdapter {
    private Context mContext;

    ArrayList<SinglePeople> peoplelist;
    SharedPreferences pref;

    public ProfileGridListViewAdapter(Context context) {
        this.mContext = context;
        //TODO
    }

    public int getCount() {
        return 7;
    }

    public Object getItem(int i) {
        return 7;
    }

    public long getItemId(int i) {
        return 7;
    }

    //Setting the view of each viewholder of grid view
    public View getView(int i, View convertView, ViewGroup parent) {
        View vindex = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vindex = inflater.inflate(R.layout.myfeedview, parent, false);

        return vindex;
    }

}


