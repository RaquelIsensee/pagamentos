package forms;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import classes.SalarioMensal;
import servicos.ServicoGrafico;
import servicos.ServicoSalarioMensal;

/**
 * This demonstration shows a 3D bar chart with item labels displayed.
 *
 */
public class FGraficoHorizontal extends ApplicationFrame {

	ArrayList<SalarioMensal> listaGrafico;
    ServicoSalarioMensal servicosalariomensal = new ServicoSalarioMensal();
    ServicoGrafico servicoGrafico = new ServicoGrafico();
    
    public void windowClosing(WindowEvent e)
    {
    	this.dispose();
    }
	
    public FGraficoHorizontal(final String title, ArrayList<SalarioMensal> listaGrafico) {
    	
        super(title);
    	
    	this.listaGrafico= listaGrafico;
        
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        
        pack();

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
   private CategoryDataset createDataset() {
	   FGraficoHorizontal self = this;

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (int i = 0; i < this.listaGrafico.size(); i++) {
			SalarioMensal salarioMensal = this.listaGrafico.get(i);
			dataset.addValue(salarioMensal.getValor(), "valor", salarioMensal.getMes());
		}

        return dataset;


    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Grafico Pagamentos",      // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        final BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        
        return chart;

    }
    
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    /*public static void main(final String[] args) {

        final FGraficoHorizontal demo = new FGraficoHorizontal("3D Bar Chart Demo 3");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }*/

}