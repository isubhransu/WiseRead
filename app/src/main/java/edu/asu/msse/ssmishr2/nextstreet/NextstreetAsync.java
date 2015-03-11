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

/**
 * Copyright 2015 Subhransu Mishra
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Purpose:
 *
 * @author Subhransu Mishra s.mishra@asu.edu
 *         MS Software Engineering, CIDSE, ASU
 * @version February 24 2015
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
        Log.d(this.getClass().getSimpleName(), "in LOGIN onInBackground on" +
                (Looper.myLooper() == Looper.getMainLooper() ? "Main thread" : "Async thread"));
        if (service == null) { // Only do this once
            UserApi.Builder builder = new UserApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://big-icon-861.appspot.com/_ah/api/");
            service = builder.build();
            System.out.println("HERE IN AFTER API CONNECTS");
        }
        try {
            System.out.println("HERE IN TRY FOR SERVICE ACCESS");
            response = service.getIfUserExist(utxt, ptxt).execute();
            //System.out.println(response.getActive());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HERE IN BEFORE RETURN SERVICE ACCESS");
        return response.getActive();
    }
}

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