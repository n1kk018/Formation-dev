package org.mycontrib.test_primefaces.web.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;
  
@ManagedBean
@SessionScoped
public class ChartBean implements Serializable {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CartesianChartModel categoryModel;  //avec series
	private BarChartModel barModel;
	private LineChartModel lineModel;
	private PieChartModel pieModel;  //pour choses avec proportions

    public ChartBean() {  
        createCategoryModel();
        createPieModel(); 
     }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
    
  
    public BarChartModel getBarModel() {
    	barModel = new BarChartModel();
    	for(ChartSeries series : getCategoryModel().getSeries()){
    	    barModel.addSeries(series);
    	}
    	barModel.setTitle("Basic Bar Chart");
    	Axis yAxis = barModel.getAxis(AxisType.Y);
    	yAxis.setMin(0);yAxis.setMax(200);
    	barModel.setLegendPosition("ne");
		return barModel;
	}

	public LineChartModel getLineModel() {
		lineModel = new LineChartModel();
    	for(ChartSeries series : getCategoryModel().getSeries()){
    	    lineModel.addSeries(series);
    	}
    	lineModel.setTitle("Basic Line Chart");
    	Axis xAxis = lineModel.getAxis(AxisType.X);
    	xAxis.setMin(2004); xAxis.setMax(2008);
    	Axis yAxis = lineModel.getAxis(AxisType.Y);
    	yAxis.setMin(0);yAxis.setMax(200);
    	lineModel.setLegendPosition("ne");
		return lineModel;
	}

	private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Boys");  
  
        boys.set("2004", 120);  
        boys.set("2005", 100);  
        boys.set("2006", 44);  
        boys.set("2007", 150);  
        boys.set("2008", 25);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Girls");  
  
        girls.set("2004", 52);  
        girls.set("2005", 60);  
        girls.set("2006", 110);  
        girls.set("2007", 135);  
        girls.set("2008", 120);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }  
    
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  
  
        pieModel.set("Brand 1", 540);  
        pieModel.set("Brand 2", 325);  
        pieModel.set("Brand 3", 702);  
        pieModel.set("Brand 4", 421);
        pieModel.setTitle("Sample Pie Chart");
        pieModel.setLegendPosition("w");
        pieModel.setShowDataLabels(true);
 
    }

   
    
}  
