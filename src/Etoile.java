/* Toute cette partie est du bonus */

public class Etoile {
    private double posX;
    private double posY;
    public Etoile(double x, double y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.posX=x; // la position X de l'étoile 
        this.posY=y; // la position Y de l'étoile 
    }
    public double getX() { // retourne la position X de l'étoile
        return this.posX;
    }
    public double getY() { // retourne la position Y de l'étoile 
        return this.posY;
    }
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le dessin de l'étoile à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX, (int)this.posY, "✦");
        return ec;
    }
    public void evolue() { 
        // indique la valeur d'évolution de l'étoile ( fait avancer l'étoile en Y de 0.1 case ) 
        this.posY+=0.1;
    }
    public void remetXZero() { 
        // réinitialise la position Y de l'étoile en 0
        this.posY=0.0;
    }
}
