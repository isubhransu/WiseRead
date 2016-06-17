package edu.asu.msse.ssmishr2.nextstreet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
public class SignupActivity extends Activity{

    EditText pass;
    EditText fname;
    EditText lname;
    EditText email;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Get the view from main.xml
        setContentView(R.layout.signup);
    }

    public void onRegClicked(View V){

        email = (EditText) findViewById(R.id.reg_email);
        pass = (EditText)findViewById(R.id.reg_password);
        fname = (EditText)findViewById(R.id.reg_firstname);
        lname = (EditText)findViewById(R.id.reg_lastname);

        String em = email.getText().toString();
        String fn = fname.getText().toString();
        String ln = lname.getText().toString();
        String pa = pass.getText().toString();

        RegisterAsync reg = new RegisterAsync(pa,fn, ln, em);
        reg.execute();

        Intent golog = new Intent(this, LoginSignupActivity.class);
        startActivity(golog);
        finish();

        Toast.makeText(this, "Welcome! Please verify email ID", Toast.LENGTH_LONG).show();
    }

    public void ongoLoginClick(View V){
        Intent gologIn = new Intent(this, LoginSignupActivity.class);
        startActivity(gologIn);
        finish();
    }
}
