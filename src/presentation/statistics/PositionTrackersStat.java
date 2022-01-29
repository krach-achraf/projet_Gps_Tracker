/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.statistics;

import entities.GPSTracker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import presentation.Main;
import service.GPSTrackerService;
import service.PositionService;

/**
 *
 * @author HP
 */
public class PositionTrackersStat extends javax.swing.JFrame {
    private PositionService ps;
    private GPSTrackerService gs;
    private static String nom;
    private static String prenom;
    private Map<String,Integer> positions;
    
    /**
     * Creates new form PositionTrackersStat
     */
    public PositionTrackersStat(String nom, String prenom) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nom = nom;
        this.prenom = prenom;
        ps = new PositionService();
        gs = new GPSTrackerService();
        positions = ps.nbrPositionsByTracker();
        nameLab.setText(nom + " " + prenom);
        nbrPosTrack1();
        nbrPosTrack2();
        countTrackers();
        countPositions();
        nbrMaxPosByTracker();
        nbrMinPosByTracker();
    }

    private void nbrPosTrack1(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Map.Entry mp : positions.entrySet())
            dataset.setValue( (Integer)mp.getValue() , "nombre" , (String)mp.getKey() ); 
        
        JFreeChart linechart = ChartFactory.createLineChart("Nombre des positions par Tracker","Trackers","Nombre", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();

        lineCategoryPlot.setBackgroundPaint(Color.white);

        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        ChartPanel lineChartPanel = new ChartPanel(linechart);
        posTrackStat1.removeAll();
        posTrackStat1.add(lineChartPanel, BorderLayout.CENTER);
        posTrackStat1.validate();
    }
    
    private void nbrPosTrack2(){
        PieDataset dataset = createDataset();  

        JFreeChart chart = ChartFactory.createPieChart("Pourcentage des positions par Tracker",  dataset,  false,   true,  false);  

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
            "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));  
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  

        ChartPanel panel = new ChartPanel(chart);  
        posTrackStat2.add(panel, BorderLayout.CENTER);
    }
  
    private PieDataset createDataset() {  
        DefaultPieDataset dataset=new DefaultPieDataset(); 
        for(Map.Entry mp : positions.entrySet())
                dataset.setValue( (String)mp.getKey(), (Integer)mp.getValue()); 

        return dataset;  
    }
    
    private void countTrackers(){
        int count = gs.countTrackers();
        countTrackers.setText(count + "");
    }
    
    private void countPositions(){
        int count = ps.countPositions();
        countPositions.setText(count + "");
    }
    
    private void nbrMaxPosByTracker(){
        int id = ps.nbrMaxPosByTracker();
        GPSTracker gPSTracker = gs.findById(id);
        nbrPlusPos.setText(gPSTracker.getSimNumber());
    }
    
    private void nbrMinPosByTracker(){
        int id = ps.nbrMinPosByTracker();
        GPSTracker gPSTracker = gs.findById(id);
        nbrMoinsPos.setText(gPSTracker.getSimNumber());
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        homeBtn = new javax.swing.JLabel();
        nameLab = new javax.swing.JLabel();
        posTrackStat2 = new javax.swing.JPanel();
        posTrackStat1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        countTrackers = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        countPositions = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        nbrMoinsPos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        nbrPlusPos = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 1, 40));

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/images/close.png"))); // NOI18N
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        jPanel3.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, -1, -1));

        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentation/images/home.png"))); // NOI18N
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
        });
        jPanel3.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        nameLab.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jPanel3.add(nameLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 25, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        posTrackStat2.setBackground(new java.awt.Color(255, 255, 255));
        posTrackStat2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        posTrackStat2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(posTrackStat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 450, 410));

        posTrackStat1.setBackground(new java.awt.Color(255, 255, 255));
        posTrackStat1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        posTrackStat1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(posTrackStat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 450, 410));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(32, 33, 35));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total des trackers");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 215, 60));

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 1));

        countTrackers.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        countTrackers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(countTrackers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 215, 100));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 33, 35));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total des positions");
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 215, 60));

        jPanel5.setBackground(new java.awt.Color(32, 33, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 1));

        countPositions.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        countPositions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(countPositions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 90, 215, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(32, 33, 35));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 1));

        nbrMoinsPos.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        nbrMoinsPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel9.add(nbrMoinsPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 40));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 33, 35));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tracker avec le moins ");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setMaximumSize(new java.awt.Dimension(215, 60));
        jLabel5.setMinimumSize(new java.awt.Dimension(215, 60));
        jLabel5.setPreferredSize(new java.awt.Dimension(215, 60));
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 215, 30));

        jLabel6.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 33, 35));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("nombre des positions");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setMaximumSize(new java.awt.Dimension(215, 60));
        jLabel6.setMinimumSize(new java.awt.Dimension(215, 60));
        jLabel6.setPreferredSize(new java.awt.Dimension(215, 60));
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 215, 25));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 90, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(32, 33, 35));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("nombre des positions");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setMaximumSize(new java.awt.Dimension(215, 60));
        jLabel3.setMinimumSize(new java.awt.Dimension(215, 60));
        jLabel3.setPreferredSize(new java.awt.Dimension(215, 60));
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 215, 25));

        jPanel7.setBackground(new java.awt.Color(32, 33, 35));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 1));

        nbrPlusPos.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        nbrPlusPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel10.add(nbrPlusPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 215, 40));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 33, 35));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tracker donnant le plus ");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel4.setMaximumSize(new java.awt.Dimension(215, 60));
        jLabel4.setMinimumSize(new java.awt.Dimension(215, 60));
        jLabel4.setPreferredSize(new java.awt.Dimension(215, 60));
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 215, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitBtnMouseClicked

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        this.setVisible(false);
        (new Main(nom, prenom)).setVisible(true);
    }//GEN-LAST:event_homeBtnMouseClicked

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
            java.util.logging.Logger.getLogger(PositionTrackersStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PositionTrackersStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PositionTrackersStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PositionTrackersStat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PositionTrackersStat(nom, prenom).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countPositions;
    private javax.swing.JLabel countTrackers;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel nameLab;
    private javax.swing.JLabel nbrMoinsPos;
    private javax.swing.JLabel nbrPlusPos;
    private javax.swing.JPanel posTrackStat1;
    private javax.swing.JPanel posTrackStat2;
    // End of variables declaration//GEN-END:variables


}
