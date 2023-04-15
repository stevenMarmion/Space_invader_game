import java.util.ArrayList;

public class EnsembleChaines {
    public ArrayList<ChainePositionnee> chaines;
    public EnsembleChaines(){
        /** Dans ce constructeur, j'instancie simplement une liste vide */
        chaines= new ArrayList<>(); 
    }
    public void ajouteChaine(int x, int y, String c) {
        /** Ajoute à la liste vide une nouvelle chaine avec une position X, Y et un dessin ( représentation visuelle ) */
        chaines.add(new ChainePositionnee(x,y,c));
    }
    public void union(EnsembleChaines e){
        /** ajoute à un ensemble de chaine, la chaine actuelle instanciée  */
        for(ChainePositionnee c : e.chaines)
            chaines.add(c);
    }
    public boolean contient(int posx, int posy){
        /** renvoie true ou false en fonction des positions X et Y passées en paramètre de la méthode 
         * regarde si l'ensemble de chaine est contenue dans les positions x et y passées en paramètres
        */
        for(ChainePositionnee c: this.chaines){
            if (posx >=c.getPosX() && posx <=c.getPosX()+c.getDessin().length() && posy >= c.getPosY()) {
                return true;
            }
        }
        return false;
    }
}
