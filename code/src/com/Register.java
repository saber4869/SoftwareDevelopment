package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Register {

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
     * @what: This reg function is used to register a new account.After checking the unique username, it will insert a new user into the databse
     * @return: boolean
     */
    public boolean reg(){
        //initialize jdbc
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        ArrayList<String> nameList = new ArrayList<String>();
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

            InputStreamReader is_reader = new InputStreamReader(System.in);
            //System.out.println("Please input the new user name:");
            String username = null;
            //new BufferedReader(is_reader).readLine();

            while (rs.next()){

                nameList.add(rs.getString("userName"));

            }
            boolean isRegistered = true;

            int i = 0;
            while(isRegistered){
                System.out.println("Please input the new user name:");
                username = new BufferedReader(is_reader).readLine();
                for(String tmp_user : nameList) {
                    if (tmp_user.equals(username)) {
                        //System.out.println(tmp_user);
                        isRegistered = true;
                        break;
                    }else{
                        //System.out.println(tmp_user+" "+username);
                        isRegistered = false;

                    }
                }
                if(isRegistered == true) {
                    System.out.println("User name has been registered, please input a new username!");
                }

            }
            System.out.println("Please input the password:");
            String password = new BufferedReader(is_reader).readLine();


            sql = "INSERT INTO user (userName, password) VALUES ('"+username+"','"+password+"')";
            int count = stmt.executeUpdate(sql);
            System.out.println("success insert a new user");

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

        return false;
    }
}
