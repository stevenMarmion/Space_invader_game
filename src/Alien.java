public class Alien {
    private double posX;
    private int posY;
    private boolean estTouche;
    private boolean changeDessin;
    public Alien(double x, int y) {
        this.posX=x;
        this.posY=y;
        this.estTouche=false;
        this.changeDessin=false;
    }
    public double getX() {
        return this.posX;
    }
    public int getY() {
        return this.posY;
    }
    public void evolue(double x, double y) {
        this.posX+=x;
        this.posY+=y;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        if (this.changeDessin==false) {
            ec.ajouteChaine((int)this.posX,this.posY+6,"                 ");
            ec.ajouteChaine((int)this.posX,this.posY+5,"     ▀▄   ▄▀     ");
            ec.ajouteChaine((int)this.posX,this.posY+4,"    ▄█▀███▀█▄    ");
            ec.ajouteChaine((int)this.posX,this.posY+3,"   █▀███████▀█   ");
            ec.ajouteChaine((int)this.posX,this.posY+2,"   █ █▀▀▀▀▀█ █   ");
            ec.ajouteChaine((int)this.posX,this.posY+1,"      ▀▀ ▀▀      ");
            ec.ajouteChaine((int)this.posX,this.posY+0,"                 ");
            return ec;
        }
        if (this.changeDessin==true) {
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
    public void changeDessin() {
        if (this.changeDessin==false) {
            this.changeDessin=true;
        }   
        else if (this.changeDessin==true) {
            this.changeDessin=false;
        }
    }
}