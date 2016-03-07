/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg304application.database;

import java.sql.*;
/**
 *
 * @author jko
 */
public class DatabaseConnection {
     
    private Connection myConnection;
    
    public DatabaseConnection(){
        init();
    }
    
    public void init(){
       try{
           
        Class.forName("com.mysql.jdbc.Driver");
        myConnection = DriverManager.getConnection(
                /* you need to insert your own database information, refer to below
               
                "jdbc:mysql://localhost:3306/mysql","dbnamehere", "dbpasswordhere"
                */
                
                );

        System.out.println("Connected to database!");
        }
        catch(Exception e){
            System.out.println("Failed to get connection");
            e.printStackTrace();
            System.exit(0);
 
        }
    }
    
   public Connection getMyConnection(){
        return myConnection;
    }
   
    public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(myConnection !=null){
    
         try{
               myConnection.close();
            }
            catch(Exception e){}
        
        
    }
  }    
    
}
