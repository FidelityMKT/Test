package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CatalogueProcess {
    
public int idCatalogueProcess;
public String nameCatalogue;
public String description;
public String key;
 Connect conecta = new Connect();

    public int getIdProcess() {
        return idCatalogueProcess;
    }

    public void setIdProcess(int idProcess) {
        this.idCatalogueProcess = idProcess;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    
    public ArrayList<CatalogueProcess> ObtenerProcesos(){
        ArrayList<CatalogueProcess> cProcesos = new ArrayList<CatalogueProcess>();
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCatalogueProcess()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              CatalogueProcess procesos= new CatalogueProcess(); 
              procesos.idCatalogueProcess=Integer.parseInt(rs.getString("idCatalogueProcess"));
              procesos.nameCatalogue=rs.getString("nameCatalogue");
              procesos.description=rs.getString("description");
              procesos.key=rs.getString("key");  
              cProcesos.add(procesos);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return cProcesos;
    }


    
}
