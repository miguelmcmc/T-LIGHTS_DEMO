package objects;


import java.util.ArrayList;
import java.util.List;

public abstract class  ListGroups {
    private static List<TLGroup> lista = new ArrayList<TLGroup>();

    public static List<TLGroup> getLista() {
        return lista;
    }


    public static TLGroup checkGrupo(int id)
    {
        TLGroup grupo = null;
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).getIdgrupo()==id)
            {
                grupo =lista.get(i);
            }
        }
        return grupo;
    }

    public static int calMaxPriority()
    {
        int max=0;
        double priority= -99999999;

        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i).calPrioridad()>=priority)
            {
                priority=lista.get(i).getPrioridad();
                max=lista.get(i).getIdgrupo();
            }
        }

        return max;
    }

}
