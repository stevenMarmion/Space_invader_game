public class Vaisseau {
    private double posX;
    public Vaisseau(int x) {
        this.posX=x;
    }
    public void deplace(double dx) {
        this.posX+=dx;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(1,3,"####");
        ec.ajouteChaine(5,2,"°°");
        ec.ajouteChaine(1,1,"uu");
        ec.ajouteChaine(0,0,"--|||--");
        return ec;
    }
    public double getPositionCanon() {
        return this.posX;
    }
}