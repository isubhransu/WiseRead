package edu.asu.msse.ssmishr2.nextstreet;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.nextstreet.backend.userApi.UserApi;
import com.nextstreet.backend.userApi.model.User;

import java.io.IOException;
import java.util.ArrayList;
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
public class PersonDetailsAsync extends AsyncTask<Void, Void, List<String>> {
    private static UserApi service = null;
    User response = null;
    String email;
    private Context context;

    public PersonDetailsAsync(String email){
        this.email = email;
    }

    @Override
    protected List<String> doInBackground(Void... params) {
        Log.d(this.getClass().getSimpleName(), "in WisereaderAsync onInBackground on" +
                (Looper.myLooper() == Looper.getMainLooper() ? "Main thread" : "Async thread"));
        if (service == null) { // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://big-icon-861.appspot.com/_ah/api/");
            service = builder.build();
        }
        try {
            response = service.getIfUserExist(email).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> dict = new ArrayList<String>();
        dict = response.getPersonDetail();

        System.out.println("IN WISEREADER BACKGROUND " + response.getNamestr());
        return dict;
    }
}
