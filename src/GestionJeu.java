import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private int posX;
    private Vaisseau v;
    private Projectile p;
    private Score s;
    private ArrayList<Alien> listeA;
    private ArrayList<Projectile> listeP;
    private ArrayList<Projectile> listeProjectileToucheAlien;
    private ArrayList<Alien> listeAlienTouche;
    
    private ArrayList<Etoile> listeEtoile; //Bonus 
    private Amorce a; // Bonus 
    private ArrayList<Asteroide> asteroide; // Bonus
    private PlaneteLambda planete; // Bonus 
    public GestionJeu() {
        this.v = new Vaisseau(0);
        
        this.posX=(int)this.v.getPositionCanon();

        this.s = new Score(0, this.getHauteur()-1);
        
        this.listeA=new ArrayList<>();
        for (double i=0.0; i<this.getLargeur()-50; i+=17.0) {
            this.listeA.add(new Alien(i, this.getHauteur()-10));
            this.listeA.add(new Alien(i, this.getHauteur()-17));
        }

        this.listeP = new ArrayList<Projectile>();

        this.listeProjectileToucheAlien =new ArrayList<>();
        this.listeAlienTouche = new ArrayList<Alien>();

        /* Bonus */
        this.listeEtoile = new ArrayList<>();
        for (double l=0.0; l<this.getHauteur(); l+=20.0) {
            for (double i=0.0; i<this.getLargeur(); i+=20.0) {
                listeEtoile.add(new Etoile(i, l));
            }
        }
        for (double l=10.0; l<this.getHauteur(); l+=20.0) {
            for (double i=10.0; i<this.getLargeur(); i+=20.0) {
                listeEtoile.add(new Etoile(i, l));
            }
        }
        this.a = new Amorce(this.getLargeur(), this.getHauteur()/2);
        this.asteroide = new ArrayList<>();
        this.asteroide.add(new Asteroide(80.0, -50.0));
        this.asteroide.add(new Asteroide(30.0, -150.0));
        this.asteroide.add(new Asteroide(50.0, -450.0));
        this.planete = new PlaneteLambda(-20.0, -30.0);
        /* Fin bonus */
    }
    public int getHauteur() {
        return 60;
    }
    public int getLargeur() {
        return 100;
    }
    public void toucheDroite() {
        this.posX+=1;
        this.v.deplace(1);
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
        for (Asteroide asteroide: this.asteroide) {
            e.union(asteroide.getEnsembleChaines());
        }
        e.union(this.a.getEnsembleChaines());
        e.union(this.planete.getEnsembleChaines());
        /* Fin bonus */
        e.union(this.v.getEnsembleChaines());
        e.union(this.s.getEnsembleChaines());
        return e;
    }
    public void jouerUnTour() {
        boolean goDroite=true;
        for (Alien a: this.listeA) {
            a.evolue();
            this.testTouche();
            if (a.getEstTouche()==true) {
                this.s.ajoute(1);
                this.listeP.remove(p);
                this.listeA.remove(a);
            }
        }
        for (Projectile p: this.listeP) {
            p.evolue();
        }
        /* Bonus */
        for (Etoile etoile: this.listeEtoile) {
            etoile.evolue();
            if (etoile.getY()>=this.getHauteur()) {
                etoile.remetXZero();
            }
        }
        for (Asteroide asteroide: this.asteroide) {
            asteroide.evolue();
        }
        this.a.evolue();
        this.planete.evolue();
        /* Fin bonus */
    }
    public void testTouche() {
        for (Projectile p: this.listeP) {
            for (Alien a: this.listeA) {
                if (a.contient((int)p.getPosX(), (int)p.getPosY())) {
                    this.listeProjectileToucheAlien.add(p);
                    this.listeAlienTouche.add(a);
                    a.estTouche();
                }
            }
        }
    }
}