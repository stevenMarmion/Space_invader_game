public class Projectile {
    private double positionX;
    private double positionY;
    public Projectile(double x, double y) {
        this.positionX=x;
        this.positionY=y;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.positionX, (int)this.positionY, "●");
        return ec;
    }
    public void evolue() {
        this.positionY+=0.2;
    }
    public double getPosX() {
        return this.positionX;
    }
    public double getPosY() {
        return this.positionY;
    }
} 