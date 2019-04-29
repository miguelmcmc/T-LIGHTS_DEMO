package resources;

public class Crono {
    private double timei;
    private double time;

    public void start()
    {
        timei = System.currentTimeMillis();
        // System.out.println("Crono Start");
    }
    public double getTime(){

        time = System.currentTimeMillis()-timei;
        //start();
        // System.out.println("actt:"+time);
        return time/1000;
    }
}
