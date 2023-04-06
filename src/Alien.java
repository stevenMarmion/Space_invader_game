public class Alien {
    private double posX;
    private int posY;
    private boolean estTouche;
    public Alien(double x, int y) {
        this.posX=x;
        this.posY=y;
        this.estTouche=false;
    }
    public double getX() {
        return this.posX;
    }
    public int getY() {
        return this.posY;
    }
    public void evolue(boolean descendre, boolean droite, boolean gauche) {
        if (descendre==true && droite==false && gauche==false) {
            this.posY-=1;
        }
        if (descendre==false && droite==false && gauche==true) {
            this.posX-=0.1;
        }
        if(descendre==false && droite==true && gauche==false) {
            this.posX+=0.1;
        }
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX,this.posY+6,"                 ");
        ec.ajouteChaine((int)this.posX,this.posY+5,"     ▀▄   ▄▀     ");
        ec.ajouteChaine((int)this.posX,this.posY+4,"    ▄█▀███▀█▄    ");
        ec.ajouteChaine((int)this.posX,this.posY+3,"   █▀███████▀█   ");
        ec.ajouteChaine((int)this.posX,this.posY+2,"   █ █▀▀▀▀▀█ █   ");
        ec.ajouteChaine((int)this.posX,this.posY+1,"      ▀▀ ▀▀      ");
        ec.ajouteChaine((int)this.posX,this.posY+0,"                 ");
        return ec;
    }
    public boolean contient(int posx, int posy){
        if (posx >= this.posX && posx <= this.posX+17 && posy >= this.posY && posy <= this.posY+6) {
            return true;
        }
        return false;
    }
    public void estTouche() {
        this.estTouche=true;
    }
    public boolean getEstTouche() {
        return this.estTouche;
    }
}