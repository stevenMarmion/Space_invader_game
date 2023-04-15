/* Toute cette partie est du bonus de graphisme */

public class Asteroide implements Planete {
    private double x;
    private double y;
    public Asteroide(double x, double y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X de l'asteroide
        this.y=y; // la position Y de l'asteroide
        // la position X,Y indique le coin en bas à gauche de l'asteroide
    }
    @Override
    public double getX() { // retourne la position X de l'asteroide
        return this.x;
    }
    @Override
    public double getY() { // retourne la position Y de l'asteroide
        return this.y;
    }
    @Override
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le dessin de l'asteroide à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.x,(int)this.y+6,"  ▪   ▄▄▄▄▄▄      ");
        ec.ajouteChaine((int)this.x,(int)this.y+5,"    ▄▒▒▒▒▓▒▓█▄  ▪ ");
        ec.ajouteChaine((int)this.x,(int)this.y+4,"  ▄████████████▄  ");
        ec.ajouteChaine((int)this.x,(int)this.y+3," ██████▒▓▓▓▓▓▓███ ");
        ec.ajouteChaine((int)this.x,(int)this.y+2,"  ▀▒▒▒▒▓▓▒█████▀  ");
        ec.ajouteChaine((int)this.x,(int)this.y+1,"▪   ▀█▒▒▒▒▓▒▓▀  ▪ ");
        ec.ajouteChaine((int)this.x,(int)this.y+0,"   ▪  ▀▀▀▀▀▀      ");
        return ec;
    }
    @Override
    public void evolue() {
        // indique la valeur d'évolution de l'asteroide ( fait avancer l'asteroide en Y de 0.4 case ) 
        this.y+=0.4;
    }
}