package service;

import connexion.Connexion;
import dao.IDao;
import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionService implements IDao<Position> {
    GPSTrackerService gs = new GPSTrackerService();
    VehiculeGPSTrackerService vgs = new VehiculeGPSTrackerService();

    @Override
    public boolean create(Position o) {
        boolean dateVerifcation = false;
        try {
            String req1 = "select * from vehiculegpstracker where idGpsTracker = ?";
            PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
            ps1.setInt(1, o.getGpsTracker().getId());
            ResultSet rs = ps1.executeQuery();
            while (rs.next()){
                if (o.getDate().after(rs.getDate("dateDebut")) ||
                        o.getDate().equals(rs.getDate("dateDebut"))){
                    dateVerifcation = true;
                    break;
                }
            }
            if (dateVerifcation){
                String req = "insert into position values (null , ?, ?, ?, ?)";
                PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
                ps.setDouble(1, o.getLatitude());
                ps.setDouble(2, o.getLongitude());
                ps.setDate(3, new Date(o.getDate().getTime()));
                ps.setInt(4, o.getGpsTracker().getId());
                if (ps.executeUpdate() == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Position o) {
        try {
            String req = "delete from position where id = ?";
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
    public boolean update(Position o) {
        String req = "update position set latitude = ?, longitude = ?, date = ?, idGpsTracker = ? where id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setDouble(1, o.getLatitude());
            pr.setDouble(2, o.getLongitude());
            pr.setDate(3, new Date(o.getDate().getTime()));
            pr.setInt(4, o.getGpsTracker().getId());
            pr.setInt(5, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Position findById(int id) {
        try {
            String req = "select * from position where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new Position(rs.getInt("id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getDate("date"),
                        gs.findById(rs.getInt("idGpsTracker")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList();
        try {
            String req = "select * from position";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                positions.add(new Position(rs.getInt("id"),
                        rs.getDouble("latitude"),
                        rs.getDouble("longitude"),
                        rs.getDate("date"),
                        gs.findById(rs.getInt("idGpsTracker"))));
            return positions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List <Position> findPositionsBetweenDates(GPSTracker tracker, java.util.Date dateDebut, java.util.Date dateFin){
        List<Position> positions = new ArrayList();
        for (Position p : findAll()){
            if (p.getGpsTracker().getId() == tracker.getId()) {
                if (!(p.getDate().before(dateDebut) || p.getDate().after(dateFin)))
                    positions.add(p);
            }
        }
        return positions;
    }   
 
    public List <Position> findPositionsBetweenDates(Vehicule vehicule, java.util.Date dateDebut, java.util.Date dateFin){
        List<Position> positions = new ArrayList();
        try {
            String req = "select position.* "
                    + "from position, vehiculegpstracker "
                    + "where vehiculegpstracker.id = position.idGpstracker "
                    + "and vehiculegpstracker.idVehicule = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, vehicule.getId());
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                java.util.Date date = (java.util.Date)rs.getDate("date");
                if(!(date.before(dateDebut) || date.after(dateFin)))
                positions.add(new Position(rs.getInt("id"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getDate("date"),
                    gs.findById(rs.getInt("idGpsTracker"))));
            }
            return positions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     
    public Map<String,Integer> nbrPositionsByTracker(){
        Map<String,Integer> positions = new HashMap();
        try {
            String req = "select gpstracker.SimNumber as SimNumber, count(*) as totalPositions "
                    + "from position, gpstracker "
                    + "where gpstracker.id = position.idGpstracker "
                    + "group by idGpsTracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                positions.put(rs.getString("SimNumber"), rs.getInt("totalPositions"));
            return positions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String,Integer> nbrPositionsByVehiculeYear(int annee){
        Map<String,Integer> positions = new HashMap();
        try {
            String req = "select vehicule.matricule as matricule, count(*) as totalPositions " +
                            "from position, vehicule, vehiculegpstracker " +
                            "where vehiculegpstracker.idGpsTracker = position.idGpstracker " +
                            "and vehiculegpstracker.idVehicule = vehicule.id " +
                            "and position.date >= vehiculegpstracker.dateDebut " +
                            "and (position.date <=  vehiculegpstracker.dateFin or vehiculegpstracker.dateFin is null) " +
                            "and position.date BETWEEN '"+ annee +"-01-01' and '"+ annee +"-12-30' " +
                            "group by vehicule.matricule;";
        PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                positions.put(rs.getString("matricule"), rs.getInt("totalPositions"));
            return positions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Map<String,Integer> nbrPositionsByVehiculeMonth(int annee, int mois){
        Map<String,Integer> positions = new HashMap();
        try {
            String req = "select vehicule.matricule as matricule, count(*) as totalPositions " +
                            "from position, vehicule, vehiculegpstracker " +
                            "where vehiculegpstracker.idGpsTracker = position.idGpstracker " +
                            "and vehiculegpstracker.idVehicule = vehicule.id " +
                            "and position.date >= vehiculegpstracker.dateDebut " +
                            "and (position.date <=  vehiculegpstracker.dateFin or vehiculegpstracker.dateFin is null) " +
                            "and position.date BETWEEN '"+ annee +"-" + mois + "-01' and '" + annee + "-" + mois + "-31' " +
                            "group by vehicule.matricule;";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                positions.put(rs.getString("matricule"), rs.getInt("totalPositions"));
            return positions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int countPositions(){
        try {
            String req = "select count(*) as totalPositions from position";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return rs.getInt("totalPositions");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int nbrMaxPosByTracker(){
        try {
            String req = "SELECT y.id ,MAX(y.count) FROM (SELECT idGpstracker AS id, COUNT(id) AS count FROM position GROUP BY idGpstracker order by count desc) y;";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int nbrMinPosByTracker(){
        try {
            String req = "SELECT y.id ,MIN(y.count) FROM (SELECT idGpstracker AS id, COUNT(id) AS count FROM position GROUP BY idGpstracker order by count asc) y;";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
