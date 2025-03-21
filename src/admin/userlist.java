/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author once
 */
public class userlist extends javax.swing.JFrame {

    /**
     * Creates new form userlist
     */
    public userlist() {
        initComponents();
        
        displaydata();
         usertable.setDefaultEditor(Object.class, null);
        customizeTable();
    }
    
    private void customizeTable() {
        // Disable cell editing
        usertable.setDefaultEditor(Object.class, null);
       usertable.getTableHeader().setBackground(Color.decode("#2A629A"));
        
        // Customize table header
        Font headerfont = new Font("Verdana",Font.PLAIN,12);
        usertable.getTableHeader().setFont(headerfont);
        usertable.setRowHeight(25);

        TableCellRenderer renderer = usertable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) renderer;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    
    
    }
    
        Color navcolor = new Color(0,204,204);
       Color bodycolor = new Color(0,255,255);
    
    
     public void displaydata(){
            try{
              dbConnector DBconnector = new dbConnector();
              ResultSet rs = DBconnector.getData("SELECT * FROM tbl_userdetails");
              usertable.setModel(DbUtils.resultSetToTableModel(rs));
                
              TableColumnModel columnModel = usertable.getColumnModel();
            columnModel.getColumn(0).setHeaderValue("User ID");
            columnModel.getColumn(1).setHeaderValue("First Name");
            columnModel.getColumn(2).setHeaderValue("Last Name");
            columnModel.getColumn(3).setHeaderValue("Email");
            columnModel.getColumn(4).setHeaderValue("Username");
            columnModel.getColumn(5).setHeaderValue("Password");
            columnModel.getColumn(6).setHeaderValue("Account Type");
            columnModel.getColumn(7).setHeaderValue("Status");
            
            

            // Refresh the table UI
           usertable.getTableHeader().repaint();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        EDITBUT = new javax.swing.JPanel();
        editbutton = new javax.swing.JLabel();
        REFRESHBUT = new javax.swing.JPanel();
        refresh = new javax.swing.JLabel();
        searchbar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ADDBUT = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 20, 260, 40);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(null);

        EDITBUT.setBackground(new java.awt.Color(255, 255, 255));
        EDITBUT.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        EDITBUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EDITBUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EDITBUTMouseExited(evt);
            }
        });
        EDITBUT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editbutton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editbutton.setText("EDIT");
        editbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbuttonMouseClicked(evt);
            }
        });
        EDITBUT.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 30));

        jPanel5.add(EDITBUT);
        EDITBUT.setBounds(100, 40, 70, 30);

        REFRESHBUT.setBackground(new java.awt.Color(255, 255, 255));
        REFRESHBUT.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        REFRESHBUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                REFRESHBUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                REFRESHBUTMouseExited(evt);
            }
        });
        REFRESHBUT.setLayout(null);

        refresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setText("REFRESH");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        REFRESHBUT.add(refresh);
        refresh.setBounds(5, 0, 60, 30);

        jPanel5.add(REFRESHBUT);
        REFRESHBUT.setBounds(190, 40, 70, 30);

        searchbar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        searchbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchbarKeyTyped(evt);
            }
        });
        jPanel5.add(searchbar);
        searchbar.setBounds(530, 50, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("SEARCH:");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(530, 30, 80, 17);

        ADDBUT.setBackground(new java.awt.Color(255, 255, 255));
        ADDBUT.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        ADDBUT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADDBUTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADDBUTMouseExited(evt);
            }
        });
        ADDBUT.setLayout(null);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("NEW");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        ADDBUT.add(add);
        add.setBounds(10, 0, 50, 30);

        jPanel5.add(ADDBUT);
        ADDBUT.setBounds(20, 40, 70, 30);

        usertable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "LASTNAME", "FIRSTNAME", "USERNAME", "PASSWORD", "EMAIL", "ACCOUNT TYPE", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usertable.setFocusable(false);
        usertable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        usertable.setRowHeight(25);
        usertable.setSelectionBackground(new java.awt.Color(80, 196, 237));
        usertable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(usertable);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 720, 290);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 70, 750, 400);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsImage/chevron_left_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbuttonMouseClicked
        int rowindex = usertable.getSelectedRow();
        if(rowindex<0){
            JOptionPane.showMessageDialog(null,"Please select an item!");

        }else{
            try{
                dbConnector dbc = new dbConnector();
            
            TableModel tbl = usertable.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_userdetails WHERE u_id = '"+tbl.getValueAt(rowindex,0)+"'");
            
            if(rs.next()){
            admin_Addacc AForm = new  admin_Addacc();
             AForm.id.setText(""+rs.getString("u_id"));
             AForm.fname.setText(""+rs.getString("u_firstname"));
             AForm.lname.setText(""+rs.getString("u_lastname"));
             AForm.email.setText(""+rs.getString("u_email"));
             AForm.uname.setText(""+rs.getString("u_username"));
             AForm.pass.setText(""+rs.getString("u_password"));
             AForm.acctype.setSelectedItem(""+rs.getString("u_account"));
             AForm.status.setSelectedItem(""+rs.getString("u_status"));
             AForm.oldpath = rs.getString("u_images");
             AForm.path = rs.getString("u_images");
             AForm.destination = rs.getString("u_images");
            AForm.setVisible(true);
            
             AForm.action = "Update";
             AForm.u_save.setText("UPDATE");
            this.dispose();
        }
            }catch(SQLException ex){
                System.out.println(""+ex);
            
            }
            }
    }//GEN-LAST:event_editbuttonMouseClicked

    private void EDITBUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITBUTMouseEntered
        EDITBUT.setBackground(navcolor);
    }//GEN-LAST:event_EDITBUTMouseEntered

    private void EDITBUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITBUTMouseExited
        EDITBUT.setBackground(bodycolor);
    }//GEN-LAST:event_EDITBUTMouseExited

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        displaydata();
    }//GEN-LAST:event_refreshMouseClicked

    private void REFRESHBUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REFRESHBUTMouseEntered
        REFRESHBUT.setBackground(bodycolor);
    }//GEN-LAST:event_REFRESHBUTMouseEntered

    private void REFRESHBUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_REFRESHBUTMouseExited
        REFRESHBUT.setBackground(bodycolor);
    }//GEN-LAST:event_REFRESHBUTMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Admin_dashboard Adash = new Admin_dashboard();
        Adash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
       
           admin_Addacc Aform = new admin_Addacc();
            Aform.setVisible(true);
            this.dispose();
        Aform.action = "NEW";
        Aform.u_save.setText("SAVE");
        
        Aform.removebut.setEnabled(false);
        Aform.selectbut.setEnabled(true);
    }//GEN-LAST:event_addMouseClicked

    private void ADDBUTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDBUTMouseEntered
        ADDBUT.setBackground(navcolor);
    }//GEN-LAST:event_ADDBUTMouseEntered

    private void ADDBUTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDBUTMouseExited
        ADDBUT.setBackground(navcolor);
    }//GEN-LAST:event_ADDBUTMouseExited

    private void searchbarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbarKeyTyped
       String query = searchbar.getText();
        String searchQuery = "SELECT * FROM tbl_userdetails WHERE u_id LIKE '%" + query + "%' OR u_firstname LIKE '%" + query + "%' OR u_lastname LIKE '%" + query + "%' OR u_username LIKE '%" + query +"%' OR u_account LIKE '%" + query +"%' OR u_status LIKE '%" + query +"%'";
    
    
        if (query.matches("\\d+")) {
            searchQuery = "SELECT * FROM tbl_userdetails WHERE u_id = " + query;
        }
    
        try {
            dbConnector connect = new dbConnector();
            ResultSet rs = connect.getData(searchQuery);
            
        DefaultTableModel model = (DefaultTableModel) usertable.getModel();
        model.setRowCount(0); 
        
        while (rs.next()) {
            Object[] rowData = {
                rs.getInt("u_id"),
                rs.getString("u_lastname"),
                rs.getString("u_firstname"),
                rs.getString("u_username"),
                rs.getString("u_password"),
                rs.getString("u_email"),
                rs.getString("u_account"),
                rs.getString("u_status")
               
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
            java.util.logging.Logger.getLogger(userlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDBUT;
    private javax.swing.JPanel EDITBUT;
    private javax.swing.JPanel REFRESHBUT;
    private javax.swing.JLabel add;
    private javax.swing.JLabel editbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField searchbar;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
