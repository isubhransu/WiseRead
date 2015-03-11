package com.nextstreet.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.utils.SystemProperty;
import com.google.appengine.api.rdbms.AppEngineDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.inject.Named;

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


/**
 * An endpoint class we are exposing
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

            int rs = conn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    //CHECK IF USER EXIST
    @ApiMethod(name= "GetIfUserExist")
    public User getIfUserExist(@Named("Email") String eml, @Named("Password") String pass) throws SQLException{
        initdb();
        Connection conn = null;
        User act = new User();
        int val=2;

        conn = DriverManager.getConnection(url);
        String query = "SELECT `active` FROM `users` WHERE email='"+eml+"' AND password='"+pass+"'";
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
}