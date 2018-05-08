package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class OperationalProcess {
    public int idProject;
    public ArrayList<Process> procesos = new ArrayList();
    Connect conecta = new Connect();

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
      
    public boolean RegistraProcesos(OperationalProcess operationalProcess)throws Exception{
       
        boolean respuesta=false;     
        try {
            EliminarProcesos(operationalProcess.idProject);
            for (int i=0; i<operationalProcess.procesos.size(); i++)
             {
                 RegistraProceso(operationalProcess.procesos.get(i));
             }
            
            }
        catch (Exception ex)
         {
             throw new Exception("Error al insertar Registro"+ex.getMessage());
         }
        return respuesta;
    }
    
    private boolean RegistraProceso(Process proceso) throws Exception{
        boolean respuesta=false;
        try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call uspProcess(?,?,?)}");            
            
            cSmt.setInt(1,proceso.idProject);
            cSmt.setInt(2,proceso.idCatalogue);
            cSmt.setString(3,proceso.observations);
              
            
           
            cSmt.execute();
            
            respuesta=true;
            cSmt.close();
        }
         catch (Exception ex)
         {
             throw new Exception("Error al insertar Registro"+ex.getMessage());
         }
        
        return respuesta;
    }
    
    private boolean EliminarProcesos(int idProject){
       boolean respuesta=false;
       try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call uspRemoveProcess(?)}");
            cSmt.setInt(1,idProject);
            cSmt.execute();      
            cSmt.close();                    
           
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        
        return respuesta;
       
   }
    
    public OperationalProcess ObtenerProceso (OperationalProcess proceso){
         try
        {          
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspSelectProcess(?)}");
             cSmt.setInt(1, proceso.idProject);
             cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              Process obtenerProceso = new Process();
              
              obtenerProceso.idCatalogue=rs.getInt("idCatalogueProcess");
              obtenerProceso.observations=rs.getString("observations");
              proceso.procesos.add(obtenerProceso);  
          }
          rs.close(); 
          
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return proceso;
    }
}

