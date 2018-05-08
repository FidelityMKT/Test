
package FidelityMkt.PMO.GAP;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CatalogueCommunication {
    public int idCatalogueCommunication;
    public String nameCatalogue;
    public String keyCommunication;
    Connect conecta = new Connect();

    public int getIdCatalogueCommunication() {
        return idCatalogueCommunication;
    }

    public void setIdCatalogueCommunication(int idCatalogueCommunication) {
        this.idCatalogueCommunication = idCatalogueCommunication;
    }

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }

    public String getKeyAwards() {
        return keyCommunication;
    }

    public void setKeyAwards(String keyAwards) {
        this.keyCommunication = keyAwards;
        
    }
    
    public ArrayList<CatalogueCommunication> ObtenerCatalogoComunicaciones(){
        ArrayList<CatalogueCommunication> comunicaciones = new ArrayList<CatalogueCommunication>();
        try
        {           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCatalogueCommunication()}");
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          while (rs.next()) {
              CatalogueCommunication catalogoComunicaciones= new CatalogueCommunication(); 
              catalogoComunicaciones.idCatalogueCommunication=Integer.parseInt(rs.getString("idCatalogueCommunication"));
              catalogoComunicaciones.nameCatalogue=rs.getString("nameCatalogue");
              catalogoComunicaciones.keyCommunication=rs.getString("keyCommunication");  
              comunicaciones.add(catalogoComunicaciones);
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return comunicaciones;
    }

    
}
