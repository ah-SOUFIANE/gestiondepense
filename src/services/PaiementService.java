package services;
import beans.Paiement;
import java.util.ArrayList;
import java.util.List;

public class PaiementService {
    private List<Paiement> paiements = new ArrayList<>();

    public boolean enregistrerPaiement(Paiement p) {
        return paiements.add(p);
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }
}
