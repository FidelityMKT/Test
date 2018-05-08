package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class CatalogueStatus {
    public int idStatus;
    public String clave;
    public String description;
    Connect conecta = new Connect();
    
    

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public ArrayList<CatalogueStatus> ObtenerEstatus(){
        ArrayList<CatalogueStatus> Status = new ArrayList<CatalogueStatus>();
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetStatus()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
             CatalogueStatus estatus= new CatalogueStatus(); 
              estatus.idStatus=Integer.parseInt(rs.getString("idStatus"));
              estatus.clave=rs.getString("clave");
              estatus.description=rs.getString("description");
              Status.add(estatus);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return Status;
    }
    
}
