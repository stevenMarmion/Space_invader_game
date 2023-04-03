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
        ec.ajouteChaine((int)this.posX,6,"░░░░░░░░░░░░░░░░░");
        ec.ajouteChaine((int)this.posX,5,"░░░░░░░░▄░░░░░░░░");
        ec.ajouteChaine((int)this.posX,4,"░░░░░░░███░░░░░░░");
        ec.ajouteChaine((int)this.posX,3,"░░▄███████████▄░░");
        ec.ajouteChaine((int)this.posX,2,"░░█████████████░░");
        ec.ajouteChaine((int)this.posX,1,"░░█████████████░░");
        ec.ajouteChaine((int)this.posX,0,"░░░░░░░░░░░░░░░░░");
        return ec;
    }
    public double getPositionCanon() {
        return this.posX+8;
    }
}