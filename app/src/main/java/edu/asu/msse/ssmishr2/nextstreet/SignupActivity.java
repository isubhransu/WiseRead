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
