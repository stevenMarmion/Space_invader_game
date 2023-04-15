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
        /** Dans ce constructeur, j'instancie tout les élements qui me serviront */

        this.v = new Vaisseau(0); // Création du Vaisseau en position en 0
        
        this.posX=(int)this.v.getPositionCanon(); // Attribut instancié pour retenir la position du canon

        this.s = new Score(0, this.getHauteur()-1); // Attribut du score instancié, placé en X et en Y ( en haut à gauche )
        
        this.listeA=new ArrayList<>(); // Création de la liste pour pour les aliens 
        // Ajout des aliens sur trois lignes, le nombre d'aliens par lignes est géré en focntion de la larguer de la fenêtre
        for (double i=0.0; i<this.getLargeur()-50; i+=17.0) {
            this.listeA.add(new Alien(i, this.getHauteur()-10));
            this.listeA.add(new Alien(i, this.getHauteur()-17));
            this.listeA.add(new Alien(i, this.getHauteur()-24));
        }

        this.listeP = new ArrayList<Projectile>(); // Création de la liste pour retenir et afficher tout les projectiles lancés

        this.listeProjectileToucheAlien =new ArrayList<>(); // Création de la liste pour récupérer tout les projectiles qui ont touchés les aliens 

        this.listeAlienTouche = new ArrayList<Alien>(); // Création de la liste pour récupérer tout les aliens touchés

        /* Bonus */
        this.listeEtoile = new ArrayList<>(); // Création de la liste pour afficher les étoiles en fond
        // Ajout des étoiles en fond sur toute la page en espacant chaque lignes d'étoiles de 20 cases en Y en partant de Y=0
        for (double l=0.0; l<this.getHauteur(); l+=20.0) {
            for (double i=0.0; i<this.getLargeur(); i+=20.0) {
                listeEtoile.add(new Etoile(i, l));
            }
        }
        // Ajout des étoiles en fond sur toute la page en espacant chaque lignes d'étoiles de 20 cases en Y en partant de Y=10
        for (double l=10.0; l<this.getHauteur(); l+=20.0) {
            for (double i=10.0; i<this.getLargeur(); i+=20.0) {
                listeEtoile.add(new Etoile(i, l));
            }
        }
        this.a = new Amorce(this.getLargeur(), this.getHauteur()/2); // Création d'une amorce qui permet d'afficher un message de début de jeu

        this.asteroide = new ArrayList<>(); // Création de la liste pour afficher les astéroides qui passeront en fond pendant le jeu
        // Ajout de 3 astéroides avec des positions X et Y plus ou moins loin en fonction du moment où je veux qu'il passent 
        this.asteroide.add(new Asteroide(80.0, -50.0));
        this.asteroide.add(new Asteroide(30.0, -150.0));
        this.asteroide.add(new Asteroide(50.0, -450.0));

        this.planete = new PlaneteLambda(-20.0, -30.0); // Création d'une planète qui a des propriété différentes d'un astéroide 

        this.niveau = new Niveau(this.getLargeur()-11, this.getHauteur()-1); // Création de l'affichage du niveau actuel dans lequel l'utilisateur se trouve ( en haut à droite )
        /* Fin bonus */
    }
    public int getHauteur() {
        /** Renvoie la hauteur actuelle de la fenêtre */
        return 60;
    }
    public int getLargeur() {
        /** Renvoie la largeur actuelle de la fenêtre */
        return 100;
    }
    public void toucheDroite() {
        /** Déplace le vaisseau à droite si l'utilisateur appuie sur la flèche droite de son clavier */
        if (this.v.getX()+17<this.getLargeur()) { // Vérifie que le déplacement à droite ne dépasse pas de la largeur de la fenêtre 
            this.posX+=1;
            this.v.deplace(1);
        }
    }
    public void toucheGauche() {
        /** Déplace le vaisseau à gauche si l'utilisateur appuie sur la flèche gauche de son clavier */
        if (this.v.getX()>0) { // Vérifie que le déplacement à gauche ne dépasse pas de la largeur de la fenêtre 
            this.posX-=1;
            this.v.deplace(-1);
        }
    }
    public void toucheEspace() {
        /** Envoie un projectile si l'utilisateur appuie sur la barre espace de son clavier */
        Projectile p=new Projectile(this.posX, 6.0);
        listeP.add(p); // ajoute le projectile dans la liste de projectile
    }
    public EnsembleChaines getChaines() {
        /** Créer les ensembles de chaines à afficher pour chaque attributs et renvoie l'ensemble de chaine de toute la fenêtre */
        EnsembleChaines e = new EnsembleChaines();
        for (Projectile p: this.listeP) { 
            // Pour chaque projectiles lancés ( qui sont donc dans la liste ), nous affichons sa chaine représentative en la liant avec l'ensemble de chaine de toute la fenêtre
            e.union(p.getEnsembleChaines());
        }
        for (Alien a: this.listeA) {
            // Pour chaque aliens instanciés dans le constructeur, nous affichons sa chaine représentative en la liant avec l'ensemble de chaine de toute la fenêtre
            e.union(a.getEnsembleChaines());
        }
        e.union(this.v.getEnsembleChaines()); // Nous lions à la fenêtre ouverte la chaine représentative du vaisseau 
        e.union(this.s.getEnsembleChaines()); // Nous lions à la fenêtre ouverte la chaine représentative du score
        e.union(this.niveau.getEnsembleChaines()); // Nous lions à la fenêtre ouverte la chaine représentative du niveau 

        /* Bonus */
        for (Etoile etoile: this.listeEtoile) {
            // Pour chaque étoiles instanciées dans le constructeur, nous affichons sa chaine représentative en la liant avec l'ensemble de chaine de toute la fenêtre
            e.union(etoile.getEnsembleChaines());
        }
        for (Asteroide asteroide: this.asteroide) {
            // Pour chaque asteroides instanciés dans le constructeur, nous affichons sa chaine représentative en la liant avec l'ensemble de chaine de toute la fenêtre
            e.union(asteroide.getEnsembleChaines());
        }
        e.union(this.a.getEnsembleChaines()); // Nous lions à la fenêtre ouverte la chaine représentative de l'amorce ( texte )
        e.union(this.planete.getEnsembleChaines()); // Nous lions à la fenêtre ouverte la chaine représentative de la planète 
        /* Fin bonus */
        return e;
    }
    public void jouerUnTour() {
        /** A chaque tours de jeu, nous appelons les méthodes dont nous avons beoin pour chaque attributs */
        for (Alien a: this.listeA) {
            // Pour chaque aliens affichés, le déplacement change en fonction du niveau  
            double pasX=0.0;
            if (this.niveau.getNiveau()==1) { // Vérifie si le niveau est à 1
                pasX=0.1; // Indique la vitesse de déplacement des aliens si le niveau est à 1
            }
            else if (this.niveau.getNiveau()==2) { // Vérifie si le niveau est à 2
                pasX=0.2; // Indique la vitesse de déplacement des aliens si le niveau est à 2
            }
            else if (this.niveau.getNiveau()==3) { // Vérifie si le niveau est à 1
                pasX=0.4; // Indique la vitesse de déplacement des aliens si le niveau est à 3
            }
            a.evolue(pasX); // Appelle la méthode évolue pour chaque alien en fonction du déplacements

            if (this.s.getScore()%10==0) { // Pour chaque pas de 10 du score, le dessin des aliens changent, ce qui créer un effet de mouvement des aliens dans le déplacement
                a.changeDessin();
            }
            this.testTouche(); // Apelle la méthode testTouche qui regarde si l'alien actuel est touché par un projectile
            if (a.getEstTouche()==true) { // Vérifie l'état du booléen dans la classe Alien qui permet de savoir si l'Alien est touché 
                this.listeA.remove(a); // Supprime l'alien de la fenêtre si il est touché
            }
        }
        for (Projectile p: this.listeP) {
            // Pour chaque projectiles lancés, nous le faisons évoluer ( monte en Y d'une certaine vitesse )
            p.evolue();
        }
        this.s.ajoute(1); // Incrémente le score e 1 à chaque tour

        /* Bonus */
        if (this.listeA.isEmpty()==true) { // On regarde si la liste est vide 
            this.remetDesAliens(); // Si c'est le cas on remet des aliens en jeu en incrémentant d'un niveau
            this.niveau.ajouteNiveau(1);
        }
        for (Etoile etoile: this.listeEtoile) {
            // Pour chaque étoiles, nous la faisons évoluer ( monte en Y d'une certaine vitesse )
            etoile.evolue();
            if (etoile.getY()>=this.getHauteur()) { // Si l'étoile atteint le sommet de la fenêtre nous la faisons remettre en bas de la fenêtre 
                etoile.remetXZero();
            }
        }
        for (Asteroide asteroide: this.asteroide) {
            // Pour chaque astéroide, nous le faisons évoluer ( monte en Y et en X d'une certaine vitesse )
            asteroide.evolue();
        }
        this.a.evolue(); // Fait évoluer le message d'amorce en X
        this.planete.evolue(); // fait évoluer la planete ne X et en Y 
        /* Fin bonus */

    }
    public void testTouche() {
        /** Pour chaque projectiles et chaque aliens, nous regardons si l'alien est touché par un des projectiles de la fenêtre */
        for (Projectile p: this.listeP) {
            for (Alien a: this.listeA) {
                if (a.contient((int)p.getPosX(), (int)p.getPosY())) { 
                    // Si l'alien est touché, nous ajoutons dans une liste le projectile et l'alien et nous suprimmons l'alien et le projectile de la fenêtre
                    this.listeProjectileToucheAlien.add(p);
                    this.listeAlienTouche.add(a);
                    this.listeP.remove(p);
                    a.estTouche();
                }
            }
        }
        for (Alien alien: this.listeA) {
            /** Si un des aliens touchent le vaisseau ou dépassent le bas de la fenêtre, la partie est terminée */
            if (alien.contient((int)this.v.getX(), 0) || alien.getY()<=0) {
                this.perdu();
            }
        }
    }
    public void perdu() {
        /** supprime tout les élements et mets fin à la partie */
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
            this.listeA.add(new Alien(i, this.getHauteur()-24));
        }
    }
}