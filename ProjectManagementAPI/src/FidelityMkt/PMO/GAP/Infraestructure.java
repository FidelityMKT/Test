package FidelityMkt.PMO.GAP;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;


public class Infraestructure {
    
    public int id_infraestructure;
    public int idProject;    
    public String observations;
    public ArrayList<Device> dispositivos = new ArrayList();
    Connect conecta = new Connect();

    public ArrayList<Device> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Device> dispositivos) {
        this.dispositivos = dispositivos;
    }
    
    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
    public String getobservation(){
        return observations;
    }
    
    public void setobservation(String observaciones){
        this.observations=observaciones;
    }        
    
    public int getid_infraestructure(){
        return id_infraestructure;
    }
    public void setid_infraestructure(int idInfraestructura){
        this.id_infraestructure=idInfraestructura;
    }
    
    
    public boolean  RegistrarInfraestructura(Infraestructure infraestructura)throws Exception{
        boolean respuesta=false;
        try
        {
           conecta.AbrirConexion();
           CallableStatement cSmt= conecta.cn.prepareCall("{call upsInsertaInfraestructura(?,?,?)}");
                     
            cSmt.setInt(1,infraestructura.idProject); 
            cSmt.setString(2,infraestructura.observations);
            if (infraestructura.id_infraestructure  > 0)
            {
                cSmt.setInt(3, infraestructura.id_infraestructure);
            }
            else
            {
                 cSmt.registerOutParameter(3, infraestructura.id_infraestructure);
            }           
            cSmt.execute();
            
            if (infraestructura.id_infraestructure != cSmt.getInt(3)) 
            {
                infraestructura.id_infraestructure = cSmt.getInt(3);
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
    
    public Infraestructure ObtenerInfraestructura (Infraestructure infraestructura){
       
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetInfrastructure(?, ?)}");
             cSmt.setInt(1, infraestructura.idProject);
             cSmt.setInt(2, infraestructura.id_infraestructure);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
         
          while (rs.next()) {
              
              
              Device device = new Device();
              device.idCatalogue=rs.getInt("idCatalogue");
              device.brand=rs.getString("brand");
              device.Model=rs.getString("model");
              device.so=rs.getString("s.o");
              device.Type=rs.getString("type");
              device.connection=rs.getString("connection");
              device.topology=rs.getString("topology");
              device.nameCatalogue=rs.getString("nameCatalogue");
              infraestructura.dispositivos.add(device);
              
              infraestructura.observations=rs.getString("observations");
              
          }
          rs.close(); 
          
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return infraestructura;
    }
    
}
