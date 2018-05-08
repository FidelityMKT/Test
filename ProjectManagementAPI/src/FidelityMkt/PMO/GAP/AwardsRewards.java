package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;


public class AwardsRewards {
    
    public int id_reward;
    public int idProject;  
    public int idCatalogueAwards; 
    public String nameCatalogue;
    public boolean goods;
    public boolean travelServices;
    public boolean experience;
    public boolean giftCards;
    public String other;
    public boolean fullfilmentGoods;
    
    Connect conecta = new Connect();

    public String getNameCatalogue() {
        return nameCatalogue;
    }
    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }
    public int getIdCatalogueAwards() {
        return idCatalogueAwards;
    }
    public void setIdCatalogueAwards(int idCatalogueAwards) {
        this.idCatalogueAwards = idCatalogueAwards;
    }   
    public int getidAwards(){
        return id_reward;
    }
    public void setidAwards(int recompensas){
        this.id_reward=recompensas;
    }
    public boolean getgoods(){
        return goods;
    }
    public void setgoods(boolean mercancias){
        this.goods=mercancias;
    }
    public boolean gettravelServices(){
        return travelServices;
    }
    public void settravelServices(boolean servicioViajes){
        this.travelServices=servicioViajes;
    }
    public boolean getexperience(){
        return experience;
    }
    public void setexperience(boolean experiencias){
        this.experience=experiencias;
    }
    public boolean getgiftCards(){
        return giftCards;
    }
    public void setgiftCards(boolean tarjetaRegalo){
        this.giftCards=tarjetaRegalo;
    }
    public String getother(){
        return other;
    }
    public void setother(String otro){
        this.other=otro;
    }
    public boolean getfullfilmentGoods(){
        return fullfilmentGoods;
    }
    public void setfullfilmentGoods(boolean fullfilment){
        this.fullfilmentGoods=fullfilment;
    }    
    public boolean RegistraRecompensas(AwardsRewards recompensas)throws Exception{
        boolean respuesta=false;
        try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call upsAwardsRewards(?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setBoolean(1,recompensas.goods);
            cSmt.setBoolean(2,recompensas.travelServices);
            cSmt.setBoolean(3,recompensas.experience);
            cSmt.setBoolean(4,recompensas.giftCards);
            cSmt.setString(5,recompensas.other);
            cSmt.setBoolean(6,recompensas.fullfilmentGoods);
            cSmt.setInt(8,recompensas.idProject);
            cSmt.setInt(9,recompensas.idCatalogueAwards);
            if (recompensas.id_reward  > 0)
            {
                cSmt.setInt(7, recompensas.id_reward );
            }
            else
            {
                 cSmt.registerOutParameter(7, recompensas.id_reward );
            }           
            cSmt.execute();
            if (recompensas.id_reward  != cSmt.getInt(7)) 
            {
                recompensas.id_reward  = cSmt.getInt(7);
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
    
   public ArrayList<AwardsRewards> ObtenerInfoRedencion(int idProject) {
          ArrayList<AwardsRewards> recompensas = new ArrayList();
        try{
        conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetAwardsRewards(?)}");
             cSmt.setInt(1, idProject);
            cSmt.execute();
          
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {  
              AwardsRewards premios = new AwardsRewards();
              
              premios.id_reward=rs.getInt("id_reward");
              premios.idProject=rs.getInt("idProject");
              premios.idCatalogueAwards=rs.getInt("idCatalogueAwards");
              premios.nameCatalogue=rs.getString("nameCatalogue");
              premios.goods=rs.getBoolean("goods");
              premios.travelServices=rs.getBoolean("travel_services");
              premios.experience=rs.getBoolean("experience");
              premios.giftCards=rs.getBoolean("gift_cards");
              premios.other=rs.getString("other");
              premios.fullfilmentGoods=rs.getBoolean("fullfilment_goods");
              recompensas.add(premios);
           }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return recompensas;
    }
}
