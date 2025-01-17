/**
 * Cette classe gère l'archivage des différentes générations dans le jeu de la vie.
 * @author  Lucas Costagliola
 */
public class Liste{
    String[] historique;
    int gen;

    Liste(){
        this.gen = -1;
        this.historique = new String[10];
    }
}
