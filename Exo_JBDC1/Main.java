package org.example.Exo_JBDC1;

import org.example.utils.ConnectionUtils;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = ConnectionUtils.getSQLConnection();
            System.out.println("on viens de se connecter a la BDD");

            System.out.println("Merci de saisir le prenom : ");
            String nom = scanner.nextLine();

            System.out.println("Merci de saisir le nom : ");
            String prenom = scanner.nextLine();

            System.out.println("Merci de saisir le numero de la classe : ");
            int numClasse = scanner.nextInt();
            scanner.nextLine(); // pour ecraser le "entrée" de trop
            System.out.println("Merci de saisir la date d'obtention du diplome : ");
            String dateDiplome = scanner.nextLine();

            String request = "INSERT INTO etudiants (nom, prenom, numClasse, dateDiplome) VALUES ('" + nom + "','" + prenom +"','" + numClasse +"','" + dateDiplome +"')";


            Statement statement = connection.createStatement();
            statement.execute(request);
            System.out.println("requete executée");


            // tentative de petit bonus avec un switch case

            System.out.println("Veuillez faire votre choix");
            System.out.println("""
                    /1 pour afficher tout les eleves 
                    /2 pour afficher les eleves d'une classe en particulier
                    /3 pour supprimer un eleve dans la BDD
                    """);
            byte choix = scanner.nextByte();
            switch (choix){
                case 1:
                    String rq1 = "SELECT * FROM etudiants";
                    statement.execute(rq1);
                    statement = connection.prepareStatement(rq1);
                    ResultSet resultSet = statement.executeQuery(rq1);
                    while (resultSet.next()){
                        System.out.println("liste des etudiants : ");
                        System.out.println("Son prenom "+resultSet.getString("prenom"));
                        System.out.println("Son nom "+resultSet.getString("nom"));
                        System.out.println("Numero de classe : "+resultSet.getInt("numClasse"));
                    }
                    break;
                case 2:
                    System.out.println("Quelle classe souhaitez vous afficher ? ");
                    byte cls = scanner.nextByte();
                    String rq2 = "SELECT * FROM etudiants WHERE numClasse = "+cls;
                    statement.execute(rq2);
                    statement = connection.prepareStatement(rq2);
                    ResultSet resultSet2 = statement.executeQuery(rq2);
                    while (resultSet2.next()){
                        System.out.println("liste des etudiants de la classe choisis : ");
                        System.out.println("Son prenom "+resultSet2.getString("prenom"));
                        System.out.println("Son nom "+resultSet2.getString("nom"));
                        System.out.println("Numero de classe : "+resultSet2.getInt("numClasse"));
                    }
                    break;
                case 3:
                    System.out.println("Quel etudiant souhaitez vous supprimer de la liste ? ");
                    byte iDelete = scanner.nextByte();
                    String rq3 = "DELETE FROM etudiants WHERE id = ?";
                    PreparedStatement statement2 = connection.prepareStatement(rq3);
                    statement2.setInt(1, iDelete);
                    statement2 = connection.prepareStatement(rq3);
                    statement2.execute(rq3);
                    System.out.println("L'etudiant a l'identifiant : "+iDelete+" a bien été supprimé");
                    break;
                default:
                    System.out.println("Choix ne correspond a aucun cas defini !!!");
                    break;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getStackTrace());
                }
            }
        }
        }
    }
