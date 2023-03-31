import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private List<ChainePositionnee> listeE;
    private int posX;
    private Vaisseau v;
    private Projectile p;
    public Score s;
    public GestionJeu() {
        this.listeE = new ArrayList<>();
        ChainePositionnee cP = new ChainePositionnee(0,30,"@@");
        listeE.add(cP);
        this.posX=cP.getPosX;
        this.v = new Vaisseau(0);
        this.p = new Projectile(0.0, 0.0);
        this.s = new Score();
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
        for (ChainePositionnee cP: this.listeE) {
            e.union(cP.getDessin());
        }
        return e;
    }
    public void jouerUnTour() {
        this.s.ajoute(1);
    }
}