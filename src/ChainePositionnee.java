public class ChainePositionnee{
    int x,y;
    String c;
    public ChainePositionnee(int a,int b, String d) {
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */
        x=a; // la position X de la chaine 
        y=b; // la position y de la chaine 
        c=d; // le dessin de la chaine à afficher 
    }
    public int getPosX() { // retourne la position X de la chaine actuelle 
        return this.x;
    }
    public int getPosY() { // retourne la position Y de la chaine actuelle
        return this.y;
    }
    public String getDessin() { // retourne le dessin de la chaine actuelle
        return this.c;
    }
}
