package org.example.utils;

import java.sql.*;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        // test de connexion

        try {
            Connection connection = ConnectionUtils.getSQLConnection();
            if (connection != null){
                System.out.println("ça fonctionne");
            }else {
                System.out.println("il faut vérifier la classe connectionUtils peut etre !");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        // fin de test connexion


        // demo de base
        // enregistrer une saisie utilisateur en BDD
//        Scanner scanner = new Scanner(System.in);
//        Connection connection = null;
//        try {
//            connection = ConnectionUtils.getSQLConnection();
//            System.out.println("on viens de se connecter a la BDD");
//
//            System.out.println("Merci de saisir le prenom : ");
//            String first_name = scanner.nextLine();
//
//            System.out.println("Merci de saisir le nom : ");
//            String last_name = scanner.nextLine();
            // une requete pour l'insertion des données
//            String request = "INSERT INTO users (first_name, last_name) VALUES ('" + first_name + "','" + last_name +"')";
//            System.out.println("Voici la requete que je vais faire : " + request);


            // façon 1 => execution d'une requete sans retour
            // Attention Danger injection SQL avec ce systeme (variable dans la chaine de caractere)
//            Statement statement = connection.createStatement();
//            statement.execute(request);
//            System.out.println("requete executée");

            // façon 2 => avec une requete preparee

//            String request = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(request);
//            preparedStatement.setString(1, first_name);
//            preparedStatement.setString(2, last_name);
//      //      preparedStatement.execute();  // retour boolean
//            int nbrRows = preparedStatement.executeUpdate(); // retour int qui correspond au nombres de lignes qui ont été affectée
//            System.out.println("Nombre de ligne affectées : "+nbrRows );

            // version avec recuperation de l'id auto generer
//            String request = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1, first_name);
//            preparedStatement.setString(2, last_name);
//            int nbrRows = preparedStatement.executeUpdate();
//            System.out.println("Nombre de ligne affectées : "+nbrRows );
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()){
//                System.out.println(resultSet.getInt(1));
//            }
//
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.out.println(e.getStackTrace());
//                }
//            }
//        }






    }
}
