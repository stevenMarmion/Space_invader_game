/* Toute cette partie est du bonus */

public class Etoile {
    private double posX;
    private double posY;
    public Etoile(double x, double y) {
        this.posX=x;
        this.posY=y;
    }
    public double getX() {
        return this.posX;
    }
    public double getY() {
        return this.posY;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX, (int)this.posY, "|");
        return ec;
    }
    public void evolue() {
        this.posY+=0.1;
    }
}
