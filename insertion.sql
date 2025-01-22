CREATE TABLE Client (
   idNumClient CHAR(5),
   civilite VARCHAR(3),
   nom VARCHAR(30),
   prenom VARCHAR(30),
   adNum VARCHAR(6),
   adVoie VARCHAR(30),
   adCP CHAR(5),
   adLocalite VARCHAR(30),
   dateN DATE,
   mel VARCHAR(30),
   telF CHAR(10),
   telP CHAR(10),
   CONSTRAINT pk_client PRIMARY KEY (idNumClient)
   CONSTRAINT ck_boncde_civilite CHECK (civilite='M' OR civilite="Mme"),

);


CREATE TABLE Livrer (
   idNomR VARCHAR(30),
   adNumR VARCHAR(6),
   adVoieR VARCHAR(30),
   adCPR CHAR(5),
   adLocaliteR VARCHAR(30),
   CONSTRAINT pk_livrer PRIMARY KEY (idNomR)
);


CREATE TABLE Presenter (
   idNomC CHAR(5),
   idRefA VARCHAR(3),
   numPage VARCHAR(30),
   codeP VARCHAR(30),
   CONSTRAINT pk_presenter PRIMARY KEY (idNomC, idRefA),
   CONSTRAINT fk_presenter_catalogue FOREIGN KEY (idNomC) REFERENCES Catalogue(idNomC),
   CONSTRAINT fk_presenter_article FOREIGN KEY (idRefA) REFERENCES Article(idRefA)
);




CREATE TABLE Commander (
   idRefA CHAR(9),
   idNumBC DECIMAL(10), -- taille non précisée
   qteA DECIMAL(10), -- CONTRAINTE A FAIRE
   tailleA DECIMAL(10), --
   CONSTRAINT pk_client PRIMARY KEY (idRefA, idNumBC),
   CONSTRAINT fk_client_article FOREIGN KEY (idRefA) REFERENCES Article(idRefA),
   CONSTRAINT fk_commander_boncde FOREIGN KEY (idNumBC) REFERENCES BonCde(idNumBC)
   CONSTRAINT ck_commander_qteA CHECK (qteA>0)
);


CREATE TABLE Catalogue (
   idNomC VARCHAR(30),
   CONSTRAINT pk_catalogue PRIMARY KEY (idNomC)
);


CREATE TABLE Article (
   idRefA CHAR(9),
   nomA VARCHAR(30),
   couleur VARCHAR(30),
   prixU DECIMAL(10,2), -- Type Reel
   taillesA CHAR(5),
   descA VARCHAR(120),
   CONSTRAINT pk_article PRIMARY KEY (idRefA),
   CONSTRAINT ck_article_prixu CHECK (prixU>0)
);


CREATE TABLE BonCde (
   idNumBC DECIMAL(10), -- taille non précisée
   dateBC DATE, -- Contrainte JJ/MM/AAAA
   codeAv CHAR(5),
   remise DECIMAL (10,2), -- Type Reel
   modeL CHAR(2),
   typeP CHAR(3),
   numCB CHAR(16),
   dExpCB CHAR(4), -- Contrainte MMAA
   cryp CHAR(3),
   fraisCR DECIMAL(1,2),
   fraisPort DECIMAL(1,2),
   idNumClient CHAR(5),
   idNomR VARCHAR(30),
   CONSTRAINT pk_boncde PRIMARY KEY (idNumBC),
   CONSTRAINT ck_boncde_idNumBC CHECK (idNumBC>0) 
   CONSTRAINT ck_boncde_remise CHECK (remise>=0 AND remise<=100),
   CONSTRAINT ck_boncde_model CHECK (modeL='Do' OR modeL="RD" OR modeL='RR'),
   CONSTRAINT ck_boncde_typep CHECK (typeP='CAB' OR typeP='CHB' OR typeP='CHD' OR typeP='CRD'),
   CONSTRAINT uk_boncde_numcb UNIQUE (numCB),
   CONSTRAINT ck_boncde_fraiscr CHECK (fraisCR=0.00 OR fraisCR=6.90),
   CONSTRAINT ck_boncde_fraisport CHECK (fraisPort=5.90 OR fraisPort=6.00 OR fraisPort=7.50),
   CONSTRAINT fk_boncde_idnumclient FOREIGN KEY (idNumClient) REFERENCES Client(idNumClient),
   CONSTRAINT fk_boncde_idnomr FOREIGN KEY (idNomR) REFERENCES Livrer(idNomR)
);


