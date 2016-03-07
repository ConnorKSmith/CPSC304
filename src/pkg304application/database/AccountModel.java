/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application.database;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author jko
 */
public class AccountModel extends AbstractTableModel {
    
    private int columnAmt = 4;
    private int rowAmt;
    private String[] columnNames = { "userID", "userName", "password", "description" };
    private ArrayList<String[]> Tuples;
    
    public AccountModel(ResultSet rs){
        Tuples = new ArrayList<String[]>();
        
        try {
            while (rs.next()){
                String[] tuple= {
                    rs.getString("userID"), rs.getString("userName"), rs.getString("password"),
                    rs.getString("description")
                };
                Tuples.add(tuple);
            }
        }
        catch (Exception e ) {
            System.out.println("Exception caught in AccountModel.java");
        }
    }

    @Override
    public int getRowCount() {
        return Tuples.size();
    }

    @Override
    public int getColumnCount() {
        return columnAmt;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = Tuples.get(rowIndex);
        return row[columnIndex];
    }
    
}
