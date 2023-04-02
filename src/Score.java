public class Score {
    private int score;
    public Score() {
        this.score=0;
    }
    public void ajoute(int i) {
        this.score+=1;
    }
    public int getScore() {
        return this.score;
    }
}