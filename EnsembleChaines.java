import java.util.ArrayList;
public class EnsembleChaines {
    ArrayList<ChainePositionnee> chaines;
    public EnsembleChaines(){
        ArrayList<ChainePositionnee> chaines= new ArrayList<>(); 
    }
    public void ajouteChaine(int x, int y, String c) {
        chaines.add(new ChainePositionnee(x,y,c));
    }
    public void union(EnsembleChaines e){
        for(ChainePositionnee c : e.chaines)
            chaines.add(c);
    }
}
