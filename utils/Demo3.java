package org.example.utils;

import java.sql.*;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {

        // la recuperation
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
//        String request = "SELECT * FROM users";
//
        try{
            connection = ConnectionUtils.getSQLConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(request);
//            while (resultSet.next()){
//                System.out.println("La colonne users_id : "+resultSet.getInt("users_id"));
//                System.out.println("La colonne first_name : "+resultSet.getString("first_name"));
//                System.out.println("La colonne last_name : "+resultSet.getString("last_name"));
//            }

        String request2 = "SELECT * FROM users WHERE users_id = ?";
        PreparedStatement statement = connection.prepareStatement(request2);
        statement.setInt(1, 3);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            System.out.println("la personne avec l'ID numero 3 : ");
            System.out.println("Son prenom "+resultSet.getString("first_name"));
            System.out.println("Son nom "+resultSet.getString("last_name"));
        }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }









    }
}
