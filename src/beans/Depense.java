package beans;

import java.util.Date;

public class Depense {
    private String libelle;
    private Date date;
    private double montant;
    private Etudiant etudiant;

    public Depense(String libelle, Date date, double montant, Etudiant etudiant) {
        this.libelle = libelle;
        this.date = date;
        this.montant = montant;
        this.etudiant = etudiant;
    }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }
}
