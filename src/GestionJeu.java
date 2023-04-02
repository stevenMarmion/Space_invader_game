import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private List<EnsembleChaines> listeE;
    private int posX;
    private Vaisseau v;
    private Projectile p;
    private Score s;
    private ArrayList<Alien> listeA;
    private ArrayList<Projectile> listeP;
    private ArrayList<Alien> listeAlienTouche;
    public GestionJeu() {
        this.listeE = new ArrayList<>();

        this.v = new Vaisseau(0);
        EnsembleChaines eVaisseau = this.v.getEnsembleChaines();
        this.listeE.add(eVaisseau);
        this.posX=(int)this.v.getPositionCanon();

        this.p = new Projectile(this.posX, 4.0);
        EnsembleChaines eProjectile = this.p.getEnsembleChaines();
        this.listeE.add(eProjectile);

        this.s = new Score();
        
        this.listeA=new ArrayList<Alien>();
        listeA.add(new Alien(0.0, this.getHauteur()));
        listeA.add(new Alien(10.0, this.getHauteur()));
        listeA.add(new Alien(20.0, this.getHauteur()));
        listeA.add(new Alien(30.0, this.getHauteur()));
        listeA.add(new Alien(40.0, this.getHauteur()));
        listeA.add(new Alien(0.0, this.getHauteur()-10));
        listeA.add(new Alien(10.0, this.getHauteur()-10));
        listeA.add(new Alien(20.0, this.getHauteur()-10));
        listeA.add(new Alien(30.0, this.getHauteur()-10));
        listeA.add(new Alien(40.0, this.getHauteur()-10));

        this.listeP = new ArrayList<>();
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
        this.p.evolue();
    }
    public EnsembleChaines getChaines() {
        EnsembleChaines e = new EnsembleChaines();
        for (EnsembleChaines eC: this.listeE) {
            e.union(eC);
        }
        return e;
    }
    public void jouerUnTour() {
        for (Alien a: this.listeA) {
            a.evolue();
            if (a.getEstTouche()==true) {
                this.s.ajoute(1);
                this.removeAlienTouche(a);
                this.removeProjectile(p);
            }
        }
        this.p.evolue();
    }
    public void testTouche() {
        for (Projectile p: this.listeP) {
            for (Alien a: this.listeA) {
                if (a.contient((int)p.getPosX(), (int)p.getPosY())) {
                    this.listeP.add(p);
                    this.listeAlienTouche.add(a);
                    a.estTouche();
                }
            }
        }
    }
    public void removeProjectile(Projectile p) {
        this.listeP.remove(p);
    }
    public void removeAlienTouche(Alien a) {
        this.listeAlienTouche.remove(a);
    }
}