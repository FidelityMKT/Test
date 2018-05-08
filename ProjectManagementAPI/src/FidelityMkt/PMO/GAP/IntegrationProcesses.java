
package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;


public class IntegrationProcesses {
    
    public int idIntegration;
    public int idProject;
    public boolean accumulationAccounts;
    public boolean accumulation;
    public boolean redemption;
    public boolean expiration;
    public boolean adminPOS;
    public String observations;
    public boolean batchSFTP;
    public String witch;
    Connect conecta = new Connect();

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
    public int getidIntegration(){
        return idIntegration;
        
        }
    public void setidIntegration(int integracion){
        this.idIntegration=integracion;
    }
    
    public boolean getaccumulationAccounts(){
        return accumulationAccounts;
    }
    
    public void setaccumulationAccounts(boolean cuentasAcumulacion){
        this.accumulationAccounts=cuentasAcumulacion;
    }
    public boolean getaccumulation(){
        return accumulation;
    }
    
    public void setaccumulation(boolean acumulacion){
        this.accumulation=acumulacion;
    }
    public boolean getredemption(){
        return redemption;
    }
    
    public void setredemption(boolean redencion){
        this.redemption=redencion;
    }
    public boolean getexpiration(){
        return expiration;
    }
    
    public void setexpiration(boolean vencimiento){
        this.expiration=vencimiento;
    }
    public boolean getadminPOS(){
        return adminPOS;
    }
    
    public void setadminPOS(boolean POS){
        this.adminPOS=POS;
    }
    
    public String getobservations(){
        return observations;
    }
    
    public void setobservations(String observaciones){
        this.observations=observaciones;
    }
    
    public boolean getbatchSFTP(){
        return batchSFTP;
    }
    
    public void setbatchSFTP(boolean batch){
        this.batchSFTP=batch;
    }

    public String getwitch(){
        return witch;
    }
    
    public void setwitch(String cual){
        this.witch=cual;
    }

    
    public boolean RegistraIntegracion(IntegrationProcesses integracion) throws Exception{
        boolean respuesta=false;
        try{
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call upsIntegrationProcess(?,?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setBoolean(1,integracion.accumulationAccounts);
            cSmt.setBoolean(2,integracion.accumulation);
            cSmt.setBoolean(3,integracion.redemption);
            cSmt.setBoolean(4,integracion.expiration);
            cSmt.setBoolean(5,integracion.adminPOS);
            cSmt.setString(6,integracion.observations);
            cSmt.setBoolean(7,integracion.batchSFTP);
            cSmt.setString(8,integracion.witch);
            cSmt.setInt(10,integracion.idProject);
            if (integracion.idIntegration  > 0)
            {
                cSmt.setInt(9, integracion.idIntegration);
            }
            else
            {
                 cSmt.registerOutParameter(9, integracion.idIntegration);
            }           
            cSmt.execute();
            if (integracion.idIntegration != cSmt.getInt(9)) 
            {
                integracion.idIntegration = cSmt.getInt(9);
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
    
    public IntegrationProcesses ObtenerProcesoIntegracion (IntegrationProcesses procesoIntegracion){
        
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetIntegrationProcess(?)}");
             cSmt.setInt(1, procesoIntegracion.idProject);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          
          while (rs.next()) {
            
              
              procesoIntegracion.accumulationAccounts=rs.getBoolean("accumulation_accounts");
              procesoIntegracion.accumulation=rs.getBoolean("accumulation");
              procesoIntegracion.redemption=rs.getBoolean("redemption");
              procesoIntegracion.expiration=rs.getBoolean("expiration");
              procesoIntegracion.adminPOS=rs.getBoolean("admin_pos");
              procesoIntegracion.observations=rs.getString("observations");
              procesoIntegracion.batchSFTP=rs.getBoolean("batch_sftp");
              procesoIntegracion.witch=rs.getString("whitch");
   
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return procesoIntegracion;
    }
    
}

