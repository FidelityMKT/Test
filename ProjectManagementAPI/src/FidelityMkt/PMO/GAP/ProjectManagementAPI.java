package FidelityMkt.PMO.GAP;

import java.util.ArrayList;



public class ProjectManagementAPI {

  
    public static void main(String[] args) throws Exception  {
         
          
       Proyecto brief = new Proyecto();
       /*
        try{          
       
        Proyecto brief = new Proyecto();
        
        brief.idUser=1002;
        brief.idGroup=513;
        brief.projectName="Prada Boutiques";
        brief.idProgram=2;
        brief.idClient=3;
        brief.userName="eduardo.rodriguez";
        brief.idProyecto=0;
        brief.RegistraProyecto(brief);        
        System.out.println("este es el registro de proyecto "+brief.idProyecto); 
            
        }
        catch (Exception ex)
                {
                    
                }
    /*
     
        brief.diagnostico.idProyecto = 1;
        brief.diagnostico.currentUsers=750000;
        brief.diagnostico.projectedUser=1000000;
        brief.diagnostico.segments=3;
        brief.diagnostico.monthlyTranss=120000;
        brief.diagnostico.annualTrans=2000000;
        brief.diagnostico.annualRedemp=1000000;
        brief.diagnostico.physicalStore=45;
        brief.diagnostico.quantityPos=500;
        brief.diagnostico.id_Diagnostico=1;
        brief.diagnostico.RegistraDiagnostico(brief.diagnostico);
        System.out.println("este es el registro de diagnostico "+ brief.diagnostico.id_Diagnostico);
             */
       /*
        brief.comunicacion.idProject=1;
        brief.comunicacion.idCatalogueCommunication=2;
        brief.comunicacion.couponBook=false;
        brief.comunicacion.web_portal=true;
        brief.comunicacion.emailing=false;
        brief.comunicacion.sms=false;
        brief.comunicacion.printed=true;
        brief.comunicacion.app=true;
        brief.comunicacion.other="si";
        brief.comunicacion.observation=" ";
        brief.comunicacion.module_adm=false;
        brief.comunicacion.manage_content=false;
        brief.comunicacion.id_channel=1;
        brief.comunicacion.RegistrarCanales(brief.comunicacion);
        System.out.println("este es el registro canales de comunicacion "+ brief.comunicacion.id_channel);
      
        
        OperationalProcess ope= new OperationalProcess();
        ArrayList<Process> PROCESOS = new ArrayList<Process>();  
        Process ADC = new Process();  
        Process ADC2 = new Process(); 
        Process ADC3 = new Process(); 
        Process ADC4 = new Process(); 
        Process ADC5 = new Process(); 
        try {
        ope.idProject=1;        
        ADC.idCatalogue=2;
        ADC.idProject=1;
        ADC.observations="obser";
        
        ADC2.idCatalogue=2;
        ADC2.idProject=1;
        ADC2.observations="impresos";
        
        ADC3.idCatalogue=3;
        ADC3.idProject=1;
        ADC3.observations="app";
        
        ADC4.idCatalogue=3;
        ADC4.idProject=1;
        ADC4.observations="app";
        
        ADC5.idCatalogue=3;
        ADC5.idProject=1;
        ADC5.observations="app";
        
        PROCESOS.add(ADC);
        PROCESOS.add(ADC2);
        PROCESOS.add(ADC3);
        PROCESOS.add(ADC4);
        PROCESOS.add(ADC5);
        ope.procesos=PROCESOS;
        
            brief.proceso.RegistraProcesos(ope);
            System.err.println("es el registro " + " " + ADC.idProject);
        } catch (Exception ex) {
            throw new Exception("Error al insertar Registro"+ex.getMessage());
        }
        
        
        /*
        brief.integracion.idProject=1;
        brief.integracion.accumulationAccounts=true;
        brief.integracion.accumulation=false;
        brief.integracion.redemption=false;
        brief.integracion.expiration=false;
        brief.integracion.adminPOS=true;
        brief.integracion.observations="No aplican";
        brief.integracion.batchSFTP=false;
        brief.integracion.witch="no abrá otro";
        brief.integracion.idIntegration=1;
        brief.integracion.RegistraIntegracion(brief.integracion);
        System.out.println("este es el registro de integracion "+ brief.integracion.idIntegration);
        
        
        
        brief.infraestructura.idProject=1;
        brief.infraestructura.observations="no aplica observaciones ";
        brief.infraestructura.id_infraestructure=1;
        brief.infraestructura.RegistrarInfraestructura(brief.infraestructura);
        System.out.println("este es el registro de infraestructura " + brief.infraestructura.id_infraestructure);
        
        
        
        ArrayList<Device> dispositivos1 = new ArrayList<Device>();     
        
        Device pos = new Device();
        pos.idInfraestructura=1;
        pos.brand="EPSON";
        pos.Model="F050NNNO";
        pos.so="NEXUS SYSTEMS";
        pos.Type="FISICA";
        pos.connection="GPRS";
        pos.topology="ARBOL";
        pos.idCatalogue=1;
        pos.idDevices=1;
        dispositivos1.add(pos);
        System.out.println("Se registro el dispositivo " + pos.idCatalogue);
        
        Device printer = new Device();
        
        printer.idInfraestructura=1;
        printer.brand="HP";
        printer.Model="F045O";
        printer.so=" ";
        printer.Type="";
        printer.connection="WI-FI";
        printer.topology="";
        printer.idCatalogue=2;
        printer.idDevices=2;
        dispositivos1.add(printer);
        System.out.println("Se registro el dispositivo " + printer.idCatalogue);
        
        
        Device cardReader = new Device();
        
        cardReader.idInfraestructura=1;
        cardReader.brand="PayClip";
        cardReader.Model="FIRMAWARE 7.11A";
        cardReader.so=" ";
        cardReader.Type="BANDA MAGNETICA";
        cardReader.connection="RED";
        cardReader.topology="";
        cardReader.idCatalogue=3;
        cardReader.idDevices=3;
        dispositivos1.add(cardReader);
        System.out.println("Se registro el dispositivo " + cardReader.idCatalogue);
        
        
        Device other = new Device();
        
        other.idInfraestructura=1;
        other.brand="";
        other.Model="";
        other.so="";
        other.Type="";
        other.connection="";
        other.topology="";
        other.idCatalogue=4;
        other.idDevices=4;
        dispositivos1.add(other);
        brief.dispositivo.RegistrarDispositivosInfraestructura(dispositivos1);        
        System.out.println("Se registro el dispositivo " + other.idCatalogue);
               

       */
      /*
        brief.redencion.idProject=1; 
        brief.redencion.idCatalogueRedemption=2;
        brief.redencion.web_page=false;
        brief.redencion.call_center=false;
        brief.redencion.pos=true;
        brief.redencion.other="No aplica";
        brief.redencion.idRedemption=1;
        brief.redencion.RegistraRedencion(brief.redencion);
        System.out.println("este es el registro"+brief.redencion.idRedemption);
       
     
        */
        brief.recompensas.idProject=2; 
        brief.recompensas.idCatalogueAwards=1;
        brief.recompensas.goods=false;
        brief.recompensas.travelServices=false;
        brief.recompensas.experience=false;
        brief.recompensas.giftCards=true;
        brief.recompensas.other="No aplica";
        brief.recompensas.fullfilmentGoods=true;
        brief.recompensas.id_reward=0;
        brief.recompensas.RegistraRecompensas(brief.recompensas);
        System.out.println("este es el registro"+brief.recompensas.id_reward); 
         
        
        /*
        brief.migracion.idProject=1;
        brief.migracion.handlesSegments="El programa manejará 5 segmentos, los cuales son: segmento 1, segmento 2,segmento 3,segmento 4,segmento 5";
        brief.migracion.attributesDifferentials="Los atributos y diferenciales que maneja cada uno de los segmentos son a su vez manejados por un proveedor, sin embargo se necesita que fidelity lleve estos manejos";
        brief.migracion.currentProgram="Solo se migraran los ud¿suarios y saldos de estos";
        brief.migracion.quantityTotalClients="500000 clientes actuales";
        brief.migracion.pointsBalanceSystem="programa externo";
        brief.migracion.clientSystemProvider="de proveedor";
        brief.migracion.highLowUsers="manualmente";
        brief.migracion.currentSystemManage="automatica";
        brief.migracion.ifIntegration1=true;
        brief.migracion.ifIntegration2=false;
        brief.migracion.ifIntegration3=true;
        brief.migracion.ifIntegration4=false;
        brief.migracion.ifIntegration5="el sistema de facturacion es el mismo del punto de venta";
        brief.migracion.ifIntegration6="los datos almacenados serán, nombre, dirección y correo electrónico";
        brief.migracion.idProgram=1;
        brief.migracion.RegistraMigracion(brief.migracion);
        System.out.println("este es el registro"+brief.migracion.idProgram);
        
                

        CatalogueDevice dispositivo = new CatalogueDevice();
        ArrayList<CatalogueDevice> dispositivos = new ArrayList<CatalogueDevice>();
        dispositivos=dispositivo.ObtenerDispositivos();
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println(dispositivos.get(i).nameCatalogue);
        
        }
         
        
        CatalogueStatus Estatus = new CatalogueStatus();
        ArrayList<CatalogueStatus> status = new ArrayList<CatalogueStatus>();
        status=Estatus.ObtenerEstatus();
        for (int i = 0; i < status.size(); i++) {
            System.out.println("Los Status son " +status.get(i).clave);
        }
         
     
          
        brief.idProyecto=1;
        brief.ObtenerProyecto(brief);
       System.out.println( " NOMBRE DE ESTATUS: " + brief.catalogoEstatus.description + " ID PROYECTO: " +brief.idProyecto + " NOMENCLATURA: " + brief.nomenclature + " ID USUARIO: " + brief.idUser + " IDPROGRAMA: " + brief.idProgram  + " ID GRUPO: " + brief.idGroup  + " ID CLIENTE: " + brief.idClient + " NOMBRE DE PROYECTO: " + brief.projectName + " NOMBRE DE USUARIO: " + brief.userName);
        /*
       Proyecto obtenerProyectos= new Proyecto();
       ArrayList<Proyecto> proyecto =new ArrayList<Proyecto>();
       proyecto=obtenerProyectos.ObtenerInfoProyectos(512);
       for (int i=0; i< proyecto.size(); i++){
           System.out.println(" ID GRUPO " + proyecto.get(i).idGroup + "/ NOMENCLATURA " + proyecto.get(i).nomenclature + "/ ID PROGRAMA " + proyecto.get(i).idProgram + "/ ID PROYECTO " + proyecto.get(i).idProyecto + "/ ID CLIENTE " + proyecto.get(i).idClient + "/ ID USUARIO " +  proyecto.get(i).idUser + "/ NOMBRE PROYECTO " +  proyecto.get(i).projectName + "/ NOMBRE USUARIO " + proyecto.get(i).userName  );
       }
        
        
        brief.diagnostico.idProyecto=1;
        brief.diagnostico.ObtenerDiagnostico(brief.diagnostico);
        System.out.println(brief.diagnostico.currentUsers + " " + brief.diagnostico.projectedUser + " " + brief.diagnostico.segments + " " + brief.diagnostico.monthlyTranss + " " + brief.diagnostico.annualTrans + " " + brief.diagnostico.annualRedemp + " " + brief.diagnostico.physicalStore + " " + brief.diagnostico.quantityPos);
          
       
       Process obtProcesos= new Process();
       ArrayList<Process> ObtProcesos =new ArrayList<Process>();
       ObtProcesos=obtProcesos.ObtenerInfoProcesos(1);
       for (int i=0; i<ObtProcesos.size(); i++)
       {
           System.out.println( "ID PROYECTO " + ObtProcesos.get(i).idProject +  "/ ID PROCESO " + ObtProcesos.get(i).idProcess +  "/ ID CATALOGO " + ObtProcesos.get(i).idCatalogue +  "/ NOMBRE CATALOGO " + ObtProcesos.get(i).nameCatalogue +  "/ OBSERVACIONES " + ObtProcesos.get(i).observations);
       }
       
        /*
     
                //brief.comunicacion.idProject + " " + brief.comunicacion.idCatalogueCommunication +  " " + brief.comunicacion.couponBook + "  " + brief.comunicacion.web_portal + " " + brief.comunicacion.emailing + " " + brief.comunicacion.sms + " " + brief.comunicacion.printed + " " + brief.comunicacion.app + " " + brief.comunicacion.other + " " + brief.comunicacion.observation + " " + brief.comunicacion.module_adm + " " + brief.comunicacion.manage_content);
     
        /*
        brief.integracion.idProject=1;
        brief.integracion.ObtenerProcesoIntegracion(brief.integracion);
        System.out.println(brief.integracion.accumulationAccounts + " " + brief.integracion.accumulation + " " + brief.integracion.redemption + " " + brief.integracion.expiration + " " + brief.integracion.adminPOS + " " + brief.integracion.observations + " " + brief.integracion.batchSFTP + " " + brief.integracion.witch);
             
         
        brief.infraestructura.idProject=1;
        brief.dispositivo.idInfraestructura=1;
        brief.infraestructura.id_infraestructure=1;
        brief.infraestructura.ObtenerInfraestructura(brief.infraestructura);
        System.out.println(brief.infraestructura.observations +  " " + brief.dispositivo.brand +  " " + brief.dispositivo.brand +  " " + brief.dispositivo.Model +  " " + brief.dispositivo.so +  " " + brief.dispositivo.Type +  " " + brief.dispositivo.connection +  " " + brief.dispositivo.topology);
        
         
        brief.dispositivo.idInfraestructura=1;
        brief.dispositivo.idDevices=1;
        brief.dispositivo.ObtenerDispositivos(brief.dispositivo);
        System.out.println(brief.dispositivo.brand + " " + brief.dispositivo.Model + " " + brief.dispositivo.so + " " + brief.dispositivo.Type + " " + brief.dispositivo.connection + " " +  brief.dispositivo.topology );
         
         
        brief.redencion.idProject=1;
        brief.redencion.ObtenerCanalesRedencion(brief.redencion);
        System.out.println(brief.redencion.web_page + " " + brief.redencion.call_center + " " + brief.redencion.pos + " " + brief.redencion.other);
        
        
        brief.recompensas.idProject=1;
        brief.recompensas.ObtenerPremiosRecompensas(brief.recompensas);
        System.out.println(brief.catalogoRecompensas.nameCatalogue + "  " +brief.recompensas.goods + " " + brief.recompensas.travelServices + " " + brief.recompensas.experience + " " + brief.recompensas.giftCards + " " + brief.recompensas.other + " " + brief.recompensas.fullfilmentGoods);
        /*
        
        brief.migracion.idProject=1;
        brief.migracion.ObtenerMigracion(brief.migracion);
        System.out.println(" handlesSegments--->  " + brief.migracion.handlesSegments + " attributesDifferentials--->  " + brief.migracion.attributesDifferentials + " currentProgram--->  " + brief.migracion.currentProgram + " quantityTotalClients--->  " + brief.migracion.quantityTotalClients + " pointsBalanceSystem--->  " + brief.migracion.pointsBalanceSystem + " clientSystemProvider--->  " + brief.migracion.clientSystemProvider + " highLowUsers---> " + brief.migracion.highLowUsers + " currentSystemManage--->  " + brief.migracion.currentSystemManage + " ifIntegration1--->  " + brief.migracion.ifIntegration1 + " ifIntegration2--->  " + brief.migracion.ifIntegration2 + " ifIntegration3--->  " + brief.migracion.ifIntegration3 + " ifIntegration4--->  " + brief.migracion.ifIntegration4 + " ifIntegration5--->  " + brief.migracion.ifIntegration5 + " ifIntegration6--->  " + brief.migracion.ifIntegration6);
  
          
        brief.ObtenerInfoProyectos(1);
         /*
        brief.proceso.idProject=9;
        brief.proceso.ObtenerProceso(brief.proceso);
        
        CatalogueProcess CProceso = new CatalogueProcess();
        ArrayList<CatalogueProcess> cProcess = new ArrayList<CatalogueProcess>();
        cProcess=CProceso.ObtenerProcesos();
        for (int i = 0; i < cProcess.size(); i++) {
            System.out.println("Los catalogos son " +cProcess.get(i).key);
        }
        */
      
        
        
        /*
         CatalogueAwardsRewards catalogoRecompensas = new CatalogueAwardsRewards();
        ArrayList<CatalogueAwardsRewards> premios = new ArrayList<CatalogueAwardsRewards>();
        premios=catalogoRecompensas.ObtenerPremiosRecompensas();
        for (int i = 0; i < premios.size(); i++) {
            System.out.println("Los catalogos son " + premios.get(i).idCatalogueAwards + premios.get(i).nameCatalogue + premios.get(i).keyAwards);
        }

       
       CommunicationChannels obtProcesos= new CommunicationChannels();
       ArrayList<CommunicationChannels> ObtProcesos =new ArrayList<CommunicationChannels>();
       ObtProcesos=obtProcesos.ObtenerInfoComunicacion(1);
       for (int i=0; i<ObtProcesos.size(); i++)
       {
           System.out.println( "ID PROYECTO " + ObtProcesos.get(i).idProject +  "/ ID CATALOGO " + ObtProcesos.get(i).idCatalogueCommunication +  "/ NOMBRE CATALOGO " + ObtProcesos.get(i).nameCatalogue +  "/ CUPONERA " + ObtProcesos.get(i).couponBook +  "/ PORTAL WEB " + ObtProcesos.get(i).web_portal +  "/ EMAILING " + ObtProcesos.get(i).emailing +  "/ SMS " + ObtProcesos.get(i).sms +  "/ APP " + ObtProcesos.get(i).app +  "/ OTRO " + ObtProcesos.get(i).other +  "/ OBSERVACIONES" + ObtProcesos.get(i).observation +  "/ MODULO ADMINISTRACION" + ObtProcesos.get(i).module_adm +  "/ GESTION DEL CONTENIDO " + ObtProcesos.get(i).manage_content);
       }

       RedemptionChannels redencion= new RedemptionChannels();
       ArrayList<RedemptionChannels> canalesRedencion =new ArrayList<RedemptionChannels>();
       canalesRedencion=redencion.ObtenerInfoRedencion(1);
       for (int i=0; i<canalesRedencion.size(); i++)
       {
           System.out.println("ID REDENCION " + canalesRedencion.get(i).idRedemption + "/ ID PROYECTO " + canalesRedencion.get(i).idProject +  "/ ID CATALOGO " + canalesRedencion.get(i).idCatalogueRedemption +  "/ NOMBRE CATALOGO " + canalesRedencion.get(i).nameCatalogue +  "/ PAGINA WEB " + canalesRedencion.get(i).web_page +  "/ CALL CENTER " + canalesRedencion.get(i).call_center +  "/ POS " + canalesRedencion.get(i).pos +  "/ OTRO " + canalesRedencion.get(i).other);
       } 
       
       AwardsRewards recompesas= new AwardsRewards();
       ArrayList<AwardsRewards> premios =new ArrayList<AwardsRewards>();
       premios=recompesas.ObtenerInfoRedencion(1);
       for (int i=0; i<premios.size(); i++)
       {
           System.out.println("ID RECOMPENSAS " + premios.get(i).id_reward + "/ ID PROYECTO " + premios.get(i).idProject +  "/ ID CATALOGO " + premios.get(i).idCatalogueAwards +  "/ NOMBRE CATALOGO " + premios.get(i).nameCatalogue +  "/ MERCANCIAS " + premios.get(i).goods +  "/ SERVICIOS DE VIAJES" + premios.get(i).travelServices +  "/ EXPERIENCIAS " + premios.get(i).experience +  "/ GIFT CARDS " + premios.get(i).giftCards +  "/ OTRO " + premios.get(i).other +  "/ FMKT FULLFILMENT " + premios.get(i).fullfilmentGoods);
       } 
       */ 
    }
}
