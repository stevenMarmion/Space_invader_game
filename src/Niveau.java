public class Niveau {
    private int x;
    private int y;
    private int niveau;
    public Niveau(int x, int y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X du message à afficher
        this.y=y; // la position Y du message à afficher
        this.niveau=1; // la valeur actuelle du niveau
        // la position X,Y indique le coin en bas à gauche de l'affichage du niveau
    }
    public void ajouteNiveau(int i) {
        /** Incrémente le niveau de 1 */
        this.niveau+=1;
    }
    public int getNiveau() { // retourne la valeur actuelle du niveau 
        return this.niveau;
    }
    public void resetNiveau() {
        this.niveau=1;
    }
    public EnsembleChaines getEnsembleChaines() {
        /** Renvoie le message à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(this.x, this.y, this.toString());
        return ec;
    }
    @Override
    public String toString() { // renvoie la chaine de caractères "Niveau :" et sa valeur actuelle
        return "Niveau : "+ this.getNiveau();
    }
}
