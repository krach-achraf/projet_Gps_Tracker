package service;

import connexion.Connexion;
import dao.IDao;
import entities.Vehicule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculeService implements IDao<Vehicule> {

    @Override
    public boolean create(Vehicule o) {
        try {
            String req1 = "select count(*) as total from vehicule where matricule = ?";
            PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
            ps1.setString(1, o.getMatricule());
            ResultSet rs = ps1.executeQuery();
            if (rs.next() && rs.getInt("total") == 1)
                return false;
            else {
                String req2 = "insert into vehicule values (null, ?, ?, ?)";
                PreparedStatement ps2 = Connexion.getConnection().prepareStatement(req2);
                ps2.setString(1, o.getMatricule());
                ps2.setString(2, o.getMarque());
                ps2.setString(3, o.getType());
                if (ps2.executeUpdate() == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Vehicule o) {
        try {
            String req = "delete from vehicule where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Vehicule o) {
        String req = "update vehicule set matricule = ?, marque = ?, type = ? where id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getMatricule());
            pr.setString(2, o.getMarque());
            pr.setString(3, o.getType());
            pr.setInt(4, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Vehicule findById(int id) {
        try {
            String req = "select * from vehicule where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new Vehicule(rs.getInt("id"),
                        rs.getString("matricule"),
                        rs.getString("marque"),
                        rs.getString("type"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehicule> findAll() {
        List<Vehicule> vehicules = new ArrayList();
        try {
            String req = "select * from vehicule";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                vehicules.add(new Vehicule(rs.getInt("id"),
                        rs.getString("matricule"),
                        rs.getString("marque"),
                        rs.getString("type")));
            return vehicules;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Vehicule findByMatricule(String matricule) {
        try {
            String req = "select * from vehicule where matricule = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1,matricule);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new Vehicule(rs.getInt("id"),
                        rs.getString("matricule"),
                        rs.getString("marque"),
                        rs.getString("type"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
