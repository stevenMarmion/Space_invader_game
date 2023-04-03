import java.util.ArrayList;

public class EnsembleChaines {
    ArrayList<ChainePositionnee> chaines;
    public EnsembleChaines(){
        ArrayList<ChainePositionnee> chaines= new ArrayList<ChainePositionnee>(); 
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
            if (c.getPosX() <= posx && c.getPosY() == posy && posx < c.getPosX() + c.getDessin().length())
                return true;
        }
        return false;
    }
}
