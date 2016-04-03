/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pkg304application.database.DatabaseConnection;

/**
 *
 * @author jinyou
 */
public class GameLibraryForm extends javax.swing.JFrame {
    
    public Statement stmt;
    public ResultSet rs;
    String thisSearchField;
    String thisFilterQuery;
    /**
     * Creates new form GameLibraryForm
     */
    public GameLibraryForm(String searchField) {
        try {
            if (searchField.equals("")){
                thisSearchField = "%";
            } else {
                thisSearchField = searchField;
            }
            initComponents();
            DatabaseConnection dbc = new DatabaseConnection();
            dbc.init();
            stmt = dbc.getMyConnection().createStatement();
            showGameList(searchField);
            showFilter();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ratingChoice = new java.awt.Choice();
        priceChoice = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        ratingTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        genreList = new java.awt.Choice();
        filterButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sortingChoice = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(386, 413));
        setResizable(false);
        setSize(new java.awt.Dimension(386, 413));
        getContentPane().setLayout(null);

        gameList.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        gameList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        gameList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gameList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 335, 160);

        addButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        addButton.setText("Add");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(20, 360, 75, 29);

        jLabel1.setFont(new java.awt.Font("Univers LT 45 Light", 0, 14)); // NOI18N
        jLabel1.setText("Search Result for Games:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 160, 162, 18);

        jLabel3.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        jLabel3.setText("Narrow By:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 30, 70, 16);

        ratingChoice.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        getContentPane().add(ratingChoice);
        ratingChoice.setBounds(80, 60, 70, 20);

        priceChoice.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        getContentPane().add(priceChoice);
        priceChoice.setBounds(240, 60, 70, 20);

        jLabel4.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        jLabel4.setText("rating:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 60, 40, 16);

        ratingTextField.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        getContentPane().add(ratingTextField);
        ratingTextField.setBounds(150, 60, 40, 20);

        priceTextField.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        priceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(priceTextField);
        priceTextField.setBounds(310, 60, 40, 20);

        jLabel5.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        jLabel5.setText("price:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(197, 60, 30, 16);

        jLabel6.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        jLabel6.setText("genre:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 90, 40, 16);

        genreList.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        getContentPane().add(genreList);
        genreList.setBounds(80, 90, 150, 20);

        filterButton.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        filterButton.setText("Filter");
        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterButtonMouseClicked(evt);
            }
        });
        getContentPane().add(filterButton);
        filterButton.setBounds(265, 90, 100, 29);

        jLabel2.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        jLabel2.setText("Sort By:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 60, 16);

        sortingChoice.setFont(new java.awt.Font("Univers LT 45 Light", 0, 12)); // NOI18N
        getContentPane().add(sortingChoice);
        sortingChoice.setBounds(80, 130, 110, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        // TODO add your handling code here:
        String insertStr;
        String selected = gameList.getSelectedValue();
        try{
            String selectStr = "select * from Game G where G.gName = '" + selected + "'";
            rs = stmt.executeQuery(selectStr);
            rs.next();          
            insertStr = "insert into OwnsGame(ownerID, gameID, playHours, priceBoughtAt) "
                + "values(" + MainForm.userID + " , " + rs.getInt("gameID") + ", 0 ," +  rs.getInt("currentPrice")  + " )";                        
            stmt.executeUpdate(insertStr); 
            this.setVisible(false);
            this.dispose();            
        } catch (SQLException ex) {
            Logger.getLogger(GameInfoForm.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }//GEN-LAST:event_addButtonMouseClicked

    private void gameListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameListMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if (evt.getClickCount() == 2){
            String selectedGame = gameList.getSelectedValue();
            String queryStr = "Select * from Game where gName='" + selectedGame + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            new GameInfoForm(rs.getString("gName"), rs.getString("gDescription"), rs.getInt("creatorID"), rs.getInt("currentPrice")).setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gameListMouseClicked

    private void priceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextFieldActionPerformed

    private void filterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterButtonMouseClicked
        try {
            // TODO add your handling code here:
            gameLibraryQueryBuilder(ratingChoice.getSelectedItem(), ratingTextField.getText(),
            priceChoice.getSelectedItem(), priceTextField.getText(), genreList.getSelectedItem(), sortingChoice.getSelectedItem());
            rs = stmt.executeQuery(thisFilterQuery);
            DefaultListModel gameListModel = new DefaultListModel();
            while (rs.next()){
                gameListModel.addElement(rs.getString("gName"));
            }
            gameList.setModel(gameListModel);
          //  refresh();
        } catch (SQLException ex) {
            Logger.getLogger(GameLibraryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filterButtonMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JList<String> gameList;
    private java.awt.Choice genreList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Choice priceChoice;
    private javax.swing.JTextField priceTextField;
    private java.awt.Choice ratingChoice;
    private javax.swing.JTextField ratingTextField;
    private java.awt.Choice sortingChoice;
    // End of variables declaration//GEN-END:variables
private void showGameList(String searchField) {
         try {
            if (searchField.equals("")){
                String queryStr = "Select DISTINCT G.gName from Game G";
                rs = stmt.executeQuery(queryStr);
                DefaultListModel gameListModel = new DefaultListModel();
                while (rs.next()){
                    gameListModel.addElement(rs.getString("gName"));
                }
                gameList.setModel(gameListModel);
            } else {
                String queryStr = "Select DISTINCT G.gName from Game G where G.gName LIKE '%" + searchField + "%'";
                                rs = stmt.executeQuery(queryStr);
                DefaultListModel gameListModel = new DefaultListModel();
                while (rs.next()){
                    gameListModel.addElement(rs.getString("gName"));
                }
                gameList.setModel(gameListModel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeveloperForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void showFilter() {
        try {
            sortingChoice.add("None");
            sortingChoice.add("Asc");
            sortingChoice.add("Desc");
            ratingChoice.add(">");
            ratingChoice.add(">=");
            ratingChoice.add("=");
            ratingChoice.add("<=");
            ratingChoice.add("<");
            ratingChoice.add("!=");
            ratingChoice.add(" ");
            priceChoice.add(">");
            priceChoice.add(">=");
            priceChoice.add("=");
            priceChoice.add("<=");
            priceChoice.add("<");
            priceChoice.add("!=");
            priceChoice.add(" ");   
            genreList.add("None");
            String queryStr = "Select * from Genre";
            ResultSet rs = stmt.executeQuery(queryStr);
            while (rs.next()){
              genreList.add(rs.getString("genre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewGameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void gameLibraryQueryBuilder(String ratingChoice, String ratingField, String priceChoice, String priceField, String genreChoice, String sortChoice) {
        thisFilterQuery = "select distinct G.gName from Game G, Review R, HasGenre H where gName like '" + thisSearchField + "'";
        if (checkFilterFields()){
            if (!genreChoice.equals("None")){
            thisFilterQuery = thisFilterQuery.concat(" and G.gameID = H.gameID and H.genre='" + genreChoice + "'");
            }
            if (!priceChoice.equals(" ") && !priceField.equals("")){
                thisFilterQuery = thisFilterQuery.concat(" and G.currentPrice " + priceChoice + priceField);
            }
            if (!ratingChoice.equals(" ") && !ratingField.equals("")){
                thisFilterQuery = thisFilterQuery.concat(" and (select avg(rating) from Game G2, Review R2"
                        + " where G2.gameID = R2.gameReviewedID and G2.gName = G.gName) " + ratingChoice + ratingField);
            }
            if (!sortChoice.equals("None")){
                thisFilterQuery = thisFilterQuery.concat(" group by G.gName " + sortChoice);
                System.out.println(thisFilterQuery);

            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Rating has to be betweeen 0 and 10, and price must be positive!", "Invalid filter!", JOptionPane.INFORMATION_MESSAGE);      
        }
    }
    
    private boolean checkFilterFields() {
        try{
        int rating = -1;
        int price = -1;
        if (!ratingTextField.getText().equals("")){
            rating = Integer.parseInt(ratingTextField.getText());
            if ((rating < 0) && (rating > 10)){
                return false;
            }
        }
        
        if (!priceTextField.getText().equals("")){
            price = Integer.parseInt(priceTextField.getText());
            if (price < 0){
                return false;
            } 
        }       
        return true;
        } catch (NumberFormatException nfe){
            return false;
        }
        
    }
    

}

