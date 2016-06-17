package com.nextstreet.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.utils.SystemProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

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

@Api(
        name = "userApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.nextstreet.com",
                ownerName = "backend.nextstreet.com",
                packagePath = ""
        )
)

public class UserEndpoint {
    User val = null;
    String url ="";

    public Void initdb(){
        try {
            if (SystemProperty.environment.value() ==
                    SystemProperty.Environment.Value.Production) {
                // Connecting from App Engine.
                // Load the class that provides the "jdbc:google:mysql://"
                // prefix.
                try {
                    Class.forName("com.mysql.jdbc.GoogleDriver");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                url ="jdbc:google:mysql://big-icon-861:nextstreetdb/nextstreet?user=root";
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } // Connecting from an external network.
                url = "jdbc:mysql://173.194.243.32:3306/nextstreet";

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //REGISTER NEW USER
    @ApiMethod(name = "SetUser")
    public User setUser(@Named("Username") String name, @Named("Password") String pass,@Named("Firstname") String fname, @Named("Lastname") String lname, @Named("Email") String email) {
        initdb();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            String query =  "INSERT INTO users" + "(username, password, first_name, last_name, email," +
                            " active) " + "VALUES"+ "('demo', '"+pass+"', '"+fname+"', '"+lname+"', '"+email+"', '0')";
            System.out.println(query);

            int rs = conn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    //CHECK IF USER EXIST
    @ApiMethod(name= "GetIfUserExist")
    public User getIfUserExist(@Named("Email") String eml) throws SQLException{
        initdb();
        Connection conn = null;
        User act = new User();
        int val=2;

        conn = DriverManager.getConnection(url);
        String query = "SELECT `active` FROM `users` WHERE email='"+eml+"';";
        String query1 = "SELECT * FROM `users` WHERE email='"+eml+"';";

        ResultSet rest = conn.createStatement().executeQuery(query1);

        List<String> pdetails = new ArrayList<String>();
        while(rest.next()) {
            String tmpstr1 = rest.getString("first_name");
            String tmpstr2 = rest.getString("last_name");
            String tmpstr3 = rest.getString("email");
            String tmpstr4 = rest.getString("profile_header");
            String tmpstr5 = rest.getString("profile_pic");
            String tmpstr6 = rest.getString("reads_count");
            String tmpstr7 = rest.getString("follower_count");
            String tmpstr8 = rest.getString("following_count");

            pdetails.add(tmpstr1);
            pdetails.add(tmpstr2);
            pdetails.add(tmpstr3);
            pdetails.add(tmpstr4);
            pdetails.add(tmpstr5);
            pdetails.add(tmpstr6);
            pdetails.add(tmpstr7);
            pdetails.add(tmpstr8);
        }

        act.setPersonDetail(pdetails);

        ResultSet res = conn.createStatement().executeQuery(query);
        if(!res.next()){
         val = 0;
        }else {
            //res.next();
            val = res.getInt(1);
        }
        act.setActive(val);

        return act;
    }

    //ACCESS ALL THE USER NAME AND DESCRIPTION IN ORDER OF NUMBER OF FOLLOWER
    @ApiMethod(name = "GetUsersName")
    public User getUsersName() throws SQLException{
        initdb();
        Connection conn = null;
        conn = DriverManager.getConnection(url);

        User usr = new User();

        String query = "SELECT first_name, email FROM users ORDER BY follower_count;";
        ResultSet res = conn.createStatement().executeQuery(query);
        List<String> nmstr = new ArrayList<String>();
        List<String> emailstr = new ArrayList<String>();

        while(res.next()) {
            String tmpstr1 = res.getString("first_name");
            String tmpstr2 = res.getString("email");
            nmstr.add(tmpstr1);
            emailstr.add(tmpstr2);
        }
        usr.setNamestr(nmstr);
        usr.setEmailstr(emailstr);
        return usr;
    }

    @ApiMethod(name = "setDoFollow")
    public User setDoFollow(@Named("PeopleToFollow") String followed, @Named("FollowerUser") String follower) throws SQLException{
        initdb();
        Connection conn = null;
        conn = DriverManager.getConnection(url);
        User usr = new User();

        try {
            String query1 = "update users set follower_count = follower_count+1 where email='"+followed+"';";
            String query2 = "update users set following_count = following_count+1 where email='"+follower+"';";
            String query3 = "select user_id from users where email ='"+followed+"';";
            String query4 = "select user_id from users where email ='"+follower+"';";

            //Update following and follower count
            int rs1 = conn.createStatement().executeUpdate(query1);
            int rs2 = conn.createStatement().executeUpdate(query2);

            //Update followers table
            int followed_id = conn.createStatement().executeUpdate(query3);
            int follower_id = conn.createStatement().executeUpdate(query4);

            String query5 ="INSERT INTO followers" + "(user_id1, user_id2) " + "VALUES"+ "('following_count', 'follower_count')";
            int rs3 = conn.createStatement().executeUpdate(query5);

            //TODO NOT EXECUTING QUERY
            String sql = "INSERT INTO followers\" + \"(user_id1, user_id2) \" + \"VALUES\"+ \"(?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,followed_id);
            pstmt.setInt(2,follower_id);
            System.out.println(pstmt);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

}