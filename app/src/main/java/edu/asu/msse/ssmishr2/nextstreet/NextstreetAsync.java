package edu.asu.msse.ssmishr2.nextstreet;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nextstreet.backend.userApi.UserApi;
import com.nextstreet.backend.userApi.model.User;

import java.io.IOException;
import java.util.List;

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

public class NextstreetAsync extends AsyncTask<Void, Void, Integer> {
    private static UserApi service = null;
    User response = null;
    private Context context;
    String utxt;
    String ptxt;

    NextstreetAsync(String utxt, String ptxt){
        this.utxt = utxt;
        this.ptxt = ptxt;
    }

    NextstreetAsync(Context context) {
        this.context = context;
    }

    @Override
    protected Integer doInBackground(Void... params) {
        Log.d(this.getClass().getSimpleName(), "in LOGIN ondoInBackground on" +
                (Looper.myLooper() == Looper.getMainLooper() ? "Main thread" : "Async thread"));
        if (service == null) { // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://big-icon-861.appspot.com/_ah/api/");
            service = builder.build();
            System.out.println("HERE IN AFTER API CONNECTS");
        }

        try {
            System.out.println("HERE IN TRY FOR SERVICE ACCESS");
            response = service.getIfUserExist(utxt).execute();
            //System.out.println(response.getActive());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HERE IN BEFORE RETURN SERVICE ACCESS");
        return response.getActive();
    }
}
//ASYNCTASK FOR NEW USER REGISTRATION
class RegisterAsync extends AsyncTask<Void, Void, Void>{
    private static UserApi service = null;
    User response = null;
    private Context context;
    String fname;
    String ptxt;
    String lname;
    String email;

    public RegisterAsync(String ptxt, String fname, String lname, String email){
        this.ptxt = ptxt;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Log.d(this.getClass().getSimpleName(), "in Reg onInBackground on" +
                (Looper.myLooper() == Looper.getMainLooper() ? "Main thread" : "Async thread"));
        if (service == null) { // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://big-icon-861.appspot.com/_ah/api/");
            service = builder.build();
        }
        try {
            System.out.println("IN TRY OF REG");
            System.out.println(service.setUser("demo", ptxt, fname, lname, email).execute());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ptxt);
        /*
        try {
            response = service.settUser();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return null;
    }
}
