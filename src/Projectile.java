public class Projectile {
    private double positionX;
    private double positionY;
    public Projectile(double x, double y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.positionX=x; // la position X du projectile
        this.positionY=y; // la position Y du projectile
        // la position X,Y indique le coin en bas à gauche de l'affichage du projectile
    }
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le dessin du projectile à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.positionX, (int)this.positionY, "●");
        return ec;
    }
    public void evolue() {
        // indique la valeur d'évolution du projectile ( fait avancer l'étoile en Y de 0.2 case ) 
        this.positionY+=0.2;
    }
    public double getPosX() { // retourne la position X du projectile
        return this.positionX;
    }
    public double getPosY() { // retourne la position Y du projectile 
        return this.positionY;
    }
} 