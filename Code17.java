import java.util.Scanner;
import java.io.*;

// -------------------------------------------------------------------------------------------------------
// ------------------------------------------- Programmes Mickael ----------------------------------------
// --------------------------------------------- Ligne 0 à 430 -------------------------------------------
// -------------------------------------------------------------------------------------------------------

public class Code17 {

    // Codes ANSI pour les couleurs
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";


    /**
     *Fonction principale
     *@author Mickael FLores
     *
     */
    public static void main(String[] args) throws Exception {
        

// -------------------------------------------------------------------------------------------------------
// ------------------------------------------- Matrices test ---------------------------------------------
// -------------------------------------------------------------------------------------------------------

        System.out.println("-*-*-*-*-*-Génération de parties de test-*-*-*-*-*-\n");
        // Création du fichier html
        PrintStream ecriture = new PrintStream("archive.html");
        
        //1
        System.out.println("-Partie test 1-");
        Liste archive = new Liste(); // Création de l'archive
        MatriceEntier matriceTest = new MatriceEntier(3, 3); //création de la matrice
        matriceTest.tabMat = new int[][]{
                                            {1, 0, 0}, 
                                            {0, 1, 0}, 
                                            {0, 0, 1}
                                        };
        afficherPartie(archive, matriceTest, ecriture); //affichage des résultats

        //2
        System.out.println("-Partie test 2-");
        archive = new Liste(); // Création de l'archive
        matriceTest = new MatriceEntier(5, 5); //création de la matrice
        matriceTest.tabMat = new int[][]{
                                            {0, 0, 0, 0, 0},
                                            {0, 1, 1, 1, 0},
                                            {1, 1, 1, 0, 0},
                                            {0, 0, 0, 0, 0},
                                            {0, 0, 0, 0, 0}
                                        };
        afficherPartie(archive, matriceTest, ecriture); //affichage des résultats


        System.out.println("\n\nTests effectués avec succès !\n\n");






// -------------------------------------------------------------------------------------------------------
// ------------------------------------------- Jeu de la Vie ---------------------------------------------
// -------------------------------------------------------------------------------------------------------
        
         
        int nbParties;
        Scanner lecteur = new Scanner(System.in);
        
        System.out.println("\n" +
                "-*-*-*-*-*-Jeu de la Vie-*-*-*-*-*-\n" +
                "Combien de parties voulez-vous jouer ?\n");
        
        nbParties = lecteur.nextInt();

        //Pour chaque partie     
        for (int p = 0; p < nbParties; p++) {

            System.out.println("\nPartie : " + (p + 1));
        
            // Création de la matrice
            MatriceEntier matrice;
            archive = new Liste();


            int lignes = 0;
            int colonnes = 0;

            
            while (true) {

                //Saisie de la matrice de l'utilisateur
                try {
                    System.out.println("Choisissez la taille de votre génération 0");
        
                    System.out.println("Combien de lignes ?");
                    if (lecteur.hasNextInt()) {
                        lignes = lecteur.nextInt();
                        lecteur.nextLine(); // vide le buffer
                    } else {
                        lecteur.nextLine(); // vide le buffer
                        throw new IllegalArgumentException("Entrée invalide. Veuillez saisir un entier.");
                    }
        
                    System.out.println("Combien de colonnes ?");
                    if (lecteur.hasNextInt()) {
                        colonnes = lecteur.nextInt();
                        lecteur.nextLine(); // vide le buffer
                    } else {
                        lecteur.nextLine(); // vide le buffer
                        throw new IllegalArgumentException("Entrée invalide. Veuillez saisir un entier.");
                    }
        
                    if (lignes <= 0 || colonnes <= 0) {
                        throw new IllegalArgumentException("Les dimensions doivent être des entiers > 0.");
                    }
        
                    matrice = new MatriceEntier(lignes, colonnes);
                    break;
        
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Entrée invalide. Veuillez réessayer.");
                }
            }
            
            // Génération de la matrice de generation 0
            genMatriceZero(matrice); 

            // Calcul et affichage des résultats de la 
            System.out.println("Partie numéro "+ (p + 1));

            afficherPartie(archive, matrice, ecriture);
        }
        ecriture.close();
        lecteur.close();


// -------------------------------------------------------------------------------------------------------
// ------------------------------------------ Menu de Débuggage ------------------------------------------
// -------------------------------------------------------------------------------------------------------
        
        /*
        System.out.println("" +
                "0.Quitter\n" +
                "1.getNbLignes\n" +
                "2.getNbColonnes\n" +
                "3.getElement\n" +
                "4.somLigne\n" +
                "5.somColonne\n" +
                "6.estCarre\n" +
                "7.estDiagonale\n" +
                "8.setElement\n" +
                "9.setPremiereDiagonale\n" +
                "10.setSecondeDiagonale\n" +
                "11.mulMatNombre\n" +
                "12.toString\n" +
                "13.toHTML");
        while (true) {
            int menu = -1;
            while (menu < 0) {
                menu = in.nextInt();
                in.nextLine();
            }
            switch (menu) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    System.out.println(getNbLignes(matrice1));
                    break;
                case 2:
                    System.out.println(getNbColonnes(matrice1));
                    break;
                case 3:
                    System.out.println("indice 1?");
                    int l = in.nextInt();
                    in.nextLine();
                    System.out.println("indice 2?");
                    int c = in.nextInt();
                    in.nextLine();
                    System.out.println(getElement(matrice1, l, c));
                    break;
                case 4:
                    System.out.println("Ligne?");
                    int ligne = in.nextInt();
                    in.nextLine();
                    System.out.println(somLigne(matrice1, ligne));
                    break;
                case 5:
                    System.out.println("Colonne?");
                    int colonne = in.nextInt();
                    in.nextLine();
                    System.out.println(somColonne(matrice1, colonne));
                    break;
                case 6:
                    System.out.println(estCarree(matrice1));
                    break;
                case 7:
                    System.out.println(estDiagonale(matrice1));
                    break;
                case 8:
                    System.out.println("Indice ligne ?");
                    int iligne = in.nextInt();
                    in.nextLine();
                    System.out.println("Indice colonne ?");
                    int icolonne = in.nextInt();
                    in.nextLine();
                    System.out.println("Element ?");
                    int element = in.nextInt();
                    in.nextLine();
                    setElement(matrice1, iligne, icolonne, element);
                    break;
                case 9:
                    System.out.println("Element?");
                    int pfelement = in.nextInt();
                    in.nextLine();
                    setPremiereDiagonale(matrice1, pfelement);
                    break;
                case 10:
                    System.out.println("Element?");
                    pfelement = in.nextInt();
                    in.nextLine();
                    setSecondeDiagonale(matrice1, pfelement);
                    break;
                case 11:
                    System.out.println("Facteur?");
                    int mul = in.nextInt();
                    in.nextLine();
                    mulMatNombre(matrice1, mul);
                    break;
                case 12:
                    System.out.println(toString(matrice1));
                    break;
                case 13:
                    System.out.println(toHTML(matrice1));
                    break;
            }
            in.close();
        }*/




    } // FIN MAIN

// -------------------------------------------------------------------------------------------------------
// ------------------------------------------- Sous Programmes -------------------------------------------
// -------------------------------------------------------------------------------------------------------


    /**
     * Affiche les générations successives d'une matrice et les enregistre dans une archive. 
     * Génère un fichier HTML contenant l'historique des générations.
     * @param pfArchive IN/OUT : archive des matrices contenant les générations précédentes
     * @param pfMatrice IN/OUT : matrice représentant la génération actuelle, mise à jour à chaque itération
     * @param pfEcrire IN : objet FileWriter utilisé pour écrire l'historique des générations dans un fichier HTML
     * @throws Exception en cas d'erreur lors de l'ajout des matrices dans l'archive, de la génération des matrices ou de l'écriture dans le fichier
     * @author Mickael FLores
     */
    public static void afficherPartie(Liste pfArchive, MatriceEntier pfMatrice, PrintStream pfEcrire) throws Exception {

        add(pfMatrice, pfArchive); // Ajoute la matrice à l'archive

        System.out.println("La matrice G0 est :");
        System.out.println(toString(pfMatrice));
        
        // Boucle de 10 générations max 
        for (int i = 1; i < 10; i++) {

            nextGen(pfMatrice); // Génère la prochaine génération

            // Vérifie si la matrice est déjà dans l'archive
            if (check(pfMatrice, pfArchive)) {
               add(pfMatrice, pfArchive); // Ajoute la matrice à l'archive pour montrer la boucle
              break; // Sort de la boucle
           }
           
            add(pfMatrice, pfArchive); // Ajoute la matrice à l'archive

            System.out.println("La matrice G" + i + " est :"); // Affiche le numéro de génération
            System.out.println(toString(pfMatrice));



        }

        System.out.println("Fin des générations"); // Affiche un message de fin de simulation

        // Affichage des matrices de l'archive dans un fichier html

        try {

            pfEcrire.println(archiveToHtml(pfArchive, pfMatrice.nbL, pfMatrice.nbC)); // écriture de l'archive dans le fichier html
            pfEcrire.println("<br />");

            System.out.println("Fichier html généré avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur lors de la génération du fichier html.");
            e.printStackTrace();
        }

    }



    /**
     * Compte le nombre de cellules vivantes autour d'une cellule donnée dans une matrice.
     * @param pfMatrice IN : matrice à analyser
     * @param pfNumL IN : indice de la ligne de la cellule cible
     * @param pfNumC IN : indice de la colonne de la cellule cible
     * @return le nombre de cellules vivantes autour de la cellule (pfNumL, pfNumC)
     * @throws Exception en cas d'erreur lors de la manipulation des indices de la matrice
     * @author Mickael FLores
     */
    public static int nbVie(MatriceEntier pfMatrice, int pfNumL, int pfNumC) throws Exception { 
        int nbVie = 0;

        // on parcourt les 8 cellules autour de la cellule (pfNumL, pfNumC)
        for (int i = pfNumL - 1; i <= pfNumL + 1; i++) {  
            for (int j = pfNumC - 1; j <= pfNumC + 1; j++) { 
                
                if (i >= 0 && i < pfMatrice.nbL && j >= 0 && j < pfMatrice.nbC && (i != pfNumL || j != pfNumC)) { // on vérifie que l'indice est dans la matrice
                    if (pfMatrice.tabMat[i][j] == 1) { // si la cellule est en vie
                        nbVie++;
                    }
                }
            }
        }

        
        return nbVie;
    }


    /**
     * Génère une représentation HTML complète d'une archive contenant plusieurs générations de matrices.
     * @param pfArchive IN : liste contenant l'historique des matrices à convertir en HTML
     * @param pfNbL IN : nombre de lignes des matrices dans l'archive
     * @param pfNbC IN : nombre de colonnes des matrices dans l'archive
     * @return une chaîne de caractères contenant le code HTML représentant l'archive
     * @author Mickael FLores
     */
    public static void nextGen(MatriceEntier pfMatrice) throws Exception {
        // Créer une copie de la matrice actuelle
        MatriceEntier oldMatrice = new MatriceEntier(pfMatrice.nbL, pfMatrice.nbC);
    
        // Copier les valeurs de pfMatrice dans oldMatrice
        for (int i = 0; i < pfMatrice.nbL; i++) {
            for (int j = 0; j < pfMatrice.nbC; j++) {
                oldMatrice.tabMat[i][j] = pfMatrice.tabMat[i][j];
            }
        }
    
        // Parcourir la matrice et appliquer les règles
        for (int i = 0; i < pfMatrice.nbL; i++) {
            for (int j = 0; j < pfMatrice.nbC; j++) {
                // Compter le nombre de cellules vivantes autour de la cellule (i, j)
                int nbVie = nbVie(oldMatrice, i, j);
    
                // Appliquer les règles du jeu de la vie
                if (oldMatrice.tabMat[i][j] == 1) { // La cellule est vivante
                    if (nbVie < 2 || nbVie > 3) {
                        pfMatrice.tabMat[i][j] = 0; // Meurt par isolement ou surpopulation
                    } else {
                        pfMatrice.tabMat[i][j] = 1; // Reste en vie
                    }
                } else { // La cellule est morte
                    if (nbVie == 3) {
                        pfMatrice.tabMat[i][j] = 1; // Naît si exactement 3 voisins vivants
                    }
                }
            }
        }
    }


    /**
     * Génère une représentation HTML complète d'une archive contenant plusieurs générations de matrices.
     * @param pfArchive IN : liste contenant l'historique des matrices à convertir en HTML
     * @param pfNbL IN : nombre de lignes des matrices dans l'archive
     * @param pfNbC IN : nombre de colonnes des matrices dans l'archive
     * @return une chaîne de caractères contenant le code HTML représentant l'archive
     * @author Mickael FLores
     */
    public static String archiveToHtml(Liste pfArchive, int pfNbL, int pfNbC){
        String ln = System.getProperty("line.separator") ;

        // on récupère la taille de l'archive
        int tailleArchive = pfArchive.gen+1;

        // on crée le code html
        String codeHtml = "<html><head><title>TP: Jeu de la vie</title><meta http-equiv='Content-Type' content='application/xhtml+xml; charset=UTF-8' /><style>table{border-collapse:collapse;border: 1px solid black;width:100px;display: inline-table;}tr,td { border: 1px solid black; height:20px;}.on { background-color:grey; }</style></head><body>";
        codeHtml += ln;

        for (int i = 0; i<tailleArchive; i++){
            codeHtml += toHtml(pfArchive.historique[i], pfNbL, pfNbC, i); // on transforme chaque matrice de l'archive en html
            codeHtml += ln; // pour séparer les générations

        }

        // on ferme le code html
        codeHtml += "</body></html>";

        return codeHtml; // on retourne le code html
    }

    
// -------------------------------------------------------------------------------------------------------
// --------------------------------------------- Programmes Lucas ----------------------------------------
// --------------------------------------------- Ligne 430 à 560 -----------------------------------------
// -------------------------------------------------------------------------------------------------------
    
    /**Ajoute pfMat dans pfArchive
     * @param pfMat IN : Matrice que l'on souhaite ajouter
     * @param pfArchive IN/OUT : Archive dans laquelle on ajoute pfMat
     * @author Lucas Costagliola
     */
    public static void add(MatriceEntier pfMat, Liste pfArchive){

        //transformation de pfMat en String
        String matString = toStr(pfMat);

        //ajout de matString dans l'archive
        pfArchive.gen++;
        pfArchive.historique[pfArchive.gen] = matString;

    }

    
    /**Renvoie true si pfMat est partout à 0 partout ou si elle existe déjà dans pfArchive, sinon false
     * @param pfMat IN : Matrice dont on souhaite vérifier l'existence
     * @param pfArchive IN : Archive dans laquelle on cherche
     * @return si pfMat existe déjà dans pfArchive
     * @author Lucas Costagliola
     */
    public static boolean check(MatriceEntier pfMat, Liste pfArchive) {
        // Transformation de pfMat en String
        String matString = toStr(pfMat);
        boolean estVide = true;

        // Verification si la matrice est partout à 0 
        for (int i = 0; i < pfMat.nbL; i++) {
            for (int j = 0; j < pfMat.nbC; j++) {
                if (pfMat.tabMat[i][j] == 1) {
                    estVide = false;
                    break;
                } 
            }
            
        }
        if(estVide){
            System.out.println("La matrice est vide, la partie est perdue");
            return true; // La matrice est partout à 0
        }

        
        // Vérification de l'existence de la matrice dans pfArchive
        for (int i = 0; i <= pfArchive.gen; i++) {
            if (pfArchive.historique[i].equals(matString)) {
                System.out.println("Les générations tournent en boucle, la partie est gagnée"); // Affiche un message si la matrice est déjà dans l'archive
                return true; // La matrice existe déjà
            }
        }
    
        return false; // La matrice n'est pas dans l'archive et n'est pas partout à 0
    }
    



    /**
     * Transforme pfMatrice en String
     * @param pfMatrice : Matrice que l'on souhaite transformer
     * @return le String de la matrice
     * @author Lucas Costagliola
     */
    public static String toStr(MatriceEntier pfMatrice){
        String string = "";
        for (int i = 0; i < pfMatrice.nbL; i++) {
            for (int j = 0; j < pfMatrice.nbC; j++) {
                string = string+pfMatrice.tabMat[i][j];
            }
        }
        return string;
    }


     /**Transforme le String pfMat en String html
     * @param pfMat IN : matrice à transformer
     * @param pfNbL IN : nombre de lignes de pfMat
     * @param pfNbC IN : nombre de colonnes de pfMat
     * @param pfGen IN : numéro de génération
     * @return le String html 
     * @author Lucas Costagliola
     */
    public static String toHtml(String pfMat, int pfNbL, int pfNbC, int pfGen ){

        String ln = System.getProperty("line.separator") ;

        String html = "<table border=\"1\"><caption>Generation "+pfGen+"</caption>";
        html += ln;

        int cpt=0;

        //Parcours du String pfMat
        for (int i = 0 ; i<pfNbL ; i++){
            //Debut d'une ligne
            html += "<tr>";

            for (int j = 0 ; j<pfNbC ; j++){
                //si le caractère est 1, on ajoute class='on'
                if ( pfMat.charAt(cpt) == '1' ){
                    html += "<td class='on'></td>";
                }
                //sinon on le laisse vide
                else {
                    html += "<td></td>";
                }
                cpt ++;
            }

            //Fin d'une ligne
            html += "</tr>";
            html += ln;
        }
        html += "</table>";

        return html;
    }


    /**
     * Génère une matrice d'entiers initialisée à 0 et permet à l'utilisateur de configurer les éléments de la matrice.
     * @param pfMatrice IN/OUT : matrice à initialiser et configurer
     * @return la matrice configurée par l'utilisateur
     * @throws Exception en cas d'erreur inattendue
     * @author Lucas Costagliola
     */
    public static void genMatriceZero(MatriceEntier pfMatrice) throws Exception {

        Scanner lecteur = new Scanner(System.in);
        
    
        System.out.println("Nous allons la configurer !");
        int element = 0;
        boolean matriceGenere = true;
    
        while (matriceGenere) { 
            for (int i = 0; i < pfMatrice.nbL; i++) {
                for (int j = 0; j < pfMatrice.nbC; j++) {
                    try {
                        System.out.println("Que voulez-vous mettre ici : 1 pour vivante ou 0 pour morte");
                        afficheMatElem(pfMatrice, i, j);
    
                        if (lecteur.hasNextInt()) {
                            element = lecteur.nextInt();
                            lecteur.nextLine(); // vide le buffer
                        } else {
                            throw new IllegalArgumentException("Entrée invalide. Veuillez saisir un entier.");
                        }
    
                        if (element != 0 && element != 1) {
                            j--;
                            throw new IllegalArgumentException("Les cellules doivent être des entiers = {0,1}.");
                        }
    
                        pfMatrice.tabMat[i][j] = element;
    
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        j--;
                        System.out.println("Entrée invalide. Veuillez réessayer.");
                        lecteur.nextLine(); // vide le buffer
                    }
                }
            }
            matriceGenere = false;
        }

        lecteur.close();

    }
    

// --------------------------------------------------------------------------------------------------------
// ------------------------------------------- Code étudiant 17 -------------------------------------------
// --------------------------------------------------------------------------------------------------------
    
    /**
     * Affiche la matrice avec un élément spécifique en surbrillance.
     * @param pfMatrice IN : matrice à afficher
     * @param pfL IN : indice de la ligne de l'élément à surligner
     * @param pfC IN : indice de la colonne de l'élément à surligner
     */
    public static void afficheMatElem(MatriceEntier pfMatrice, int pfL, int pfC) {

        String ln = System.getProperty("line.separator");
        String chaine = "";

        for (int i = 0; i < pfMatrice.nbL; i++) {
            for (int j = 0; j < pfMatrice.nbC; j++) {
                if (i == pfL && j == pfC) {
                    chaine += RED + pfMatrice.tabMat[i][j] + RESET + " ";
                } else {
                    chaine += pfMatrice.tabMat[i][j] + " ";
                }
            }
            chaine+= ln;
        }

        System.out.println(chaine);

    }



    /**
     * Permet de connaître le nombre de lignes d'une matrice
     * @param pfMatrice : Matrice à altérer
     * @return Nombres de lignes de la matrice
     */
    public static int getNbLignes(MatriceEntier pfMatrice){
        return pfMatrice.nbL;
    }

    /**
     * Permet de connaître le nombre de colonnes d'une matrice
     * @param pfMatrice : Matrice à altérer
     * @return Nombres de colonnes de la matrice
     */
    public static int getNbColonnes(MatriceEntier pfMatrice){
        return pfMatrice.nbC;
    }

    /**
     * Permet de trouver l'élément à une coordonnée
     * @param pfMatrice : Matrice à altérer
     * @param pfIndiceL : Nombre de lignes de la matrice
     * @param pfIndiceC : Nombre de colonnes de la matrice
     * @return Élément aux coordonnées [pfIndiceL;pfIndiceC]
     * @throws Exception : Retourne une erreur si l'indice fournit est en dehors des bornes
     */
    public static int getElement(MatriceEntier pfMatrice, int pfIndiceL, int pfIndiceC)throws Exception{
        if(pfIndiceL<0 || pfIndiceL> pfMatrice.nbL || pfIndiceC<0 || pfIndiceL> pfMatrice.nbC)throw new Exception("Les arguments doivent êtres positifs et inférieur au nombre maximal de lignes/colonnes de la matrice !");
        return pfMatrice.tabMat[pfIndiceL][pfIndiceC];
    }

    /**
     * Ajoute les éléments d'une ligne d'une matrice et retourne la somme
     * @param pfMatrice : Matrice à altérer
     * @param pfIndiceL : Ligne souhaitée de la matrice
     * @return Somme des valeurs de la ligne
     * @throws Exception : Retourne une erreur si l'indice fournit est en dehors des bornes
     */
    public static int somLigne(MatriceEntier pfMatrice, int pfIndiceL)throws Exception{
        if(pfIndiceL < 0 || pfIndiceL >= pfMatrice.nbL)throw new Exception("L'indice doit être compris entre 0 et le nombre maximal de lignes de la matrice !");
        int sommeL = 0;
        for(int i = 0 ; i < pfMatrice.nbC ; i++){
            sommeL += pfMatrice.tabMat[pfIndiceL][i];
        }
        return sommeL;
    }

    /**
     * Ajoute les éléments d'une colonne d'une matrice et retourne la somme
     * @param pfMatrice : Matrice à altérer
     * @param pfIndiceC : Colonne souhaitée de la matrice
     * @return Somme des valeurs de la colonne
     * @throws Exception : Retourne une erreur si l'indice fournit est en dehors des bornes
     */
    public static int somColonne(MatriceEntier pfMatrice, int pfIndiceC)throws Exception{
        if(pfIndiceC < 0 || pfIndiceC >= pfMatrice.nbC)throw new Exception("L'indice doit être compris entre 0 et le nombre maximal de colonnes de la matrice !");
        int sommeC = 0;
        for(int i = 0 ; i < pfMatrice.nbL ; i++){
            sommeC += pfMatrice.tabMat[i][pfIndiceC];
        }
        return sommeC;
    }

    /**
     * Permet de savoir si une matrice est carrée
     * @param pfMatrice : Matrice qui peut être carrée?
     * @return vrai si la matrice est carrée, faux si elle ne l'est pas
     */
    public static boolean estCarree(MatriceEntier pfMatrice){
        return(pfMatrice.nbC== pfMatrice.nbL);
    }

    /**
     * Permet de savoir si une matrice est diagonale
     * @param pfMatrice : Matrice qui peut être diagonale?
     * @return vrai si la matrice est diagonale, faux si elle ne l'est pas
     * @throws Exception : Retourne une erreur si la matrice n'est pas carrée
     */
    public static boolean estDiagonale(MatriceEntier pfMatrice)throws Exception{
        if(!(pfMatrice.nbC== pfMatrice.nbL))throw new Exception("La matrice doit être carrée !");
        for(int i = 0 ; i < pfMatrice.nbL ; i++){
            for(int j = 0 ; j < pfMatrice.nbC ; j++){
                if(i!=j){
                    if(pfMatrice.tabMat[i][j]!=0)return false;
                }
            }
        }
        return true;
    }

    /**
     * Permet d'altérer un élément d'une matrice à des coordonnées données
     * @param pfMatrice : Matrice à altérer
     * @param pfIndiceL : Coordonnées de l'élément à remplacer
     * @param pfIndiceC : Coordonnées de l'élément à remplacer
     * @param pfElement : Élément à intégrer
     */
    public static void setElement(MatriceEntier pfMatrice, int pfIndiceL, int pfIndiceC, int pfElement){
        pfMatrice.tabMat[pfIndiceL][pfIndiceC]=pfElement;
    }

    /**
     * Défini les valeurs de la diagonale [0;0] de la matrice
     * @param pfMatrice : Matrice à altérer
     * @param pfElement : Élément à intégrer
     * @throws Exception : Retourne une erreur si la matrice n'est pas carrée
     */
    public static void setPremiereDiagonale(MatriceEntier pfMatrice, int pfElement)throws Exception{
        if(!(pfMatrice.nbC== pfMatrice.nbL))throw new Exception("La matrice n'est pas carrée !");
        for(int i = 0 ; i < pfMatrice.nbL ; i++){
            pfMatrice.tabMat[i][i] = pfElement;
        }
    }

    /**
     * Défini les valeurs de la diagonale [0;1] de la matrice
     * @param pfMatrice : Matrice à altérer
     * @param pfElement : Élément à intégrer
     * @throws Exception : Retourne une erreur si la matrice n'est pas carrée
     */
    public static void setSecondeDiagonale(MatriceEntier pfMatrice, int pfElement)throws Exception{
        if(!(pfMatrice.nbC== pfMatrice.nbL))throw new Exception("La matrice n'est pas carrée !");
        for(int i = 0 ; i < pfMatrice.nbL ; i++){
            pfMatrice.tabMat[i][pfMatrice.nbC-i-1] = pfElement;
        }
    }

    /**
     * Multiplie les valeurs de la matrice par un facteur
     * @param pfMatrice : Matrice à altérer
     * @param pfFacteur : Facteur de multiplication
     */
    public static void mulMatNombre(MatriceEntier pfMatrice, int pfFacteur){
        for(int i = 0 ; i < pfMatrice.nbL ; i++){
            for(int j = 0 ; j < pfMatrice.nbC ; j++){
                pfMatrice.tabMat[i][j] *= pfFacteur;
            }
        }
    }

    /**
     * Fabrique une représentation graphique de la matrice
     * @param pfMatrice : Matrice que l'on souhaite afficher
     * @return Graphique de la matrice
     */
    public static String toString(MatriceEntier pfMatrice){
        String ln = System.getProperty("line.separator") ;
        String chaine = "";

        for (int i = 0; i < pfMatrice.nbL; i++) {
            for (int j = 0; j < pfMatrice.nbC; j++) {
                chaine += pfMatrice.tabMat[i][j] + " ";
            }
            chaine += ln;
        }
        return chaine;
    }

    /**
     * Fabrique une représentation graphique de la matrice sous format HTML
     * @param pfMatrice : Matrice que l'on souhaite afficher
     * @return Graphique HTML de la matrice
     */
    public static String toHTML(MatriceEntier pfMatrice){
        String ln = System.getProperty("line.separator") ;
        String html = "";

        html += "<table border=\"1\">" + ln;
        for (int i = 0; i < pfMatrice.nbL; i++) {
            html += "<tr>";
            for (int j = 0; j < pfMatrice.nbC; j++) {
                html += "<td>";
                html += pfMatrice.tabMat[i][j];
                html += "</td>";
            }
            html += "</tr>";
            html += ln;
        }
        html += "</table>";
        return html;
    }


}
