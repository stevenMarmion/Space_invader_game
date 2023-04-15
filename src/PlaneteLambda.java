/* Toute cette partie est du bonus de graphisme */

public class PlaneteLambda implements Planete {
    private double x;
    private double y;
    public PlaneteLambda(double x, double y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X de la planète à afficher
        this.y=y; // la position Y de la planète à afficher
        // la position X,Y indique le coin en bas à gauche de l'affichage de la planète
    }
    @Override
    public double getX() { // retourne la position X de la planète
        return this.x;
    }
    @Override
    public double getY() { // retourne la position Y de la planète
        return this.y;
    }
    @Override
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le dessin de la planète à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.x,(int)this.y+6,"▪     ▄▄▄▄▄▄    ▪ ");
        ec.ajouteChaine((int)this.x,(int)this.y+5,"   ▪▄████████▄    ");
        ec.ajouteChaine((int)this.x,(int)this.y+4,"  ▄████████████▄  ");
        ec.ajouteChaine((int)this.x,(int)this.y+3," ████████████████ ");
        ec.ajouteChaine((int)this.x,(int)this.y+2,"  ▀████████████▀ ▪");
        ec.ajouteChaine((int)this.x,(int)this.y+1,"▪   ▀████████▀    ");
        ec.ajouteChaine((int)this.x,(int)this.y+0,"      ▀▀▀▀▀▀   ▪  ");
        return ec;
    }
    @Override
    public void evolue() {
        // indique la valeur d'évolution de la planète ( fait avancer la planète en Y et X de 0.1 case ) 
        this.y+=0.1;
        this.x+=0.1;
    }
}