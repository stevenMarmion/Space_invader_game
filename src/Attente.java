public class Attente {
    private int x;
    private int y;
    private int attente;
    public Attente(int x, int y) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        this.x=x; // la position X de l'attente à afficher
        this.y=y; // la position Y de l'attente à afficher
        this.attente=500; // la valeur actuelle de l'attente
        // la position X,Y indique le coin en bas à gauche de l'affichage de l'attente
    }
    public void decremente(int i) { // Décrémente de i l'attente
        this.attente-=i;
    }
    public int getAttente() { // retourne la valeur actuelle de l'attente
        return this.attente;
    }
    public EnsembleChaines getEnsembleChaines() {
         /** Renvoie le message à afficher */
        EnsembleChaines ec= new EnsembleChaines();
        ec.ajouteChaine(this.x, this.y, this.toString());
        return ec;
    }
    @Override
    public String toString() { // renvoie la chaine de caractères "Attente :" et sa valeur actuelle
        return "Attente : le jeu recommence dans "+ this.getAttente() + " ...";
    }
}
