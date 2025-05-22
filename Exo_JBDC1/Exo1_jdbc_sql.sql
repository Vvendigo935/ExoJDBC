CREATE DATABASE IF NOT EXISTS exo_jdbc1;

USE exo_jdbc1;

CREATE TABLE IF NOT EXISTS etudiants(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
nom VARCHAR(150),
prenom VARCHAR(150),
numClasse INT,
dateDiplome VARCHAR(8));

SELECT * FROM etudiants; -- afficher et vérifier la table

DROP TABLE etudiants; -- en cas de pépin pour recommencer