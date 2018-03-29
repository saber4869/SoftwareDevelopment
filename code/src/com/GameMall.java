package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class GameMall {

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
     * @what: This mall function is used to buy items for the users if they have enough credits.
     * @param: String username : the username represents which account the user login
     * @return: void
     */
    public void mall(String username){
        //initialize jdbc
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        InputStreamReader is_reader = new InputStreamReader(System.in);
        try {
            //Register JDBC driver

            try{

                Class.forName("com.mysql.jdbc.Driver");
                //System.out.println("successfully load MySQL driver！");
            }catch(ClassNotFoundException e1){
                System.out.println("can not find MySQL driver!");
                e1.printStackTrace();
            }
            //Open a connection

            Properties props = new Properties();
            props.setProperty("characterEncoding", "utf-8");


            conn = DriverManager.getConnection(DB_URL, USER, PASS);


            stmt = conn.createStatement();
            String sql;

//            sql = "SELECT count(*) FROM recipe_copy";
            sql = "SELECT user.userCredits FROM user WHERE username = '"+username+"'";;
            ResultSet rs = stmt.executeQuery(sql);
            int user_credits = 0;
            if(rs.next()){
                user_credits = Integer.parseInt(rs.getString("userCredits"));
            }


            sql = "SELECT * FROM itemTable WHERE itemTable.itemType = 1";
            rs = stmt.executeQuery(sql);
            ArrayList<String> itemList = new ArrayList<String>();
            ArrayList<String> itemIDList = new ArrayList<String>();
            ArrayList<String> itemCreditsList = new ArrayList<String>();
            System.out.println("------Game Mall------");
            System.out.println("------*Your Balance:"+user_credits+"*------");
            System.out.println("------Equipment------");
            while (rs.next()){

                itemIDList.add(rs.getString("itemID"));
                itemList.add(rs.getString("itemName"));
                itemCreditsList.add(rs.getString("itemCost"));
                System.out.println("ID:"+rs.getString("itemID"));
                System.out.println("name:"+rs.getString("itemName"));
                System.out.println("cost:"+rs.getString("itemCost"));
                System.out.println("description:"+rs.getString("itemDescription"));
                System.out.println("_________________________");

            }
            sql = "SELECT * FROM itemTable WHERE itemTable.itemType = 2";
            rs = stmt.executeQuery(sql);


            System.out.println("------Soldier------");
            while (rs.next()){

                itemIDList.add(rs.getString("itemID"));
                itemList.add(rs.getString("itemName"));
                itemCreditsList.add(rs.getString("itemCost"));
                System.out.println("ID:"+rs.getString("itemID"));
                System.out.println("soldier type:"+rs.getString("itemName"));
                System.out.println("cost:"+rs.getString("itemCost"));
                System.out.println("description:"+rs.getString("itemDescription"));
                System.out.println("_________________________");

            }


            System.out.println("Please enter the id of the item you want to buy, if you want to go back to the main menu please enter 0:");
            String select = new BufferedReader(is_reader).readLine();
            int id = Integer.parseInt(select);
            if(id<9 && id>0){

                int count;
                user_credits = user_credits - Integer.parseInt(itemCreditsList.get(id-1));
                if(user_credits >= 0) {
                    sql = "INSERT INTO userCollection (userName, itemName,itemID) VALUES ('"+username+"','"+itemList.get(id-1)+"','"+itemIDList.get(id-1)+"')";
                    count = stmt.executeUpdate(sql);
                    sql = "UPDATE user SET userCredits=" + user_credits + " WHERE userName='" + username + "'";
                    count = stmt.executeUpdate(sql);
                    System.out.println("Succeed to buy the item, and the remain credit is: "+user_credits);
                }else{
                    System.out.println("You cannot pay for it because of the lack of credits, and it will return to the main page");
                }

            }else if(id == 0){
                System.out.println("Returning to the main menu");
            }else{
                System.out.println("Illegal input, the program will return to the main menu");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }//end finally try
    }
}
