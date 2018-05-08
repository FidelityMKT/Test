package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogueDevice {

    public int idCatalogue;
    public String nameCatalogue;
    public String description;
    public String observations;    
    Connect conecta = new Connect();

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
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

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }  
    
   public ArrayList<CatalogueDevice> ObtenerDispositivos(){
        ArrayList<CatalogueDevice> dispositivos = new ArrayList<CatalogueDevice>();
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCatalogueDevices()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              CatalogueDevice dispositivo= new CatalogueDevice(); 
              dispositivo.idCatalogue=Integer.parseInt(rs.getString("idCatalogue"));
              dispositivo.nameCatalogue=rs.getString("nameCatalogue");
              dispositivo.description=rs.getString("description");
              dispositivo.observations=rs.getString("observations");  
              dispositivos.add(dispositivo);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return dispositivos;
    }
    
}
