/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADDFORMSINTERNALPAGE;

import config.Session;
import config.dbConnector;
import internalpages.appointment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import user.desk_dashboard;

/**
 *
 * @author Noname
 */
public class addAppointment extends javax.swing.JFrame {

    /**
     * Creates new form addAppointment
     */
    public addAppointment() {
        initComponents();
        populateDoctorComboBox();
        patientcombox();
//        createTimeField();
       
    }
    
    
    private void populateDoctorComboBox() {
    try {
        dbConnector dbc = new dbConnector();
      
            ResultSet resultSet = dbc.getData("SELECT u_id, u_lastname FROM tbl_userdetails WHERE u_account = 'DOCTOR' AND u_status = 'Active' ");
        
        // Populate the combo box with doctor IDs and names
        while (resultSet.next()) {
            String doctorID = resultSet.getString("u_id");
            String doctorName = resultSet.getString("u_lastname");
            String doctorInfo = doctorID + " - " + doctorName;
            doctor.addItem(doctorInfo);
        }
        
        // Close connections
        resultSet.close();
       
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: Failed to retrieve doctor information.");
    }
}
    
   private void patientcombox() {
    try {
        dbConnector dbc = new dbConnector();
      
            ResultSet resultSet = dbc.getData("SELECT p_id, p_lastname,p_firstname FROM tbl_patients");
        
        // Populate the combo box with doctor IDs and names
        while (resultSet.next()) {
            String patientID = resultSet.getString("p_id");
            String patientFName = resultSet.getString("p_firstname");
            String patientLname = resultSet.getString("p_lastname");
            String doctorInfo = patientID + " - " + patientFName+","+patientLname;
            patientId.addItem(doctorInfo);
        }
        
        // Close connections
        resultSet.close();
       
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: Failed to retrieve doctor information.");
    }
} 
   
   private void createTimeField() {
        try {
            MaskFormatter timeFormatter = new MaskFormatter("##:##");
            time = new JFormattedTextField(timeFormatter);
            time.setBounds(260, 140, 90, 30);
            jPanel2.add(time);
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to create time input field.");
        }
    }
   
   
//  private boolean isAppointmentTimeAvailable(String selectedDate, String selectedTime, String selectedDoctorID) {
//    dbConnector dbc = new dbConnector();
//    String query = "SELECT COUNT(*) FROM tbl_appointment WHERE date = '" + selectedDate + "' AND time = '" + selectedTime + "' AND u_id = " + selectedDoctorID;
//    ResultSet resultSet = null;
//    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//    try {
//        resultSet = dbc.getData(query);
//        if (resultSet.next()) {
//            int count = resultSet.getInt(1);
//            if (count == 0) {
//               
//                return true; 
//            } else {
//             
//                JOptionPane.showMessageDialog(null, "This time is already scheduled. Please select another time.", "Time Unavailable", JOptionPane.WARNING_MESSAGE);
//                return false;
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    return false; 
//}
    
   private boolean isAppointmentTimeAvailable(String selectedDate, String selectedTime, String selectedDoctorID) {
    dbConnector dbc = new dbConnector();
    String query = "SELECT time FROM tbl_appointment WHERE date = '" + selectedDate + "' AND u_id = " + selectedDoctorID;
    ResultSet resultSet = null;
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    try {
        resultSet = dbc.getData(query);
        Date selectedTimeDate = timeFormat.parse(selectedTime);

        while (resultSet.next()) {
            String existingTime = resultSet.getString("time");
            Date existingTimeDate = timeFormat.parse(existingTime);

            long timeDifference = Math.abs(selectedTimeDate.getTime() - existingTimeDate.getTime());
            long timeDifferenceInMinutes = timeDifference / (60 * 1000);

            if (timeDifferenceInMinutes < 60) {
                JOptionPane.showMessageDialog(null, "This time is already scheduled within an hour. Please select another time.", "Time Unavailable", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        return true;
    } catch (SQLException | ParseException e) {
        e.printStackTrace();
    } finally {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return false;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        appttype = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        doctor = new javax.swing.JComboBox<>();
        patientId = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PATIENT ID:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 20, 200, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APPOINTMENT SCHEDULE:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 100, 190, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TIME:");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 150, 70, 30);
        jPanel2.add(time);
        time.setBounds(20, 190, 210, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DATE:");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 230, 70, 30);

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setText("<html>Procedure do you want to make an appointment for?<html>");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel14);
        jLabel14.setBounds(290, 10, 230, 50);

        appttype.setEditable(true);
        appttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Medical Examination", "Doctor check", "Check-Up" }));
        jPanel2.add(appttype);
        appttype.setBounds(290, 70, 230, 50);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DOCTORS:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(360, 140, 110, 20);

        label.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("SAVE");
        label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
        });
        jPanel2.add(label);
        label.setBounds(300, 390, 80, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CANCEL");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8);
        jLabel8.setBounds(400, 390, 90, 27);

        doctor.setEditable(true);
        doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Doctor " }));
        doctor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorActionPerformed(evt);
            }
        });
        jPanel2.add(doctor);
        doctor.setBounds(330, 170, 170, 50);

        patientId.setBackground(new java.awt.Color(204, 204, 204));
        patientId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select patient ID" }));
        patientId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(patientId);
        patientId.setBounds(20, 60, 200, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 60, 540, 430);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appointment form");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 20, 280, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
//       desk_dashboard dDash = new desk_dashboard();
//       dDash.setVisible(true);
//       appointment appt = new appointment();
//       dDash.maindesktop.add(appt).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseClicked
     dbConnector dbc = new dbConnector();
         String selectedDoctorInfo = (String) doctor.getSelectedItem();
         String[] parts = selectedDoctorInfo.split(" - ");
        String selectedDoctorID = parts[0]; // Extracting the doctor's ID
        
        String selectedpatientInfo = (String) patientId.getSelectedItem();
         String[] patientParts = selectedpatientInfo.split(" - ");
        String selectedpatientID = patientParts[0];
        
            
        Date selectedDateObj = calendar.getDate();
        
                
        String selectedTime = time.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String selectedDate = dateFormat.format(selectedDateObj);
        
        if (selectedpatientID.equals("Select patient ID") || selectedDoctorID.equals("Select Doctor ") || calendar.getDate() == null || selectedTime.isEmpty() || appttype.getSelectedItem().equals("Please Select")) {
     JOptionPane.showMessageDialog(null, "Please fill out all required fields!", "Missing Information", JOptionPane.WARNING_MESSAGE);
    return;
  }
            Session sess = Session.getInstance();
            int deskID = sess.getId();
       
         if (isAppointmentTimeAvailable(selectedDate, selectedTime, selectedDoctorID)) {
        String query = "INSERT INTO tbl_appointment (p_id, apptType, date, time, u_id, apptStatus,staff_id  ,created_date) VALUES ('"+selectedpatientID+"','"+appttype.getSelectedItem()+"', '"+selectedDate+"', '"+selectedTime+"', "+selectedDoctorID+",'Scheduled','"+deskID+"',NOW())";
         boolean result = dbc.insertData(query);
        if (result) {
        JOptionPane.showMessageDialog(null, "Successfully Saved!");
        desk_dashboard dDash = new desk_dashboard();
        appointment appt = new appointment();
        dDash.maindesktop.add(appt).setVisible(true);
        this.dispose();
        } else {
        System.out.println("Saving Data Failed!");
        }
         }

    }//GEN-LAST:event_labelMouseClicked

    private void doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorActionPerformed
       
    }//GEN-LAST:event_doctorActionPerformed

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
            java.util.logging.Logger.getLogger(addAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> appttype;
    public javax.swing.JComboBox<String> doctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel label;
    public javax.swing.JComboBox<String> patientId;
    public javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
