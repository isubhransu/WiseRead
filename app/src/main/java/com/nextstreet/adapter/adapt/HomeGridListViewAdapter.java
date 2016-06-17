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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.asu.msse.ssmishr2.nextstreet.FollowPeopleAsync;
import edu.asu.msse.ssmishr2.nextstreet.R;
import edu.asu.msse.ssmishr2.nextstreet.WisereaderAsync;



public class HomeGridListViewAdapter extends BaseAdapter {
    private Context mContext;

    ArrayList<SinglePeople> peoplelist;
    SharedPreferences pref;

    public HomeGridListViewAdapter(Context context) {
        this.mContext = context;
        //TODO
    }

    public int getCount() {
        return 3;
    }

    public Object getItem(int i) {
        return 3;
    }

    public long getItemId(int i) {
        return 3;
    }


    //Setting the view of each viewholder of grid view
    public View getView(int i, View convertView, ViewGroup parent) {
        View vindex = convertView;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vindex = inflater.inflate(R.layout.singlepostview, parent, false);

        return vindex;
    }

}


