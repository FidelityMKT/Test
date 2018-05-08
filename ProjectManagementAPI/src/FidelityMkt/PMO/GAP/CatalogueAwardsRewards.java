
package FidelityMkt.PMO.GAP;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogueAwardsRewards {
    
    public int idCatalogueAwards;
    public String nameCatalogue;
    public String keyAwards;
    Connect conecta = new Connect();

    public int getIdCatalogueAwards() {
        return idCatalogueAwards;
    }

    public void setIdCatalogueAwards(int idCatalogueAwards) {
        this.idCatalogueAwards = idCatalogueAwards;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }

    public String getKeyAwards() {
        return keyAwards;
    }

    public void setKeyAwards(String keyAwards) {
        this.keyAwards = keyAwards;
    }
    
    public ArrayList<CatalogueAwardsRewards> ObtenerPremiosRecompensas(){
        ArrayList<CatalogueAwardsRewards> premios = new ArrayList<CatalogueAwardsRewards>();
        try
        {           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCatalogueAwards()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              CatalogueAwardsRewards catalogoRecompensas= new CatalogueAwardsRewards(); 
              catalogoRecompensas.idCatalogueAwards=Integer.parseInt(rs.getString("idCatalogueAwards"));
              catalogoRecompensas.nameCatalogue=rs.getString("nameCatalogue");
              catalogoRecompensas.keyAwards=rs.getString("keyAwards");  
              premios.add(catalogoRecompensas);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return premios;
    }

}
