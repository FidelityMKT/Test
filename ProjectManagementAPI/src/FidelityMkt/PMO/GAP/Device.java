package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;


public class Device {
    public int idDevices;
    public int idCatalogue;
    public String nameCatalogue;
    public int idInfraestructura;
    public String brand;
    public String Model;
    public String so;
    public String Type;
    public String connection;
    public String topology;    
    
    
   
   Connect conecta = new Connect();

    public String getNameCatalogue() {
        return nameCatalogue;
    }

    public void setNameCatalogue(String nameCatalogue) {
        this.nameCatalogue = nameCatalogue;
    }
   
    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }

    public int getIdInfraestructura() {
        return idInfraestructura;
    }

    public void setIdInfraestructura(int idInfraestructura) {
        this.idInfraestructura = idInfraestructura;
    }
   
   
    
    public int getidDispositive(){
        return idDevices;
    }
    public void setidDispositive(int dispositivo){
        this.idDevices=dispositivo;
    }
    
    public String getbrand(){
        return brand;
    }
    public void setbrand(String marca){
        this.brand=marca;
    }
      public String getmodel(){
        return Model;
    }
    public void setmodel(String modelo){
        this.Model=modelo;
    }
      public String getSO(){
        return so;
    }
    public void setSO(String so){
        this.so=so;
    }
    
    public String gettype(){
        return Type;
    }
    public void settype(String tipo){
        this.Type=tipo;
    }
    
    public String getConnection(){
        return connection;
    }
    public void setConnection(String conexion){
        this.connection=conexion;
    }
    
    public String gettopology(){
        return topology;
    }
    public void settopology(String topologia){
        this.topology=topologia;
    }
    
    
    public int RegistrarDispositivosInfraestructura(ArrayList<Device> dispositivos) throws Exception
    {
        try
        {
        int procesados=0;
        if(dispositivos.size()>0)
        {
            for(int i=0; i<dispositivos.size(); i++)
            {
                 RegistraDispositivo(dispositivos.get(i));
                 procesados++;
            }
        }
        return procesados;
        }
        catch (Exception ex)
        {
          throw new Exception("Error al insertar Registro"+ex.getMessage());  
        } 
        
    }
    
    
        
    
     public boolean RegistraDispositivo(Device dispositivo) throws Exception{
        boolean respuesta=false;
        try
        {
            
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call upsRegisterDevice(?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setInt(1,dispositivo.idInfraestructura);
            cSmt.setString(2,dispositivo.brand);
            cSmt.setString(3,dispositivo.Model);
            cSmt.setString(4,dispositivo.so);
            cSmt.setString(5,dispositivo.Type);
            cSmt.setString(6,dispositivo.connection);
            cSmt.setString(7,dispositivo.topology);
            cSmt.setInt(9,dispositivo.idCatalogue);
            if (dispositivo.idDevices  > 0)
            {
                cSmt.setInt(8, dispositivo.idDevices);
            }
            else
            {
                 cSmt.registerOutParameter(8, dispositivo.idDevices);
            }  
            respuesta=true;
            cSmt.execute();
            if(dispositivo.idDevices>0)
            {
                respuesta=true;
            }
            if (dispositivo.idDevices != cSmt.getInt(8)) 
            {
                dispositivo.idDevices = cSmt.getInt(8);
            }
            
            
            cSmt.close();
        }
         catch (Exception ex)
         {
             throw new Exception("Error al insertar Registro"+ex.getMessage());
         }
        return respuesta;
    }
     
     
     public Device ObtenerDispositivos (Device dispositivos){
        
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetDevices(?,?)}");
             cSmt.setInt(1, dispositivos.idInfraestructura);
              cSmt.setInt(2, dispositivos.idDevices);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          
          while (rs.next()) {
              
              dispositivos.brand=rs.getString("brand");
              dispositivos.Model=rs.getString("model");
              dispositivos.so=rs.getString("s.o");
              dispositivos.Type=rs.getString("type");
              dispositivos.connection=rs.getString("connection");
              dispositivos.topology=rs.getString("topology");
              
              
       
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
