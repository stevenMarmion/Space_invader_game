public class Score {
    private int x;
    private int y;
    private int score;
    public Score(int x, int y) {
        this.x=x;
        this.y=y;
        this.score=0;
    }
    public void ajoute(int i) {
        this.score+=1;
    }
    public int getScore() {
        return this.score;
    }
    public EnsembleChaines getEnsembleChaines() {
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(this.x, this.y, this.toString());
        return ec;
    }
    @Override
    public String toString() {
        return "Score : "+ this.getScore();
    }
}