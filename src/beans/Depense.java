package beans;

import java.util.Date;

public class Depense {
    private String libelle;
    private double montant;
    private Date date;

    public Depense(String libelle, double montant, Date date) {
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
    }

    public Depense(String libelle, double montant, Date date) {
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
    }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
