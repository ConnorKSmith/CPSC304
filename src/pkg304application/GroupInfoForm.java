/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg304application.database.DatabaseConnection;

/**
 *
 * @author jinyou
 */
public class GroupInfoForm extends javax.swing.JFrame {

    /**
     * Creates new form GroupInfoForm
     */
    ResultSet rs;
    Statement stmt;
    public GroupInfoForm() {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            initComponents();
            stmt = dbc.getMyConnection().createStatement();
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(GroupInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public GroupInfoForm(String groupName, String groupDesc, int creatorUserID, int dateCreated){
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            initComponents();
            stmt = dbc.getMyConnection().createStatement();
            showGroupInfo(groupName, groupDesc, creatorUserID, dateCreated);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
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

        groupName = new javax.swing.JLabel();
        infoTab = new javax.swing.JTabbedPane();
        descriptionTab = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        userListTab = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        creatorName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateCreated = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        groupName.setText("jLabel1");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionTab.setViewportView(descriptionArea);

        infoTab.addTab("Description", descriptionTab);

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userListTab.setViewportView(userList);

        infoTab.addTab("User List", userListTab);

        jLabel1.setText("Creator");

        creatorName.setText("jLabel2");

        jLabel3.setText("Date Created");

        dateCreated.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creatorName)
                            .addComponent(dateCreated))
                        .addGap(112, 112, 112)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(creatorName))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateCreated))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroupInfoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creatorName;
    private javax.swing.JLabel dateCreated;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JScrollPane descriptionTab;
    private javax.swing.JLabel groupName;
    private javax.swing.JTabbedPane infoTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> userList;
    private javax.swing.JScrollPane userListTab;
    // End of variables declaration//GEN-END:variables
private void showGroupInfo(String g, String d, int cre, int date) {
        try {
            groupName.setText(g);
            descriptionArea.setText(d);
            dateCreated.setText(Integer.toString(date));
            String queryStr = "Select userName from Account where userID=" + cre;
            rs = stmt.executeQuery(queryStr);
            rs.next();
            creatorName.setText(rs.getString("userName"));
            //queryStr = "select count(ownerID) from OwnsGame O, Game G where G.gameID = O.gameId and G.gName='" + g + "'";
            //rs = stmt.executeQuery(queryStr);
            //rs.next();
            //playerPopulation.setText(rs.getString("count(ownerID)"));
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
