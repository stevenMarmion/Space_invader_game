/* Toute cette partie est du bonus de graphisme */

public class PlaneteLambda implements Planete {
    private double x;
    private double y;
    public PlaneteLambda(double x, double y) {
        this.x=x;
        this.y=y;
    }
    @Override
    public double getX() {
        return this.x;
    }
    @Override
    public double getY() {
        return this.y;
    }
    @Override
    public EnsembleChaines getEnsembleChaines() {
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
        this.y+=0.1;
        this.x+=0.1;
    }
}