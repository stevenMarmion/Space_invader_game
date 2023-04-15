/* Toute cette partie est du bonus */

public class Amorce {
    private double x;
    private double y; 
    public Amorce(double x, double y) {
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
        ec.ajouteChaine((int)this.x, (int)this.y-1, "|  BIENVENU DANS L'UNIVERS DE |");
        ec.ajouteChaine((int)this.x, (int)this.y-2, "|        SPACE INVADER        |");
        ec.ajouteChaine((int)this.x, (int)this.y-3, "+-----------------------------+");
        return ec;
    }
    public void evolue() { 
        // indique la valeur d'évolution du message ( fait reculer le message en X de 0.6 case ) 
        this.x-=0.6;
    }
}