package services;

import beans.Depense;
import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepenseService implements IDao<Depense> {
    private Connection cn = Connexion.getInstance().getCn();
    private EtudiantService etudiantService = new EtudiantService();

    @Override
    public boolean create(Depense o) {
        String query = "INSERT INTO Depense (libelle, date, montant, etudiant_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getLibelle());
            ps.setDate(2, new java.sql.Date(o.getDate().getTime()));
            ps.setDouble(3, o.getMontant());
            ps.setInt(4, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur insertion dépense : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Depense> findAll() {
        List<Depense> depenses = new ArrayList<>();
        String query = "SELECT * FROM Depense";
        try (PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));
                depenses.add(new Depense(rs.getString("libelle"), rs.getDate("date"), rs.getDouble("montant"), etudiant));
            }
        } catch (SQLException ex) {
            System.out.println(" Erreur findAll dépenses : " + ex.getMessage());
        }
        return depenses;
    }
}

