package FidelityMkt.PMO.GAP;

import FidelityMkt.PMO.GAP.Connect;
import java.sql.*;
import FidelityMkt.PMO.GAP.*;
import java.util.ArrayList;

public class Proyecto {

    public int idProyecto;
    public int idClient;
    public int idProgram;
    public int idGroup;
    public int idUser;
    public String dateOfAssignment;
    public String nomenclature;
    public String projectName;
    public String userName;
    public String nameStatus;
    public int idStatus;
    

    public Diagnostic diagnostico = new Diagnostic();
    public OperationalProcess proceso = new OperationalProcess();
    public CommunicationChannels comunicacion = new CommunicationChannels();
    public IntegrationProcesses integracion = new IntegrationProcesses();
    public RedemptionChannels redencion = new RedemptionChannels();
    public AwardsRewards recompensas = new AwardsRewards();
    public MigrationProgram migracion = new MigrationProgram();
    public Device dispositivo = new Device();
    public Infraestructure infraestructura = new Infraestructure();
    public Process procesos = new Process();
    public CatalogueStatus catalogoEstatus=new CatalogueStatus();
    public CatalogueAwardsRewards catalogoRecompensas=new CatalogueAwardsRewards();
    public CatalogueCommunication catalogoComunicaiones = new CatalogueCommunication();

    Connect conecta = new Connect();

    public String getDateOfAssignment() {
        return dateOfAssignment;
    }

    public void setDateOfAssignment(String dateOfAssignment) {
        this.dateOfAssignment = dateOfAssignment;
    }

    
    
    
    public int getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }
    
    
    
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }
    
    public int getidProyectoProject() {
        return idProyecto;
    }

    public void setidProyectoProject(int idProyecto) {
        this.idProyecto = idProyecto;

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    

    public int getidUsuario() {
        return idUser;
    }

    public void setidUsuario(int idusuario) {
        this.idUser = idusuario;

    }

    public String getNombreProyecto() {
        return projectName;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.projectName = nombreProyecto;

    }

    public String getnombreUsuario() {
        return userName;
    }

    public void setnombreUsuario(String NombreUsuario) {
        this.userName = NombreUsuario;
    }

    public int getidStatus() {
        return idStatus;
    }

    public void setidStatus(int estatus) {
        this.idStatus = estatus;
    }

    public Proyecto RegistraProyecto(Proyecto proyecto) throws Exception {
           
        try {
            conecta.AbrirConexion();
            CallableStatement cStmt = conecta.cn.prepareCall("{call uspRegistraBrief(?, ? , ?, ?, ?, ?, ?)}");

            
            cStmt.setInt(1, proyecto.idUser);
            cStmt.setString(2, proyecto.projectName);
            cStmt.setString(3, proyecto.userName);
            cStmt.setInt(4, proyecto.idGroup);
            cStmt.setInt(6, proyecto.idClient);
            cStmt.setInt(7, proyecto.idProgram);
               if (proyecto.idProyecto  > 0)
            {
                cStmt.setInt(5, proyecto.idProyecto);
            }
            else
            {
                 cStmt.registerOutParameter(5, proyecto.idProyecto );
            }           
            cStmt.execute();
            if (proyecto.idProyecto != cStmt.getInt(5)) 
            {
                proyecto.idProyecto = cStmt.getInt(5);
            }
            
            cStmt.close();
            
        } catch (Exception ex) {            
            throw new Exception("Error al insertar proyecto"+ ex.getMessage());
        }

        return proyecto;

    }
    
    public Proyecto ObtenerProyecto (Proyecto proyecto){
        
        try
        {
           
            conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetProyecto(?)}");
             cSmt.setInt(1, proyecto.idProyecto);
            cSmt.execute();
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {     
              proyecto.catalogoEstatus.description=rs.getString("description");
              proyecto.idClient=rs.getInt("idClient");
              proyecto.nomenclature=rs.getString("nomenclature");
              proyecto.idProgram=rs.getInt("idProgram");
              proyecto.idGroup=rs.getInt("idGroup");
              proyecto.idUser=rs.getInt("id_user");               
              proyecto.projectName=rs.getString("projectName");
              proyecto.userName=rs.getString("userName");              
              proyecto.dateOfAssignment=rs.getString("dateOfAssignment");
              proyecto.idStatus=rs.getInt("idStatus");                
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }

        return proyecto;
    }  
    
    public ArrayList<Proyecto> ObtenerInfoProyectos(int idGroup) {
          ArrayList<Proyecto> proyectos = new ArrayList();
        try{
        conecta.AbrirConexion();
            CallableStatement cSmt = conecta.cn.prepareCall("{call uspGetProjectsByGroup(?)}");
             cSmt.setInt(1, idGroup);
            cSmt.execute();
          
          ResultSet rs = cSmt.getResultSet();          
          while (rs.next()) {  
              Proyecto proyecto = new Proyecto();
              proyecto.idProyecto=rs.getInt("id_proyecto");
              proyecto.idGroup=rs.getInt("idGroup");
              proyecto.nomenclature=rs.getString("nomenclature");
              proyecto.idProgram=rs.getInt("idProgram");
              proyecto.idClient=rs.getInt("idClient");
              proyecto.idUser=rs.getInt("id_user");
              proyecto.projectName=rs.getString("projectName");
              proyecto.userName=rs.getString("userName");
              proyecto.nameStatus=rs.getString("description");
              proyecto.dateOfAssignment=rs.getString("dateOfAssignment");
              proyecto.idStatus=rs.getInt("idStatus");
              proyectos.add(proyecto);
                    
          }
          rs.close();                    
          cSmt.close();
        }
         catch (Exception ex)
         {
             System.out.println("error"+ex.getMessage());
         }
        return proyectos;
    }

}
