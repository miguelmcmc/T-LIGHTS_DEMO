package Graphs;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.ArrayList;
import java.util.List;

/** Creates a simple real-time chart */
public abstract class Graphics {
  private static XYChart chart = null;
  private static double[] Xaxis;

  private static List<Data> series = new ArrayList<Data>();

  private static SwingWrapper<XYChart> sw ;


  public static List<Data> getSeries() {
    return series;
  }


  public static void init(){
    double phase = 0;
    double[] initdata = getSineData(phase);


    //Init X
    Xaxis = new double[100];
    for (int i = 0; i < Xaxis.length; i++) {
      Xaxis[i] = i;
    }


    // Show it
    sw = new SwingWrapper<XYChart>(chart);
    sw.displayChart();
  }

  public static void addSerie(){

    for(int i=0;i<series.size();i++){
      if(i==0){
        // Create Chart
        //System.out.println("PPPP");
        chart =
                QuickChart.getChart(
                        "Prioridades", "Tiempo", "Prioridad", series.get(i).getNombre(), Xaxis, series.get(0).getData());
      }
      else{
        XYSeries serie=chart.addSeries(series.get(i).getNombre(),series.get(i).getData());
        serie.setMarker(SeriesMarkers.NONE);
      }
    }
  }
  public static void updateSeries(){
    for(int i=0;i<series.size();i++){

      chart.updateXYSeries(series.get(i).getNombre(),Xaxis,series.get(i).getData(),null);
    }
    sw.repaintChart();
  }

  private static double[] getSineData(double phase) {

    double[] xData = new double[100];
    double[] yData = new double[100];
    for (int i = 0; i < xData.length; i++) {
      double radians = phase + (2 * Math.PI / xData.length * i);
      xData[i] = i;
      yData[i] = Math.sin(radians);
    }
    return yData;
  }

}
