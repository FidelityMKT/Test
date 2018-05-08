package FidelityMkt.PMO.GAP;

import java.sql.*;



public class Connect {
    Connection cn;
   
    
    public Connection   AbrirConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://10.10.10.4/FidelityERP_test","fideERPdb","Gnv85(61.");
            System.out.println("prueba exitosa");
       
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }return cn;
    }
    Statement creaStatement(){
        throw new UnsupportedOperationException("No soportado");
        
    }
 }
