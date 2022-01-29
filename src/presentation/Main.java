/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import presentation.gestion.GestionAffectations;
import presentation.gestion.GestionPositions;
import presentation.gestion.GestionTrackers;
import presentation.gestion.GestionUsers;
import presentation.gestion.GestionVehicules;
import presentation.maps.PosTrackers;
import presentation.maps.PosVehicules;
import presentation.rapport.PositionsRapport;
import presentation.statistics.PositionTrackersStat;
import presentation.statistics.PositionsVehicMonth;
import presentation.statistics.PositionsVehicYear;

/**
 *
 * @author HP
 */
public class Main extends javax.swing.JFrame {
    private static String nom;
    private static String prenom;
    
    /**
     * Creates new form Main
     */
    public Main(String nom, String prenom) {
        initComponents();
        this.nom = nom;
        this.prenom = prenom;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        usersBtn = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        posTrackerStatBtn = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        posTrackerMapBtn = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        positionsRapportBtn = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        vehiculesBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        positionsBtn = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        trackersBtn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        affectationsBtn = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        posVehicStatMonthBtn = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        posVehiculeMapBtn = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();
        posVehicStatYearBtn = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(32, 33, 35));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersBtn.setBackground(new java.awt.Color(0, 51, 153));
        usersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersBtnMouseClicked(evt);
            }
        });
        usersBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Utilisateurs");
        usersBtn.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ajouter Modifier Supprimer");
        usersBtn.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(usersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 70, 200, 100));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 30, 100, -1));

        posTrackerStatBtn.setBackground(new java.awt.Color(0, 102, 153));
        posTrackerStatBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posTrackerStatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posTrackerStatBtnMouseClicked(evt);
            }
        });
        posTrackerStatBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Positions");
        posTrackerStatBtn.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel20.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Par tracker ");
        posTrackerStatBtn.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(posTrackerStatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 70, 200, 100));

        posTrackerMapBtn.setBackground(new java.awt.Color(153, 153, 255));
        posTrackerMapBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posTrackerMapBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posTrackerMapBtnMouseClicked(evt);
            }
        });
        posTrackerMapBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Positions");
        posTrackerMapBtn.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Par tracker entre 2 dates");
        posTrackerMapBtn.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(posTrackerMapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 70, 200, 100));

        positionsRapportBtn.setBackground(new java.awt.Color(204, 204, 255));
        positionsRapportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        positionsRapportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionsRapportBtnMouseClicked(evt);
            }
        });
        positionsRapportBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Positions");
        positionsRapportBtn.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel24.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Par véhicule entre 2 dates");
        positionsRapportBtn.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(positionsRapportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 70, 200, 100));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Maps");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 30, 160, -1));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Statistics");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 30, 200, -1));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rapport");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 30, 100, -1));

        vehiculesBtn.setBackground(new java.awt.Color(0, 51, 153));
        vehiculesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vehiculesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehiculesBtnMouseClicked(evt);
            }
        });
        vehiculesBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Véhiclues");
        vehiculesBtn.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ajouter Modifier Supprimer");
        vehiculesBtn.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(vehiculesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 182, 200, 100));

        positionsBtn.setBackground(new java.awt.Color(0, 51, 153));
        positionsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        positionsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionsBtnMouseClicked(evt);
            }
        });
        positionsBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Positions");
        positionsBtn.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel17.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Ajouter Modifier Supprimer");
        positionsBtn.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(positionsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 294, 200, 100));

        trackersBtn.setBackground(new java.awt.Color(0, 51, 153));
        trackersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trackersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trackersBtnMouseClicked(evt);
            }
        });
        trackersBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Trackers");
        trackersBtn.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Ajouter Modifier Supprimer");
        trackersBtn.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(trackersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 406, 200, 100));

        affectationsBtn.setBackground(new java.awt.Color(0, 51, 153));
        affectationsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        affectationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                affectationsBtnMouseClicked(evt);
            }
        });
        affectationsBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Affectations");
        affectationsBtn.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Affecter Désaffecter");
        affectationsBtn.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(affectationsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 518, 200, 100));

        posVehicStatMonthBtn.setBackground(new java.awt.Color(0, 102, 153));
        posVehicStatMonthBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posVehicStatMonthBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posVehicStatMonthBtnMouseClicked(evt);
            }
        });
        posVehicStatMonthBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Positions");
        posVehicStatMonthBtn.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, -1));

        jLabel21.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Par une véhicule / mois");
        posVehicStatMonthBtn.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(posVehicStatMonthBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 294, 200, 100));

        posVehiculeMapBtn.setBackground(new java.awt.Color(153, 153, 255));
        posVehiculeMapBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posVehiculeMapBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posVehiculeMapBtnMouseClicked(evt);
            }
        });
        posVehiculeMapBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Positions");
        posVehiculeMapBtn.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel23.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Par véhicule entre 2 dates");
        posVehiculeMapBtn.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));
        jPanel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Positions");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel26.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Par une véhicule / année");
        jPanel12.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        posVehiculeMapBtn.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        jPanel13.setBackground(new java.awt.Color(153, 153, 255));
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Positions");
        jPanel13.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Par une véhicule / année");
        jPanel13.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));
        jPanel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Positions");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel30.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Par une véhicule / année");
        jPanel14.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        posVehiculeMapBtn.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        jPanel15.setBackground(new java.awt.Color(153, 153, 255));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Positions");
        jPanel15.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel32.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Par une véhicule / année");
        jPanel15.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel16.setBackground(new java.awt.Color(153, 153, 255));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Positions");
        jPanel16.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel34.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Par une véhicule / année");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        jPanel17.setBackground(new java.awt.Color(153, 153, 255));
        jPanel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Positions");
        jPanel17.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel36.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Par une véhicule / année");
        jPanel17.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel18.setBackground(new java.awt.Color(153, 153, 255));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Positions");
        jPanel18.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel38.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Par une véhicule / année");
        jPanel18.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        posVehiculeMapBtn.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        jPanel3.add(posVehiculeMapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 182, 200, 100));

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/images/close.png"))); // NOI18N
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        jPanel3.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 40));

        posVehicStatYearBtn.setBackground(new java.awt.Color(0, 102, 153));
        posVehicStatYearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        posVehicStatYearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                posVehicStatYearBtnMouseClicked(evt);
            }
        });
        posVehicStatYearBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Cascadia Mono", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Positions");
        posVehicStatYearBtn.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, -1));

        jLabel40.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Par une véhicule / année");
        posVehicStatYearBtn.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel3.add(posVehicStatYearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 182, 200, 100));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersBtnMouseClicked
        this.setVisible(false);
        (new GestionUsers(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_usersBtnMouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void vehiculesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehiculesBtnMouseClicked
        this.setVisible(false);
        (new GestionVehicules(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_vehiculesBtnMouseClicked

    private void trackersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trackersBtnMouseClicked
        this.setVisible(false);
        (new GestionTrackers(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_trackersBtnMouseClicked

    private void positionsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionsBtnMouseClicked
        this.setVisible(false);
        (new GestionPositions(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_positionsBtnMouseClicked

    private void affectationsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_affectationsBtnMouseClicked
        this.setVisible(false);
        (new GestionAffectations(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_affectationsBtnMouseClicked

    private void positionsRapportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionsRapportBtnMouseClicked
        this.setVisible(false);
        (new PositionsRapport(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_positionsRapportBtnMouseClicked

    private void posTrackerStatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posTrackerStatBtnMouseClicked
        this.setVisible(false);
        (new PositionTrackersStat(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_posTrackerStatBtnMouseClicked

    private void posVehicStatMonthBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posVehicStatMonthBtnMouseClicked
        this.setVisible(false);
        (new PositionsVehicMonth(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_posVehicStatMonthBtnMouseClicked

    private void posVehicStatYearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posVehicStatYearBtnMouseClicked
        this.setVisible(false);
        (new PositionsVehicYear(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_posVehicStatYearBtnMouseClicked

    private void posTrackerMapBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posTrackerMapBtnMouseClicked
        this.setVisible(false);
        (new PosTrackers(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_posTrackerMapBtnMouseClicked

    private void posVehiculeMapBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_posVehiculeMapBtnMouseClicked
        this.setVisible(false);
        (new PosVehicules(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_posVehiculeMapBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(nom, prenom).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel affectationsBtn;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel posTrackerMapBtn;
    private javax.swing.JPanel posTrackerStatBtn;
    private javax.swing.JPanel posVehicStatMonthBtn;
    private javax.swing.JPanel posVehicStatYearBtn;
    private javax.swing.JPanel posVehiculeMapBtn;
    private javax.swing.JPanel positionsBtn;
    private javax.swing.JPanel positionsRapportBtn;
    private javax.swing.JPanel trackersBtn;
    private javax.swing.JPanel usersBtn;
    private javax.swing.JPanel vehiculesBtn;
    // End of variables declaration//GEN-END:variables
}