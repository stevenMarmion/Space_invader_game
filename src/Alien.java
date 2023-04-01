public class Alien {
    private double posX;
    private int posY;
    public Alien(double x, int y) {
        this.posX=x;
        this.posY=y;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX,this.posY,"   ',,'   ");
        ec.ajouteChaine((int)this.posX,this.posY-1," --°--°-- ");
        ec.ajouteChaine((int)this.posX,this.posY-2,"|--------|");
        ec.ajouteChaine((int)this.posX,this.posY-3,"| ------ |");
        ec.ajouteChaine((int)this.posX,this.posY-4,"    --    ");
        return ec;
    }
    public void evolue() {
        for (int i=0;i<100;++i) {
            this.posX+=0.1;
        }
        this.posY-=1;
        for (int i=0;i<100;++i) {
            this.posX-=0.1;
        }
        this.posY-=1;
    }
    public boolean contient(int posx, int posy){
        if (posx >this.posX && posy >= this.posY-4 && posy <=this.posY && posx <= this.posX + this.posY+11)
            return true;
        return false;
    }
}