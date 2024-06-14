DROP DATABASE IF EXISTS polynames_database;

CREATE DATABASE polynames_database;

USE polynames_database;

CREATE TABLE partie(
   score INT,
   est_complete BOOLEAN,
   est_initialisee BOOLEAN,
   code_partie CHAR(10),
   PRIMARY KEY(code_partie)
);

CREATE TABLE Mot(
   id_mot INT AUTO_INCREMENT,
   mot VARCHAR(50),
   PRIMARY KEY(id_mot)
);

CREATE TABLE Indice(
   id_indice INT AUTO_INCREMENT,
   indice VARCHAR(50),
   nb_carte_associe INT,
   nb_carte_trouve INT,
   code_partie CHAR(10),
   numero_tour_associe INT,
   PRIMARY KEY(id_indice),
   FOREIGN KEY(code_partie) REFERENCES partie(code_partie)
);

CREATE TABLE Joueur(
   jeton CHAR(30),
   est_hote BOOLEAN,
   role INT,
   code_partie CHAR(10),
   PRIMARY KEY(jeton),
   FOREIGN KEY(code_partie) REFERENCES partie(code_partie)
);

CREATE TABLE Carte(
   face_cachee BOOLEAN DEFAULT TRUE,
   couleur INT,
   id_mot INT,
   code_partie CHAR(10),
   PRIMARY KEY(id_mot, code_partie),
   FOREIGN KEY(id_mot) REFERENCES Mot(id_mot),
   FOREIGN KEY(code_partie) REFERENCES partie(code_partie)
);