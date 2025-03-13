package test;

import beans.Depense;
import beans.Etudiant;
import connexion.Connexion;
import services.DepenseService;
import services.EtudiantService;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        if (Connexion.getInstance().getCn() != null) {
            System.out.println(" Connexion à la base de données réussie !");
        } else {
            System.out.println(" Erreur de connexion !");
            return; 
        }

        EtudiantService etudiantService = new EtudiantService();
        DepenseService depenseService = new DepenseService();

        Etudiant etudiant = new Etudiant("Soufiane", "ait Hmad", "aithmadsoufiane@email.com");
        if (etudiantService.create(etudiant)) {
            System.out.println("Étudiant ajouté avec succès !");
        } else {
            System.out.println("Erreur lors de l'ajout de l'étudiant.");
        }

        Depense depense = new Depense("Frais de scolarité", 1300.0, new Date());
        if (depenseService.create(depense)) {
            System.out.println("Dépense ajoutée avec succès !");
        } else {
            System.out.println("Erreur lors de l'ajout de la dépense.");
        }

        List<Etudiant> etudiants = etudiantService.findAll();
        System.out.println("\n Liste des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(" - ID: " + e.getId() + ", Nom: " + e.getNom() + ", Prénom: " + e.getPrenom() + ", Email: " + e.getEmail());
        }

        List<Depense> depenses = depenseService.findAll();
        System.out.println("\n Liste des dépenses :");
        for (Depense d : depenses) {
            System.out.println(" - ID: " + d.getId() + ", Libellé: " + d.getLibelle() + ", Montant: " + d.getMontant() + ", Date: " + d.getDate());
        }
    }
}
