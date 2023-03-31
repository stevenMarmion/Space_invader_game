import java.util.List;
import java.util.ArrayList;

public class GestionJeu {
    private List<EnsembleChaines> listeE;
    public GestionJeu() {
        this.listeE = new ArrayList<>();
    }
    public int getHauteur() {
        return 60;
    }
    public int getLargeur() {
        return 100;
    }
    public void toucheDroite() {
    }
    public void toucheGauche() {

    }
    public void toucheEspace() {

    }
    public EnsembleChaines getChaines() {
        EnsembleChaines e = new EnsembleChaines();
        e.ajouteChaine(0, 30, "@@");
        return e;
    }
    public void jouerUnTour() {

    }
}