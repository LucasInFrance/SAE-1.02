INSERT INTO Catalogue
VALUES ('Hiver');

--Parka 3 en 1

INSERT INTO Article
VALUES ('D0026.023', 'Parka 3 en 1', 'Camel', 149.00, '34/56', 'Gilet amovible doublé Thermolactyl. Parka:tissu déperlant 57% polyester, 35% coton, 8% polyamide.');
INSERT INTO Presenter
VALUES ('Hiver', 'D0026.023', '4', 'A');

--Jean coupe Mom

INSERT INTO Article
VALUES ('D6606.001', 'Jean coupe Mom', 'Denim foncé', 45.99, '38/52', '99% coton, 1% élasthanne. Ceinture à passants. Bouton, glissière, 2 poches + 1 poche devant. 2 poches dos.');
INSERT INTO Presenter
VALUES ('Hiver', 'D6606.001', '4', 'B');

--Sac en croute de cuir

INSERT INTO Article
VALUES ('D0615.004', 'Sac en croûte de cuir', 'Marron animalier', 59.99, '', 'Croûte de cuir motif animalier.');
INSERT INTO Presenter
VALUES ('Hiver', 'D0615.004', '4', 'C');

--Pulls marinière épaule boutonée

INSERT INTO Article
VALUES ('D5333.025', 'Pull marinière épaule', 'Beige rayé', 49.99, '34/56', '63% polyester (dont 50% polyester recyclé), 23% acrylique. 10% laine, 4% élasthane. Col asymétrique');
INSERT INTO Presenter
VALUES ('Hiver', 'D5333.025', '4', 'D');

INSERT INTO Article
VALUES ('D5333.013', 'Pull marinière épaule', 'Blanc rayé', 49.99, '34/56', '63% polyester (dont 50% polyester recyclé), 23% acrylique. 10% laine, 4% élasthane. Col asymétrique');
INSERT INTO Presenter
VALUES ('Hiver', 'D5333.013', '4', 'D');

INSERT INTO Article
VALUES ('D5333.001', 'Pull marinière épaule', 'Marine rayé', 49.99, '34/56', '63% polyester (dont 50% polyester recyclé), 23% acrylique. 10% laine, 4% élasthane. Col asymétrique');
INSERT INTO Presenter
VALUES ('Hiver', 'D5333.001', '4', 'D');

--T-shirts Essential

INSERT INTO Article
VALUES ('D0295.009', 'T-shirts Essential', '', 25.99, '38', '');
INSERT INTO Presenter
VALUES ('Hiver', 'D0295.009', '100', '');

--Fine côte Thermodactyl

INSERT INTO Article
VALUES ('D6917.006', 'Fine côte Thermodactyl', '', 25.99, '38', '');
INSERT INTO Presenter
VALUES ('Hiver', 'D6917.006', '106', '');



--Relais

INSERT INTO Livrer VALUES ('Consigne La Poste Pickup Capitole', '9', 'Rue Lafayette à l''intérieur du bureau', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Consigne Pickup La Poste Remusat', '25', 'Rue de Remusat dans le sas d''entrée', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Excklusive', '20', 'Rue Sainte Ursule', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Four Twenty CBD Shop', '40', 'Rue Pargaminières', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('My Look', '12', 'Rue des Changes', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Consigne Smart Wash Toulouse', '29', 'Rue du Rempart Matabiau', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('GSM Services 31', '3bis', 'Boulevard de Strasbourg', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Midica Relais', '22', 'Rue des Tourneurs', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('KDC Nutrition', '9', 'Rue de Bayard', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Asia Shop', '18', 'Rue Matabiau', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('Carrefour City', '43', 'Rue de Metz', '31000', 'Toulouse');

INSERT INTO Livrer VALUES ('La Poste de Toulouse Arnaud', '17', 'Boulevard Lascrosses', '31000', 'Toulouse');



-- CLIENTS -----------------------------------------------------------------------------------


-- Client 1 : Marc Assein
INSERT INTO Client (
   idNumClient, civilite, nom, prenom,
   adNum, adVoie, adCP, adLocalite,
   dateN, mel, telF, telP
)
VALUES (
   '56789',
   'M',
   'ASSEIN',
   'Marc',
   '18',
   'Avenue des Chênes',
   '31400',
   'Toulouse',
   NULL,        
   NULL,                    
   NULL,           
   NULL            
);


INSERT INTO BonCde (
  idNumBC, dateBC, codeAv, remise, modeL, typeP,
  numCB, dExpCB, cryp, fraisCR, fraisPort,
  idNumClient, idNomR
)
VALUES (
  1001,
  DATE '2025-01-24', 
  '39626',              
  0.00,               -- pas de remise
  'Do',               -- à domicile
  'CAB',              -- paiement par carte bancaire
  '1111999922224444',
  '0127',
  '192',
  0.00,             
  7.50,           
  '56789',          
  NULL            
);

INSERT INTO Commander (
  idRefA, idNumBC, qteA, tailleA
)
VALUES (
  'D5333.013',  
  1001,
  2,
  42
);

-- Client 2 : Hélène Aztarès
INSERT INTO Client (
   idNumClient, civilite, nom, prenom,
   adNum, adVoie, adCP, adLocalite,
   dateN, mel, telF, telP
)
VALUES (
   '12678',
   'Mme',
   'AZTAKES',
   'Hélène',
   '300',
   'Rue Ferrari',
   '72000',
   'Le Mans',
   NULL,     
   NULL,
   NULL,      
   NULL      
);

INSERT INTO BonCde (
  idNumBC, dateBC, codeAv, remise, modeL, typeP,
  numCB, dExpCB, cryp, fraisCR, fraisPort,
  idNumClient, idNomR
)
VALUES (
  1002,
  DATE '2025-01-24',
  '39626',
  0.00,
  'RD',              
  'CRD',
  NULL,    
  NULL,
  NULL,
  0.00,
  7.50,           
  '12678',        
  NULL       
);

-- Article 1
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D0295.009', 1002, 3, 38);

-- Article 2
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D6917.006', 1002, 1, 38);

--2ème Bon de Commande

INSERT INTO BonCde (
  idNumBC, dateBC, codeAv, remise, modeL, typeP,
  numCB, dExpCB, cryp, fraisCR, fraisPort,
  idNumClient, idNomR
)
VALUES (
  1003,
  DATE '2025-01-24',
  '39626', 
  0.00,
  'Do',       -- probablement la même livraison rapide/7,50
  'CHD',      -- paiement par chèque
  NULL,
  NULL,
  NULL,
  0.00,
  5.90,
  '12678',    -- même cliente
  NULL
);

-- Parka 3 en 1
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D0026.023', 1003, 1, 40);

-- Pull épaule
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D5333.001', 1003, 1, 38);

-- Client 3 : Alain Verse
INSERT INTO Client (
   idNumClient, civilite, nom, prenom,
   adNum, adVoie, adCP, adLocalite,
   dateN, mel, telF, telP
)
VALUES (
   '12345',
   'M',
   'VERSE',
   'Alain',
   '69',
   'Rue du Contre Sens',
   '31700',
   'Blagnac',
   DATE '1984-01-20',         -- d’après ce qui figure sur le bon
   'alain.verse@gmail.com',
   '0606000000',
   '0505000000'
);

INSERT INTO BonCde (
  idNumBC, dateBC, codeAv, remise, modeL, typeP,
  numCB, dExpCB, cryp, fraisCR, fraisPort,
  idNumClient, idNomR
)
VALUES (
  1004,
  DATE '2025-01-24',
  '39626',
  0.00,
  'RR',             -- livraison à domicile (5,90)
  'CAB',
  '9999888877776666',  -- si carte différente ; sinon modifiez
  '0126',           -- date d’expiration, p.ex. 01/26
  '987',            -- cryptogramme
  0.00,
  6.00,
  '12345', 
  'Carrefour City'
);

INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D5333.025', 1004, 1, 36);
