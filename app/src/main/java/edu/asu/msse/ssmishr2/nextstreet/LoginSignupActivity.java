package edu.asu.msse.ssmishr2.nextstreet;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.concurrent.ExecutionException;
import javax.xml.transform.Result;

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


        setContentView(R.layout.loginsignup);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        loginbutton = (Button) findViewById(R.id.btnLogin);
    }

    public void onLoginClick(View v) {

        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        /**
        int ifactive = 2;
        utxt = email.getText().toString();
        ptxt = password.getText().toString();

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Mydetails", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("email", utxt); // Storing string
        editor.commit();
        NextstreetAsync checkuser = new NextstreetAsync(utxt, ptxt);
        checkuser.execute();

        try {
            ifactive = checkuser.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         **/

        utxt = email.getText().toString();
        ptxt = password.getText().toString();
        if(utxt.equals("demo") && ptxt.equals("demo")) {
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