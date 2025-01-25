-- C

SELECT 
    c.idRefA,
    a.nomA,
    SUM(c.qteA) AS nb_ventes
FROM Commander c, Article a
WHERE c.idRefA = a.idRefA
GROUP BY c.idRefA, a.nomA;



-- D

SELECT 
    cl.idNumClient,
    cl.nom,
    cl.prenom,
    COUNT(b.idNumBC) AS nb_commandes
FROM Client cl, BonCde b
WHERE cl.idNumClient = b.idNumClient
GROUP BY cl.idNumClient, cl.nom, cl.prenom;



-- E

SELECT 
    c.adLocalite AS ville,
    COUNT(DISTINCT b.idNumBC) AS nb_commandes,
    SUM(cm.qteA * a.prixU) AS montant_total
FROM Client c, BonCde b, Commander cm, Article a
WHERE c.idNumClient = b.idNumClient
  AND b.idNumBC     = cm.idNumBC
  AND cm.idRefA     = a.idRefA
GROUP BY c.adLocalite;



-- F

SELECT prixU
FROM Article
WHERE idRefA = 'D6917.006';


-- G 

SELECT 
    b.idNumClient,
    c.qteA AS quantite
FROM Commander c, BonCde b
WHERE c.idNumBC = b.idNumBC
  AND c.idRefA  = 'D6917.006';
