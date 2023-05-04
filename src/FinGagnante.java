/* Toute cette partie est du bonus */

public class FinGagnante {
    private double x;
    private double y; 
    public FinGagnante(double x, double y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X du message 
        this.y=y; // la position Y du message 
        // la position X,Y indique le coin en bas à gauche du message 
    }
    public double getX() { // retourne la position X du message
        return this.x;
    }
    public double getY() { // retourne la position Y du message
        return this.y;
    }
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le message à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.x, (int)this.y-0, "+-----------------------------+");
        ec.ajouteChaine((int)this.x, (int)this.y-1, "|      VOUS AVEZ GAGNE        |");
        ec.ajouteChaine((int)this.x, (int)this.y-2, "|         LA PARTIE !         |");
        ec.ajouteChaine((int)this.x, (int)this.y-3, "|                             |");
        ec.ajouteChaine((int)this.x, (int)this.y-4, "|     ATTENDEZ QUELQUES       |");
        ec.ajouteChaine((int)this.x, (int)this.y-5, "|   SECONDES AVANT QUE LE     |");
        ec.ajouteChaine((int)this.x, (int)this.y-6, "|      JEU RECOMMENCE ...     |");
        ec.ajouteChaine((int)this.x, (int)this.y-7, "+-----------------------------+");
        return ec;
    }
}