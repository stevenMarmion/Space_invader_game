import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private List<EnsembleChaines> listeE;
    private int posX;
    private Vaisseau v;
    private Projectile p;
    private Score s;
    private ArrayList<Alien> listeA;
    public GestionJeu() {
        this.listeE = new ArrayList<>();
        EnsembleChaines e= new EnsembleChaines();
        listeE.add(e);
        ChainePositionnee cP = new ChainePositionnee(0,30,"@@");
        e.ajouteChaine(0,30,"@@");
        this.posX=cP.getPosX();
        this.v = new Vaisseau(0);
        this.p = new Projectile(0.0, 0.0);
        this.s = new Score();
        this.listeA=new ArrayList<Alien>();
        listeA.add(new Alien(0.0, this.getHauteur()));
        listeA.add(new Alien(1.0, this.getHauteur()));
        listeA.add(new Alien(20.0, this.getHauteur()));
        listeA.add(new Alien(30.0, this.getHauteur()));
        listeA.add(new Alien(40.0, this.getHauteur()));
        listeA.add(new Alien(0.0, this.getHauteur()-10));
        listeA.add(new Alien(1.0, this.getHauteur()-10));
        listeA.add(new Alien(20.0, this.getHauteur()-10));
        listeA.add(new Alien(30.0, this.getHauteur()-10));
        listeA.add(new Alien(40.0, this.getHauteur()-10));
    }
    public int getHauteur() {
        return 60;
    }
    public int getLargeur() {
        return 100;
    }
    public void toucheDroite() {
        this.posX+=1;
        this.v.deplace(1.0);
    }
    public void toucheGauche() {
        this.posX-=1;
        this.v.deplace(-1);
    }
    public void toucheEspace() {
        System.out.println("Appui sur la touche espace");
    }
    public EnsembleChaines getChaines() {
        EnsembleChaines e = new EnsembleChaines();
        for (EnsembleChaines eC: this.listeE) {
            e.union(eC);
        }
        return e;
    }
    public void jouerUnTour() {
        this.s.ajoute(1);
    }
}