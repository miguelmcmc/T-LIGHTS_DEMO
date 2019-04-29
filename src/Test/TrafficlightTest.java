package Test;

import junit.framework.TestCase;
import objects.Trafficlight;

import java.util.Random;

public class TrafficlightTest extends TestCase {
    private final Trafficlight t_test = new Trafficlight(1,1,3);
    private final Random random = new Random();

    public void testGetId() {
        assertEquals(t_test.getId(),1);
    }

    public void testSetId() {
        int numero = random.nextInt(15);
        System.out.println("Poniendo id: "+numero);
        t_test.setId(numero);

        assertEquals(t_test.getId(),numero);
    }

    public void testGetGroup() {
        assertEquals(t_test.getGroup(),1);
    }

    public void testSetGroup() {
        int numero = random.nextInt(15);
        System.out.println("Poniendo id_grupo: "+numero);
        t_test.setGroup(numero);

        assertEquals(t_test.getGroup(),numero);
    }

    public void testAddVehicle() {
        int numero = random.nextInt(40);
        System.out.println("Creando : "+numero+" coches");
        for (int i=0;i<numero;i++){
            t_test.addVehicle();
        }
        assertEquals(t_test.getVa().size(),numero);
    }

    public void testRemoveVehicle() {
        testAddVehicle();

        int numero = random.nextInt(t_test.getVa().size());
        int resultado = t_test.getVa().size()-numero;
        System.out.println("Eliminando : "+numero+" coches");
        for (int i=0;i<numero;i++){
            t_test.removeVehicle();
        }
        assertEquals(t_test.getVa().size(),resultado);
    }

    public void testGetStatus() {
        assertEquals(t_test.getStatus(),1);
    }

    public void testChangeStatus() {
        int numero = random.nextInt(2);
        switch (numero){
            case 0: {
                System.out.println("Poniendo semaforo en verde");
            }break;
            case 1: {
                System.out.println("Poniendo semaforo en rojo");
            }break;
        }
        t_test.changeStatus(numero);
        assertEquals(t_test.getStatus(),numero);
    }

}
