package beans;

import java.util.Date;

public class Depense {
    private int id;
    private String libelle;
    private double montant;
    private Date date;

    public Depense(int id, String libelle, double montant, Date date) {
        this.id = id;
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
    }

    public Depense(String libelle, double montant, Date date) {
        this.libelle = libelle;
        this.montant = montant;
        this.date = date;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
