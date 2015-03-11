package edu.asu.msse.ssmishr2.nextstreet;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import javax.xml.transform.Result;

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
 * @version February 18 2015
 */

public class LoginSignupActivity extends Activity {
    // Declare Variables
    Button loginbutton;
    Button signup;
    String ptxt;
    String utxt;
    EditText password;
    EditText email;


    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Get the view from main.xml
        setContentView(R.layout.loginsignup);

        // Locate EditTexts in main.xml
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        // Locate Buttons in main.xml
        loginbutton = (Button) findViewById(R.id.btnLogin);
    }

    public void onLoginClick(View v) {

        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        int ifactive = 2;
        utxt = email.getText().toString();
        ptxt = password.getText().toString();

        NextstreetAsync checkuser = new NextstreetAsync(utxt, ptxt);
        checkuser.execute();

        try {
            ifactive = checkuser.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(ifactive == 1) {
            Intent goHome = new Intent(getApplicationContext(), Home.class);
            startActivity(goHome);
            finish();
        }else{
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("wrong password or username");
            dlgAlert.setTitle("Error Message...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }
    public void onSignupClick(View V){
        Intent gosignUP = new Intent(this, SignupActivity.class);
        startActivity(gosignUP);
        finish();
    }
}