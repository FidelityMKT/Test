
package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;


public class RedemptionChannels {
    
    public int idRedemption;
    public int idProject; 
    public int idCatalogueRedemption;
    public String nameCatalogue;
    public boolean web_page;
    public boolean call_center;
    public boolean pos;
    public String other;
    
    Connect conecta = new Connect();

    public String getNameCatalogue() {
        return nameCatalogue;
    }
    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }   
    public int getIdCatalogueRedemption() {
        return idCatalogueRedemption;
    }
    public void setIdCatalogueRedemption(int idCatalogueRedemption) {
        this.idCatalogueRedemption = idCatalogueRedemption;
    }
    public int getIdProject() {
        return idProject;
    }
    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    public int getid_redemption(){
        return idRedemption;        
    }
    public void setid_redemption(int idRedencion){
        this.idRedemption=idRedencion;
    }
    public boolean getweb_page(){
        return web_page;
    }
    public void setweb_page(boolean paginaWeb){
        this.web_page=paginaWeb;
    }
    public boolean getcall_center(){
        return call_center;
    }
    public void setcall_center(boolean centroAtencion){
        this.call_center=centroAtencion;
    }
    public boolean getpos(){
        return pos;
    }
    public void setpos(boolean POS){
        this.pos=POS;
    }
    public String getother(){
        return other;
    }
    public void setother(String otra){
        this.other=otra;
    }  
    public boolean RegistraRedencion(RedemptionChannels redencion){
        boolean respuesta=false;
        try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call upsRedemptionChannels(?,?,?,?,?,?,?)}");
            
            cSmt.setBoolean(1,redencion.web_page);
            cSmt.setBoolean(2,redencion.call_center);
            cSmt.setBoolean(3,redencion.pos);
            cSmt.setString(4,redencion.other);
            cSmt.setInt(6,redencion.idProject);
            cSmt.setInt(7,redencion.idCatalogueRedemption);
            if (redencion.idRedemption  > 0)
            {
                cSmt.setInt(5, redencion.idRedemption);
            }
            else
            {
                 cSmt.registerOutParameter(5, redencion.idRedemption);
            }           
            cSmt.execute();
            if (redencion.idRedemption != cSmt.getInt(5)) 
            {
                redencion.idRedemption = cSmt.getInt(5);
            }
            respuesta=true;
            cSmt.close();             
        }        
        catch (Exception ex)
                {
                    System.out.println("error"+ex.getMessage());
                }      
        return respuesta;
    }
    
    
    public ArrayList<RedemptionChannels> ObtenerInfoRedencion(int idProject) {
          ArrayList<RedemptionChannels> canalesRedencion = new ArrayList();
        try{
        conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call upsGetRedemptionChannels(?)}");
             cSmt.setInt(1, idProject);
            cSmt.execute();
          
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {  
              RedemptionChannels redencion = new RedemptionChannels();
              
              redencion.idRedemption=rs.getInt("id_redemption");
              redencion.idProject=rs.getInt("idProject");
              redencion.idCatalogueRedemption=rs.getInt("idCatalogueRedemption");
              redencion.nameCatalogue=rs.getString("nameCatalogue");
              redencion.web_page=rs.getBoolean("web_page");
              redencion.call_center=rs.getBoolean("call_center");
              redencion.pos=rs.getBoolean("pos");
              redencion.other=rs.getString("other");
              canalesRedencion.add(redencion);
           }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return canalesRedencion;
    }
    
    }
