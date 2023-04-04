import java.util.ArrayList;

public class EnsembleChaines {
    public ArrayList<ChainePositionnee> chaines;
    public EnsembleChaines(){
        chaines= new ArrayList<>(); 
    }
    public void ajouteChaine(int x, int y, String c) {
        chaines.add(new ChainePositionnee(x,y,c));
    }
    public void union(EnsembleChaines e){
        for(ChainePositionnee c : e.chaines)
            chaines.add(c);
    }
    public boolean contient(int posx, int posy){
        for(ChainePositionnee c: this.chaines){
            if (posx >=c.getPosX() && posx <=c.getPosX()+c.getDessin().length() && posy >= c.getPosY()) {
                return true;
            }
        }
        return false;
    }
}
