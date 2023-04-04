/* Toute cette partie est du bonus */

public class Amorce {
    private double x;
    private double y; 
    public Amorce(double x, double y) {
        this.x=x;
        this.y=y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.x, (int)this.y-0, "+-----------------------------+");
        ec.ajouteChaine((int)this.x, (int)this.y-1, "|  BIENVENU DANS L'UNIVERS DE |");
        ec.ajouteChaine((int)this.x, (int)this.y-2, "|        SPACE INVADER        |");
        ec.ajouteChaine((int)this.x, (int)this.y-3, "+-----------------------------+");
        return ec;
    }
    public void evolue() {
        this.x-=0.3;
    }
}