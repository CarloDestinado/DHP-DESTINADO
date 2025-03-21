/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADDFORMSINTERNALPAGE;

import config.PanelPrinter;
import config.dbConnector;
import internalpages.apptreports;
import internalpages.reports_dash;
import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import user.desk_dashboard;

/**
 *
 * @author once
 */
public class patientReports extends javax.swing.JFrame {

    /**
     * Creates new form patientReports
     */
    public patientReports() {
        initComponents();
        displaydata();
        customizeTable();
    }
    
    private void customizeTable() {
        // Disable cell editing
        patientTableReports.setDefaultEditor(Object.class, null);
        patientTableReports.getTableHeader().setBackground(Color.decode("#2A629A"));
        
// Customize table header
        Font headerfont = new Font("Verdana",Font.BOLD,14);
         patientTableReports.getTableHeader().setFont(headerfont);
         patientTableReports.setRowHeight(25);

        TableCellRenderer renderer = patientTableReports.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) renderer;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
      
    }

    
     private void printTable(JTable table){
 
                try {
                  MessageFormat headerFormat = new MessageFormat("PATIENT REPORTS");
                  MessageFormat footerFormat = new MessageFormat("- {0} -");
                  table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
                } catch (PrinterException pe) {
                  System.err.println("Error printing: " + pe.getMessage());
                }
              }
    
    
    public void displaydata(){
    try{
         
      dbConnector DBconnector = new dbConnector();
      ResultSet rs = DBconnector.getData("SELECT * FROM tbl_patients");
      
       patientTableReports.setModel(DbUtils.resultSetToTableModel(rs));
       
       

       
        TableColumnModel columnModel = patientTableReports.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("Patient ID");
            columnModel.getColumn(1).setHeaderValue("First Name");
            columnModel.getColumn(2).setHeaderValue("Last Name");
            columnModel.getColumn(3).setHeaderValue("Age");
            columnModel.getColumn(4).setHeaderValue("Gender");
            columnModel.getColumn(5).setHeaderValue("Birthdate");
            columnModel.getColumn(6).setHeaderValue("Contact");
            columnModel.getColumn(7).setHeaderValue("Address");
            
            // Refresh the table UI
           patientTableReports.getTableHeader().repaint();  
    
      
    }catch(SQLException ex){
        System.out.println("Errors:"+ex.getMessage());
    
    }
    
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        patientprinttable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientTableReports = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRINT TABLE");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 0, 120, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(30, 40, 120, 40);

        searchbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbarActionPerformed(evt);
            }
        });
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchbarKeyTyped(evt);
            }
        });
        jPanel2.add(searchbar);
        searchbar.setBounds(610, 50, 180, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("search:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(610, 30, 60, 20);

        jPanel5.setBackground(new java.awt.Color(0, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REFRESH");
        jPanel5.add(jLabel4);
        jLabel4.setBounds(14, 0, 90, 40);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(170, 40, 120, 40);

        patientprinttable.setLayout(null);

        patientTableReports.setBackground(new java.awt.Color(204, 255, 255));
        patientTableReports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        patientTableReports.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        patientTableReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTableReports.setFocusable(false);
        patientTableReports.setIntercellSpacing(new java.awt.Dimension(0, 0));
        patientTableReports.setRowHeight(25);
        patientTableReports.setSelectionBackground(new java.awt.Color(42, 98, 154));
        patientTableReports.setShowVerticalLines(false);
        patientTableReports.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(patientTableReports);

        patientprinttable.add(jScrollPane1);
        jScrollPane1.setBounds(0, 60, 800, 280);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PATIENT REPORTS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        patientprinttable.add(jLabel2);
        jLabel2.setBounds(234, 15, 347, 34);

        jPanel2.add(patientprinttable);
        patientprinttable.setBounds(10, 90, 810, 340);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 60, 830, 480);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsImage/arrow_circle_left_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(6, 4, 60, 40);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PATIENT REPORTS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 20, 300, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbarActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
//         desk_dashboard dashB = new desk_dashboard();
//       dashB.setVisible(true);
//        reports_dash dashreports = new reports_dash();
//       dashB.maindesktop.add(dashreports).setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
//        MessageFormat header = new MessageFormat("PATIENTS REPORTS");
//        
//        try{
//           
//            patientTableReports.print(JTable.PrintMode.NORMAL,header,null);
//            
//            
//        }catch(PrinterException ex){
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        
//        
//        }

//         JPanel printpanel = new JPanel();
//       PanelPrinter Pprint = new PanelPrinter(patientprinttable);
//       Pprint.printPanel();

    printTable(patientTableReports);


    }//GEN-LAST:event_jLabel3MouseClicked

    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped
        String query = searchbar.getText();
        String searchQuery = "SELECT * FROM tbl_patients WHERE p_id LIKE '%" + query + "%' OR p_firstname LIKE '%" + query + "%' OR p_lastname LIKE '%" + query + "%'";
    
    
        if (query.matches("\\d+")) {
            searchQuery = "SELECT * FROM tbl_patients WHERE p_id = " + query;
        }
    
        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
          DefaultTableModel model = (DefaultTableModel) patientTableReports.getModel();
        model.setRowCount(0); 
        
        while (rs.next()) {
            Object[] rowData = {
                rs.getInt("p_id"),
                rs.getString("p_lastname"),
                rs.getString("p_firstname"),
                rs.getString("p_age"),
                rs.getString("p_gender"),
                rs.getString("p_dateofbirth"),
                rs.getString("p_contact"),
                rs.getString("p_address")
            };
            model.addRow(rowData);
        }
        } catch(SQLException ex) {
            System.out.println("Error searching users: " + ex.getMessage());
        }
    }//GEN-LAST:event_searchbarKeyTyped

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
            java.util.logging.Logger.getLogger(patientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patientReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patientReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTableReports;
    private javax.swing.JPanel patientprinttable;
    private javax.swing.JTextField searchbar;
    // End of variables declaration//GEN-END:variables
}
