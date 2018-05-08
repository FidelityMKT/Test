
package FidelityMkt.PMO.GAP;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogueRedemption {
    public int idCatalogueRedemption;
    public String nameCatalogue;
    public String keyRedemption;
    Connect conecta = new Connect();

    public int getIdCatalogueRedemption() {
        return idCatalogueRedemption;
    }

    public void setIdCatalogueRedemption(int idCatalogueRedemption) {
        this.idCatalogueRedemption = idCatalogueRedemption;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }

    public String getKeyRedemption() {
        return keyRedemption;
    }

    public void setKeyRedemption(String keyRedemption) {
        this.keyRedemption = keyRedemption;
    }
      public ArrayList<CatalogueRedemption> ObtenerCatalogoRedenciones(){
        ArrayList<CatalogueRedemption> redenciones = new ArrayList<CatalogueRedemption>();
        try
        {           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCatalogueRedemption()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              CatalogueRedemption catalogoRedenciones= new CatalogueRedemption(); 
              catalogoRedenciones.idCatalogueRedemption=Integer.parseInt(rs.getString("idCatalogueRedemption"));
              catalogoRedenciones.nameCatalogue=rs.getString("nameCatalogue");
              catalogoRedenciones.keyRedemption=rs.getString("keyRedemption");  
              redenciones.add(catalogoRedenciones);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return redenciones;
    }

    void nameCatalogue(String nameCatalogue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
