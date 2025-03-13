package services;

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantService implements IDao<Etudiant> {

    private Connection cn = Connexion.getInstance().getCn();

    @Override
    public boolean create(Etudiant o) {
        String query = "INSERT INTO Etudiant (nom, prenom, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de l'insertion : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        String query = "DELETE FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de la suppression : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        String query = "UPDATE Etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de la mise à jour : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String query = "SELECT * FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de la récupération : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiant";
        try (PreparedStatement ps = cn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(" Erreur lors de la récupération des étudiants : " + ex.getMessage());
        }
        return etudiants;
    }
}
