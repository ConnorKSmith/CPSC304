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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jko
 */
public class SignUpForm extends javax.swing.JFrame {

    /**
     * Creates new form SignUpForm
     */
    
    Statement stmt = null;
    ResultSet rs = null;
    
    public SignUpForm() {
        initComponents();
        mismatch.setVisible(false);
        alreadyExists.setVisible(false);
        insufficientInfo.setVisible(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        signUpTitle = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        createAccountButton = new javax.swing.JButton();
        passwordLabel2 = new javax.swing.JLabel();
        passwordField2 = new javax.swing.JPasswordField();
        playerButton = new javax.swing.JRadioButton();
        accountTypeLabel = new javax.swing.JLabel();
        developerButton = new javax.swing.JRadioButton();
        mismatch = new javax.swing.JLabel();
        alreadyExists = new javax.swing.JLabel();
        insufficientInfo = new javax.swing.JLabel();
        backgroundImg = new javax.swing.JLabel();

        buttonGroup1.add(playerButton);
        buttonGroup1.add(developerButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 530));
        setResizable(false);
        getContentPane().setLayout(null);

        signUpTitle.setFont(new java.awt.Font("Nanum Brush Script", 0, 36)); // NOI18N
        signUpTitle.setText("Sign up here!");
        getContentPane().add(signUpTitle);
        signUpTitle.setBounds(154, 39, 155, 43);

        userNameLabel.setFont(new java.awt.Font("Nanum Pen Script", 0, 24)); // NOI18N
        userNameLabel.setText("Your username:");
        getContentPane().add(userNameLabel);
        userNameLabel.setBounds(51, 123, 130, 29);

        passwordLabel.setFont(new java.awt.Font("Nanum Pen Script", 0, 24)); // NOI18N
        passwordLabel.setText("Your password:");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(51, 198, 129, 29);

        userNameTextField.setFont(new java.awt.Font("Nanum Brush Script", 0, 22)); // NOI18N
        userNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(userNameTextField);
        userNameTextField.setBounds(245, 128, 170, 31);

        passwordField.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(passwordField);
        passwordField.setBounds(245, 203, 170, 24);

        createAccountButton.setFont(new java.awt.Font("Nanum Pen Script", 0, 24)); // NOI18N
        createAccountButton.setText("Create Account");
        createAccountButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
            }
        });
        getContentPane().add(createAccountButton);
        createAccountButton.setBounds(153, 429, 162, 33);

        passwordLabel2.setFont(new java.awt.Font("Nanum Pen Script", 0, 24)); // NOI18N
        passwordLabel2.setText("Re-enter:");
        getContentPane().add(passwordLabel2);
        passwordLabel2.setBounds(51, 244, 80, 29);

        passwordField2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        passwordField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(passwordField2);
        passwordField2.setBounds(245, 245, 170, 24);

        playerButton.setFont(new java.awt.Font("Nanum Pen Script", 0, 18)); // NOI18N
        playerButton.setText("Player");
        getContentPane().add(playerButton);
        playerButton.setBounds(247, 330, 68, 27);

        accountTypeLabel.setFont(new java.awt.Font("Nanum Pen Script", 0, 24)); // NOI18N
        accountTypeLabel.setText("Account Type:");
        getContentPane().add(accountTypeLabel);
        accountTypeLabel.setBounds(51, 327, 122, 29);

        developerButton.setFont(new java.awt.Font("Nanum Pen Script", 0, 18)); // NOI18N
        developerButton.setText("Developer");
        getContentPane().add(developerButton);
        developerButton.setBounds(321, 330, 88, 27);

        mismatch.setFont(new java.awt.Font("Nanum Pen Script", 0, 18)); // NOI18N
        mismatch.setForeground(new java.awt.Color(255, 0, 0));
        mismatch.setText("The passwords do not match!");
        getContentPane().add(mismatch);
        mismatch.setBounds(51, 291, 180, 22);

        alreadyExists.setFont(new java.awt.Font("Nanum Pen Script", 0, 18)); // NOI18N
        alreadyExists.setForeground(new java.awt.Color(255, 0, 0));
        alreadyExists.setText("Username already exists!");
        getContentPane().add(alreadyExists);
        alreadyExists.setBounds(51, 158, 149, 22);

        insufficientInfo.setFont(new java.awt.Font("Nanum Pen Script", 0, 18)); // NOI18N
        insufficientInfo.setForeground(new java.awt.Color(255, 0, 0));
        insufficientInfo.setText("Missing information!");
        getContentPane().add(insufficientInfo);
        insufficientInfo.setBounds(51, 363, 130, 22);

        backgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staticImg/signup.jpeg"))); // NOI18N
        getContentPane().add(backgroundImg);
        backgroundImg.setBounds(0, -10, 510, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        // TODO add your handling code here:
        String u = userNameTextField.getText();
        String p = passwordField.getText();
        String insertStr;
        
        if ((u.equals(null) || p.equals(null)) || !(playerButton.isSelected() || developerButton.isSelected())){
            System.out.println("You are missing some information.");
            insufficientInfo.setVisible(true);
            return;
        }
        
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.init();
        if (!passwordField.getText().equals(passwordField2.getText())){
            System.out.println("Passwords do not match!");
            mismatch.setVisible(true);
            return;
        }

        insertStr = "insert into Account(userName, password) "
                + "values('" + u + "' , '" + p + "')";
        
        System.out.println(insertStr);
        
        try{
            stmt= dbc.getMyConnection().createStatement(); 
            stmt.executeUpdate(insertStr);
            
            String queryStr = "select userID from Account A where A.userName='" + u + "'";
            rs = stmt.executeQuery(queryStr);
            rs.next();
            int id = rs.getInt("userID");
            
            if (playerButton.isSelected()){ addPlayer(id);}

            if (developerButton.isSelected()) {addDeveloper(id);}
            
        } catch (SQLException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
            alreadyExists.setVisible(true);
            return;
        }
            JOptionPane.showMessageDialog(null, "You account has been created!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            this.dispose();
  
    }//GEN-LAST:event_createAccountButtonActionPerformed

    private void addPlayer(int id){
        String insertStr = "insert into Player(playerID) values('" + id + "')";
        try {
            stmt.executeUpdate(insertStr);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addDeveloper(int id){
        String insertStr = "insert into Developer(developerID) values('" + id + "')";
        try {
            stmt.executeUpdate(insertStr);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountTypeLabel;
    private javax.swing.JLabel alreadyExists;
    private javax.swing.JLabel backgroundImg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JRadioButton developerButton;
    private javax.swing.JLabel insufficientInfo;
    private javax.swing.JLabel mismatch;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JRadioButton playerButton;
    private javax.swing.JLabel signUpTitle;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
