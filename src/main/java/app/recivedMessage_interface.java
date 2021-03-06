/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Terfa
 */
public class recivedMessage_interface extends javax.swing.JFrame {

    String user,pass,side;
    /**
     * Creates new form recivedMessage_interface
     */
    public recivedMessage_interface() {
        initComponents();
        
    }
    public ArrayList<rec_message> messagelist(){
        ArrayList<rec_message> messagelist = new ArrayList<>();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/samproject","root","");
            
            String sql = "select * from message where destination='"+side+"' and is_sent='تم الإرسال'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rec_message mes;
            
            while(rs.next()){
                mes = new rec_message(rs.getInt("id"),rs.getString("message_number"),rs.getString("date"),rs.getString("letter_attachments"),rs.getString("type"),rs.getString("subject"),rs.getString("source"),rs.getString("is_urgent"),rs.getString("send_method"),rs.getString("sender"),rs.getString("reciver"),rs.getString("isOpened"));
                messagelist.add(mes);
            }
            
        conn.close();
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    return messagelist;
    
    }
    
    public void show_message(){
        ArrayList<rec_message> list = messagelist();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Message.getModel();
        Object[] row = new Object[12];
        for(int i = 0;i<list.size();i++){
          row[0]=list.get(i).getmessage_state();
          row[1]=list.get(i).getmessage_reciver();
          row[2]=list.get(i).getmessage_sender();
          row[3]=list.get(i).getmessage_send_method();
          row[4]=list.get(i).getmessage_is_urgent();
          row[5]=list.get(i).getmessage_source();
          row[6]=list.get(i).getmessage_subject();
          row[7]=list.get(i).getmessage_type();
          row[8]=list.get(i).getmessage_letter_attachments();
          row[9]=list.get(i).getmessage_number_m();
          row[10]=list.get(i).getmessage_date();
          row[11]=list.get(i).getmessage_id();
          model.addRow(row);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        message_number = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        attachments = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        in = new javax.swing.JRadioButton();
        ex = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        through_circus = new javax.swing.JRadioButton();
        through_person = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        isRescived = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Message = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        des = new javax.swing.JTextField();
        sender = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        reciver = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("إستلام الرسالة");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("الرقم التسلسلي");

        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("التاريخ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("نمرة المراسلة");

        message_number.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("مرفقات الخطاب");

        attachments.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("النوع");

        buttonGroup1.add(in);
        in.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        in.setText("داخـــلي");
        in.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroup1.add(ex);
        ex.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ex.setText("خـارجـــي");
        ex.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("الموضوع");

        subject.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("الجهة المرسلة");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("وصف المراسلة");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setText("عاجل");
        jRadioButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setText("عادي");
        jRadioButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("طريقة الإرسال");

        buttonGroup3.add(through_circus);
        through_circus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        through_circus.setText("عبر السيرك");
        through_circus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        buttonGroup3.add(through_person);
        through_person.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        through_person.setText("عن طريق شخص");
        through_person.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("حالة الإستلام");

        isRescived.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        isRescived.setText("تم الإستلام");
        isRescived.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTable_Display_Message.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "حالة الإستلام", "إسم المستلم", "إسم المرسل", "طريقة الإرسال", "وصف المراسلة", "الوجه المرسلة", "الموضوع", "النوع", "مرفقات الخطاب", "نمرة المراسلة", "التاريخ", "الرقم التسلسلي"
            }
        ));
        jTable_Display_Message.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_MessageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Message);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("إسم المرسل");

        des.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        sender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("اسم المستلم");

        reciver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("إستلام");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("عرض الرسائل");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Terfa\\Documents\\NetBeansProjects\\samproject\\src\\main\\java\\img\\back_1.png")); // NOI18N
        jButton4.setText("رجوع");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(message_number)
                                                    .addComponent(subject, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(through_person)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(isRescived)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(through_circus)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel10)))))
                                        .addGap(95, 95, 95)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(ex)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(in)))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel3)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(35, 35, 35)
                                        .addComponent(reciver, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel13)))
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(attachments)
                                    .addComponent(des)
                                    .addComponent(sender))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel12)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(message_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(attachments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(in)
                    .addComponent(ex)
                    .addComponent(jLabel7)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jLabel10)
                        .addComponent(through_circus)
                        .addComponent(through_person)
                        .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(reciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(isRescived))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model = (DefaultTableModel)jTable_Display_Message.getModel();
       model.setRowCount(0);
       show_message();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable_Display_MessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_MessageMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int i = jTable_Display_Message.getSelectedRow();
            TableModel model = jTable_Display_Message.getModel();
            id.setText(model.getValueAt(i,11).toString());
            Date da = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 10));
            date.setDate(da);
            message_number.setText(model.getValueAt(i, 9).toString());
            attachments.setText(model.getValueAt(i, 8).toString());
            String type = model.getValueAt(i,7).toString();
            if(type.equals("داخـــلي")){
                in.setSelected(true);
            }else{
                ex.setSelected(true);
            }
            subject.setText(model.getValueAt(i, 6).toString());
            des.setText(model.getValueAt(i,5).toString());
            String Urge = model.getValueAt(i,4).toString();
            if(Urge.equals("عاجل")){
                jRadioButton1.setSelected(true);
            }else{
                jRadioButton2.setSelected(true);
            }
            
            String sendMethod = model.getValueAt(i, 3).toString();
            if(sendMethod.equals("عبر السيرك")){
                through_circus.setSelected(true);
            }else{
                through_person.setSelected(true);
            }
            
            sender.setText(model.getValueAt(i,2).toString());
            reciver.setText(model.getValueAt(i,1).toString());
            String see = model.getValueAt(i, 0).toString();
            if(see.equals("تم الإستلام")){
                isRescived.setSelected(true);
            }else{
                isRescived.setSelected(false);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(SentMessages_interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jTable_Display_MessageMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/samproject","root","");
            
            String sql = "update message set isOpened='تم الإستلام',reciver='"+user+"' where id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id.getText()));
           
           
            pstmt.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable_Display_Message.getModel();
            model.setRowCount(0);
            show_message();
            JOptionPane.showMessageDialog(null, "تم إستلام الرسالة");
            conn.close();
            
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        secretary_interface back = new secretary_interface();
        back.jLabel3.setText(user);
        back.jLabel4.setText(pass);
        back.side=side;
        
        back.setVisible(true);
        back.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(recivedMessage_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recivedMessage_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recivedMessage_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recivedMessage_interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recivedMessage_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attachments;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField des;
    private javax.swing.JRadioButton ex;
    private javax.swing.JTextField id;
    private javax.swing.JRadioButton in;
    private javax.swing.JCheckBox isRescived;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Message;
    private javax.swing.JTextField message_number;
    private javax.swing.JTextField reciver;
    private javax.swing.JTextField sender;
    private javax.swing.JTextField subject;
    private javax.swing.JRadioButton through_circus;
    private javax.swing.JRadioButton through_person;
    // End of variables declaration//GEN-END:variables
}
