public class Balle {
    private int posX;
    private int posY;
    public Balle(int x, int y) {
        this.posX=x;
        this.posY=y;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine((int)this.posX, (int)this.posY, "|");
        return ec;
    }
    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }
}
