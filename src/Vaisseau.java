public class Vaisseau {
    private double posX;
    public Vaisseau(int x) {
        /** Dans ce constructeur, j'instancie la position X du vaisseau */
        this.posX=x;
    }
    public void deplace(double dx) { 
        // indique la valeur de déplacement du vaisseau ( fait avancer le vaisseau en X de la valeur passée en paramètre ) 
        this.posX+=dx;
    }
    public EnsembleChaines getEnsembleChaines() {
         /** Renvoie le dessin du vaisseau à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX,6,"                 ");
        ec.ajouteChaine((int)this.posX,5,"        ▄        ");
        ec.ajouteChaine((int)this.posX,4,"       ███       ");
        ec.ajouteChaine((int)this.posX,3,"  ▄███████████▄  ");
        ec.ajouteChaine((int)this.posX,2,"  █████████████  ");
        ec.ajouteChaine((int)this.posX,1,"  █████████████  ");
        ec.ajouteChaine((int)this.posX,0,"                 ");
        return ec;
    }
    public double getPositionCanon() {
        /** Renvoie la position X du canon du vaisseau */
        return this.posX+8;
    }
    public double getX() {
        /** retourne la position X du vaisseau ( renvoie la valeur tout à gauche du dessin ) */
        return this.posX;
    }
    public boolean contient(int posx, int posy){
        /** renvoie true ou false en fonction des paramètres de la fonction */
        if (posx >= this.posX && posx <= this.posX+17 && posy >= 0 && posy <= 5) {
            // Vérifie si les paramètres de la fonction ( les positions X et Y ) sont contenues dans les superficie prise par le vaisseau dans la fenêtre
            return true;
        }
        return false;
    }
}