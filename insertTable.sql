-- Relais ------------------------------------------------------------------------------------------
INSERT INTO Livrer(idNomR, adNumR, adVoieR, adCPR, adLocaliteR)
VALUES
  (
    'Consigne La Poste Pickup Capitole',
    '9',
    'Rue Lafayette à l''intérieur du bureau',
    '31000',
    'Toulouse'
  ),
  (
    'Consigne Pickup La Poste Remusat',
    '25',
    'Rue de Remusat dans le sas d''entrée',
    '31000',
    'Toulouse'
  ),
  (
    'Excklusive',
    '20',
    'Rue Sainte Ursule',
    '31000',
    'Toulouse'
  ),
  (
    'Four Twenty CBD Shop',
    '40',
    'Rue Pargaminières',
    '31000',
    'Toulouse'
  ),
  (
    'My Look',
    '12',
    'Rue des Changes',
    '31000',
    'Toulouse'
  ),
  (
    'Consigne Smart Wash Toulouse',
    '29',
    'Rue du Rempart Matabiau',
    '31000',
    'Toulouse'
  ),
  (
    'GSM Services 31',
    '3bis',
    'Boulevard de Strasbourg',
    '31000',
    'Toulouse'
  ),
  (
    'Midica Relais',
    '22',
    'Rue des Tourneurs',
    '31000',
    'Toulouse'
  ),
  (
    'KDC Nutrition',
    '9',
    'Rue de Bayard',
    '31000',
    'Toulouse'
  ),
  (
    'Asia Shop',
    '18',
    'Rue Matabiau',
    '31000',
    'Toulouse'
  ),
  (
    'Carrefour City',
    '43',
    'Rue de Metz',
    '31000',
    'Toulouse'
  ),
  (
    'La Poste de Toulouse Arnaud Bernard',
    '17',
    'Boulevard Lascrosses',
    '31000',
    'Toulouse'
  );





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
  'DS333013',  
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
VALUES ('D0295009', 1002, 3, 38);

-- Article 2
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D6917006', 1002, 1, 38);






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
  '12678',    -- même cliente qu’au 2e bon
  NULL
);

-- Parka 3 en 1
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('D0026023', 1003, 1, 40);

-- Pull épaule
INSERT INTO Commander (idRefA, idNumBC, qteA, tailleA)
VALUES ('DS333001', 1003, 1, 38);












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
VALUES ('D5333025', 1004, 1, 36);
