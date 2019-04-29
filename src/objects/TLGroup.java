package objects;

import java.util.ArrayList;
import java.util.List;

public class TLGroup {
    private List<Trafficlight> tla;
    private int idgrupo;
    private double pri;

    public TLGroup(int id) {

        this.tla = new ArrayList<Trafficlight>();
        this.idgrupo = id;

    }

    public void addTrafficlight(Trafficlight tl)
    {
        tla.add(tl);
    }

    public List<Trafficlight> getLista() {
        return tla;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public void setLista(List<Trafficlight> tla) {
        this.tla = tla;
    }
    public double calPrioridad(){
        double prioridad=0;
        for(int i=0;i<tla.size();i++){
            prioridad += tla.get(i).calPriority();
        }
        pri = prioridad;

        return pri;
    }
    public double getPrioridad()
    {
        return pri;
    }

    public void changeStatus(int status){
        for(int i=0;i<tla.size();i++){
            tla.get(i).changeStatus(status);
        }
    }
    public int getStatus(){
        return tla.get(0).getStatus();
    }
    
}
