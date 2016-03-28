/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import pkg304application.database.DatabaseConnection;

/**
 *
 * @author jko
 */
public class GameInfoForm extends javax.swing.JFrame {

       
    /**
     * Creates new form GameInfoForm
     */
    ResultSet rs;
    Statement stmt;
    String thisGame;
    static int thisGameID;
    
    
    public GameInfoForm(String gameName, String gameDescription, int creatorID, int price){
        try {
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            initComponents();
            thisGame = gameName;
            stmt = dbc.getMyConnection().createStatement();
            String query = "select gameID from Game where gName='" + thisGame + "'";
            rs = stmt.executeQuery(query);
            rs.next();
            thisGameID = rs.getInt("gameID");
            initializeReviewButton();
            showReviewList();
            showGameInfo(gameName, gameDescription, creatorID, price);
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

        gameName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        developerName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        infoTab = new javax.swing.JTabbedPane();
        descriptionTab = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        reviewsTab = new javax.swing.JScrollPane();
        reviewList = new javax.swing.JList<>();
        achievementTab = new javax.swing.JScrollPane();
        achievementList = new javax.swing.JList<>();
        populationLabel = new javax.swing.JLabel();
        playerPopulation = new javax.swing.JLabel();
        reviewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameName.setFont(new java.awt.Font("PT Serif Caption", 1, 18)); // NOI18N
        gameName.setText("jLabel1");

        jLabel1.setText("Developer:");

        developerName.setText("jLabel2");

        jLabel2.setText("Price:");

        priceLabel.setText("jLabel3");

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionTab.setViewportView(descriptionArea);

        infoTab.addTab("Description", descriptionTab);

        reviewList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        reviewList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewListMouseClicked(evt);
            }
        });
        reviewsTab.setViewportView(reviewList);

        infoTab.addTab("Reviews", reviewsTab);

        achievementList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        achievementTab.setViewportView(achievementList);

        infoTab.addTab("Achievements", achievementTab);

        populationLabel.setText("Players:");

        playerPopulation.setText("jLabel4");

        reviewButton.setText("Write a Review");
        reviewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reviewButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(265, 265, 265)
                            .addComponent(gameName))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(populationLabel))
                                    .addGap(309, 309, 309)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(priceLabel)
                                        .addComponent(playerPopulation)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(developerName))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(gameName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(infoTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(developerName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(populationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerPopulation))
                .addGap(62, 62, 62)
                .addComponent(reviewButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reviewButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewButtonMouseClicked
        // TODO add your handling code here:
        if (!reviewButton.isEnabled()){
            System.out.println("you must own the game to make a review!");
            return;
        }
        System.out.println("User writing the review: " + MainForm.userName);
        new ReviewForm(MainForm.userName, thisGame).setVisible(true);
    }//GEN-LAST:event_reviewButtonMouseClicked

    private void reviewListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewListMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String selectedReview = reviewList.getSelectedValue();
            String query = "select R.reviewerID, G.gameID from Game G, Review R, Account A where R.reviewerID=A.userID and A.userName='"
                                    + selectedReview + "' and G.gameID = " + thisGameID;
            rs = stmt.executeQuery(query);
            rs.next();
            new SearchReviewForm(rs.getInt("reviewerID"), rs.getInt("gameID")).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reviewListMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> achievementList;
    private javax.swing.JScrollPane achievementTab;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JScrollPane descriptionTab;
    private javax.swing.JLabel developerName;
    private javax.swing.JLabel gameName;
    private javax.swing.JTabbedPane infoTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel playerPopulation;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton reviewButton;
    private javax.swing.JList<String> reviewList;
    private javax.swing.JScrollPane reviewsTab;
    // End of variables declaration//GEN-END:variables

    private void showGameInfo(String g, String d, int dev, int p) {
        try {
            gameName.setText(g);
            descriptionArea.setText(d);
            priceLabel.setText(Integer.toString(p));
            String queryStr = "Select userName from Account where userID=" + dev;
            rs = stmt.executeQuery(queryStr);
            rs.next();
            developerName.setText(rs.getString("userName"));
            queryStr = "select count(ownerID) from OwnsGame O, Game G where G.gameID = O.gameId and G.gName='" + g + "'";
            System.out.println(queryStr);
            rs = stmt.executeQuery(queryStr);
            rs.next();
            playerPopulation.setText(rs.getString("count(ownerID)"));
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void initializeReviewButton() {
        try {  
            String query = "select * from OwnsGame O, Game G where O.gameID =" + thisGameID + " and G.gName='"
                    + thisGame + "' and O.ownerID =" + MainForm.userID;
            rs = stmt.executeQuery(query);
            if (!rs.next()){
                
                reviewButton.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    private void showReviewList() {
        try {
            String queryStr = "select A.userName from Review R, Account A where R.gameReviewedID=" + thisGameID + " and R.reviewerID=A.userID";

            rs = stmt.executeQuery(queryStr);
            DefaultListModel reviewListModel = new DefaultListModel();
            while (rs.next()){
                reviewListModel.addElement(rs.getString("userName"));
            }
            reviewList.setModel(reviewListModel);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
