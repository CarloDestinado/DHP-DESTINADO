/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADDFORMSINTERNALPAGE;

import static admin.admin_Addacc.getHeightFromWidth;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import user.desk_dashboard;

/**
 *
 * @author once
 */
public class userinfo extends javax.swing.JFrame {

    /**
     * Creates new form userinfo
     */
    public userinfo() {
        initComponents();
    }
     public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
     
     public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public void userdetails(){
        Session sess = Session.getInstance();
        
        id.setText(""+sess.getId());
        acctype.setText(""+sess.getType());
        Fname.setText(""+sess.getFname());
        Lname.setText(""+sess.getLname());
        email.setText(""+sess.getEmail());
        uname.setText(""+sess.getUname());
        picture.setIcon(ResizeImage(sess.getImage(), null, picture));
        
        
              
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        picture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        acctype = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        Fname = new javax.swing.JLabel();
        Lname = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        jLabel17.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.gray));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 220, 50, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("First name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 260, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Last name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 300, 90, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 340, 60, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("username:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 380, 100, 30);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsImage/icons8-test-account-100.png"))); // NOI18N
        picture.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.orange, java.awt.Color.blue, null));
        jPanel2.add(picture);
        picture.setBounds(0, 0, 220, 130);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(80, 30, 220, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsImage/arrow_circle_left_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(6, 4, 60, 40);

        acctype.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        acctype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acctype.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(acctype);
        acctype.setBounds(120, 170, 130, 30);

        id.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(id);
        id.setBounds(100, 220, 190, 30);

        Fname.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Fname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(Fname);
        Fname.setBounds(100, 260, 190, 30);

        Lname.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(Lname);
        Lname.setBounds(100, 300, 190, 30);

        email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(email);
        email.setBounds(100, 340, 190, 30);

        uname.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        uname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(uname);
        uname.setBounds(100, 380, 190, 30);

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel18.setText("or");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(170, 470, 20, 14);

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("UPDATE INFO");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 0, 130, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 430, 130, 30);

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CHANGE PASSWORD");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(90, 490, 180, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
           
        try{
             Session sess = Session.getInstance();
             int userId = sess.getId();     
             dbConnector dbc = new dbConnector();
             
             ResultSet rs = dbc.getData("SELECT * FROM tbl_userdetails WHERE u_id = '"+userId+"'");
                
              if(rs.next()){
             Udetails update = new Udetails();
              update.picture.setIcon(update.ResizeImage(rs.getString("u_images"), null,update.picture));
              update.oldpath = rs.getString("u_images");
             update.path = rs.getString("u_images");
             update.destination = rs.getString("u_images");
             
             if(rs.getString("u_images").isEmpty()){
              update.selectbut.setEnabled(true);
               update.removebut.setEnabled(false);
            }else{
              update.selectbut.setEnabled(false);
               update.removebut.setEnabled(true);
            }
              update.setVisible(true);
             this.dispose();
              }
              
            }catch(SQLException ex){
                System.out.println(""+ex);
            }
//        dbConnector dbc = new dbConnector();
//            dbc.UpdateData("UPDATE tbl_userdetails SET u_firstname = '"+Fname.getText()+"',u_lastname = '"+Lname.getText()+"',u_email = '"+Email.getText()+"',u_username =  '"+uname.getText()+"',u_password = '"+pass.getText()+"',u_account = '"+acctype.getText()+"'Where u_id = '"+id.getText()+"'");
//             JOptionPane.showMessageDialog(null,"Data Updated Please Login Again to Refresh the Information!");
//             this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
     userdetails();
    }//GEN-LAST:event_formWindowActivated

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
      changepass change = new changepass();
      change.setVisible(true);
      dispose();
      
    }//GEN-LAST:event_jLabel16MouseClicked

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
            java.util.logging.Logger.getLogger(userinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fname;
    private javax.swing.JLabel Lname;
    private javax.swing.JLabel acctype;
    private javax.swing.JLabel email;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel picture;
    private javax.swing.JLabel uname;
    // End of variables declaration//GEN-END:variables
}
