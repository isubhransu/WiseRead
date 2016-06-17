package com.nextstreet.backend;

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
public class User {

    public int active;
    public List<String> namestr;
    public List<String> emailstr;
    public List<String> personDetail;

    public void setActive(int dta){
        this.active = dta;
    }

    public  void setNamestr(List<String> str){
        this.namestr = str;
    }

    public void setPersonDetail(List<String> str){
        this.personDetail = str;
    }

    public  List<String> getPersonDetail(){
        return this.personDetail;
    }
    public List<String> getNamestr(){
        return this.namestr;
    }

    public void setEmailstr(List<String> str){
        this.emailstr = str;
    }

    public List<String> getEmailstr(){
        return this.emailstr;
    }

    public int getActive(){
        return this.active;
    }
}
