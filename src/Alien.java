public class Alien {
    private double posX;
    private int posY;
    private boolean estTouche;
    private boolean changeDessin;
    private int cpt;
    public Alien(double x, int y) { 
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.posX=x; // la position X
        this.posY=y; // la position Y
        // la position X,Y indique le coin en bas à gauche de l'alien
        this.estTouche=false; // si l'alien est touché ou non
        this.changeDessin=false; // si l'on change de dessin ou non 
        this.cpt=0; // initie un compteur pour un des méthodes dans le classe
    }
    public double getX() { // retourne la position X de l'alien
        return this.posX;
    }
    public int getY() { // retourne la position Y de l'alien 
        return this.posY;
    }
    public int getCpt() { // retourne la valeur acuelle du compteur
        return this.cpt;
    }
    public void evolue(double pasX) {
        /** fait évoluer l'alien plus ou moins rapidement en fonction de la valeur du paramètre pasX */
        if (pasX==0.1) {
            if (this.cpt < 500) { // fait avancer l'alien en abscisse de 0.1 case jusqu'à que la valeur du compteur soit à 499
                this.posX+=pasX;
            }
            else if (this.cpt==500) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 500
                this.posY-=1;
            }
            else if (this.cpt < 1000) { // fait reculer l'alien en abscisse de 0.1 jusqu'à que la valeur du compteur soit à 999
                this.posX-=pasX;
            }
            else if (this.cpt==1000) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 1000
                this.posY-=1;
            }
            else {
                this.cpt=0; // remet le compteur à 0 si le compteur dépasse 1000
            }
            this.cpt+=1; // incrémente le compteur
        }
        if (pasX==0.2) {
            if (this.cpt < 250) { // fait avancer l'alien en abscisse de 0.2 case jusqu'à que la valeur du compteur soit à 249
                this.posX+=pasX;
            }
            else if (this.cpt==250) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 250
                this.posY-=1;
            }
            else if (this.cpt < 500) { // fait reculer l'alien en abscisse de 0.2 jusqu'à que la valeur du compteur soit à 499
                this.posX-=pasX;
            }
            else if (this.cpt==500) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 500
                this.posY-=1;
            }
            else {
                this.cpt=0; // remet le compteur à 0 si le compteur dépasse 500
            }
            this.cpt+=1; // incrémente le compteur
        }
        if (pasX==0.4) {
            if (this.cpt < 125) { // fait avancer l'alien en abscisse de 0.4 case jusqu'à que la valeur du compteur soit à 124
                this.posX+=pasX;
            }
            else if (this.cpt==125) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 125
                this.posY-=1;
            }
            else if (this.cpt < 250) { // fait reculer l'alien en abscisse de 0.4 case jusqu'à que la valeur du compteur soit à 249
                this.posX-=pasX;
            }
            else if (this.cpt==250) { // fait descendre l'alien de 1 case en ordonnée si le compteur est à 250
                this.posY-=1;
            }
            else {
                this.cpt=0;  // remet le compteur à 0 si le compteur dépasse 250
            }
            this.cpt+=1; // incrémente le compteur
        }
        
    }
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le dessin de l'alien à afficher */
        EnsembleChaines ec= new EnsembleChaines(); // Instancie un élement de type EnsembleChaine 
        if (this.changeDessin==false) { // regarde si l'attribut de changeDessin est à true ou false
            // Indique le dessin de l'alien si l'attribut est à false
            ec.ajouteChaine((int)this.posX,this.posY+6,"                 ");
            ec.ajouteChaine((int)this.posX,this.posY+5,"     ▀▄   ▄▀     ");
            ec.ajouteChaine((int)this.posX,this.posY+4,"    ▄█▀███▀█▄    ");
            ec.ajouteChaine((int)this.posX,this.posY+3,"   █▀███████▀█   ");
            ec.ajouteChaine((int)this.posX,this.posY+2,"   █ █▀▀▀▀▀█ █   ");
            ec.ajouteChaine((int)this.posX,this.posY+1,"      ▀▀ ▀▀      ");
            ec.ajouteChaine((int)this.posX,this.posY+0,"                 ");
            return ec;
        }
        if (this.changeDessin==true) { // regarde si l'attribut de changeDessin est à true ou false
            // indique le dessin de l'alien si l'attribut est à true
            ec.ajouteChaine((int)this.posX,this.posY+6,"                 ");
            ec.ajouteChaine((int)this.posX,this.posY+5,"      ▀▄   ▄▀    ");
            ec.ajouteChaine((int)this.posX,this.posY+4,"    ▄█▀███▀█▄    ");
            ec.ajouteChaine((int)this.posX,this.posY+3,"   █▀███████▀█   ");
            ec.ajouteChaine((int)this.posX,this.posY+2,"   █ █▀▀▀▀▀█ █   ");
            ec.ajouteChaine((int)this.posX,this.posY+1,"    ▀▀     ▀▀    ");
            ec.ajouteChaine((int)this.posX,this.posY+0,"                 ");
            return ec;
        }
        return ec;
    }
    public boolean contient(int posx, int posy){
        /** renvoie true ou false en fonction des paramètres de la fonction */
        if (posx >= this.posX && posx <= this.posX+17 && posy >= this.posY && posy <= this.posY+6) {
            // Vérifie si les paramètres de la fonction ( les positions X et Y ) sont contenues dans les superficie prise par l'alien dans la fenêtre
            return true;
        }
        return false;
    }
    public void estTouche() { // change de valeur booléenne l'attribut estTouche
        this.estTouche=true;
    }
    public boolean getEstTouche() { // retourne l'état de l'attribut estTouche
        return this.estTouche;
    }
    public void changeDessin() { 
        // change la valeur de l'attribut en fonction de l'état actuelle de l'attribut estTouche ( permet de changer le dessin de l'alien )
        if (this.changeDessin==false) {
            this.changeDessin=true;
        }   
        else if (this.changeDessin==true) {
            this.changeDessin=false;
        }
    }
}