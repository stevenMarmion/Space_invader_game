public class Niveau {
    private int x;
    private int y;
    private int niveau;
    public Niveau(int x, int y) {
        this.x=x;
        this.y=y;
        this.niveau=0;
    }
    public void ajouteNiveau(int i) {
        this.niveau+=1;
    }
    public int getNiveau() {
        return this.niveau;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(this.x, this.y, this.toString());
        return ec;
    }
    @Override
    public String toString() {
        return "Niveau : "+ this.getNiveau();
    }
}
