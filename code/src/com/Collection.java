package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Collection {
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
     * @what: This show function is used to show different types of the user personal collections.
     * @param: String username : the username represents which account the user login
     * @return: void
     */
    public void show(String username){
        //initialize jdbc
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;

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

            sql = "SELECT * FROM userCollection WHERE userName='"+username+"'";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<String> equipmentList = new ArrayList<String>();
            ArrayList<String> soldierList = new ArrayList<String>();
            while (rs.next()){

                String tmp_collectionID = rs.getString("itemID");


                if(Integer.parseInt(tmp_collectionID)<5){
                    //System.out.println("item1");
                    equipmentList.add(rs.getString("itemName"));
                }else{
                    //System.out.println("soldier1");
                    soldierList.add(rs.getString("itemName"));
                }
            }
            System.out.println("------Collection------");
            System.out.println("------Equipment------");
            for(String str : equipmentList){
                System.out.println("||"+str+"||");
            }
            System.out.println("----------------------");
            System.out.println("------ Soldier ------");

            for(String str : soldierList){
                System.out.println("||"+str+"||");
            }

            System.out.println("----------------------");
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


    }

}
