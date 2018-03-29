package com;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
public class Login {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/SoftwareDevelopment?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    //  Database credentials
    static final String USER = "root";

    static final String PASS = "123456";

    /**
     *
     *
     *
     * @Package: com
     * @throws: Exception,SQLException,ClassNotFoundException
     * @what: This log function is used to log into the main page of the project
     * @param: String username : the username represents which account the user login
     * @param: String password : the password is used to identify the user information
     * @return: boolean
     */
    public boolean log(String username, String password){
        //initialize jdbc
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;

        //System.out.println(username+" "+password);
        try {
            //Register JDBC driver

            try{

                Class.forName("com.mysql.jdbc.Driver");

            }catch(ClassNotFoundException e1){
                System.out.println("can not find MySQL driver!");
                e1.printStackTrace();
            }
            //Open a connection

            Properties props = new Properties();
            props.setProperty("characterEncoding", "utf-8");

            //System.out.println("Connecting to the database, please wait for a second");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){

                String tmp_user = rs.getString("userName");
                String tmp_pw = rs.getString("password");
                //System.out.println(tmp_user+" "+tmp_pw);
                if((tmp_user.equals(username)) && (tmp_pw.equals(password))){
                    System.out.println("Login Successfully!");
                    return false;
                }else{


                }
            }


            rs.close();
            stmt.close();
            conn.close();

        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Username or password wrong, please login again or register a new account!");
        return true;
    }
}
