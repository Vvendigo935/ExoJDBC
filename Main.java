package org.example;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1 nouveau projet
        // file => new => projet => Build system : maven

        // 2 ajout de depencies maven :
        // ne pas oublier de rajouter la balise <dependencies>
        // dans le fichier pom.xml a la racine de votre projet

        // 3 ajouter le connecteur correspondant a la BDD
        // https://mvnrepository.com/
        // une fois la dependance rajouter entre les balises dependencies
        // je recharge le projet maven

        // je peux verifier la presence de la nouvelle librairie
        // en regardant les external librairies presentes sur inteliJi

        // Preparation pour se connecter a ma BDD
        String url = "jdbc:mysql://localhost:3306/exo_jdbc1";
        String username = "root";
        String password = "test";



        // test de connexion
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null){
                System.out.println("La connexion est OK !!!");
            }else {
                System.out.println("Connexion echoué");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        // meilleur pratique mettre la connexion dans une classe a part
        // voir connectionUtils et demo2



    }
}