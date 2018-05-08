package FidelityMkt.PMO.GAP;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;


public class MigrationProgram {
    
    public int idProgram;
    public int idProject; 
    public String handlesSegments;
    public String attributesDifferentials;
    public String currentProgram;
    public String quantityTotalClients;
    public String pointsBalanceSystem;
    public String clientSystemProvider;
    public String highLowUsers;
    public String currentSystemManage;
    public boolean ifIntegration1;
    public boolean ifIntegration2;
    public boolean ifIntegration3;
    public boolean ifIntegration4;
    public String ifIntegration5;
    public String ifIntegration6;
    Connect conecta = new Connect();

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
    public int getidProgram(){
        return idProgram;
    }
    public void setidProgram(int idPrograma){
        this.idProgram=idPrograma;
    }
    public String gethandlesSegments(){
        return handlesSegments;
    }
    public void sethandlesSegments(String segmentos){
        this.handlesSegments=segmentos;
    }
    public String getattributesDifferentials(){
        return attributesDifferentials;
    }
    public void setattributesDifferentials(String atributosDiferenciales){
        this.attributesDifferentials=atributosDiferenciales;
    }
    public String getcurrentProgram(){
        return currentProgram;
    }
    public void setcurrentProgram(String programaActual){
        this.currentProgram=programaActual;
    }
    public String getquantityTotalClients(){
        return quantityTotalClients;
    }
    public void setquantityTotalClients(String clientesTotales){
        this.quantityTotalClients=clientesTotales;
    }
    public String getpointsBalanceSystem(){
        return pointsBalanceSystem;
    }
    public void setpointsBalanceSystem(String sistemaBalence){
        this.pointsBalanceSystem=sistemaBalence;
    }
    public String getclientSystemProvider(){
        return clientSystemProvider;
    }
    public void setclientSystemProvider(String sistemaClienteProveedor){
        this.clientSystemProvider=sistemaClienteProveedor;
    }
    public String gethighLowUsers(){
        return highLowUsers;
    }
    public void sethighLowUsers(String altaBajaUsuarios){
        this.highLowUsers=altaBajaUsuarios;
    }
    public String getcurrentSystemManage(){
        return currentSystemManage;
    }
    public void setcurrentSystemManage(String manejoSistemaActual){
        this.currentSystemManage=manejoSistemaActual;
    }
    public boolean getifIntegration1(){
        return ifIntegration1;
    }    
    public void setifIntegration1(boolean integracion1){
        this.ifIntegration1=integracion1;
    }
    public boolean getifIntegration2(){
        return ifIntegration2;
    }    
    public void setifIntegration2(boolean integracion2){
        this.ifIntegration2=integracion2;
    }
    public boolean getifIntegration3(){
        return ifIntegration3;
    }    
    public void setifIntegration3(boolean integracion3){
         this.ifIntegration3=integracion3;    
    }       
    public boolean getifIntegration4(){
        return ifIntegration4;
    }    
    public void setifIntegration4(boolean integracion4){
        this.ifIntegration4=integracion4;
    }
    public String getifIntegration5(){
        return ifIntegration5;
    }
    public void setifIntegration5(String ifIntegration5){
        this.ifIntegration5=ifIntegration5;
    }
    public String getifIntegration6(){
        return ifIntegration6;
    }
    public void setifIntegration6(String ifIntegration6){
        this.ifIntegration6=ifIntegration6;
    }
    
    
     public boolean RegistraMigracion(MigrationProgram migracion) throws Exception{
        boolean respuesta=false;
        try
        {
            conecta.AbrirConexion();
            CallableStatement cSmt= conecta.cn.prepareCall("{call upsMigrationProgram(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            cSmt.setString(1,migracion.handlesSegments);
            cSmt.setString(2,migracion.attributesDifferentials);
            cSmt.setString(3,migracion.currentProgram);
            cSmt.setString(4,migracion.quantityTotalClients);
            cSmt.setString(5,migracion.pointsBalanceSystem);
            cSmt.setString(6,migracion.clientSystemProvider);
            cSmt.setString(7,migracion.highLowUsers);
            cSmt.setString(8,migracion.currentSystemManage);
            cSmt.setBoolean(9,migracion.ifIntegration1);
            cSmt.setBoolean(10,migracion.ifIntegration2);
            cSmt.setBoolean(11,migracion.ifIntegration3);
            cSmt.setBoolean(12,migracion.ifIntegration4);
            cSmt.setString(13,migracion.ifIntegration5);
            cSmt.setString(14,migracion.ifIntegration6);
            cSmt.setInt(16,migracion.idProject);
            if (migracion.idProgram  > 0)
            {
                cSmt.setInt(15, migracion.idProgram);
            }
            else
            {
                 cSmt.registerOutParameter(15, migracion.idProgram);
            }           
            cSmt.execute();
            if (migracion.idProgram != cSmt.getInt(15)) 
            {
                migracion.idProgram = cSmt.getInt(15);
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
     
    public MigrationProgram ObtenerMigracion (MigrationProgram migracion){
        
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetMigrationProgram(?)}");
             cSmt.setInt(1, migracion.idProject);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();
          
          while (rs.next()) {
            
            migracion.handlesSegments=rs.getString("handles_segments");
            migracion.attributesDifferentials=rs.getString("attributes_differentials");
            migracion.currentProgram=rs.getString("current_program");
            migracion.quantityTotalClients=rs.getString("quantity_total_clients");
            migracion.pointsBalanceSystem=rs.getString("points_balance_system");
            migracion.clientSystemProvider=rs.getString("client_system_provider");
            migracion.highLowUsers=rs.getString("high_low_users");
            migracion.currentSystemManage=rs.getString("current_system_manage");
            migracion.ifIntegration1=rs.getBoolean("if_integration1");
            migracion.ifIntegration2=rs.getBoolean("if_integration2");
            migracion.ifIntegration3=rs.getBoolean("if_integration3");
            migracion.ifIntegration4=rs.getBoolean("if_integration4");
            migracion.ifIntegration5=rs.getString("if_integration5");
            migracion.ifIntegration6=rs.getString("if_integration6");       
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return migracion;
    }
}
