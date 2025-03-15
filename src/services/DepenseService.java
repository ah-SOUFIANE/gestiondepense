package services;

import beans.Depense;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepenseService implements IDao<Depense> {

    private Connection cn = Connexion.getInstance().getCn();

    @Override
    public boolean create(Depense o) {
        String query = "INSERT INTO Depense (libelle, montant, date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getLibelle());
            ps.setDouble(2, o.getMontant());
            ps.setDate(3, new java.sql.Date(o.getDate().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de l'ajout de la dépense : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Depense o) {
        String query = "DELETE FROM Depense WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de la dépense : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Depense o) {
        String query = "UPDATE Depense SET libelle = ?, montant = ?, date = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getLibelle());
            ps.setDouble(2, o.getMontant());
            ps.setDate(3, new java.sql.Date(o.getDate().getTime()));
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de la dépense : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Depense findById(int id) {
        String query = "SELECT * FROM Depense WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Depense(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("montant"), rs.getDate("date"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération de la dépense : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Depense> findAll() {
        List<Depense> depenses = new ArrayList<>();
        String query = "SELECT * FROM Depense";
        try (PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                depenses.add(new Depense(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("montant"), rs.getDate("date")));
            }
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de la récupération des dépenses : " + ex.getMessage());
        }
        return depenses;
    }
}


