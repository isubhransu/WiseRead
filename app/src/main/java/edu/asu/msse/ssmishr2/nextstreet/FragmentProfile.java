package edu.asu.msse.ssmishr2.nextstreet;

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
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.nextstreet.adapter.adapt.PeopleGridviewAdapter;
import com.nextstreet.adapter.adapt.ProfileGridListViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FragmentProfile extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FragmentProfile newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FragmentProfile fragment = new FragmentProfile();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView followers = (TextView) view.findViewById(R.id.Followerscount);
        TextView following = (TextView) view.findViewById(R.id.followingcount);
        TextView name = (TextView) view.findViewById(R.id.PersonName);
        TextView bio = (TextView) view.findViewById(R.id.Bio);

        SharedPreferences pref  = PreferenceManager.getDefaultSharedPreferences(getActivity());//TODO SHARED PREFERENCE GIVING NULL
        String s = pref.getString("email", null);

        System.out.println("Email is "+s);
        PersonDetailsAsync getuserdetails = new PersonDetailsAsync("demo");
        getuserdetails.execute();
        List<String> usrDetails = new ArrayList<String>();
        try {
            usrDetails = getuserdetails.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(usrDetails);

        followers.setText(usrDetails.get(6));
        following.setText(usrDetails.get(7));
        name.setText(usrDetails.get(0)+" "+usrDetails.get(1));
        bio.setText(usrDetails.get(4));

        GridView gridView = (GridView) view.findViewById(R.id.myfeedgrid);


        gridView.setAdapter(new ProfileGridListViewAdapter(view.getContext()));

        return view;
    }
}