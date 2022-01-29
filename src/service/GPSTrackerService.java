package service;

import connexion.Connexion;
import dao.IDao;
import entities.GPSTracker;
import entities.Position;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GPSTrackerService implements IDao<GPSTracker> {

    @Override
    public boolean create(GPSTracker o) {
        try {
            String req1 = "select count(*) from gpstracker where simNumber = ?";
            PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
            ps1.setString(1, o.getSimNumber());
            ResultSet rs = ps1.executeQuery();
            if (rs.next() && rs.getInt(1) == 1)
                return false;
            else {
                String req2 = "insert into gpstracker values (null, ?);";
                PreparedStatement ps2 = Connexion.getConnection().prepareStatement(req2);
                ps2.setString(1, o.getSimNumber());
                if (ps2.executeUpdate() == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(GPSTracker o) {
        try {
            String req = "delete from gpstracker where id = ?";
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
    public boolean update(GPSTracker o) {
        String req = "update gpstracker set simNumber = ? where id = ?";
        try {
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, o.getSimNumber());
            pr.setInt(2, o.getId());
            if (pr.executeUpdate() == 1)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public GPSTracker findById(int id) {
        try {
            String req = "select * from gpstracker where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new GPSTracker(rs.getInt("id"), rs.getString("simNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GPSTracker> findAll() {
        List<GPSTracker> gpsTrackers = new ArrayList();
        try {
            String req = "select * from gpstracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next())
                gpsTrackers.add(new GPSTracker(rs.getInt("id"), rs.getString("simNumber")));
            return gpsTrackers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List <Position> findPositionsBetweenDates (GPSTracker tracker, Date dateDebut, Date dateFin){
        PositionService ps = new PositionService();
        List<Position> positions = new ArrayList();
        for (Position p : ps.findAll()){
            if (p.getGpsTracker().getId() == tracker.getId())
                if (!(p.getDate().before(dateDebut) && p.getDate().after(dateFin)))
                    positions.add(p);
        }
        return positions;
    }
    
    public GPSTracker findBySimNumber(String simNumber) {
        try {
            String req = "select * from gpstracker where simNumber = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, simNumber);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return new GPSTracker(rs.getInt("id"), rs.getString("simNumber"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int countTrackers(){
        try {
            String req = "select count(*) as totalTrackers from gpstracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
                return rs.getInt("totalTrackers");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
