package Graphs;

public class Data {
    private double[] data;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public Data(String nombre) {
        this.data = new double[100];
        this.nombre=nombre;
    }

    public void addValue(double dato){
        for (int i=0;i<this.data.length-1;i++){
            this.data[i]=this.data[i+1];
        }
        this.data[this.data.length-1]=dato;
    }

    public double[] getData() {
        return data;
    }
}
