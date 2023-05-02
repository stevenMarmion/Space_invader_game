public class Score {
    private int x;
    private int y;
    private int score;
    public Score(int x, int y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X du score à afficher
        this.y=y; // la position Y du score à afficher
        this.score=0; // la valeur actuelle du score
        // la position X,Y indique le coin en bas à gauche de l'affichage du nscore
    }
    public void ajoute(int i) { // Incrémente de 1 le score
        this.score+=i;
    }
    public int getScore() { // retourne la valeur actuelle du score
        return this.score;
    }
    public EnsembleChaines getEnsembleChaines() {
         /** Renvoie le message à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(this.x, this.y, this.toString());
        return ec;
    }
    @Override
    public String toString() { // renvoie la chaine de caractères "Score :" et sa valeur actuelle
        return "Score : "+ this.getScore();
    }
}