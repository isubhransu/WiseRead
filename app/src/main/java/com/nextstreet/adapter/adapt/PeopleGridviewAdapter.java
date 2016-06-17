package com.nextstreet.adapter.adapt;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.asu.msse.ssmishr2.nextstreet.FollowPeopleAsync;
import edu.asu.msse.ssmishr2.nextstreet.R;
import edu.asu.msse.ssmishr2.nextstreet.WisereaderAsync;

//import android.content.DialogInterface;
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

class SinglePeople{
    int profilePic;
    String peopleName;
    String peopleEmail;
    SinglePeople(int img, String peopleName, String peopleEmail){
        this.profilePic = img;
        this.peopleName = peopleName;
        this.peopleEmail = peopleEmail;
    }
}

public class PeopleGridviewAdapter extends BaseAdapter{
    private Context mContext;
    ViewHolder holder = null;
    Boolean val = true;
    ArrayList<SinglePeople> peoplelist;
    SharedPreferences pref;
    int strln;

    public PeopleGridviewAdapter(Context context) {
        this.pref = context.getSharedPreferences("Mydetails", 0);
        this.mContext = context;
        peoplelist = new ArrayList<SinglePeople>();

        //TODO Make it dynamic
        int[] tempProfilePic = {R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile, R.drawable.demo_profile};
        //A database request to get all the name and description of people inorder of number of follower
        WisereaderAsync checkuser = new WisereaderAsync();
        checkuser.execute();
        List<List<String>> temp;
        try {
            temp = checkuser.get();
            List<String> tempPeoplename = temp.get(0);
            List<String> tempPeopleemail = temp.get(1);
            System.out.println(tempProfilePic[7]);
            strln = tempPeoplename.toArray(new String[0]).length;

            String[] tempPeopleName = tempPeoplename.toArray(new String[0]);
            String[] tempPeopleEmail = tempPeopleemail.toArray(new String[0]);


             for (int i = 0; i < strln-1; i++) {
                SinglePeople tempPeople = new SinglePeople(tempProfilePic[i], tempPeopleName[i], tempPeopleEmail[i]);
                 System.out.print(tempPeopleName.length);
                peoplelist.add(tempPeople);
            }

       } catch (InterruptedException e) {
           e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
       }
    }

    public int getCount() {
        return peoplelist.size();
    }

    public Object getItem(int i) {
        return peoplelist.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    //Recycles the use of view
    class ViewHolder{
        ImageView peopleprofilepic;
        TextView pName;
        TextView pDesc;
        Button followb;
        ViewHolder(View v){
            peopleprofilepic = (ImageView) v.findViewById(R.id.peopleprofilepic);
            pName = (TextView) v.findViewById(R.id.PeopleName);
            pDesc = (TextView) v.findViewById(R.id.PeopleDesc);
            followb = (Button) v.findViewById(R.id.button2);
        }
    }

    //Setting the view of each viewholder of grid view
    public View getView(int i, View convertView, ViewGroup parent) {
        View vindex = convertView;
        if(vindex == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vindex = inflater.inflate(R.layout.singlepeopleview, parent, false);
            holder = new ViewHolder(vindex);
            vindex.setTag(holder);
        }else {
            holder = (ViewHolder) vindex.getTag();
        }

        SinglePeople temp = peoplelist.get(i);
        holder.peopleprofilepic.setImageResource(temp.profilePic);
        holder.pName.setText(temp.peopleName);
        holder.pDesc.setText(temp.peopleEmail);

        final int position = i;

        (vindex.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String follower = pref.getString("email", null);
                final String followed = peoplelist.get(position).peopleEmail;
                if(holder.followb.getText().toString().equals("follow")) {
                    holder.followb.setText("unfollow");
                }else{
                    holder.followb.setText("follow");
                }
                System.out.println("I am "+ follower+ " following "+followed);

                FollowPeopleAsync checkuser = new FollowPeopleAsync(followed, follower);
                checkuser.execute();
            }
        });

//TODO NULL VIEW IS COMING
/*
        final int position = i;
        (convertView.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
               String pname = peoplelist.get(position).peopleName;
                FollowPeopleAsync checkuser = new FollowPeopleAsync(pname);
                checkuser.execute();
            }
        });
        */


        return vindex;
    }

}


