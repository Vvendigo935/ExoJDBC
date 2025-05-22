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

SELECT * FROM etudiants WHERE numClasse = 4; -- afficher uniquement les etudiants de la classe 4

DELETE FROM etudiants WHERE id = 2; -- suppression de l'eleve a l'id 2

SELECT * FROM etudiants;