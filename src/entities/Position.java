package entities;

import java.util.Date;

public class Position {
    private int id;
    private double latitude;
    private double longitude;
    private Date date;
    private GPSTracker gpsTracker;

    public Position(double latitude, double longitude, Date date, GPSTracker gpsTracker) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
        this.gpsTracker = gpsTracker;
    }

    public Position(int id, double latitude, double longitude, Date date, GPSTracker gpsTracker) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.gpsTracker = gpsTracker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GPSTracker getGpsTracker() {
        return gpsTracker;
    }

    public void setGpsTracker(GPSTracker gpsTracker) {
        this.gpsTracker = gpsTracker;
    }

    @Override
    public String toString() {
        return "Position : { " +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", date=" + date +
                ", gpsTracker=" + gpsTracker.getSimNumber() +
                " }";
    }
}
