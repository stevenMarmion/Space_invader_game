// javac --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls *.java
// java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls Executable

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
    private Niveau niveau; // Bonus 
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
        this.niveau = new Niveau(this.getLargeur()-11, this.getHauteur()-1);
        /* Fin bonus */
    }
    public int getHauteur() {
        return 60;
    }
    public int getLargeur() {
        return 100;
    }
    public void toucheDroite() {
        if (this.v.getX()+17<this.getLargeur()) {
            this.posX+=1;
            this.v.deplace(1);
        }
    }
    public void toucheGauche() {
        if (this.v.getX()>0) {
            this.posX-=1;
            this.v.deplace(-1);
        }
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
        e.union(this.v.getEnsembleChaines());
        e.union(this.s.getEnsembleChaines());
        e.union(this.niveau.getEnsembleChaines());

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
        return e;
    }
    public void jouerUnTour() {
        for (Alien a: this.listeA) {
            double pasX=0.0;
            if (this.niveau.getNiveau()==1) {
                pasX=0.1;
            }
            else if (this.niveau.getNiveau()==2) {
                pasX=0.2;
            }
            else if (this.niveau.getNiveau()==3) {
                pasX=0.4;
            }
            else if (this.niveau.getNiveau()==4) {
                pasX=0.8;
            }
            a.evolue(pasX);
            if (this.s.getScore()%10==0) { 
                // regarde si le score est un multiple de 10
                // si c'est le cas, on change le dessin de l'alien 
                a.changeDessin();
            }
            this.testTouche();
            if (a.getEstTouche()==true) {
                this.listeP.remove(p);
                this.listeA.remove(a);
            }
        }
        for (Projectile p: this.listeP) {
            p.evolue();
        }
        this.s.ajoute(1);

        /* Bonus */
        if (this.listeA.isEmpty()==true) {
            this.remetDesAliens();
            this.niveau.ajouteNiveau(1);
        }
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
        for (Alien alien: this.listeA) {
            if (alien.contient((int)this.v.getX(), 0) || alien.getY()<=0) {
                this.perdu();
            }
        }
    }
    public void perdu() {
        this.listeP.clear();
        this.listeA.clear();
        this.listeProjectileToucheAlien.clear();
        this.listeAlienTouche.clear();
        this.listeEtoile.clear(); 
        this.asteroide.clear();
        this.planete=null;
    }
    public void remetDesAliens() {
        /** Si tout les aliens de la première vague sont morts, on en envoie une deuxième. Ce qui implique l'on doit en remettre sur la map **/
        for (double i=0.0; i<this.getLargeur()-50; i+=17.0) {
            this.listeA.add(new Alien(i, this.getHauteur()-10));
            this.listeA.add(new Alien(i, this.getHauteur()-17));
        }
    }
}