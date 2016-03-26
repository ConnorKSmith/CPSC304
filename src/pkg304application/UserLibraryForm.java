/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;
import pkg304application.database.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
/**
 *
 * @author jko
 */
public class UserLibraryForm extends javax.swing.JFrame {

    /**
     * Creates new form UserLibraryForm
     */
    Statement stmt;
    Statement stmt2;
    ResultSet rs;
    ResultSet rs2;
    
    public UserLibraryForm(String searchField) {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            stmt2 = dbc.getMyConnection().createStatement();
            initComponents();
            showUserList(searchField);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(UserLibraryForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search Result for Users:");

        userList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() > 2){
            String selectedUser = userList.getSelectedValue();
            String queryString = "Select A.userID from Account A where A.userName='" + selectedUser + "'";
                try {
                    rs = stmt.executeQuery(queryString);
                    System.out.println(queryString);
                    if (rs.next()){
                        String check = "select * from Developer where developerID=" + rs.getInt("userID");
                        ResultSet rs2 = stmt2.executeQuery(check);
                        if (rs2.next()){
                            new SearchUserForm(rs.getInt("userID"), true).setVisible(true);
                        } else {
                            new SearchUserForm(rs.getInt("userID"), false).setVisible(true);
                        }
                    } else {
                        System.out.println("no user exists");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_userListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables

    private void showUserList(String searchField) {
        try {
            if (searchField.equals("")){
                String queryStr = "Select DISTINCT A.userName from Account A";
                rs = stmt.executeQuery(queryStr);
                DefaultListModel userListModel = new DefaultListModel();
                while (rs.next()){
                    userListModel.addElement(rs.getString("userName"));
                }
                userList.setModel(userListModel);
            } else {
                String queryStr = "Select DISTINCT A.userName from Account A where A.userName LIKE '%" + searchField + "%'";          
                System.out.println(queryStr);
                rs = stmt.executeQuery(queryStr);
                DefaultListModel userListModel = new DefaultListModel();
                while (rs.next()){
                    userListModel.addElement(rs.getString("userName"));
                }
                userList.setModel(userListModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
