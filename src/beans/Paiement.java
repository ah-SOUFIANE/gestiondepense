package beans;

public class Paiement {
    private Depense depense;
    private Etudiant etudiant;
    private String statut;

    public Paiement(Depense depense, Etudiant etudiant, String statut) {
        this.depense = depense;
        this.etudiant = etudiant;
        this.statut = statut;
    }

    public Depense getDepense() { return depense; }
    public void setDepense(Depense depense) { this.depense = depense; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}


