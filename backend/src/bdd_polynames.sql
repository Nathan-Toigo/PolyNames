DROP DATABASE IF EXISTS polynames_db;
CREATE DATABASE polynames_db;
USE polynames_db;

CREATE TABLE Dictionnaire(
   id_dictionnaire INT AUTO_INCREMENT,
   titre VARCHAR(50),
   PRIMARY KEY(id_dictionnaire)
);

CREATE TABLE Couleur(
   id_couleur INT AUTO_INCREMENT,
   couleur VARCHAR(50),
   PRIMARY KEY(id_couleur)
);

CREATE TABLE Mot(
   id_mot INT AUTO_INCREMENT,
   mot VARCHAR(50),
   PRIMARY KEY(id_mot)
);

CREATE TABLE Joueur(
   jeton CHAR(10),
   pseudonyme VARCHAR(50) UNIQUE,
   PRIMARY KEY(jeton)
);

CREATE TABLE Etat(
   id_etat INT AUTO_INCREMENT,
   etat VARCHAR(50),
   PRIMARY KEY(id_etat)
);

CREATE TABLE Grille(
   id_grille INT,
   hauteur_grille INT NOT NULL,
   largeur_grille INT NOT NULL,
   score TINYINT,
   tour TINYINT,
   id_etat INT NOT NULL,
   PRIMARY KEY(id_grille),
   FOREIGN KEY(id_etat) REFERENCES Etat(id_etat)
);

CREATE TABLE Carte(
   face_cachee BOOLEAN,
   ligne TINYINT,
   colonne TINYINT,
   id_mot INT NOT NULL,
   id_couleur INT NOT NULL,
   id_grille INT NOT NULL,
   PRIMARY KEY(id_grille, id_mot),
   FOREIGN KEY(id_mot) REFERENCES Mot(id_mot),
   FOREIGN KEY(id_couleur) REFERENCES Couleur(id_couleur),
   FOREIGN KEY(id_grille) REFERENCES Grille(id_grille)
);

CREATE TABLE Indice(
   id_indice INT AUTO_INCREMENT,
   indice VARCHAR(50),
   N TINYINT,
   id_grille INT NOT NULL,
   PRIMARY KEY(id_indice),
   FOREIGN KEY(id_grille) REFERENCES Grille(id_grille)
);

CREATE TABLE Mot_Dictionnaire(
   id_dictionnaire INT,
   id_mot INT,
   PRIMARY KEY(id_dictionnaire, id_mot),
   FOREIGN KEY(id_dictionnaire) REFERENCES Dictionnaire(id_dictionnaire),
   FOREIGN KEY(id_mot) REFERENCES Mot(id_mot)
);

CREATE TABLE Role(
   id_role INT AUTO_INCREMENT,
   role VARCHAR(50),
   PRIMARY KEY(id_role)
);

CREATE TABLE Partie(
   id_partie INT AUTO_INCREMENT,
   code CHAR(10) UNIQUE,
   PRIMARY KEY(id_partie)
);

CREATE TABLE Grille_Joueur(
   id_grille INT,
   id_joueur INT,
   id_role INT,
   id_partie INT,
   PRIMARY KEY(id_grille, id_joueur, id_role, id_partie),
   FOREIGN KEY(id_grille) REFERENCES Grille(id_grille),
   FOREIGN KEY(id_joueur) REFERENCES Joueur(id_joueur),
   FOREIGN KEY(id_role) REFERENCES Role(id_role),
   FOREIGN KEY(id_partie) REFERENCES Partie(id_partie)
);


CREATE TABLE Session(
   id_session INT AUTO_INCREMENT,
   creation DATETIME,
   jeton CHAR(15) UNIQUE,
   id_joueur INT,
   PRIMARY KEY(id_session),
   FOREIGN KEY(id_joueur) REFERENCES Joueur(id_joueur)
);

INSERT INTO Dictionnaire(titre) VALUES('principal');
INSERT INTO Mot(mot) VALUES("Pomme");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,1);
INSERT INTO Mot(mot) VALUES("Chat");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,2);
INSERT INTO Mot(mot) VALUES("Maison");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,3);
INSERT INTO Mot(mot) VALUES("Horloge");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,4);
INSERT INTO Mot(mot) VALUES("Soleil");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,5);
INSERT INTO Mot(mot) VALUES("Voiture");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,6);
INSERT INTO Mot(mot) VALUES("Jardin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,7);
INSERT INTO Mot(mot) VALUES("Arbre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,8);
INSERT INTO Mot(mot) VALUES("Livre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,9);
INSERT INTO Mot(mot) VALUES("Chien");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,10);
INSERT INTO Mot(mot) VALUES("Plage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,11);
INSERT INTO Mot(mot) VALUES("Gâteau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,12);
INSERT INTO Mot(mot) VALUES("Table");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,13);
INSERT INTO Mot(mot) VALUES("Lunettes");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,14);
INSERT INTO Mot(mot) VALUES("Rire");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,15);
INSERT INTO Mot(mot) VALUES("Téléphone");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,16);
INSERT INTO Mot(mot) VALUES("Chemin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,17);
INSERT INTO Mot(mot) VALUES("Fleurs");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,18);
INSERT INTO Mot(mot) VALUES("Bateau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,19);
INSERT INTO Mot(mot) VALUES("Musique");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,20);
INSERT INTO Mot(mot) VALUES("Lecture");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,21);
INSERT INTO Mot(mot) VALUES("Ordinateur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,22);
INSERT INTO Mot(mot) VALUES("Pizza");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,23);
INSERT INTO Mot(mot) VALUES("Crayon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,24);
INSERT INTO Mot(mot) VALUES("Étoile");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,25);
INSERT INTO Mot(mot) VALUES("Ballon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,26);
INSERT INTO Mot(mot) VALUES("Sac");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,27);
INSERT INTO Mot(mot) VALUES("École");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,28);
INSERT INTO Mot(mot) VALUES("Avion");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,29);
INSERT INTO Mot(mot) VALUES("Ciseaux");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,30);
INSERT INTO Mot(mot) VALUES("Montagne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,31);
INSERT INTO Mot(mot) VALUES("Caméra");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,32);
INSERT INTO Mot(mot) VALUES("Feu");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,33);
INSERT INTO Mot(mot) VALUES("Pont");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,34);
INSERT INTO Mot(mot) VALUES("Vélo");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,35);
INSERT INTO Mot(mot) VALUES("Lapin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,36);
INSERT INTO Mot(mot) VALUES("Bouteille");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,37);
INSERT INTO Mot(mot) VALUES("Train");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,38);
INSERT INTO Mot(mot) VALUES("Oiseau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,39);
INSERT INTO Mot(mot) VALUES("Porte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,40);
INSERT INTO Mot(mot) VALUES("Chapeau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,41);
INSERT INTO Mot(mot) VALUES("Papillon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,42);
INSERT INTO Mot(mot) VALUES("Pain");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,43);
INSERT INTO Mot(mot) VALUES("Canard");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,44);
INSERT INTO Mot(mot) VALUES("Tennis");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,45);
INSERT INTO Mot(mot) VALUES("Guitare");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,46);
INSERT INTO Mot(mot) VALUES("Orange");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,47);
INSERT INTO Mot(mot) VALUES("Lac");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,48);
INSERT INTO Mot(mot) VALUES("Fraise");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,49);
INSERT INTO Mot(mot) VALUES("Carte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,50);
INSERT INTO Mot(mot) VALUES("Lion");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,51);
INSERT INTO Mot(mot) VALUES("Parapluie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,52);
INSERT INTO Mot(mot) VALUES("Lune");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,53);
INSERT INTO Mot(mot) VALUES("Miroir");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,54);
INSERT INTO Mot(mot) VALUES("Serpent");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,55);
INSERT INTO Mot(mot) VALUES("Café");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,56);
INSERT INTO Mot(mot) VALUES("Chaussettes");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,57);
INSERT INTO Mot(mot) VALUES("Couronne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,58);
INSERT INTO Mot(mot) VALUES("Chocolat");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,59);
INSERT INTO Mot(mot) VALUES("Champignon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,60);
INSERT INTO Mot(mot) VALUES("Sirène");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,61);
INSERT INTO Mot(mot) VALUES("Nuage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,62);
INSERT INTO Mot(mot) VALUES("Course");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,63);
INSERT INTO Mot(mot) VALUES("Clé");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,64);
INSERT INTO Mot(mot) VALUES("Papier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,65);
INSERT INTO Mot(mot) VALUES("Danse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,66);
INSERT INTO Mot(mot) VALUES("Piano");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,67);
INSERT INTO Mot(mot) VALUES("Pluie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,68);
INSERT INTO Mot(mot) VALUES("Filet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,69);
INSERT INTO Mot(mot) VALUES("Hiver");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,70);
INSERT INTO Mot(mot) VALUES("Piscine");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,71);
INSERT INTO Mot(mot) VALUES("Trésor");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,72);
INSERT INTO Mot(mot) VALUES("Joueur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,73);
INSERT INTO Mot(mot) VALUES("Robot");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,74);
INSERT INTO Mot(mot) VALUES("Cadeau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,75);
INSERT INTO Mot(mot) VALUES("Météo");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,76);
INSERT INTO Mot(mot) VALUES("Volant");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,77);
INSERT INTO Mot(mot) VALUES("Fumée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,78);
INSERT INTO Mot(mot) VALUES("Marteau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,79);
INSERT INTO Mot(mot) VALUES("Épée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,80);
INSERT INTO Mot(mot) VALUES("Perroquet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,81);
INSERT INTO Mot(mot) VALUES("Portefeuille");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,82);
INSERT INTO Mot(mot) VALUES("Hélicoptère");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,83);
INSERT INTO Mot(mot) VALUES("Neige");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,84);
INSERT INTO Mot(mot) VALUES("Vin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,85);
INSERT INTO Mot(mot) VALUES("Aventure");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,86);
INSERT INTO Mot(mot) VALUES("Nez");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,87);
INSERT INTO Mot(mot) VALUES("Plante");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,88);
INSERT INTO Mot(mot) VALUES("Microphone");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,89);
INSERT INTO Mot(mot) VALUES("Coccinelle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,90);
INSERT INTO Mot(mot) VALUES("Chasse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,91);
INSERT INTO Mot(mot) VALUES("Montre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,92);
INSERT INTO Mot(mot) VALUES("Plume");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,93);
INSERT INTO Mot(mot) VALUES("C?ur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,94);
INSERT INTO Mot(mot) VALUES("Drapeau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,95);
INSERT INTO Mot(mot) VALUES("Parc");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,96);
INSERT INTO Mot(mot) VALUES("Tambour");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,97);
INSERT INTO Mot(mot) VALUES("Balle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,98);
INSERT INTO Mot(mot) VALUES("Globe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,99);
INSERT INTO Mot(mot) VALUES("Chanson");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,100);
INSERT INTO Mot(mot) VALUES("Doigt");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,101);
INSERT INTO Mot(mot) VALUES("Arc-en-ciel");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,102);
INSERT INTO Mot(mot) VALUES("Boisson");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,103);
INSERT INTO Mot(mot) VALUES("Souris");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,104);
INSERT INTO Mot(mot) VALUES("Carton");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,105);
INSERT INTO Mot(mot) VALUES("Saut");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,106);
INSERT INTO Mot(mot) VALUES("Sorcière");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,107);
INSERT INTO Mot(mot) VALUES("Radio");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,108);
INSERT INTO Mot(mot) VALUES("Étoile filante");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,109);
INSERT INTO Mot(mot) VALUES("Aile");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,110);
INSERT INTO Mot(mot) VALUES("Thé");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,111);
INSERT INTO Mot(mot) VALUES("Tableau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,112);
INSERT INTO Mot(mot) VALUES("Grenouille");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,113);
INSERT INTO Mot(mot) VALUES("Mur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,114);
INSERT INTO Mot(mot) VALUES("Lutin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,115);
INSERT INTO Mot(mot) VALUES("Avocat");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,116);
INSERT INTO Mot(mot) VALUES("Roche");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,117);
INSERT INTO Mot(mot) VALUES("Stylo");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,118);
INSERT INTO Mot(mot) VALUES("Écouteurs");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,119);
INSERT INTO Mot(mot) VALUES("Labyrinthe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,120);
INSERT INTO Mot(mot) VALUES("Araignée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,121);
INSERT INTO Mot(mot) VALUES("Chaudron");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,122);
INSERT INTO Mot(mot) VALUES("Champ");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,123);
INSERT INTO Mot(mot) VALUES("Hérisson");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,124);
INSERT INTO Mot(mot) VALUES("Couteau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,125);
INSERT INTO Mot(mot) VALUES("Sombrero");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,126);
INSERT INTO Mot(mot) VALUES("Trampoline");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,127);
INSERT INTO Mot(mot) VALUES("Pingouin");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,128);
INSERT INTO Mot(mot) VALUES("Microscope");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,129);
INSERT INTO Mot(mot) VALUES("Tunnel");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,130);
INSERT INTO Mot(mot) VALUES("Peinture");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,131);
INSERT INTO Mot(mot) VALUES("Sifflet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,132);
INSERT INTO Mot(mot) VALUES("Football");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,133);
INSERT INTO Mot(mot) VALUES("Cheval");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,134);
INSERT INTO Mot(mot) VALUES("Montgolfière");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,135);
INSERT INTO Mot(mot) VALUES("Éponge");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,136);
INSERT INTO Mot(mot) VALUES("Télécommande");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,137);
INSERT INTO Mot(mot) VALUES("Astronaute");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,138);
INSERT INTO Mot(mot) VALUES("Diamant");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,139);
INSERT INTO Mot(mot) VALUES("Ampoule");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,140);
INSERT INTO Mot(mot) VALUES("Bibliothèque");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,141);
INSERT INTO Mot(mot) VALUES("Toupie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,142);
INSERT INTO Mot(mot) VALUES("Super-héros");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,143);
INSERT INTO Mot(mot) VALUES("Désert");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,144);
INSERT INTO Mot(mot) VALUES("Costume");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,145);
INSERT INTO Mot(mot) VALUES("Croissant");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,146);
INSERT INTO Mot(mot) VALUES("Clavier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,147);
INSERT INTO Mot(mot) VALUES("Cerf");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,148);
INSERT INTO Mot(mot) VALUES("Crème");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,149);
INSERT INTO Mot(mot) VALUES("Tapis");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,150);
INSERT INTO Mot(mot) VALUES("Glace");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,151);
INSERT INTO Mot(mot) VALUES("Plongée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,152);
INSERT INTO Mot(mot) VALUES("Donut");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,153);
INSERT INTO Mot(mot) VALUES("Échelle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,154);
INSERT INTO Mot(mot) VALUES("Autruche");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,155);
INSERT INTO Mot(mot) VALUES("Bricolage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,156);
INSERT INTO Mot(mot) VALUES("Princesse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,157);
INSERT INTO Mot(mot) VALUES("Hula-hoop");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,158);
INSERT INTO Mot(mot) VALUES("Escargot");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,159);
INSERT INTO Mot(mot) VALUES("Casquette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,160);
INSERT INTO Mot(mot) VALUES("Boussole");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,161);
INSERT INTO Mot(mot) VALUES("Tornade");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,162);
INSERT INTO Mot(mot) VALUES("Bélier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,163);
INSERT INTO Mot(mot) VALUES("Trône");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,164);
INSERT INTO Mot(mot) VALUES("Crochet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,165);
INSERT INTO Mot(mot) VALUES("Hôtel");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,166);
INSERT INTO Mot(mot) VALUES("Escalade");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,167);
INSERT INTO Mot(mot) VALUES("Cactus");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,168);
INSERT INTO Mot(mot) VALUES("Écureuil");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,169);
INSERT INTO Mot(mot) VALUES("Ski");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,170);
INSERT INTO Mot(mot) VALUES("Papaye");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,171);
INSERT INTO Mot(mot) VALUES("Pique-nique");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,172);
INSERT INTO Mot(mot) VALUES("Aéroport");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,173);
INSERT INTO Mot(mot) VALUES("Peigne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,174);
INSERT INTO Mot(mot) VALUES("Aviron");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,175);
INSERT INTO Mot(mot) VALUES("Galette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,176);
INSERT INTO Mot(mot) VALUES("Poisson");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,177);
INSERT INTO Mot(mot) VALUES("Parachutiste");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,178);
INSERT INTO Mot(mot) VALUES("Tatouage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,179);
INSERT INTO Mot(mot) VALUES("Foyer");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,180);
INSERT INTO Mot(mot) VALUES("Gland");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,181);
INSERT INTO Mot(mot) VALUES("Plongeon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,182);
INSERT INTO Mot(mot) VALUES("Glaçon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,183);
INSERT INTO Mot(mot) VALUES("Échasse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,184);
INSERT INTO Mot(mot) VALUES("Feux d'artifice");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,185);
INSERT INTO Mot(mot) VALUES("Corne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,186);
INSERT INTO Mot(mot) VALUES("Maracas");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,187);
INSERT INTO Mot(mot) VALUES("Colisée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,188);
INSERT INTO Mot(mot) VALUES("Mer");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,189);
INSERT INTO Mot(mot) VALUES("Réveil");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,190);
INSERT INTO Mot(mot) VALUES("Vase");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,191);
INSERT INTO Mot(mot) VALUES("Guirlande");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,192);
INSERT INTO Mot(mot) VALUES("Atome");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,193);
INSERT INTO Mot(mot) VALUES("Roue");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,194);
INSERT INTO Mot(mot) VALUES("Feu de camp");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,195);
INSERT INTO Mot(mot) VALUES("Serrure");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,196);
INSERT INTO Mot(mot) VALUES("Dinde");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,197);
INSERT INTO Mot(mot) VALUES("Guimauve");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,198);
INSERT INTO Mot(mot) VALUES("Échiquier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,199);
INSERT INTO Mot(mot) VALUES("Alpaga");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,200);
INSERT INTO Mot(mot) VALUES("Barque");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,201);
INSERT INTO Mot(mot) VALUES("Jumelles");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,202);
INSERT INTO Mot(mot) VALUES("Colibri");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,203);
INSERT INTO Mot(mot) VALUES("Caisse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,204);
INSERT INTO Mot(mot) VALUES("Phare");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,205);
INSERT INTO Mot(mot) VALUES("Prise");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,206);
INSERT INTO Mot(mot) VALUES("Saturne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,207);
INSERT INTO Mot(mot) VALUES("Casque");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,208);
INSERT INTO Mot(mot) VALUES("Fée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,209);
INSERT INTO Mot(mot) VALUES("Javelot");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,210);
INSERT INTO Mot(mot) VALUES("Échafaudage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,211);
INSERT INTO Mot(mot) VALUES("Barbe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,212);
INSERT INTO Mot(mot) VALUES("Archipel");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,213);
INSERT INTO Mot(mot) VALUES("Vague");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,214);
INSERT INTO Mot(mot) VALUES("Cigogne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,215);
INSERT INTO Mot(mot) VALUES("Lanterne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,216);
INSERT INTO Mot(mot) VALUES("Éventail");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,217);
INSERT INTO Mot(mot) VALUES("Flamme");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,218);
INSERT INTO Mot(mot) VALUES("Lait");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,219);
INSERT INTO Mot(mot) VALUES("Arcade");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,220);
INSERT INTO Mot(mot) VALUES("Haricot");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,221);
INSERT INTO Mot(mot) VALUES("Rhinocéros");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,222);
INSERT INTO Mot(mot) VALUES("Banquise");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,223);
INSERT INTO Mot(mot) VALUES("Magicien");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,224);
INSERT INTO Mot(mot) VALUES("Colline");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,225);
INSERT INTO Mot(mot) VALUES("Griffe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,226);
INSERT INTO Mot(mot) VALUES("Tortue");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,227);
INSERT INTO Mot(mot) VALUES("Usine");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,228);
INSERT INTO Mot(mot) VALUES("Rosée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,229);
INSERT INTO Mot(mot) VALUES("Placard");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,230);
INSERT INTO Mot(mot) VALUES("Dictionnaire");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,231);
INSERT INTO Mot(mot) VALUES("Ver");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,232);
INSERT INTO Mot(mot) VALUES("Chouette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,233);
INSERT INTO Mot(mot) VALUES("Chapelet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,234);
INSERT INTO Mot(mot) VALUES("Cafard");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,235);
INSERT INTO Mot(mot) VALUES("Aquarium");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,236);
INSERT INTO Mot(mot) VALUES("Radar");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,237);
INSERT INTO Mot(mot) VALUES("Oreiller");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,238);
INSERT INTO Mot(mot) VALUES("Dragon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,239);
INSERT INTO Mot(mot) VALUES("Bulle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,240);
INSERT INTO Mot(mot) VALUES("Légume");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,241);
INSERT INTO Mot(mot) VALUES("Parasol");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,242);
INSERT INTO Mot(mot) VALUES("Palmier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,243);
INSERT INTO Mot(mot) VALUES("Alouette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,244);
INSERT INTO Mot(mot) VALUES("Enveloppe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,245);
INSERT INTO Mot(mot) VALUES("Tomate");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,246);
INSERT INTO Mot(mot) VALUES("Forêt");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,247);
INSERT INTO Mot(mot) VALUES("Tuba");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,248);
INSERT INTO Mot(mot) VALUES("Saumon");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,249);
INSERT INTO Mot(mot) VALUES("Noyau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,250);
INSERT INTO Mot(mot) VALUES("Satellite");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,251);
INSERT INTO Mot(mot) VALUES("Récolte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,252);
INSERT INTO Mot(mot) VALUES("Cycliste");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,253);
INSERT INTO Mot(mot) VALUES("Assiette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,254);
INSERT INTO Mot(mot) VALUES("Cour");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,255);
INSERT INTO Mot(mot) VALUES("Foulard");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,256);
INSERT INTO Mot(mot) VALUES("Patinage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,257);
INSERT INTO Mot(mot) VALUES("Fusée");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,258);
INSERT INTO Mot(mot) VALUES("Serre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,259);
INSERT INTO Mot(mot) VALUES("Chausson");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,260);
INSERT INTO Mot(mot) VALUES("Sauna");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,261);
INSERT INTO Mot(mot) VALUES("Ambulance");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,262);
INSERT INTO Mot(mot) VALUES("Verger");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,263);
INSERT INTO Mot(mot) VALUES("Bougie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,264);
INSERT INTO Mot(mot) VALUES("Fanfare");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,265);
INSERT INTO Mot(mot) VALUES("Tracteur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,266);
INSERT INTO Mot(mot) VALUES("Grain");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,267);
INSERT INTO Mot(mot) VALUES("Déodorant");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,268);
INSERT INTO Mot(mot) VALUES("Soupe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,269);
INSERT INTO Mot(mot) VALUES("Pâtisserie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,270);
INSERT INTO Mot(mot) VALUES("Sorbet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,271);
INSERT INTO Mot(mot) VALUES("Ruche");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,272);
INSERT INTO Mot(mot) VALUES("Raton-laveur");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,273);
INSERT INTO Mot(mot) VALUES("Méduse");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,274);
INSERT INTO Mot(mot) VALUES("Poussette");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,275);
INSERT INTO Mot(mot) VALUES("Sommeil");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,276);
INSERT INTO Mot(mot) VALUES("Huile");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,277);
INSERT INTO Mot(mot) VALUES("Brocoli");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,278);
INSERT INTO Mot(mot) VALUES("Truite");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,279);
INSERT INTO Mot(mot) VALUES("Pièce");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,280);
INSERT INTO Mot(mot) VALUES("Tigre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,281);
INSERT INTO Mot(mot) VALUES("Fontaine");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,282);
INSERT INTO Mot(mot) VALUES("Artichaut");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,283);
INSERT INTO Mot(mot) VALUES("Moustique");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,284);
INSERT INTO Mot(mot) VALUES("Glacier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,285);
INSERT INTO Mot(mot) VALUES("Château");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,286);
INSERT INTO Mot(mot) VALUES("Moustache");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,287);
INSERT INTO Mot(mot) VALUES("Canne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,288);
INSERT INTO Mot(mot) VALUES("Pétale");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,289);
INSERT INTO Mot(mot) VALUES("Branche");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,290);
INSERT INTO Mot(mot) VALUES("Lampe");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,291);
INSERT INTO Mot(mot) VALUES("Sable");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,292);
INSERT INTO Mot(mot) VALUES("Cigale");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,293);
INSERT INTO Mot(mot) VALUES("Camion");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,294);
INSERT INTO Mot(mot) VALUES("Salle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,295);
INSERT INTO Mot(mot) VALUES("Aigle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,296);
INSERT INTO Mot(mot) VALUES("Crinière");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,297);
INSERT INTO Mot(mot) VALUES("Clown");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,298);
INSERT INTO Mot(mot) VALUES("Corbeau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,299);
INSERT INTO Mot(mot) VALUES("Sabre");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,300);
INSERT INTO Mot(mot) VALUES("Boulangerie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,301);
INSERT INTO Mot(mot) VALUES("Arène");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,302);
INSERT INTO Mot(mot) VALUES("Corde");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,303);
INSERT INTO Mot(mot) VALUES("Miel");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,304);
INSERT INTO Mot(mot) VALUES("Larme");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,305);
INSERT INTO Mot(mot) VALUES("Morsure");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,306);
INSERT INTO Mot(mot) VALUES("Chalet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,307);
INSERT INTO Mot(mot) VALUES("Sablier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,308);
INSERT INTO Mot(mot) VALUES("Arc");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,309);
INSERT INTO Mot(mot) VALUES("Grenier");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,310);
INSERT INTO Mot(mot) VALUES("Noix");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,311);
INSERT INTO Mot(mot) VALUES("Gondole");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,312);
INSERT INTO Mot(mot) VALUES("Boîte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,313);
INSERT INTO Mot(mot) VALUES("Libellule");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,314);
INSERT INTO Mot(mot) VALUES("Planète");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,315);
INSERT INTO Mot(mot) VALUES("Bouquet");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,316);
INSERT INTO Mot(mot) VALUES("Magie");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,317);
INSERT INTO Mot(mot) VALUES("Vent");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,318);
INSERT INTO Mot(mot) VALUES("Cygne");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,319);
INSERT INTO Mot(mot) VALUES("Goutte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,320);
INSERT INTO Mot(mot) VALUES("Tournesol");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,321);
INSERT INTO Mot(mot) VALUES("Biscuit");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,322);
INSERT INTO Mot(mot) VALUES("Aube");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,323);
INSERT INTO Mot(mot) VALUES("Selle");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,324);
INSERT INTO Mot(mot) VALUES("Carotte");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,325);
INSERT INTO Mot(mot) VALUES("Bagage");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,326);
INSERT INTO Mot(mot) VALUES("Noeud");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,327);
INSERT INTO Mot(mot) VALUES("Tonneau");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,328);
INSERT INTO Mot(mot) VALUES("Cloche");
INSERT INTO Mot_Dictionnaire(id_dictionnaire,id_mot) VALUES(1,329);

INSERT INTO Etat(etat) VALUES("Gagné");
INSERT INTO Etat(etat) VALUES("Perdu");
INSERT INTO Etat(etat) VALUES("En cours");

INSERT INTO Role(role) VALUES("");
INSERT INTO Role(role) VALUES("Maître des mots");
INSERT INTO Role(role) VALUES("Maître des intuitions");

INSERT INTO Couleur(couleur) VALUES("Bleu");
INSERT INTO Couleur(couleur) VALUES("Gris");
INSERT INTO Couleur(couleur) VALUES("Noir");

INSERT INTO Joueur(pseudonyme) VALUES("toto");
INSERT INTO Joueur(pseudonyme) VALUES("baba");
INSERT INTO Joueur(pseudonyme) VALUES("salut");

INSERT INTO Grille(id_grille,hauteur_grille,largeur_grille,score,id_etat) VALUES(1,0,0,0,1);

INSERT INTO Grille(id_grille,hauteur_grille,largeur_grille,score,id_etat,tour) VALUES(2,5,5,0,3,0);
INSERT INTO Grille(id_grille,hauteur_grille,largeur_grille,score,id_etat,tour) VALUES(3,5,5,0,3,0);
INSERT INTO Grille(id_grille,hauteur_grille,largeur_grille,score,id_etat,tour) VALUES(4,5,5,0,3,0);

INSERT INTO Partie(code) VALUES("0000000000");
INSERT INTO Partie(code) VALUES("0000000001");



INSERT INTO Indice(indice,N,id_grille) VALUES("chevalier",3,1);

INSERT INTO Carte(id_grille, id_mot, ligne, colonne, face_cachee, id_couleur) VALUES(1,23,1,1,true,1);
INSERT INTO Carte(id_grille, id_mot, ligne, colonne, face_cachee, id_couleur) VALUES(1,24,1,2,true,1);
INSERT INTO Carte(id_grille, id_mot, ligne, colonne, face_cachee, id_couleur) VALUES(1,25,1,3,true,1);
INSERT INTO Carte(id_grille, id_mot, ligne, colonne, face_cachee, id_couleur) VALUES(1,26,1,4,true,1);
INSERT INTO Carte(id_grille, id_mot, ligne, colonne, face_cachee, id_couleur) VALUES(1,27,1,5,true,1);
