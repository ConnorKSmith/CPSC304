/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg304application.database.*;

/**
 *
 * @author jko
 */
import pkg304application.database.DatabaseConnection;
public class SearchReviewForm extends javax.swing.JFrame {
    
    /**
     * Creates new form SearchReviewForm
     */
    Statement stmt;
    ResultSet rs;
    
    public SearchReviewForm(int reviewerID, int gameID) {
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            initComponents();
            showReview(reviewerID, gameID);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(SearchReviewForm.class.getName()).log(Level.SEVERE, null, ex);
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

        reviewerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewArea = new javax.swing.JTextArea();
        reviewArea.setEditable(false);
        ratingLabel = new javax.swing.JLabel();
        rating = new javax.swing.JTextField();
        rating.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(351, 246));

        reviewerLabel.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        reviewerLabel.setText("jLabel1");

        reviewArea.setColumns(20);
        reviewArea.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        reviewArea.setRows(5);
        jScrollPane1.setViewportView(reviewArea);

        ratingLabel.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        ratingLabel.setText("Rated (out of 10) :");

        rating.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ratingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(reviewerLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(reviewerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ratingLabel)
                    .addComponent(rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rating;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JTextArea reviewArea;
    private javax.swing.JLabel reviewerLabel;
    // End of variables declaration//GEN-END:variables

    private void showReview(int reviewerID, int gameID) {
        try {
            String query = "select * from Review R, Game G, Account A where R.reviewerID="
                    + reviewerID +" and R.gameReviewedID=" + gameID +" and A.userID=" + reviewerID; 
            rs = stmt.executeQuery(query);
            System.out.println(query);
            rs.next();
            rating.setText(Integer.toString(rs.getInt("rating")));
            reviewArea.setText(rs.getString("reviewDesc"));
            reviewerLabel.setText(rs.getString("userName"));
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchReviewForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
