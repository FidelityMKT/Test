package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;


public class CommunicationChannels {
    
    
    public int id_channel;
    public int idProject;
    public int idCatalogueCommunication;
    public String nameCatalogue;
    public boolean couponBook;
    public boolean web_portal;  
    public boolean emailing;
    public boolean sms;
    public boolean printed;
    public boolean app;
    public String other;
    public String observation;
    public boolean module_adm;
    public boolean manage_content;
  
    Connect conecta = new Connect();

    public int getIdCatalogueCommunication() {
        return idCatalogueCommunication;
    }

    public void setIdCatalogueCommunication(int idCatalogueCommunication) {
        this.idCatalogueCommunication = idCatalogueCommunication;
    }
    
    public boolean isCouponBook() {
        return couponBook;
    }

    public void setCouponBook(boolean couponBook) {
        this.couponBook = couponBook;
    }
    
            
    
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
    public int getid_channel(){
        return id_channel;        
    }
    
    public void setid_channel(int canal){
        this.id_channel=canal;
    }
    
    public boolean getweb_portal(){
        return web_portal;
    }
    
    public void setweb_portal(boolean portalWeb){
        this.web_portal=portalWeb;
    }
    
    public boolean getemailing(){
        return emailing;
    }
    
    public void getemailing(boolean email){
        this.emailing=email;
    }
    
    public boolean getsms(){
        return sms;
    }
    
    public void setsms(boolean mensaje){
        this.sms=mensaje;
    }
    
    public boolean getapp(){
        return app;
    }
    
    public void setapp(boolean aplicacion){
        this.app=aplicacion;
    }
    
    public boolean getprinted(){
        return printed;
    }
    
    public void setprinted(boolean impresion){
        this.printed=impresion;
    }
    
    public String getother(){
        return other;
    }
    
    public void setother(String otro){
        this.other=otro;
    }
    
    public String getobservation(){
        return observation;
    }
    
    public void setobservation(String observaciones){
        this.observation=observaciones;
    }
    
     public boolean getmodule_adm(){
        return module_adm;
    }
    
    public void setmodule_adm(boolean moduloAdm){
        this.module_adm=moduloAdm;
    }
    
     public boolean getmanage_content(){
        return manage_content;
    }
    
    public void setmanage_content(boolean gestionContenido){
        this.manage_content=gestionContenido;
    }
    
    public boolean RegistrarCanales(CommunicationChannels canales) throws Exception{
        boolean respuesta=false;
        try
            
        {
           conecta.AbrirConexion();
           CallableStatement cSmt= conecta.cn.prepareCall("{call upsCommunicationChannel(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setBoolean(1,canales.web_portal);
            cSmt.setBoolean(2,canales.emailing);
            cSmt.setBoolean(3,canales.sms);
            cSmt.setBoolean(4,canales.printed);
            cSmt.setBoolean(5,canales.app);
            cSmt.setString(6,canales.other);
            cSmt.setString(7,canales.observation);
            cSmt.setBoolean(8,canales.module_adm);
            cSmt.setBoolean(9,canales.manage_content);
            cSmt.setInt(11,canales.idProject);
            cSmt.setBoolean(12,canales.couponBook);
            cSmt.setInt(13,canales.idCatalogueCommunication);
            if (canales.id_channel  > 0)
            {
                cSmt.setInt(10, canales.id_channel);
            }
            else
            {
                 cSmt.registerOutParameter(10, canales.id_channel);
            }           
            cSmt.execute();
            if (canales.id_channel != cSmt.getInt(10)) 
            {
                canales.id_channel = cSmt.getInt(10);
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
    
    
     public ArrayList<CommunicationChannels> ObtenerInfoComunicacion(int idProject) {
          ArrayList<CommunicationChannels> canalesComunicacion = new ArrayList();
        try{
        conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetCommunicationChannesl(?)}");
             cSmt.setInt(1, idProject);
            cSmt.execute();
          
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {  
              CommunicationChannels canales = new CommunicationChannels();
              
              canales.idProject=rs.getInt("idProject");
              canales.idCatalogueCommunication=rs.getInt("idCatalogueCommunication");
              canales.nameCatalogue=rs.getString("nameCatalogue");
              canales.couponBook=rs.getBoolean("couponBook");
              canales.web_portal=rs.getBoolean("web_portal");
              canales.emailing=rs.getBoolean("emailing");
              canales.sms=rs.getBoolean("sms");
              canales.app=rs.getBoolean("app");
              canales.other=rs.getString("other");
              canales.observation=rs.getString("observation");
              canales.module_adm=rs.getBoolean("module_adm");
              canales.manage_content=rs.getBoolean("manage_content");              
              canalesComunicacion.add(canales);
             }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return canalesComunicacion;
    }

   
    
}
