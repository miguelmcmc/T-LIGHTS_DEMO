package Graphs;

import objects.ListGroups;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class SEM{
   public JButton add;
   public JButton remove;
   public JLabel name;
   public JTextField numveh;

   public int grupo;
   public int id;
}

public abstract class Frame {

    private static int height=0;
    private static int heightoff = 50;
    private static List<SEM> SEMs = new ArrayList<SEM>();
    private static int count;

    public static void init(){
        JFrame f = new JFrame("Opciones");

        for(int i=0;i<ListGroups.getLista().size();i++){
            for(int j=0;j<ListGroups.getLista().get(i).getLista().size();j++){
                SEM sem = new SEM();
                sem.grupo = ListGroups.getLista().get(i).getIdgrupo();
                sem.id = ListGroups.getLista().get(i).getLista().get(j).getId();
                sem.add = new JButton("+");
                sem.remove = new JButton("-");
                sem.name = new JLabel("Sem "+sem.id+" | "+sem.grupo);
                sem.numveh = new JTextField();

                sem.name.setBounds(0,height*heightoff,90,30);
                sem.add.setBounds(100,height*heightoff,50,30);
                sem.remove.setBounds(160,height*heightoff,50,30);
                sem.numveh.setBounds(220,height*heightoff,50,30);

                f.add(sem.name);
                f.add(sem.add);
                f.add(sem.remove);
                f.add(sem.numveh);

                SEMs.add(sem);

                height++;
            }
        }
        f.setSize(290,height*heightoff+15);
        f.setLayout(null);
        f.setVisible(true);


        for(count=0;count<SEMs.size();count++){
            SEMs.get(count).add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListGroups.getLista().get(SEMs.get(count).grupo).getLista().get(SEMs.get(count).id).addVehicle();
                    SEMs.get(count).numveh.setText(""+ListGroups.getLista().get(SEMs.get(count).grupo).getLista().get(SEMs.get(count).id).getVa().size());
                }
            });
            SEMs.get(count).remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListGroups.getLista().get(SEMs.get(count).grupo).getLista().get(SEMs.get(count).id).removeVehicle();
                    SEMs.get(count).numveh.setText(""+ListGroups.getLista().get(SEMs.get(count).grupo).getLista().get(SEMs.get(count).id).getVa().size());
                }
            });
        }
    }


}

