import Graphs.Data;
import Graphs.Graphics;
import objects.Control;
import objects.ListGroups;
import objects.TLGroup;
import objects.Trafficlight;
import py4j.GatewayServer;


public class Main {


    public static void main(String[] args) {

        Main app = new Main();
        GatewayServer server = new GatewayServer(app);
        System.out.println("ESPERANDO SUMO");
        server.start();

    }

    public static void initT(){
        System.out.println("INIT");
        Graphics.addSerie();
        Graphics.init();
    }
    public static int grupoVerde(){

        int maxGroup=calMaxPriority();
        Control.changeStatus(maxGroup);
        
        updateGraphics();
        return maxGroup;
    }
    public static void setVeh(int semid,int numveh){
       // ##Confidencial
    }
    public static void addSem(int semid,int grupoid,int prioVeh){
	// ##Confidencial
    }
    private static void setGraphics(String nombre){

        Data data = new Data(nombre);
        Graphics.getSeries().add(data);
    }
    private static void updateGraphics(){
        //Graphics
        for(int i=0;i<ListGroups.getLista().size();i++){
            Graphics.getSeries().get(i).addValue(ListGroups.getLista().get(i).getPrioridad());
        }
        Graphics.updateSeries();
    }

    public static void printListGroups ()
    {
	// ##Confidencial
    }
}
