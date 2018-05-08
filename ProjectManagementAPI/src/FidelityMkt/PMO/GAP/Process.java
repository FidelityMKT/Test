
package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class Process {
    public int idProject;
    public int idProcess;
    public int idCatalogue;
    public String nameCatalogue;
    public String observations;
    Connect conecta = new Connect();

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    
    public int getidProcess() {
        return idProcess;
    }

    public void setidProcess(int idProcess) {
        this.idProcess = idProcess;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }
    

    
    
    
    public int getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(int idProcess) {
        this.idProcess = idProcess;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
    public ArrayList<Process> ObtenerInfoProcesos(int idProject) {
          ArrayList<Process> procesos = new ArrayList();
        try{
        conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetProcessByProject(?)}");
             cSmt.setInt(1, idProject);
            cSmt.execute();
          
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {  
              Process proceso = new Process();
              
              proceso.idProcess=rs.getInt("idProcess");
              proceso.idCatalogue=rs.getInt("idCatalogueProcess");
              proceso.observations=rs.getString("observations");
              proceso.nameCatalogue=rs.getString("nameCatalogue");
              procesos.add(proceso);
                    
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return procesos;
    }
    
    
}
