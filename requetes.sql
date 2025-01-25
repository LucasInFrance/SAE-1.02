-- A Nombre de commandes passées

SELECT COUNT(idNumBC) AS Nb_de_commandes
FROM BonCde;

-- B Montant total commandé et nombre de lignes de commandes

--B-V1 - Nous l'interprétons comme total du montant d'achat d'article (donc hors frais de port) de tout les clients confondus, ainsi que le nombre de lignes d'articles commandés au total.

SELECT SUM(prixU*qteA) AS Total_Commande, COUNT(tailleA) AS Nb_de_lignes
FROM BonCde B, Commander C, Article A
WHERE B.idNumBC=C.idNumBC
AND C.idRefA=A.idRefA;

--B-V2 - avec frais (ne marche pas on a 479.22 au lieu de 479.82)

SELECT (SUM(prixU*qteA)+SUM(DISTINCT fraisPort)+SUM(DISTINCT fraisCR)) AS Total_Commande, COUNT(tailleA) AS Nb_de_lignes
FROM BonCde B, Commander C, Article A
WHERE B.idNumBC=C.idNumBC
AND C.idRefA=A.idRefA;



-- C Nombre de ventes par article

SELECT c.idRefA, a.nomA, SUM(c.qteA) AS nb_ventes
FROM Commander c, Article a
WHERE c.idRefA = a.idRefA
GROUP BY c.idRefA, a.nomA;



-- D Nombre de commandes passées par client

SELECT cl.idNumClient, cl.nom, cl.prenom, COUNT(b.idNumBC) AS nb_commandes
FROM Client cl, BonCde b
WHERE cl.idNumClient = b.idNumClient
GROUP BY cl.idNumClient, cl.nom, cl.prenom;



-- E Nombre de commandes passées et montant total par ville des clients

SELECT c.adLocalite AS ville, COUNT(DISTINCT b.idNumBC) AS nb_commandes, SUM(cm.qteA * a.prixU) AS montant_total
FROM Client c, BonCde b, Commander cm, Article a
WHERE c.idNumClient = b.idNumClient
AND b.idNumBC = cm.idNumBC
AND cm.idRefA = a.idRefA
GROUP BY c.adLocalite;



-- F Obtenir le prix unitaire de l’article de référence D6917.006

SELECT prixU
FROM Article
WHERE idRefA = 'D6917.006';


-- G Obtenir les numéros clients ayant commandé l’article de référence D6917.006 avec la quantité commandée

SELECT b.idNumClient, c.qteA AS quantite
FROM Commander c, BonCde b
WHERE c.idNumBC = b.idNumBC
AND c.idRefA  = 'D6917.006';


-- H Nom des clients ayant réalisé plusieurs commandes pour un montant total > 200€ avec le nb de commandes et le montant total commandé


SELECT cl.nom, cl.prenom, COUNT(DISTINCT b.idNumBC) AS nb_commandes, SUM(cm.qteA * a.prixU) AS montant_total
FROM Client cl, BonCde b, Commander cm, Article a
WHERE cl.idNumClient = b.idNumClient
AND b.idNumBC = cm.idNumBC
AND cm.idRefA = a.idRefA
GROUP BY cl.nom, cl.prenom
HAVING COUNT(DISTINCT b.idNumBC) > 1
AND SUM(cm.qteA * a.prixU) > 200;

