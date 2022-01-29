package entities;

import java.util.Date;

public class VehiculeGPSTracker {
    private int id;
    private Vehicule vehicule;
    private GPSTracker gpsTracker;
    private Date dateDebut;
    private Date dateFin;

    public VehiculeGPSTracker(Date dateDebut, Date dateFin, Vehicule vehicule, GPSTracker gpsTracker) {
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public VehiculeGPSTracker(int id,  Date dateDebut, Date dateFin, Vehicule vehicule, GPSTracker gpsTracker) {
        this.id = id;
        this.vehicule = vehicule;
        this.gpsTracker = gpsTracker;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public GPSTracker getGpsTracker() {
        return gpsTracker;
    }

    public void setGpsTracker(GPSTracker gpsTracker) {
        this.gpsTracker = gpsTracker;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "VehiculeGPSTracker : { " +
                "id= " + id +
                ", vehicule=" + vehicule.getMatricule() +
                ", gpsTracker=" + gpsTracker.getSimNumber() +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                " }";
    }
}
