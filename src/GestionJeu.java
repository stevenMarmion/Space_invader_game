import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private int posX;
    private Vaisseau v;
    private Projectile p;
    private Score s;
    private ArrayList<Alien> listeA;
    private ArrayList<Projectile> listeP;
    private ArrayList<Alien> listeAlienTouche;
    /* Bonus */ private ArrayList<Etoile> listeEtoile;
    public GestionJeu() {
        this.v = new Vaisseau(0);
        
        this.posX=(int)this.v.getPositionCanon();

        this.s = new Score();
        
        this.listeA=new ArrayList<>();
        this.listeA.add(new Alien(0.0, this.getHauteur()-10));
        this.listeA.add(new Alien(15.0, this.getHauteur()-10));
        this.listeA.add(new Alien(30.0, this.getHauteur()-10));
        this.listeA.add(new Alien(45.0, this.getHauteur()-10));
        this.listeA.add(new Alien(60.0, this.getHauteur()-10));
        this.listeA.add(new Alien(0.0, this.getHauteur()-20));
        this.listeA.add(new Alien(15.0, this.getHauteur()-20));
        this.listeA.add(new Alien(30.0, this.getHauteur()-20));
        this.listeA.add(new Alien(45.0, this.getHauteur()-20));
        this.listeA.add(new Alien(60.0, this.getHauteur()-20));

        this.listeP = new ArrayList<Projectile>();

        this.listeAlienTouche = new ArrayList<Alien>();

        /* Bonus */
        this.listeEtoile = new ArrayList<>();
        this.listeEtoile.add(new Etoile(2.0, 0.0));
    }
    public int getHauteur() {
        return 85;
    }
    public int getLargeur() {
        return 180;
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
        Projectile p=new Projectile(this.posX, 6.0);
        listeP.add(p);
    }
    public EnsembleChaines getChaines() {
        EnsembleChaines e = new EnsembleChaines();
        for (Projectile p: this.listeP) {
            e.union(p.getEnsembleChaines());
        }
        for (Alien a: this.listeA) {
            e.union(a.getEnsembleChaines());
        }

        /* Bonus */
        for (Etoile etoile: this.listeEtoile) {
            e.union(etoile.getEnsembleChaines());
        }
        /* Fin bonus */

        e.union(this.v.getEnsembleChaines());
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
        for (Projectile p: this.listeP) {
            p.evolue();
        }
        /* Bonus */
        for (Etoile etoile: this.listeEtoile) {
            etoile.evolue();
        }
        /* Fin bonus */
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