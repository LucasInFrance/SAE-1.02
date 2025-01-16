
/**
 * Indiquer le ou les numeros de TP et d'exercice.
 *
 * @author (votre nom)
 */
public class MatriceEntier
{
    int nbL;
    int nbC;
    int tabMat[][];
    MatriceEntier()throws Exception{
        throw new Exception ("Il n'y a pas de paramètre");
    }
    MatriceEntier (int pfLigne, int pfColonne)throws Exception{
        if (pfLigne <= 0 || pfColonne <= 0){
            throw new Exception ("Le nombre de ligne et de colonne doit être superieur à 0");
        }
        this.nbL = pfLigne;
        this.nbC = pfColonne;
        this.tabMat = new int [pfLigne][pfColonne];
        for(int i=0;i<pfLigne;i++){
            for(int j=0;j<pfColonne;j++){
            this.tabMat[i][j]=0;
            }
        }
    }
}

