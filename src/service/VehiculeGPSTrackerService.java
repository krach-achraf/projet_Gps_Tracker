package service;

import connexion.Connexion;
import dao.IDao;
import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class VehiculeGPSTrackerService implements IDao<VehiculeGPSTracker> {
    VehiculeService vs = new VehiculeService();
    GPSTrackerService gs = new GPSTrackerService();

    @Override
    public boolean create(VehiculeGPSTracker o) {
        try {
            String req = "insert into vehiculegpstracker values (null, ?, ?, ?, null);";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1,o.getVehicule().getId());
            ps.setInt(2, o.getGpsTracker().getId());
            ps.setDate(3, new Date(o.getDateDebut().getTime()));   
            if (ps.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(VehiculeGPSTracker o) {
        try {
            String req = "delete from vehiculegpstracker where id = ?";
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
    public boolean update(VehiculeGPSTracker o) {
        try {
            String req = "update vehiculegpstracker set dateDebut = ?, idVehicule = ?, idGpsTracker = ? where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDate(1, new Date(o.getDateDebut().getTime()));
            pr.setInt(2, o.getVehicule().getId());
            pr.setInt(3, o.getGpsTracker().getId());
            pr.setInt(4, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public VehiculeGPSTracker findById(int id) {
        try {
            String req = "select * from vehiculegpstracker where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new VehiculeGPSTracker(rs.getInt("id"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        vs.findById(rs.getInt("idVehicule")),
                        gs.findById(rs.getInt("idGpsTracker")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VehiculeGPSTracker> findAll() {
        List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList();
        try {
            String req = "select * from vehiculegpstracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        vs.findById(rs.getInt("idVehicule")),
                        gs.findById(rs.getInt("idGpsTracker"))));
            return vehiculeGPSTrackers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Vehicule> findVehicules() {
        List<Vehicule> vehicules = new ArrayList();
        try {
            String req = "select * from vehicule where id not in(select idVehicule from vehiculegpstracker where dateFin is null);";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                    vehicules.add(new Vehicule(rs.getInt("id"),
                        rs.getString("matricule"),
                        rs.getString("marque"),
                        rs.getString("type")));
            }
            return vehicules;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<GPSTracker> findTrackersNull() {
        List<GPSTracker> gPSTrackers = new ArrayList();
        try {
            String req = "select * from gpstracker where id in(select idGpstracker from vehiculegpstracker where dateFin is null);";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                gPSTrackers.add(new GPSTracker(rs.getInt("id"),rs.getString("simNumber")));
            }
            return gPSTrackers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<GPSTracker> findTrackersNotNull() {
        List<GPSTracker> gPSTrackers = new ArrayList();
        try {
            String req = "select * from gpstracker where id not in(select idGpstracker from vehiculegpstracker where dateFin is null);";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                gPSTrackers.add(new GPSTracker(rs.getInt("id"),rs.getString("simNumber")));
            }
            return gPSTrackers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateDateFin(VehiculeGPSTracker o) {
        try {
            String req = "update vehiculegpstracker set dateFin = ? where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDate(1, new Date(o.getDateFin().getTime()));
            pr.setInt(2, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<VehiculeGPSTracker> findByTrackerId(int id) {
        List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList<>();
        try {
            String req = "select * from vehiculegpstracker where idGpstracker = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        vs.findById(rs.getInt("idVehicule")),
                        gs.findById(rs.getInt("idGpsTracker"))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculeGPSTrackers;
    }
}
