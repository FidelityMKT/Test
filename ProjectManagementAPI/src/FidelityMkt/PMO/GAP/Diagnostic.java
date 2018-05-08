package FidelityMkt.PMO.GAP;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;


public class Diagnostic {
   
    public int id_Diagnostico;
    public int idProyecto;
    public int currentUsers;
    public int projectedUser;
    public int segments;
    public int monthlyTranss;
    public int annualTrans;
    public int annualRedemp;
    public int physicalStore;
    public int quantityPos;
    Connect conecta = new Connect();

      

    public int getId_Diagnostico() {
        return id_Diagnostico;
    }

    public void setId_Diagnostico(int id_Diagnostico) {
        this.id_Diagnostico = id_Diagnostico;
    }

    public int getIdProyectoDiag() {
        return idProyecto;
    }

    public void setIdProyectoDiag(int idProyectoDiag) {
        this.idProyecto = idProyectoDiag;
    }

    public int getCurrentUsers() {
        return currentUsers;
    }

    public void setCurrentUsers(int currentUsers) {
        this.currentUsers = currentUsers;
    }

    public int getProjectedUser() {
        return projectedUser;
    }

    public void setProjectedUser(int projectedUser) {
        this.projectedUser = projectedUser;
    }

    public int getSegments() {
        return segments;
    }

    public void setSegments(int segments) {
        this.segments = segments;
    }

    public int getMonthlyTranss() {
        return monthlyTranss;
    }

    public void setMonthlyTranss(int monthlyTranss) {
        this.monthlyTranss = monthlyTranss;
    }

    public int getAnnualTrans() {
        return annualTrans;
    }

    public void setAnnualTrans(int annualTrans) {
        this.annualTrans = annualTrans;
    }

    public int getAnnualRedemp() {
        return annualRedemp;
    }

    public void setAnnualRedemp(int annualRedemp) {
        this.annualRedemp = annualRedemp;
    }

    public int getPhysicalStore() {
        return physicalStore;
    }

    public void setPhysicalStore(int physicalStore) {
        this.physicalStore = physicalStore;
    }

    public int getQuantityPos() {
        return quantityPos;
    }

    public void setQuantityPos(int quantityPos) {
        this.quantityPos = quantityPos;
    }
    
    
        
        
          public boolean RegistraDiagnostico(Diagnostic diagnostico) throws Exception{
              boolean respuesta = false;
        try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call uspRegisterDiagnostic (?,?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setInt(1,diagnostico.currentUsers);
            cSmt.setInt(2,diagnostico.projectedUser);
            cSmt.setInt(3,diagnostico.segments);
            cSmt.setInt(4,diagnostico.monthlyTranss);
            cSmt.setInt(5,diagnostico.annualTrans);
            cSmt.setInt(6,diagnostico.annualRedemp);
            cSmt.setInt(7,diagnostico.physicalStore);
            cSmt.setInt(8,diagnostico.quantityPos);            
            cSmt.setInt(10,diagnostico.idProyecto);
            // validación de actualización
            if (diagnostico.id_Diagnostico  > 0)
            {
                cSmt.setInt(9, diagnostico.id_Diagnostico);
            }
            else
            {
                 cSmt.registerOutParameter(9, diagnostico.id_Diagnostico);
            }           
            cSmt.execute();
            //validación de inserción
            if (diagnostico.id_Diagnostico != cSmt.getInt(9)) 
            {
                diagnostico.id_Diagnostico = cSmt.getInt(9);
            }
            respuesta=true;
            cSmt.close();
        }
         catch (Exception ex)
         {
             throw new Exception("Error al insertar Registro"+ex.getMessage());
         }
        return respuesta;
    }
          
          public Diagnostic ObtenerDiagnostico (Diagnostic diagnostico){
        
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetDiagnostic(?)}");
             cSmt.setInt(1, diagnostico.idProyecto);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          
          while (rs.next()) {
            
              
              diagnostico.currentUsers=rs.getInt("currentUsers");
              diagnostico.projectedUser=rs.getInt("projectedUsers");
              diagnostico.segments=rs.getInt("segments");
              diagnostico.monthlyTranss=rs.getInt("monthlyTrans");
              diagnostico.annualTrans=rs.getInt("annualTrans");
              diagnostico.annualRedemp=rs.getInt("annualRedemp");
              diagnostico.physicalStore=rs.getInt("physicalStore");
              diagnostico.quantityPos=rs.getInt("quantityPos");
       
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return diagnostico;
    }
    
    
    
}
