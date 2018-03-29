package com;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/SoftwareDevelopment?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    private static String username;
    /**
     *
     *
     *
     * @Package: com
     * @throws: Exception
     * @what: This main function is the control system of the program, it will read what user inputs and give different reactions
     *        It first read user input about the login page. After user login successfully, it will read the input about the operation about
     *        whether entering the game mall or viewing the collections
     * @return: void
     */
    public static void main(String[] args) {
        boolean link = true;
        InputStreamReader is_reader = new InputStreamReader(System.in);
        try{
            while(link) {
                //InputStreamReader is_reader = new InputStreamReader(System.in);
                System.out.println("Login Page");
                System.out.println("1.Login");
                System.out.println("2.Register");
                System.out.println("3.Exit ");


                String select = new BufferedReader(is_reader).readLine();
                switch (select) {
                    case "1": {
                        Login login = new Login();
                        System.out.println("Please input the Username:");
                        username = new BufferedReader(is_reader).readLine();
                        System.out.println("Please input the Password:");
                        String password = new BufferedReader(is_reader).readLine();
                        link = login.log(username, password);
                        //login.log("user1","abc");

                        break;
                    }
                    case "2": {
                        Register reg = new Register();
                        reg.reg();
                        link = false;
                        break;
                    }
                    case "3": {
                        link = false;
                        System.out.println("The game will exit.");
                        System.exit(1);
                        break;

                    }
                    default: {
                        link=false;
                        System.out.println("Illegal input, the game will exit.");
                        System.exit(1);
                        break;
                    }

                }
            }
        }catch(Exception e){
                //Handle errors for Class.forName
                e.printStackTrace();
            }




        try {
        boolean run = true;

        while(run) {
            //InputStreamReader is_reader = new InputStreamReader(System.in);
            System.out.println("----------------------");
            System.out.println("Welcome to the Game:");
            System.out.println("1.Enter the Game Mall");
            System.out.println("2.Show Personal Collection");
            System.out.println("3.Exit ");
            System.out.println("Please enter your selection:");
            String select = new BufferedReader(is_reader).readLine();

            switch(select){
                case "1":{
                    GameMall mall = new GameMall();
                    mall.mall(username);
                    break;
                }
                case "2":{
                    Collection col = new Collection();
                    col.show(username);
                    run = true;
                    break;
                }
                case "3":{
                    run = false;
                    break;

                }
                default:{
                    Collection col = new Collection();
                    col.show(username);
                    run = true;
                    break;
                }
            }


        }
            System.out.println("----------------------");
            System.out.println("Exiting the game, welcome to see you next time! ");
            System.exit(1);
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
