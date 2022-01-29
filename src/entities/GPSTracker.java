package entities;

public class GPSTracker {
    private int id;
    private String simNumber;

    public GPSTracker(String simNumber) {
        this.simNumber = simNumber;
    }

    public GPSTracker(int id, String simNumber) {
        this.id = id;
        this.simNumber = simNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    @Override
    public String toString() {
        return "GPSTracker : { " +
                "id=" + id +
                ", simNumber='" + simNumber + '\'' +
                " }";
    }
}
