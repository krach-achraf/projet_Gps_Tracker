package test;

import connexion.Connexion;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
    public static void main(String[] args) {
        String cretateTableVehicule = "create table Vehicule (" +
                "id int primary key auto_increment," +
                "matricule varchar(20)," +
                "marque varchar(20)," +
                "type varchar(20));";

        String cretateTableGpsTracker = "create table GPSTracker (" +
                "id int primary key auto_increment," +
                "simNumber varchar(20));";

        String cretateTableVehiculeGpsTracker = "create table VehiculeGPSTracker (" +
                "id int primary key auto_increment," +
                "idVehicule int," +
                "idGpsTracker int," +
                "dateDebut Date," +
                "dateFin Date null," +
                "foreign key (idVehicule) references vehicule (id)," +
                "foreign key (idGpsTracker) references gpstracker (id));";

        String cretateTablePosition = "create table Position (" +
                "id int primary key auto_increment," +
                "latitude double," +
                "longitude double," +
                "date Date," +
                "idGpsTracker int," +
                "foreign key (idGpsTracker) references gpstracker (id));";
        
        String cretateTableUser = "create table User (" +
                "id int primary key auto_increment," +
                "nom varchar(30)," +
                "prenom varchar(30)," +
                "login varchar(30)," +
                "email varchar(50)," +
                "password varchar(255));";

        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate("drop table if exists vehiculegpstracker;");
            st.executeUpdate("drop table if exists position;");
            st.executeUpdate("drop table if exists gpstracker;");
            st.executeUpdate("drop table if exists vehicule;");
            st.executeUpdate("drop table if exists user;");
            st.executeUpdate(cretateTableVehicule);
            st.executeUpdate(cretateTableGpsTracker);
            st.executeUpdate(cretateTableUser);
            st.executeUpdate(cretateTableVehiculeGpsTracker);
            st.executeUpdate(cretateTablePosition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
